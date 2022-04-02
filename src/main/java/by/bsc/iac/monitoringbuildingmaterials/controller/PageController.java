package by.bsc.iac.monitoringbuildingmaterials.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/international")
public class PageController {

    @GetMapping("/international")
    public String getInternationalPage(HttpServletRequest request) {
        String newURI = request.getRequestURI().replace("/iacsk", "");
        if (newURI.contains("?lang=")) {
            newURI = newURI.substring(0, newURI.length() - 2) + request.getParameter("lang");
        } else {
            newURI = newURI.replace("/international", "?lang=" + request.getParameter("lang"));
        }
        return "redirect:" + newURI;
    }

}
