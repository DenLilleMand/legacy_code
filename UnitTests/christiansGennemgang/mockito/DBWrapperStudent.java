package mockito;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DBWrapperStudent {
	private Log logger;
	private Configuration configuration;

	public DBWrapperStudent() {
		this(LogFactory.getLog(DefaultAccountManager.class),
				new DefaultConfiguration("school"));
	}

	public DBWrapperStudent(Log logger, Configuration configuration) {
		this.logger = logger;
		this.configuration = configuration;
	}

}
