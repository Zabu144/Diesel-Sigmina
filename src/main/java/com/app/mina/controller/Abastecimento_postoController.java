package com.app.mina.controller;

import com.app.mina.domain.abastecimento_posto.Abastecimento_posto;
import com.app.mina.domain.abastecimento_posto.Abastecimento_postoRepository;
import com.app.mina.domain.abastecimento_posto.DadosAlteracaoAbastecimento_posto;
import com.app.mina.domain.abastecimento_posto.DadosCadastroAbastecimento_posto;
import com.app.mina.domain.cc_ref.Cc_ref;
import com.app.mina.domain.cc_ref.Cc_refRepository;
import com.app.mina.domain.equipamento.Equipamento;
import com.app.mina.domain.equipamento.EquipamentoRepository;
import com.app.mina.domain.trabalhador.Trabalhador;
import com.app.mina.domain.trabalhador.TrabalhadorRepository;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/abastecimento_posto")
public class Abastecimento_postoController {

    @Autowired
    private Abastecimento_postoRepository repository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private TrabalhadorRepository trabalhadorRepository;

    @Autowired
    private Cc_refRepository cc_refRepository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var abastecimento_posto = repository.getReferenceById(id);
            model.addAttribute("abastecimento_posto", abastecimento_posto);
        }

        List<Equipamento> equipamentos = equipamentoRepository.findAll();
        model.addAttribute("equipamentos", equipamentos);

        List<Trabalhador> trabalhadors = trabalhadorRepository.findAll();
        model.addAttribute("trabalhadors", trabalhadors);

        List<Cc_ref> cc_refs = cc_refRepository.findAll();
        model.addAttribute("cc_refs", cc_refs);

        return "abastecimento_posto/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "abastecimento_posto/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraAbastecimento_posto(DadosCadastroAbastecimento_posto dados) {
        var abastecimento_posto = new Abastecimento_posto(dados);

        repository.save(abastecimento_posto);

        return "redirect:/abastecimento_posto";
    }

    @PutMapping
    @Transactional
    public String alteraAbastecimento_posto(DadosAlteracaoAbastecimento_posto dados) {
        var abastecimento_posto = repository.getReferenceById(dados.id());
        abastecimento_posto.atualizaDados(dados);

        return "redirect:/abastecimento_posto";
    }

    @DeleteMapping
    @Transactional
    public String removeAbastecimento_posto(Long id) {
        repository.deleteById(id);

        return "redirect:/abastecimento_posto";
    }

}
