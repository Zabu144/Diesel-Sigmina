package com.app.mina.controller;

import com.app.mina.domain.cc.Cc;
import com.app.mina.domain.cc.DadosAlteracaoCc;
import com.app.mina.domain.cc.DadosCadastroCc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import com.app.mina.domain.cc.CcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cc")
public class CcController {

    @Autowired
    private CcRepository repository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var cc = repository.getReferenceById(id);
            model.addAttribute("cc", cc);
        }
        return "cc/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "cc/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraCc(DadosCadastroCc dados) {
        var cc = new Cc(dados);

        repository.save(cc);

        return "redirect:/cc";
    }

    public String alteraCc(DadosAlteracaoCc dados) {
        var cc = repository.getReferenceById(dados.id());
        cc.atualizaDados(dados);

        return "redirect:/cc";
    }

    @DeleteMapping
    @Transactional
    public String removeCc(Long id) {
        repository.deleteById(id);

        return "redirect:/cc";
    }
}
