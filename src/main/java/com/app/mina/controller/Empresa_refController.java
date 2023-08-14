package com.app.mina.controller;

import com.app.mina.domain.empresa_ref.DadosAlteracaoEmpresa_ref;
import com.app.mina.domain.empresa_ref.DadosCadastroEmpresa_ref;
import com.app.mina.domain.empresa_ref.Empresa_ref;
import com.app.mina.domain.empresa_ref.Empresa_refRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/empresa_ref")
public class Empresa_refController {

    @Autowired
    private Empresa_refRepository repository;


    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var empresa_ref = repository.getReferenceById(id);
            model.addAttribute("empresa_ref", empresa_ref);
        }
        return "empresa_ref/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "empresa_ref/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraEmpresa_ref(DadosCadastroEmpresa_ref dados) {
        var empresa_ref = new Empresa_ref(dados);

        repository.save(empresa_ref);

        return "redirect:/empresa_ref";
    }

    @PutMapping
    @Transactional
    public String alteraEmpresa_ref(DadosAlteracaoEmpresa_ref dados) {
        var empresa_ref = repository.getReferenceById(dados.id());
        empresa_ref.atualizaDados(dados);

        return "redirect:/empresa_ref";
    }

    @DeleteMapping
    @Transactional
    public String removeEmpresa_ref(Long id) {
        repository.deleteById(id);

        return "redirect:/empresa_ref";
    }
}
