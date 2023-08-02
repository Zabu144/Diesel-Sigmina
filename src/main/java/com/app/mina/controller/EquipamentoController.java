package com.app.mina.controller;

import com.app.mina.domain.categoria.Categoria;
import com.app.mina.domain.categoria.CategoriaRepository;
import com.app.mina.domain.custos.Custos;
import com.app.mina.domain.custos.CustosRepository;
import com.app.mina.domain.empresa.Empresa;
import com.app.mina.domain.empresa.EmpresaRepository;
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
    private EmpresaRepository empresaRepository;

    @Autowired
    private CustosRepository custosRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var equipamento = repository.getReferenceById(id);
            model.addAttribute("equipamento", equipamento);
        }

        List<Empresa> empresas = empresaRepository.findAll();
        model.addAttribute("empresas", empresas);

        List<Custos> custo = custosRepository.findAll();
        model.addAttribute("custo", custo);

        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);

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
    @GetMapping("getSiglaByCategoria")
    @ResponseBody
    public ResponseEntity<String> getSiglaByCategoria(@RequestParam("categoria") String categoria) {
        Categoria categoriaSelecionada = categoriaRepository.findByNome(categoria);
        if (categoriaSelecionada != null) {
            return ResponseEntity.ok(categoriaSelecionada.getSigla());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("getCnpjByEmpresa")
    @ResponseBody
    public ResponseEntity<String> getCnpjByEmpresa(@RequestParam("empresa") String empresa) {
        Empresa empresaSelecionada = empresaRepository.findByNome(empresa);
        if (empresaSelecionada != null) {
            return ResponseEntity.ok(empresaSelecionada.getCnpj());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("getDescricaoByCustos")
    @ResponseBody
    public ResponseEntity<String> getDescricaoByCustos(@RequestParam("custos") String custos) {
        Custos custosSelecionada = custosRepository.findByCodigo(custos);
        if (custosSelecionada != null) {
            return ResponseEntity.ok(custosSelecionada.getDescricao());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
