package gpig.group2.ui;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class DemoController {

	@Autowired
	private AlertsService alertsService;
	
    @RequestMapping()
    public String settingsPage() throws Exception {

        return "home";
    }
    
    @RequestMapping(value = "/alerts", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Alert> getNewAlerts() {
    	return alertsService.getUnActionedAlerts();
    }
}
