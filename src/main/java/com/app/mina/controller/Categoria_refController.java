package com.app.mina.controller;

import com.app.mina.domain.categoria_ref.Categoria_ref;
import com.app.mina.domain.categoria_ref.Categoria_refRepository;
import com.app.mina.domain.categoria_ref.DadosAlteracaoCategoria_ref;
import com.app.mina.domain.categoria_ref.DadosCadastroCategoria_ref;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categoria_ref")
public class Categoria_refController {

    @Autowired
    private Categoria_refRepository repository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var categoria_ref = repository.getReferenceById(id);
            model.addAttribute("categoria_ref", categoria_ref);
        }
        return "categoria_ref/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "categoria_ref/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraCategoria_ref(DadosCadastroCategoria_ref dados) {
        var categoria_ref = new Categoria_ref(dados);

        repository.save(categoria_ref);

        return "redirect:/categoria_ref";
    }

    @PutMapping
    @Transactional
    public String alterarCategoria_ref(DadosAlteracaoCategoria_ref dados) {
        var categoria_ref = repository.getReferenceById(dados.id());
        categoria_ref.atualizaDados(dados);

        return "redirect:/categoria_ref";
    }

    @DeleteMapping
    @Transactional
    public String removeCategoria_ref(Long id) {
        repository.deleteById(id);

        return "redirect:/categoria_ref";
    }
}
