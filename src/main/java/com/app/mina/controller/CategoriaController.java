package com.app.mina.controller;

import com.app.mina.domain.categoria.Categoria;
import com.app.mina.domain.categoria.CategoriaRepository;
import com.app.mina.domain.categoria.DadosAlteracaoCategoria;
import com.app.mina.domain.categoria.DadosCadastroCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var categoria = repository.getReferenceById(id);
            model.addAttribute("categoria", categoria);
        }
        return "categoria/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "categoria/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraCategoria(DadosCadastroCategoria dados) {
        var categoria = new Categoria(dados);

        repository.save(categoria);

        return "redirect:/categoria";
    }

    @PutMapping
    @Transactional
    public String alterarCategoria(DadosAlteracaoCategoria dados) {
        var categoria = repository.getReferenceById(dados.id());
        categoria.atualizaDados(dados);

        return "redirect:/categoria";
    }

    @DeleteMapping
    @Transactional
    public String removeCategoria(Long id) {
        repository.deleteById(id);

        return "redirect:/categoria";
    }
}
