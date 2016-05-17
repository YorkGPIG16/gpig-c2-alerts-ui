package gpig.group2.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public synchronized void actionAlert(int alertId, AlertAction action) {
		Alert alert = unactionedAlerts.get(alertId);
		alert.setActioned(action);
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
