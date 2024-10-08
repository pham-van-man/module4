package org.example.bai_tap_1.controller;

import org.example.bai_tap_1.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private ServiceImpl serviceMoney;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/result")
    public String result(@RequestParam double usd, Model model) {
        usd = serviceMoney.currencyConverter(usd);
        model.addAttribute("usd", usd);
        return "home";
    }
}
