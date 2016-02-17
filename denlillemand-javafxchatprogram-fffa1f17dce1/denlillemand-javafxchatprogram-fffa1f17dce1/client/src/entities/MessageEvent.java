package entities;

import java.io.Serializable;
import java.lang.Iterable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MessageEvent implements Serializable, Comparable<MessageEvent>
{
	private String message;
	private String sender;
	private String visitOrder;
	private String subject;
	private List<String> subjects = new ArrayList<String>();
	
	public List<String> getSubjects()
	{
		return subjects;
	}
	
	public void addSubject(String subject)
	{
		subjects.add(subject);
	}
	
	public void addAllSubjects(Collection<String> collection)
	{
		subjects.addAll(collection);
	}
	
	
	
	public MessageEvent()
	{
		
	}
	
	public MessageEvent(String message,String subject,List<String> subjects, String sender)
	{
		this.message = message;
		this.subjects = subjects;
		this.sender = sender;
		this.subject = subject;
	}
	
	public String getSubject()
	{
		return subject;
	}
	
	public void setSubjects(List<String> list) {
		this.subjects = list;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public String getVisitOrder() {
		return visitOrder;
	}

	public void setVisitOrder(String visitOrder) {
		this.visitOrder = visitOrder;
	}
	


	@Override
	public int compareTo(MessageEvent o) {
		if(subjects.equals(o.getSubjects()))
		{
			return 0;
		}
			return -1;			
	}

}
