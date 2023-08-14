package com.app.mina.controller;

import com.app.mina.domain.ccRef.DadosAlteracaoCcRef;
import com.app.mina.domain.ccRef.DadosCadastroCcRef;
import com.app.mina.domain.ccRef.CcRef;
import com.app.mina.domain.ccRef.CcRefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ccRef")
public class CcRefController {

    @Autowired
    private CcRefRepository repository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var ccRef = repository.getReferenceById(id);
            model.addAttribute("ccRef", ccRef);
        }
        return "ccRef/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "ccRef/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraCcRef(DadosCadastroCcRef dados) {
        var ccRef = new CcRef(dados);

        repository.save(ccRef);

        return "redirect:/ccRef";
    }

    @PutMapping
    @Transactional
    public String alteraCcRef(DadosAlteracaoCcRef dados) {
        var ccRef = repository.getReferenceById(dados.id());
        ccRef.atualizaDados(dados);

        return "redirect:/ccRef";
    }

    @DeleteMapping
    @Transactional
    public String removeCcRef(Long id) {
        repository.deleteById(id);

        return "redirect:/ccRef";
    }
}
