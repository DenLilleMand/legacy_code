package eventHandlingController;

import java.util.Arrays;

import controller.NetworkControllerClient;
import entities.User;
import entities.UserStatus;
import state.State;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import loaders.LoadingPictures;

public class EventHandlingControllerMainClient {
	private static EventHandlingControllerMainClient instance;

	public EventHandlingControllerMainClient() {
		// dont handle reflection here - the FXML loader uses reflection to load
		// data into this object
		// atleast the documentation mentions smt. about reflection.
	}

	public static EventHandlingControllerMainClient getInstance() {
		if (instance == null) {
			instance = new EventHandlingControllerMainClient();
		}
		return instance;
	}

	// fxid :"userColumn"
	@FXML
	private TableColumn<User, User> userColumn;


	// fxid :"onlineColumn"
	@FXML
	private TableColumn<User, User> onlineColumn;
	
	@FXML
	private TextField subjectField;

	@FXML
	private Label userLabel;

	@FXML
	private TableColumn<User, User> friendColumn;

	@FXML
	private TextArea writeChatArea;

	@FXML
	private AnchorPane mainAnchorPane;

	@FXML
	private Button sendButton;

	@FXML
	private TextArea collectiveTextArea;

	@FXML
	private ScrollPane textAreaPane;

	@FXML
	private ScrollPane writeChatPane;

	// fxid :"userTable"
	@FXML
	private TableView<User> userTable;

	@FXML
	private Label collectiveLabel;

	@FXML
	private Label chatLabel;

	@FXML
	private MenuItem connectItem;

	@FXML
	private MenuItem exitItem;

	@FXML
	private GridPane backgroundPane;

	private final String ZERO = "";
	private NetworkControllerClient networkController = NetworkControllerClient
			.getInstance();

	private ObservableList<User> userList;

	private State state = State.getInstance();
	private final String SEPERATOR = System.getProperty("line.separator");
	private ContextMenu userMenu = null;

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		instance = this;
		ableToType(true);
		userMenu = new ContextMenu();
		
		
		

		sendButton
				.setOnAction((event) -> {
					try {
						String message = writeChatArea.getText();
						if (message != null) {
							networkController.sendMessage(writeChatArea
									.getText(),subjectField.getText(),Arrays.asList(subjectField.getText().split(" ")));
						} else {
							networkController
									.sendMessage("the message was null/or possibly the field that it came from", " no subject",Arrays.asList(subjectField.getText().split(" ")));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					writeChatArea.setText(ZERO);
				});
		userColumn.setCellValueFactory(new PropertyValueFactory<User, User>(
				"User Name"));

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

		friendColumn
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

								}
								// since the boolean is Boolean, it could
								// possibly be null...
								// or as renderers so often do, continue their
								// weird behavior despite no
								// objects.
								else {
									labelGraphic.setImage(null);
									label.setText(null);
								}
								setGraphic(label);
							}
						};
					}
				});
		// �benbart g�r den her metode forskellen. men hvad den lige g�r er jeg
		// ikke helt sikker p� :)
		// men det er tydeligvis en anden slags cell factory der bliver brugt.
		// s� de m� komplimentere hinanden.
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

		friendColumn
				.setCellFactory(new Callback<TableColumn<User, User>, TableCell<User, User>>() {
					@Override
					public TableCell<User, User> call(
							TableColumn<User, User> friendColumn) {
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
									if (user.getUserStatus().equalsIgnoreCase(
											UserStatus.FRIEND)) {
										label.setText(ZERO);
										labelGraphic.setImage(LoadingPictures
												.getCheckedImage());
									} else if (user.getUserStatus()
											.equalsIgnoreCase(UserStatus.USER)) {
										label.setText(ZERO);
										labelGraphic.setImage(LoadingPictures
												.getUncheckedImage());
									}

								}
								// since the boolean is Boolean, it could
								// possibly be null...
								// or as renderers so often do, continue their
								// weird behavior despite no
								// objects.
								else {
									labelGraphic.setImage(null);
									label.setText(null);
								}
								setGraphic(label);
							}
						};
					}
				});
		MenuItem removeItem = new MenuItem("Remove friend");
		removeItem.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				User selectedFriend = userTable.getSelectionModel()
						.getSelectedItem();
				if (selectedFriend != null) {
					try {
						User copiedUser = selectedFriend.copy();// smt about
																// serialization.
						copiedUser.setUserStatus(UserStatus.USER);
						networkController.removeFriend(copiedUser);
						selectedFriend.setUserStatus(UserStatus.USER);
						updateTableView();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		MenuItem addItem = new MenuItem("Add friend");
		addItem.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				User selectedUser = userTable.getSelectionModel()
						.getSelectedItem();
				if (selectedUser != null) {
//					System.out.println(selectedUser.getUserName() + ":"
//							+ selectedUser.getUserStatus());
					try {
						User copiedUser = selectedUser.copy();// smt about
																// serialization.
						copiedUser.setUserStatus(UserStatus.FRIEND);
						networkController.addFriend(copiedUser);
						selectedUser.setUserStatus(UserStatus.FRIEND);
						updateTableView();
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}

			}
		});
		userMenu.getItems().addAll(addItem, removeItem);

		userTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// Åbenbart så scaler javafx ikke DPI, og fordi vi har:
				System.out.println(javafx.stage.Screen.getPrimary().getDpi());
				// = 96 i DPI, så fucker vores coordinater, så¨jeg har plusset
				// dem lidt :)
				// blog om DPI scaling:
				// http://news.kynosarges.org/2013/08/09/javafx-dpi-scaling/
				userMenu.show((Node) event.getSource(),
						event.getSceneX() + 350, event.getSceneY() + 100);
			}
		});

		updateUserList();
		KeyCombination undo = new KeyCodeCombination(KeyCode.Z,
				KeyCombination.CONTROL_DOWN);
		/**
		 * Start p� stack l�sning af undo/redo(3rd semester eksamen). ideen bag
		 * det var at man kunne undo/redo at tilf�je venner tror jeg.
		 */
		writeChatArea.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (undo.match(event)) {
				}
			}
		});

		connectItem.setOnAction((event) -> {
			try {
				connect();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		userLabel.setText(State.getInstance().getUser().getUserName());
	}

	public void updateUserList() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				userList = FXCollections.observableArrayList(state
						.getUserList());
				for (int i = 0; i < userList.size(); i++) {
					if (userList
							.get(i)
							.getUserName()
							.equalsIgnoreCase(
									State.getInstance().getUser().getUserName())) {
						userList.remove(i);
						break;
					}
				}
				userTable.setItems(userList);
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

	public ObservableList<User> getData() {
		return userList;
	}

	private void connect() throws Exception {
		networkController.connectToServer();
	}

	private void ableToType(boolean bool) {
		writeChatArea.setEditable(bool);
	}

	public void showMessage(String message) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				collectiveTextArea.appendText(SEPERATOR + message);
			}
		});
	}

	public TableView<User> getUserTable() {
		return userTable;
	}
}
