package gpig.group2.ui.service;

import org.springframework.stereotype.Service;

import gpig.group2.ui.model.Alert;

@Service
public class LoggerService {
	public void logActionedAlert(Alert alert) {
		//TODO: Impliement LoggerService properly
		System.out.println(alert.toString());
	}
}
