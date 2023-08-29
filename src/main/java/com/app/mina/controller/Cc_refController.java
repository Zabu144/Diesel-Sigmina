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
@RequestMapping("/cc_ref") // Mapeamento base para o Controller
public class Cc_refController {

    // Injeção de dependências
    @Autowired
    private Cc_refRepository repository;

    @GetMapping("/formulario") // Manipula a requisição GET para a página de formulário
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var cc_ref = repository.getReferenceById(id);
            model.addAttribute("cc_ref", cc_ref);
        }
        return "cc_ref/formulario";
    }

    @GetMapping // Manipula a requisição GET para a página de listagem
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "cc_ref/listagem";
    }

    @PostMapping // Manipula a requisição POST para cadastro
    @Transactional
    public String cadastraCc_ref(DadosCadastroCc_ref dados) {
        var cc_ref = new Cc_ref(dados);

        repository.save(cc_ref);

        return "redirect:/cc_ref";
    }

    @PutMapping // Manipula a requisição PUT para alteração
    @Transactional
    public String alteraCc_ref(DadosAlteracaoCc_ref dados) {
        var cc_ref = repository.getReferenceById(dados.id());
        cc_ref.atualizaDados(dados);

        return "redirect:/cc_ref";
    }

    @DeleteMapping // Manipula a requisição DELETE para remover
    @Transactional
    public String removeCc_ref(Long id) {
        repository.deleteById(id);

        return "redirect:/cc_ref";
    }
}
