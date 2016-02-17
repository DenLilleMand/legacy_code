package eventHandlingController;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import collections.graph.GraphWrapper;
import collections.graph.Vertex;
import collections.tree.TreeNode;
import collections.tree.TreeRootWrapper;
import stackUndoRedoImplementation.BreadthFirstCommand;
import stackUndoRedoImplementation.PostorderCommand;
import stackUndoRedoImplementation.PreorderCommand;
import stackUndoRedoImplementation.ResetCommand;
import stackUndoRedoImplementation.UndoRedoForTreeAlgorithms;
import stackUndoRedoImplementation.UndoRedoStackWrapper;
import control.NetworkController;
import entities.ArrayListWrapper;
import entities.MessageEvent;
import entities.User;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import loaders.LoadingPictures;
import model.db.Adapter;
import model.db.GraphDb;
import model.db.IMysqlDbWrapper;
import model.db.MysqlWrapper;

public class EventHandlingControllerMain {
	@FXML
	private TableColumn<User, User> userColumn;

	@FXML
	private TableColumn<User, User> onlineColumn;

	@FXML
	private TableView<Vertex<String>> graphTable;

	@FXML
	private Button graphBreadthFirstButton;

	@FXML
	private Button graphDepthFirstButton;

	@FXML
	private TabPane mainPane;

	@FXML
	private Tab mainTab;

	@FXML
	private Tab adjacencyTab;

	@FXML
	private Button breadthFirstButton;

	@FXML
	private Button postorderButton;

	@FXML
	private Button preorderButton;

	@FXML
	private Button undoButton;

	@FXML
	private Button redoButton;

	@FXML
	private TreeTableView<TreeNode> subjectTable;

	@FXML
	private TreeTableColumn<TreeNode, String> subjectColumn;

	@FXML
	private TreeTableColumn<TreeNode, String> messageColumn;

	@FXML
	private TreeTableColumn<TreeNode, String> visitOrderColumn;

	@FXML
	private TreeTableColumn<TreeNode, String> userTreeColumn;

	@FXML
	private Label dbLabel;

	@FXML
	private Button neo4jButton;

	@FXML
	private Button mysqlButton;

	// fx:id="mainAnchorPane"
	@FXML
	private AnchorPane mainAnchorPane;

	// collectiveTextArea
	@FXML
	private TextArea collectiveTextArea;

	// fx:id="scrollPane"
	@FXML
	private ScrollPane scrollPane;

	// fx:id="userLabel"
	@FXML
	private Label userLabel;

	// fx:id = "userTable"
	@FXML
	private TableView<User> userTable;

	// fx:id="startButton"
	@FXML
	private Button startButton;

	// fx:id="collectiveLabel
	@FXML
	private Label collectiveLabel;

	// fx:id="backgroundPane"
	@FXML
	private GridPane backgroundPane;

	private ObservableList<User> data;

	public ObservableList<User> getData() {
		return data;
	}

	private final String ZERO = "";
	private NetworkController networkController = NetworkController
			.getInstance();
	private LoadingPictures loadingPictures = LoadingPictures.getInstance();
	private Socket connectionSocket;
	private State state = State.getInstance();
	private final String SEPERATOR = System.getProperty("line.separator");
	private IMysqlDbWrapper dbWrapper = MysqlWrapper.getInstance();
	ArrayListWrapper userWrapper = ArrayListWrapper.getInstance();
	private UndoRedoForTreeAlgorithms undoRedoStackWrapper = UndoRedoStackWrapper
			.getInstance();
	private GraphWrapper graphWrapper;

	private static EventHandlingControllerMain instance;

	public void setMysqlDbWrapper(IMysqlDbWrapper dbWrapper) {
		this.dbWrapper = dbWrapper;
	}

	public EventHandlingControllerMain() {
		// dont handle reflection here - the FXML loader uses reflection to load
		// data into this object
		// atleast the documentation mentions smt. about reflection.
	}

