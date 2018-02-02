package ua.org.hasper.Parser.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;


@Controller
public class MainController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String homePage(WebRequest request, Model model) {
        return "index";
    }

    @RequestMapping(value = {"/stepOne", "/stepTwo", "/stepThree", "/stepFour", "/stepFive", "/stepSix"}, method = RequestMethod.GET)
    public String steps() {
        return "redirect:/";
    }


}
