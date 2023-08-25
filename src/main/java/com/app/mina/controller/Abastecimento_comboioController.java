package com.app.mina.controller;

import com.app.mina.domain.abastecimento_comboio.Abastecimento_comboio;
import com.app.mina.domain.abastecimento_comboio.Abastecimento_comboioRepository;
import com.app.mina.domain.abastecimento_comboio.DadosAlteracaoAbastecimento_comboio;
import com.app.mina.domain.abastecimento_comboio.DadosCadastroAbastecimento_comboio;
import com.app.mina.domain.categoria_ref.Categoria_ref;
import com.app.mina.domain.categoria_ref.Categoria_refRepository;
import com.app.mina.domain.equipamento.Equipamento;
import com.app.mina.domain.equipamento.EquipamentoRepository;
import com.app.mina.domain.posto_ref.Posto_ref;
import com.app.mina.domain.posto_ref.Posto_refRepository;
import com.app.mina.domain.trabalhador.Trabalhador;
import com.app.mina.domain.trabalhador.TrabalhadorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/abastecimento_comboio")
public class Abastecimento_comboioController {

    @Autowired
    private Abastecimento_comboioRepository repository;

    @Autowired
    private TrabalhadorRepository trabalhadorRepository;

    @Autowired
    private Posto_refRepository posto_refRepository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private Categoria_refRepository categoria_refRepository;


    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var abastecimento_comboio = repository.getReferenceById(id);
            model.addAttribute("abastecimento_comboio", abastecimento_comboio);
        }

        List<Trabalhador> trabalhadors = trabalhadorRepository.findAll();
        model.addAttribute("trabalhadors", trabalhadors);

        List<Posto_ref> posto_refs = posto_refRepository.findAll();
        model.addAttribute("posto_refs", posto_refs);

        List<Equipamento> equipamentos = equipamentoRepository.findAll();
        model.addAttribute("equipamentos", equipamentos);

        List<Categoria_ref> categoria_refs = categoria_refRepository.findAll();
        model.addAttribute("categoria_refs", categoria_refs);

        return "abastecimento_comboio/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "abastecimento_comboio/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraAbastecimento_comboio(DadosCadastroAbastecimento_comboio dados) {
        var abastecimento_comboio = new Abastecimento_comboio(dados);

        repository.save(abastecimento_comboio);

        return "redirect:/abastecimento_comboio";
    }

    @PutMapping
    @Transactional
    public String alteraAbastecimento_comboio(DadosAlteracaoAbastecimento_comboio dados) {
        var abastecimento_comboio = repository.getReferenceById(dados.id());
        abastecimento_comboio.atualizaDados(dados);

        return "redirect:/abastecimento_comboio";
    }

    @GetMapping("getSiglaByCategoria_ref")
    @ResponseBody
    public ResponseEntity<String> getSiglaByCategoria_ref(@RequestParam("categoria_ref") String categoria_ref) {
        Categoria_ref categoria_refSelecionada = categoria_refRepository.findByNome(categoria_ref);
        if (categoria_refSelecionada != null) {
            return ResponseEntity.ok(categoria_refSelecionada.getSigla());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
