package com.app.mina.controller;

import com.app.mina.domain.equipamento.Equipamento;
import com.app.mina.domain.equipamento.EquipamentoRepository;
import com.app.mina.domain.posto_ref.DadosAlteracaoPosto_ref;
import com.app.mina.domain.posto_ref.DadosCadastroPosto_ref;
import com.app.mina.domain.posto_ref.Posto_ref;
import com.app.mina.domain.posto_ref.Posto_refRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posto_ref") // Manipula a requisição GET para a página de formulário
public class Posto_refController {

    // Injeção de dependências
    @Autowired
    private Posto_refRepository repository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @GetMapping("/formulario") // Manipula a requisição GET para a página de formulário
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var posto_ref = repository.getReferenceById(id);
            model.addAttribute("posto_ref", posto_ref);
        }

        List<Equipamento> equipamentos = equipamentoRepository.findAll();
        model.addAttribute("equipamentos", equipamentos);

        return "posto_ref/formulario";
    }

    @GetMapping // Manipula a requisição GET para a página de listagem
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "posto_ref/listagem";
    }

    @PostMapping // Manipula a requisição POST para cadastro
    @Transactional
    public String cadastraPosto_ref(DadosCadastroPosto_ref dados) {
        var posto_ref = new Posto_ref(dados);

        repository.save(posto_ref);

        return "redirect:/posto_ref";
    }

    @PutMapping // Manipula a requisição PUT para alteração
    @Transactional
    public String alteraPosto_ref(DadosAlteracaoPosto_ref dados) {
        var posto_ref = repository.getReferenceById(dados.id());
        posto_ref.atualizaDados(dados);

        return "redirect:/posto_ref";
    }

    @DeleteMapping // Manipula a requisição DELETE para remover
    @Transactional
    public String removePosto_ref(Long id) {
        repository.deleteById(id);

        return "redirect:/posto_ref";
    }
}