	public static EventHandlingControllerMain getInstance() {
		if (instance == null) {
			instance = new EventHandlingControllerMain();
		}
		return instance;
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		instance = this;
		// http://docs.oracle.com/javafx/2/ui_controls/table-view.htm
		// evt. s�g p� hvordan man tilf�jer flere forskellige typer til det
		// samme table.
		// SelectionModel and FocusModel er vigtige her tror jeg.

		// mainPane.

		// i et seri�st stykke kode ville man nok lave den der CallBack klasse
		// som en component
		// som bare extender CallBack, s�dan at vores initialize() metode ikke
		// bliver spammet
		// med table relaterede ting.
		onlineColumn
				.setCellValueFactory(new Callback<CellDataFeatures<User, User>, ObservableValue<User>>() {
					@Override
					public ObservableValue<User> call(
							CellDataFeatures<User, User> features) {
						return new ReadOnlyObjectWrapper<User>(features
								.getValue());
					}
				});

		onlineColumn
				.setCellFactory(new Callback<TableColumn<User, User>, TableCell<User, User>>() {
					@Override
					public TableCell<User, User> call(
							TableColumn<User, User> onlineColumn) {
						return new TableCell<User, User>() {
							final ImageView labelGraphic = new ImageView();
							final Label label = new Label();
							{
								label.setGraphic(labelGraphic);
								label.setMinWidth(130);
							}

							@Override
							public void updateItem(final User user,
									boolean empty) {
								super.updateItem(user, empty);
								if (user != null) {
									if (user.isOnline()) {
										label.setText(ZERO);
										labelGraphic.setImage(LoadingPictures
												.getCheckedImage());
									} else if (!user.isOnline()) {
										label.setText(ZERO);
										labelGraphic.setImage(LoadingPictures
												.getUncheckedImage());
									}
								} else {
									labelGraphic.setImage(null);
									label.setText(null);
								}
								setGraphic(label);
							}
						};
					}
				});
		userColumn
				.setCellValueFactory(new Callback<CellDataFeatures<User, User>, ObservableValue<User>>() {
					@Override
					public ObservableValue<User> call(
							CellDataFeatures<User, User> features) {
						return new ReadOnlyObjectWrapper<User>(features
								.getValue());
					}
				});

		userColumn
				.setCellFactory(new Callback<TableColumn<User, User>, TableCell<User, User>>() {
					@Override
					public TableCell<User, User> call(
							TableColumn<User, User> userColumn) {
						return new TableCell<User, User>() {
							final ImageView labelGraphic = new ImageView();
							final Label label = new Label();
							{
								label.setGraphic(labelGraphic);
								label.setMinWidth(50);
							}

							@Override
							public void updateItem(final User user,
									boolean empty) {
								super.updateItem(user, empty);
								if (user != null) {
									label.setText(user.getUserName());
								} else {
									labelGraphic.setImage(null);
									label.setText(null);
								}
								setGraphic(label);
							}
						};
					}
				});

		updateUserListWithDatabase(ConnectToDatabase.DO_IT);

		startButton.setOnAction((event) -> {
			try {
				networkController.startRunning();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		subjectColumn.setCellValueFactory((f) -> new SimpleStringProperty(f
				.getValue().getValue().getData().getSubject()));
		messageColumn.setCellValueFactory((f) -> new SimpleStringProperty(f
				.getValue().getValue().getData().getMessage()));
		visitOrderColumn.setCellValueFactory((f) -> new SimpleStringProperty(f
				.getValue().getValue().getVisitOrder().toString()));
		userTreeColumn.setCellValueFactory((f) -> new SimpleStringProperty(f
				.getValue().getValue().getData().getSender()));

		TreeRootWrapper tree = TreeRootWrapper.getInstance(subjectTable);

		MessageEvent root = new MessageEvent("root", "root",
				Arrays.asList("root".split(" ")), "root");
		tree.setRoot(root);

		tree.createTreeTableView();

		preorderButton.setOnAction((event) -> {
			PreorderCommand command = null;
			if (undoRedoStackWrapper.isEmpty()) {
				command = new PreorderCommand(tree, new ResetCommand(tree));
			} else {
				try {
					command = new PreorderCommand(tree, undoRedoStackWrapper
							.peek());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			command.execute();
			undoRedoStackWrapper.pushCommand(command);
			tree.updateTree();

		});

		postorderButton.setOnAction((event) -> {
			PostorderCommand command = null;
			if (undoRedoStackWrapper.isEmpty()) {
				command = new PostorderCommand(tree, new ResetCommand(tree));
			} else {
				try {
					command = new PostorderCommand(tree, undoRedoStackWrapper
							.peek());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			command.execute();
			undoRedoStackWrapper.pushCommand(command);
			tree.updateTree();

		});

		breadthFirstButton
				.setOnAction((event) -> {
					BreadthFirstCommand command = null;
					if (undoRedoStackWrapper.isEmpty()) {
						command = new BreadthFirstCommand(tree,
								new ResetCommand(tree));
					} else {
						try {
							command = new BreadthFirstCommand(tree,
									undoRedoStackWrapper.peek());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					command.execute();
					undoRedoStackWrapper.pushCommand(command);
					tree.updateTree();
				});

		undoButton.setOnAction((event) -> {
			undoRedoStackWrapper.undo();
		});

		redoButton.setOnAction((event) -> {
			undoRedoStackWrapper.redo();
		});

	}

	// ikke helt sikker p� hvordan den her metode skal se ud, hvis det er
	// clients der skal kunne tale med hinanden
	public void showMessage(String string) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				collectiveTextArea.appendText(SEPERATOR + string);
			}
		});
	}

	public void updateTableView() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				for (TableColumn<User, ?> column : userTable.getColumns()) {
					column.setVisible(false);
					column.setVisible(true);
				}

			}

		});
	}

	public void updateUserListWithDatabase(ConnectToDatabase connect) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					if (connect == ConnectToDatabase.DO_IT) {
						Iterator<User> userIterator = dbWrapper
								.retrieveAllUsers();
						while (userIterator.hasNext()) {
							userWrapper.addUser(userIterator.next());
						}
					}
				} catch (Exception e) {
					dbLabel.setText("error at an exam OMG!! :'(  ");
					e.printStackTrace();
				}
				data = FXCollections.observableArrayList(userWrapper
						.getUserList());
				userTable.setItems(data);
			}
		});

		neo4jButton.setOnAction((event) -> {
			setMysqlDbWrapper(new Adapter(GraphDb.getInstance()));
			updateUserListWithDatabase(ConnectToDatabase.DO_IT);
			dbLabel.setText("graphdb");
		});

		mysqlButton.setOnAction((event) -> {
			setMysqlDbWrapper(MysqlWrapper.getInstance());
			updateUserListWithDatabase(ConnectToDatabase.DO_IT);
			dbLabel.setText("mysql");
		});

		try {
			graphWrapper = GraphWrapper.getInstance(graphBreadthFirstButton,
					graphDepthFirstButton, graphTable, dbWrapper);
			dbWrapper.registerObserver(graphWrapper);
		} catch (Exception e) {
			System.out.println("couldn't load the graphWrapper");
			e.printStackTrace();
		}
	}
}
