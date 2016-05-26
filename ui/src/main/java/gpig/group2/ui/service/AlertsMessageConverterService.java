package gpig.group2.ui.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import gpig.group2.models.alerts.Action;
import gpig.group2.models.alerts.ActionStatus;
import gpig.group2.models.alerts.AlertMessage;
import gpig.group2.models.alerts.Priority;
import gpig.group2.ui.model.Alert;
import gpig.group2.ui.model.AlertAction;
import gpig.group2.ui.model.AlertPriority;

@Service
public class AlertsMessageConverterService {

	private static final String IMAGE_TAG = "#image:";

	public List<Alert> convertAlertMessageToAlerts(AlertMessage msg) {

		List<Alert> alerts = new ArrayList<>();

		for (gpig.group2.models.alerts.Alert inAlert : msg.alerts) {
			Alert alert = new Alert();

			alert.setId(inAlert.id);
			alert.setPriority(convertAlertPriorityInbound(inAlert));
			alert.setActioned(convertActionStatusInbound(inAlert));

			String[] components = inAlert.message.split(IMAGE_TAG);
			alert.setText(components[0]);
			if (components.length > 1) {
				alert.setImageUrl(components[1]);
			}

			if (inAlert.action != null) {
				alert.setActionText(inAlert.action.message);
			}

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
			msgAlert.action = new Action();
			msgAlert.action.status = convertActionStatusOutbound(alert);
			msgAlert.action.message = alert.getActionText();
			msg.alerts.add(msgAlert);
		}

		return msg;
	}

	private AlertAction convertActionStatusInbound(gpig.group2.models.alerts.Alert inAlert) {

		if (inAlert.action == null) {
			return AlertAction.NOT_ACTIONED;
		}

		switch (inAlert.action.status) {
			case ACTION_ACTIONED:
				return AlertAction.ACTIONED;
			case ACTION_IGNORE:
				return AlertAction.IGNORED;
			default:
				return AlertAction.NOT_ACTIONED;
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

	private ActionStatus convertActionStatusOutbound(Alert alert) {

		switch (alert.getActioned()) {
			case ACTIONED:
				return ActionStatus.ACTION_ACTIONED;
			case IGNORED:
				return ActionStatus.ACTION_IGNORE;
			case NOT_ACTIONED:
				return null;
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
