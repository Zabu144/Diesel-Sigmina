package com.app.mina.controller;

import com.app.mina.domain.empresa.Empresa;
import com.app.mina.domain.empresa.EmpresaRepository;
import com.app.mina.domain.trabalhador.DadosAlteracaoTrabalhador;
import com.app.mina.domain.trabalhador.DadosCadastroTrabalhador;
import com.app.mina.domain.trabalhador.Trabalhador;
import com.app.mina.domain.trabalhador.TrabalhadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trabalhador")
public class TrabalhadorController {

    @Autowired
    private TrabalhadorRepository repository;

    @Autowired
    private EmpresaRepository empresaRepository;


    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var trabalhador = repository.getReferenceById(id);
            model.addAttribute("trabalhador", trabalhador);
        }

        List<Empresa> empresas = empresaRepository.findAll();
        model.addAttribute("empresas", empresas);

        return "trabalhador/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "trabalhador/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraTrabalhador(DadosCadastroTrabalhador dados) {
        var trabalhador = new Trabalhador(dados);

        repository.save(trabalhador);

        return "redirect:/trabalhador";
    }

    @PutMapping
    @Transactional
    public String alteraTrabalhador(DadosAlteracaoTrabalhador dados) {
        var trabalhador = repository.getReferenceById(dados.id());
        trabalhador.atualizaDados(dados);

        return "redirect:/trabalhador";
    }

    @DeleteMapping
    @Transactional
    public String removeTrabalhador(Long id) {
        repository.deleteById(id);

        return "redirect:/trabalhador";
    }

}
