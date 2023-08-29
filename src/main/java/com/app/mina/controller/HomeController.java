package com.app.mina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home") // Mapeamento base para o Controller
public class HomeController {

    @GetMapping("page") // Manipula a requisição GET para a página home/page
    public String carregaPaginaHome() {
        return "home/page";
    }
}
