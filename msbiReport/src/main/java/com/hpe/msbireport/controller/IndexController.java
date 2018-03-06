package com.hpe.msbireport.controller;

import com.hpe.msbireport.service.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Project:
 * Author: HONGMIN GAO
 * Date: 26/12/17
 * Description: This is the entry point for this web app.
 */
@Controller
@RequestMapping("/api/")
public class IndexController {

    @RequestMapping("/index.html")
    public String index(Model model){
        model.addAttribute("welcome","This is index page..");
        return "index";
    }

}

