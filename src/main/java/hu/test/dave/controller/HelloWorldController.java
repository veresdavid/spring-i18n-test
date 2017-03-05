package hu.test.dave.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping("/")
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model, Locale locale) {
        String item = messageSource.getMessage("secret.item", null, locale);
        model.addAttribute("item", item);
        return "welcome";
    }

    @RequestMapping(value = "/helloagain", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model, Locale locale) {
        String item = messageSource.getMessage("secret.item", null, locale);
        model.addAttribute("item", item);
        return "welcome";
    }

}
