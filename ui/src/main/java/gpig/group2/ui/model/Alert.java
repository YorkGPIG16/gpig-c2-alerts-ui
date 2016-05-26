package gpig.group2.ui.model;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Alert {

	private Integer id;
	private String text;
	private AlertPriority priority;
	private AlertAction actioned;
	private String actionText;
	private String imageUrl;

	@JsonIgnore
	private DateTime createdDate;

	@JsonIgnore
	private DateTime lastUpgradeTime;

	public Alert() {
		setCreatedDate();
		lastUpgradeTime = createdDate;
	}

	public Alert(Integer id, String text, String imageUrl, AlertPriority priority, AlertAction actioned) {
		this.id = id;
		this.text = text;
		this.priority = priority;
		this.actioned = actioned;
		this.imageUrl = imageUrl;

		setCreatedDate();
		lastUpgradeTime = createdDate;
	}

	public void setImageUrl(String imageUrl) {

		this.imageUrl = imageUrl;
	}

	public String getImageUrl() {

		return imageUrl;
	}

	public DateTime getLastUpgradeTime() {

		return lastUpgradeTime;
	}

	public void setLastUpgradeTime(DateTime lastUpgradeTime) {

		this.lastUpgradeTime = lastUpgradeTime;
	}

	public DateTime getCreatedDate() {

		return createdDate;
	}

	private void setCreatedDate() {

		createdDate = new DateTime();
	}

	public String getActionText() {

		return actionText;
	}

	public void setActionText(String actionText) {

		this.actionText = actionText;
	}

	public String getText() {

		return text;
	}

	public void setText(String alertText) {

		this.text = alertText;
	}

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {

		this.id = id;
	}

	public AlertPriority getPriority() {

		return priority;
	}

	public void setPriority(AlertPriority priority) {

		this.priority = priority;
	}

	public AlertAction getActioned() {

		return actioned;
	}

	public void setActioned(AlertAction actioned) {

		this.actioned = actioned;
	}

	@Override
	public String toString() {

		return "Alert [id=" + id + ", text=" + text + ", priority=" + priority + ", actioned=" + actioned
				+ ", actionText=" + actionText + "]";
	}
}
