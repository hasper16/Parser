package ua.org.hasper.Parser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController {


    @RequestMapping(value = "error", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {

        ModelAndView errorPage = new ModelAndView("errorPage");
        String errorMsg = "";
        String errorHead = "";
        int httpErrorCode = getErrorCode(httpRequest);

        switch (httpErrorCode) {
            case 400: {
                errorMsg = "Http Error Code: 400. Bad Request";
                errorHead = "Error 400";
                break;
            }
            case 401: {
                errorMsg = "Http Error Code: 401. Unauthorized";
                errorHead = "Error 401";
                break;
            }
            case 404: {
                errorMsg = "Http Error Code: 404. Resource not found";
                errorHead = "Error 404";
                break;
            }
            case 405: {
                errorMsg = "Http Error Code: 405. Method Not Allowed";
                errorHead = "Error 405";
                break;
            }
            case 500: {
                errorMsg = "Http Error Code: 500. Internal Server Error";
                errorHead = "Error 500";
                break;
            }
        }
        errorPage.addObject("errorMsg", errorMsg);
        errorPage.addObject("errorHead", errorHead);
        return errorPage;
    }

    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
                .getAttribute("javax.servlet.error.status_code");
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}