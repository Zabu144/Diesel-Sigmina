package com.app.mina.controller;

import com.app.mina.domain.empresa.DadosCadastroEmpresa;
import com.app.mina.domain.empresa.Empresa;
import com.app.mina.domain.empresa.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaRepository repository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var empresa = repository.getReferenceById(id);
            model.addAttribute("empresa", empresa);
        }
        return "empresa/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "empresa/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraEquipamento(DadosCadastroEmpresa dados) {
        var empresa = new Empresa(dados);

        repository.save(empresa);

        return "redirect:/empresa";
    }

    @DeleteMapping
    @Transactional
    public String removeEmpresa(Long id) {
        repository.deleteById(id);

        return "redirect:/empresa";
    }
}
