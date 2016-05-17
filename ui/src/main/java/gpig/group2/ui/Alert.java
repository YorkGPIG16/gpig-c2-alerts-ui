package gpig.group2.ui;

public class Alert {

	private int id;
	private String text;
	private AlertPriority priority;
	private boolean actioned;

	public Alert(int id, String text, AlertPriority priority, boolean actioned) {
		super();
		this.id = id;
		this.text = text;
		this.priority = priority;
		this.actioned = actioned;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String alertText) {
		this.text = alertText;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AlertPriority getPriority() {
		return priority;
	}

	public void setPriority(AlertPriority priority) {
		this.priority = priority;
	}

	public boolean isActioned() {
		return actioned;
	}

	public void setActioned(boolean actioned) {
		this.actioned = actioned;
	}
}
