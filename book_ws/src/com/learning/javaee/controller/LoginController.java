package com.learning.javaee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Jul 23, 2009
 * Time: 12:42:25 PM
 */
@Controller
@RequestMapping("/demo/login.action")
public class LoginController {
    @RequestMapping(method = RequestMethod.POST)
    public String show(HttpServletRequest request, ModelMap model) {
        System.out.println("<<---------- Inside LoginController ---------->>");
        request.setAttribute("Name", "LogIn");
        return "demo/login";        
    }
}
