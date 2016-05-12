package gpig.group2.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class DemoController {

    @RequestMapping()
    public String settingsPage() throws Exception {

        return "home";
    }
}
