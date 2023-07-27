package com.app.mina.controller;

import com.app.mina.domain.posto.DadosAlteracaoPosto;
import com.app.mina.domain.posto.DadosCadastroPosto;
import com.app.mina.domain.posto.Posto;
import com.app.mina.domain.posto.PostoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posto")
public class PostoController {

    @Autowired
    private PostoRepository repository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var posto = repository.getReferenceById(id);
            model.addAttribute("posto", posto);
        }
        return "posto/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "posto/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraPosto(DadosCadastroPosto dados) {
        var posto = new Posto(dados);

        repository.save(posto);

        return "redirect:/posto";
    }

    @PutMapping
    @Transactional
    public String alteraPosto(DadosAlteracaoPosto dados) {
        var posto = repository.getReferenceById(dados.id());
        posto.atualizaDados(dados);

        return "redirect:/posto";
    }

    @DeleteMapping
    @Transactional
    public String removePosto(Long id) {
        repository.deleteById(id);

        return "redirect:/posto";
    }
}
