package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/homepage")
    public String showHomepage(Model model) {
        // 必要に応じてモデルにデータを追加
        model.addAttribute("message", "Welcome to the homepage!");
        return "homepage"; // テンプレート名
    }
}
