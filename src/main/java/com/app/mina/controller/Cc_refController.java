package com.app.mina.controller;

import com.app.mina.domain.cc_ref.DadosAlteracaoCc_ref;
import com.app.mina.domain.cc_ref.DadosCadastroCc_ref;
import com.app.mina.domain.cc_ref.Cc_ref;
import com.app.mina.domain.cc_ref.Cc_refRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cc_ref")
public class Cc_refController {

    @Autowired
    private Cc_refRepository repository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var cc_ref = repository.getReferenceById(id);
            model.addAttribute("cc_ref", cc_ref);
        }
        return "cc_ref/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "cc_ref/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraCc_ref(DadosCadastroCc_ref dados) {
        var cc_ref = new Cc_ref(dados);

        repository.save(cc_ref);

        return "redirect:/cc_ref";
    }

    @PutMapping
    @Transactional
    public String alteraCc_ref(DadosAlteracaoCc_ref dados) {
        var cc_ref = repository.getReferenceById(dados.id());
        cc_ref.atualizaDados(dados);

        return "redirect:/cc_ref";
    }

    @DeleteMapping
    @Transactional
    public String removeCc_ref(Long id) {
        repository.deleteById(id);

        return "redirect:/cc_ref";
    }
}
