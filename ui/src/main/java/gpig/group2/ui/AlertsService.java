package gpig.group2.ui;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertsService {

	@Autowired
	private LoggerService loggerService;

	private Map<Integer, Alert> unactionedAlerts = new HashMap<>();

	public synchronized void addAlert(Alert alert) {
		unactionedAlerts.put(alert.getId(), alert);
	}

	public synchronized void actionAlert(int alertId) {
		Alert alert = unactionedAlerts.get(alertId);
		alert.setActioned(true);
		loggerService.logActionedAlert(alert);
		unactionedAlerts.remove(alertId);
	}

	public synchronized Collection<Alert> getUnActionedAlerts() {
		return unactionedAlerts.values();
	}
	
	@PostConstruct
	public void postConstruct() {
		unactionedAlerts.put(1, new Alert(1, "alert 1", AlertPriority.FIVE, false));
		unactionedAlerts.put(2, new Alert(2, "alert 2", AlertPriority.FOUR, false));
	}
}
