package com.app.mina.controller;

import com.app.mina.domain.custos.DadosAlteracaoCustos;
import com.app.mina.domain.custos.DadosCadastroCustos;
import com.app.mina.domain.custos.Custos;
import com.app.mina.domain.custos.CustosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/custos")
public class CustosController {

    @Autowired
    private CustosRepository repository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var custos = repository.getReferenceById(id);
            model.addAttribute("custos", custos);
        }
        return "custos/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "custos/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraCustos(DadosCadastroCustos dados) {
        var custos = new Custos(dados);

        repository.save(custos);

        return "redirect:/custos";
    }

    @PutMapping
    @Transactional
    public String alteraCustos(DadosAlteracaoCustos dados) {
        var custos = repository.getReferenceById(dados.id());
        custos.atualizaDados(dados);

        return "redirect:/custos";
    }

    @DeleteMapping
    @Transactional
    public String removeCustos(Long id) {
        repository.deleteById(id);

        return "redirect:/custos";
    }
}
