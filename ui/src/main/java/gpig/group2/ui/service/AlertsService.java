package gpig.group2.ui.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gpig.group2.ui.model.Alert;
import gpig.group2.ui.model.AlertAction;

@Service
public class AlertsService {

	@Autowired
	private LoggerService loggerService;

	private Map<Integer, Alert> unactionedAlerts = new HashMap<>();
	private Map<Integer, Alert> actionedAlerts = new HashMap<>();

	public synchronized void addAlerts(List<Alert> alerts) {
		for (Alert alert : alerts) {
			unactionedAlerts.put(alert.getId(), alert);
		}
	}

	public synchronized void actionAlert(int alertId, AlertAction action, String actionText) {
		Alert alert = unactionedAlerts.get(alertId);
		alert.setActioned(action);
		alert.setActionText(actionText);
		
		loggerService.logActionedAlert(alert);
		unactionedAlerts.remove(alertId);
		actionedAlerts.put(alertId, alert);
	}
	
	public synchronized List<Alert> getUnActionedAlerts() {
		return new ArrayList<>(unactionedAlerts.values());
	}

	public synchronized List<Alert> getActionedAlerts() {
		return new ArrayList<>(actionedAlerts.values());
	}
}
