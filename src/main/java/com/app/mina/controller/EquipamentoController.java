package com.app.mina.controller;

import com.app.mina.domain.categoria_ref.Categoria_ref;
import com.app.mina.domain.categoria_ref.Categoria_refRepository;
import com.app.mina.domain.cc_ref.Cc_ref;
import com.app.mina.domain.cc_ref.Cc_refRepository;
import com.app.mina.domain.empresa_ref.Empresa_ref;
import com.app.mina.domain.empresa_ref.Empresa_refRepository;
import com.app.mina.domain.equipamento.DadosAlteracaoEquipamento;
import com.app.mina.domain.equipamento.DadosCadastroEquipamento;
import com.app.mina.domain.equipamento.Equipamento;
import com.app.mina.domain.equipamento.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private Empresa_refRepository empresa_refRepository;

    @Autowired
    private Cc_refRepository cc_refRepository;

    @Autowired
    private Categoria_refRepository categoria_refRepository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var equipamento = repository.getReferenceById(id);
            model.addAttribute("equipamento", equipamento);
        }

        List<Empresa_ref> empresa_refs = empresa_refRepository.findAll();
        model.addAttribute("empresa_refs", empresa_refs);

        List<Cc_ref> cc_refs = cc_refRepository.findAll();
        model.addAttribute("cc_refs", cc_refs);

        List<Categoria_ref> categoria_refs = categoria_refRepository.findAll();
        model.addAttribute("categoria_refs", categoria_refs);

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

    //Métodos para lidar com a requisição AJAX e retornar as informações da categoria em outros formulários
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

    @GetMapping("getCnpjByEmpresa_ref")
    @ResponseBody
    public ResponseEntity<String> getCnpjByEmpresa_ref(@RequestParam("empresa_ref") String empresa_ref) {
        Empresa_ref empresa_refSelecionada = empresa_refRepository.findByNome(empresa_ref);
        if (empresa_refSelecionada != null) {
            return ResponseEntity.ok(empresa_refSelecionada.getCnpj());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("getDescricaoByCc_ref")
    @ResponseBody
    public ResponseEntity<String> getDescricaoByCc_ref(@RequestParam("cc_ref") String cc_ref) {
        Cc_ref cc_refSelecionada = cc_refRepository.findByCodigo(cc_ref);
        if (cc_refSelecionada != null) {
            return ResponseEntity.ok(cc_refSelecionada.getDescricao());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
