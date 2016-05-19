package gpig.group2.ui.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import gpig.group2.ui.model.Alert;
import gpig.group2.ui.model.AlertAction;
import gpig.group2.ui.model.AlertPriority;

@Service
public class AlertsService {

	@Autowired
	private LoggerService loggerService;
	
	@Value("${alert.upgradeSeconds}")
	private long upgradeSeconds;

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
		DateTime now = new DateTime();
		
		ArrayList<Alert> alerts = new ArrayList<>(unactionedAlerts.values());
		for (Alert alert : alerts) {
			if (now.getMillis() - alert.getLastUpgradeTime().getMillis() >= upgradeSeconds * 1000) {
				AlertPriority newPriority = upgradePriority(alert);
				alert.setPriority(newPriority);
				alert.setLastUpgradeTime(now);
			}
		}
		
		return alerts;
	}

	private AlertPriority upgradePriority(Alert alert) {
		switch (alert.getPriority()) {
			case MEDIUM:
				return AlertPriority.HIGH;
			case LOW:
				return AlertPriority.MEDIUM;
			default:
				return AlertPriority.HIGH;
		}
	}

	public synchronized List<Alert> getActionedAlerts() {
		return new ArrayList<>(actionedAlerts.values());
	}
}
