package com.app.mina.controller;

import com.app.mina.domain.empresa_ref.Empresa_ref;
import com.app.mina.domain.empresa_ref.Empresa_refRepository;
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
@RequestMapping("/trabalhador") // Mapeamento base para o Controller
public class TrabalhadorController {

    // Injeção de dependências
    @Autowired
    private TrabalhadorRepository repository;

    @Autowired
    private Empresa_refRepository empresa_refRepository;


    @GetMapping("/formulario") // Manipula a requisição GET para a página de formulário
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var trabalhador = repository.getReferenceById(id);
            model.addAttribute("trabalhador", trabalhador);
        }

        List<Empresa_ref> empresa_refs = empresa_refRepository.findAll();
        model.addAttribute("empresa_refs", empresa_refs);

        return "trabalhador/formulario";
    }

    @GetMapping // Manipula a requisição GET para a página de listagem
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "trabalhador/listagem";
    }

    @PostMapping // Manipula a requisição POST para cadastro
    @Transactional
    public String cadastraTrabalhador(DadosCadastroTrabalhador dados) {
        var trabalhador = new Trabalhador(dados);

        repository.save(trabalhador);

        return "redirect:/trabalhador";
    }

    @PutMapping // Manipula a requisição PUT para alteração
    @Transactional
    public String alteraTrabalhador(DadosAlteracaoTrabalhador dados) {
        var trabalhador = repository.getReferenceById(dados.id());
        trabalhador.atualizaDados(dados);

        return "redirect:/trabalhador";
    }

    @DeleteMapping // Manipula a requisição DELETE para remover
    @Transactional
    public String removeTrabalhador(Long id) {
        repository.deleteById(id);

        return "redirect:/trabalhador";
    }

}
