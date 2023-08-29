package com.app.mina.controller;

import com.app.mina.domain.categoria_ref.Categoria_ref;
import com.app.mina.domain.categoria_ref.Categoria_refRepository;
import com.app.mina.domain.categoria_ref.DadosAlteracaoCategoria_ref;
import com.app.mina.domain.categoria_ref.DadosCadastroCategoria_ref;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categoria_ref") // Mapeamento base para o Controller
public class Categoria_refController {

    // Injeção de dependências
    @Autowired
    private Categoria_refRepository repository;

    @GetMapping("/formulario") // Manipula a requisição GET para a página de formulário
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var categoria_ref = repository.getReferenceById(id);
            model.addAttribute("categoria_ref", categoria_ref);
        }
        return "categoria_ref/formulario";
    }

    @GetMapping // Manipula a requisição GET para a página de listagem
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "categoria_ref/listagem";
    }

    @PostMapping // Manipula a requisição POST para cadastro
    @Transactional
    public String cadastraCategoria_ref(DadosCadastroCategoria_ref dados) {
        var categoria_ref = new Categoria_ref(dados);

        repository.save(categoria_ref);

        return "redirect:/categoria_ref";
    }

    @PutMapping // Manipula a requisição PUT para alteração
    @Transactional
    public String alterarCategoria_ref(DadosAlteracaoCategoria_ref dados) {
        var categoria_ref = repository.getReferenceById(dados.id());
        categoria_ref.atualizaDados(dados);

        return "redirect:/categoria_ref";
    }

    @DeleteMapping // Manipula a requisição DELETE para remover
    @Transactional
    public String removeCategoria_ref(Long id) {
        repository.deleteById(id);

        return "redirect:/categoria_ref";
    }
}
