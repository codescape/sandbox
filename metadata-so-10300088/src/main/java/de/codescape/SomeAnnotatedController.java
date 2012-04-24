package de.codescape;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SomeAnnotatedController {

    @RequestMapping(method = {RequestMethod.GET}, value = "/someUrl")
    public void someMethod() {
        // do something later
    }

}
