package gpig.group2.ui;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import gpig.group2.models.alerts.Action;
import gpig.group2.models.alerts.AlertMessage;
import gpig.group2.models.alerts.Priority;

@Service
public class AlertsMessageConverterService {

	public List<Alert> convertAlertMessageToAlerts(AlertMessage msg) {

		List<Alert> alerts = new ArrayList<>();

		for (gpig.group2.models.alerts.Alert inAlert : msg.alerts) {
			Alert alert = new Alert();

			alert.setId(inAlert.id);
			alert.setText(inAlert.message);
			alert.setPriority(convertAlertPriorityInbound(inAlert));
			alert.setActioned(convertActionedInbound(inAlert));

			alerts.add(alert);
		}

		return alerts;
	}

	public AlertMessage convertAlertsToAlertMessage(List<Alert> alerts) {

		AlertMessage msg = new AlertMessage();
		msg.alerts = new ArrayList<>();

		for (Alert alert : alerts) {
			gpig.group2.models.alerts.Alert msgAlert = new gpig.group2.models.alerts.Alert();
			msgAlert.id = alert.getId();
			msgAlert.message = alert.getText();
			msgAlert.priority = convertPriorityOutbound(alert);
			msgAlert.action = convertActionedOutbound(alert);
			msg.alerts.add(msgAlert);
		}

		return msg;
	}

	private AlertAction convertActionedInbound(gpig.group2.models.alerts.Alert inAlert) {
		switch (inAlert.action) {
			case ACTION_ACTIONED:
				return AlertAction.ACTIONED;
			case ACTION_IGNORE:
				return AlertAction.IGNORED;
			case ACTION_NOT_ACTIONED:
				return AlertAction.NOT_ACTIONED;
			default:
				return null;
		}
	}

	private AlertPriority convertAlertPriorityInbound(gpig.group2.models.alerts.Alert inAlert) {
		switch (inAlert.priority) {
			case PRIORITY_LOW:
				return AlertPriority.LOW;
			case PRIORITY_MEDIUM:
				return AlertPriority.MEDIUM;
			case PRIORITY_HIGH:
				return AlertPriority.HIGH;
			default:
				return null;
		}
	}

	private Action convertActionedOutbound(Alert alert) {
		switch (alert.getActioned()) {
			case ACTIONED:
				return Action.ACTION_ACTIONED;
			case IGNORED:
				return Action.ACTION_IGNORE;
			case NOT_ACTIONED:
				return Action.ACTION_NOT_ACTIONED;
			default:
				return null;
		}
	}

	private Priority convertPriorityOutbound(Alert alert) {
		switch (alert.getPriority()) {
			case HIGH:
				return Priority.PRIORITY_HIGH;
			case MEDIUM:
				return Priority.PRIORITY_MEDIUM;
			case LOW:
				return Priority.PRIORITY_LOW;
			default:
				return null;
		}
	}
}
