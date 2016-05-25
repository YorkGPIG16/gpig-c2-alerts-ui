package gpig.group2.ui.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import gpig.group2.models.alerts.AlertMessage;
import gpig.group2.ui.model.Alert;
import gpig.group2.ui.service.AlertsMessageConverterService;
import gpig.group2.ui.service.AlertsService;

@Controller
@RequestMapping("/")
public class AlertsController {

	@Autowired
	private AlertsService alertsService;
	
	@Autowired AlertsMessageConverterService alertsMessageConverterService;

	@RequestMapping("/alertsui")
	public String settingsPage() throws Exception {

		return "alertsui";
	}

	@RequestMapping(value = "/alerts", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public Collection<Alert> getNewAlerts() {
		return alertsService.getUnActionedAlerts();
	}

	@RequestMapping(value = "/alerts", consumes = "application/xml", method = RequestMethod.POST)
	@ResponseBody
	public String receiveAlerts(@RequestBody AlertMessage msg) {
		List<Alert> alerts = alertsMessageConverterService.convertAlertMessageToAlerts(msg);
		alertsService.addAlerts(alerts);
		return "Received";
	}
	
	@RequestMapping(value = "/alerts/action", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public String actionAlert(@RequestBody Alert alert) {
		alertsService.actionAlert(alert.getId(), alert.getActioned(), alert.getActionText());
		return "Actioned";
	}
	
	@RequestMapping(value = "/actionedAlerts", produces = "application/xml", method = RequestMethod.GET)
	@ResponseBody
	public AlertMessage getActionedAlerts() {
		return alertsMessageConverterService.convertAlertsToAlertMessage(alertsService.getActionedAlerts());
	}
}
