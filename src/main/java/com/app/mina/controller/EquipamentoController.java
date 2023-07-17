package com.app.mina.controller;

import com.app.mina.domain.empresa.Empresa;
import com.app.mina.domain.empresa.EmpresaRepository;
import com.app.mina.domain.equipamento.DadosAlteracaoEquipamento;
import com.app.mina.domain.equipamento.DadosCadastroEquipamento;
import com.app.mina.domain.equipamento.Equipamento;
import com.app.mina.domain.equipamento.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/equipamento")
public class EquipamentoController {

    @Autowired
    private EquipamentoRepository repository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var equipamento = repository.getReferenceById(id);
            model.addAttribute("equipamento", equipamento);
        }

        List<Empresa> empresas = empresaRepository.findAll();
        model.addAttribute("empresas", empresas);

        return "equipamento/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "equipamento/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraEquipamento(DadosCadastroEquipamento dados) {
        var equipamento = new Equipamento(dados);

        repository.save(equipamento);

        return "redirect:/equipamento";
    }

    @PutMapping
    @Transactional
    public String alteraEquipamento(DadosAlteracaoEquipamento dados) {
        var equipamento = repository.getReferenceById(dados.id());
        equipamento.atualizaDados(dados);

        return "redirect:/equipamento";
    }

    @DeleteMapping
    @Transactional
    public String removeEquipamento(Long id) {
        repository.deleteById(id);

        return "redirect:/equipamento";
    }
}
