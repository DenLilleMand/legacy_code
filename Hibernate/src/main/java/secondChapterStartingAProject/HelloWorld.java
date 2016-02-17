package secondChapterStartingAProject;

import java.util.*;
import org.hibernate.*;
import javax.persistence.*;

public class HelloWorld 
{
	public static void main(String[] args) 
	{
		// First unit of work
		/**Session: Session—A Hibernate Session is many things in one. It’s a single-threaded
nonshared object that represents a particular unit of work with the database.
It has the persistence manager API you call to load and store objects.
(The Session internals consist of a queue of SQL statements that need to be
synchronized with the database at some point and a map of managed persistence
instances that are monitored by the Session.) */
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		/**Transaction: Transaction—This Hibernate API can be used to set transaction boundaries
programmatically, but it’s optional (transaction boundaries aren’t).
Other choices are JDBC transaction demarcation, the JTA interface, or container-
managed transactions with EJBs. */
		Transaction tx = session.beginTransaction();
		Message message = new Message("Hello World");
		Long msgId = (Long) session.save(message);
		tx.commit();
		session.close();
		// Second unit of work
		Session newSession = HibernateUtil.getSessionFactory().openSession();
		Transaction newTransaction = newSession.beginTransaction();
		/**Query: Query—A database query can be written in Hibernate’s own object-oriented
query language (HQL) or plain SQL. This interface allows you to create queries,
bind arguments to placeholders in the query, and execute the query in
various ways. - det er skrevet i HQL, og bliver oversat til:
select m.MESSAGE_ID, m.MESSAGE_TEXT, m.NEXT_MESSAGE_ID
from MESSAGES m
order by m.MESSAGE_TEXT asc  | når det bliver kørt */
		List messages = newSession.createQuery(
				"from Message m order by m.text asc").list();
		System.out.println(messages.size() + " message(s) found:");

		for (Iterator iter = messages.iterator(); iter.hasNext();) {
			Message loadedMsg = (Message) iter.next();
			System.out.println(loadedMsg.getText());
		}
		newTransaction.commit();
		newSession.close();
		
		/**uncomment når vi kommer dertil. denne kode kalder de queries der ser sådan her ud:
		 * select m.MESSAGE_ID, m.MESSAGE_TEXT, m.NEXT_MESSAGE_ID
from MESSAGES m
where m.MESSAGE_ID = 1
insert into MESSAGES (MESSAGE_ID, MESSAGE_TEXT, NEXT_MESSAGE_ID)
values (2, 'Take me to your leader (please)', null)
update MESSAGES
set MESSAGE_TEXT = 'Greetings Earthling', NEXT_MESSAGE_ID = 2
where MESSAGE_ID = 1 */
//		// Third unit of work
//		Session thirdSession =
//		HibernateUtil.getSessionFactory().openSession();
//		Transaction thirdTransaction = thirdSession.beginTransaction();
//		// msgId holds the identifier value of the first message
//		message = (Message) thirdSession.get( Message.class, msgId );
//		message.setText( "Greetings Earthling" );
//		message.setNextMessage(
//		new Message( "Take me to your leader (please)" )
//		);
//		thirdTransaction.commit();
//		thirdSession.close();
		// Shutting down the application
		HibernateUtil.shutDown();
	}
}