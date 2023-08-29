package com.app.mina.controller;

import com.app.mina.domain.abastecimento_posto.Abastecimento_posto;
import com.app.mina.domain.abastecimento_posto.Abastecimento_postoRepository;
import com.app.mina.domain.abastecimento_posto.DadosAlteracaoAbastecimento_posto;
import com.app.mina.domain.abastecimento_posto.DadosCadastroAbastecimento_posto;
import com.app.mina.domain.cc_ref.Cc_ref;
import com.app.mina.domain.cc_ref.Cc_refRepository;
import com.app.mina.domain.equipamento.Equipamento;
import com.app.mina.domain.equipamento.EquipamentoRepository;
import com.app.mina.domain.posto_ref.Posto_ref;
import com.app.mina.domain.posto_ref.Posto_refRepository;
import com.app.mina.domain.trabalhador.Trabalhador;
import com.app.mina.domain.trabalhador.TrabalhadorRepository;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/abastecimento_posto") // Mapeamento base para o Controller
public class Abastecimento_postoController {

    // Injeção de dependências
    @Autowired
    private Abastecimento_postoRepository repository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private TrabalhadorRepository trabalhadorRepository;

    @Autowired
    private Cc_refRepository cc_refRepository;

    @Autowired
    private Posto_refRepository posto_refRepository;

    @GetMapping("/formulario") // Manipula a requisição GET para a página de formulário
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

        List<Posto_ref> posto_refs = posto_refRepository.findAll();
        model.addAttribute("posto_refs", posto_refs);

        return "abastecimento_posto/formulario";
    }

    @GetMapping // Manipula a requisição Get para a página de listagem
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "abastecimento_posto/listagem";
    }

    @PostMapping // Manipula a requisição POST para cadastro
    @Transactional
    public String cadastraAbastecimento_posto(DadosCadastroAbastecimento_posto dados) {
        var abastecimento_posto = new Abastecimento_posto(dados);

        repository.save(abastecimento_posto);

        return "redirect:/abastecimento_posto";
    }

    @PutMapping // Manipula a requisição PUT para alteração
    @Transactional
    public String alteraAbastecimento_posto(DadosAlteracaoAbastecimento_posto dados) {
        var abastecimento_posto = repository.getReferenceById(dados.id());
        abastecimento_posto.atualizaDados(dados);

        return "redirect:/abastecimento_posto";
    }

    @DeleteMapping // Manipula a requisiçãop DELETE para remover
    @Transactional
    public String removeAbastecimento_posto(Long id) {
        repository.deleteById(id);

        return "redirect:/abastecimento_posto";
    }

    @PostMapping("/abastecimento_posto") // Manipula a requisição POST para processar um formulário de data e hora
    public String processForm(@RequestParam("data_abastecimento") String dataHoraString) {

        return "redirect:/abastecimento_posto";
    }

}
