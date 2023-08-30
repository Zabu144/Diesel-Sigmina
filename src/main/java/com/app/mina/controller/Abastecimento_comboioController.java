package com.app.mina.controller;

import com.app.mina.domain.abastecimento_comboio.Abastecimento_comboio;
import com.app.mina.domain.abastecimento_comboio.Abastecimento_comboioRepository;
import com.app.mina.domain.abastecimento_comboio.DadosAlteracaoAbastecimento_comboio;
import com.app.mina.domain.abastecimento_comboio.DadosCadastroAbastecimento_comboio;
import com.app.mina.domain.categoria_ref.Categoria_ref;
import com.app.mina.domain.categoria_ref.Categoria_refRepository;
import com.app.mina.domain.empresa_ref.Empresa_ref;
import com.app.mina.domain.empresa_ref.Empresa_refRepository;
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
@RequestMapping("/abastecimento_comboio")  // Mapeamento base para o Controller
public class Abastecimento_comboioController {

    // Injeção de dependências
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

    @Autowired
    private Empresa_refRepository empresa_refRepository;


    @GetMapping("/formulario") // Manipula a requisição GET para a página de formulário
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

        List<Empresa_ref> empresa_refs = empresa_refRepository.findAll();
        model.addAttribute("empresa_refs", empresa_refs);

        return "abastecimento_comboio/formulario";
    }

    @GetMapping  // Manipula a requisição GET para a página de listagem
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "abastecimento_comboio/listagem";
    }

    @PostMapping // Manipula a requisição POST para cadastro
    @Transactional
    public String cadastraAbastecimento_comboio(DadosCadastroAbastecimento_comboio dados) {
        var abastecimento_comboio = new Abastecimento_comboio(dados);

        repository.save(abastecimento_comboio);

        return "redirect:/abastecimento_comboio";
    }

    @PutMapping // Manipula a requisição PUT para alteração
    @Transactional
    public String alteraAbastecimento_comboio(DadosAlteracaoAbastecimento_comboio dados) {
        var abastecimento_comboio = repository.getReferenceById(dados.id());
        abastecimento_comboio.atualizaDados(dados);

        return "redirect:/abastecimento_comboio";
    }

    @DeleteMapping // Manipula a requisição DELETE para remover
    @Transactional
    public String removeAbastecimento_comboio(Long id) {
        repository.deleteById(id);

        return "redirect:/abastecimento_comboio";
    }

    //Métodos para lidar com a requisição AJAX e retornar as informações da categoria em outros formulários
    @GetMapping("getSiglaByCategoria_ref")  // Faz um GET na tabela categoria_ref para pegar a coluna sigla
    @ResponseBody
    public ResponseEntity<String> getSiglaByCategoria_ref(@RequestParam("categoria_ref") String categoria_ref) {
        Categoria_ref categoria_refSelecionada = categoria_refRepository.findByNome(categoria_ref);
        if (categoria_refSelecionada != null) {
            return ResponseEntity.ok(categoria_refSelecionada.getSigla());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/abastecimento_posto") // Manipula a requisição POST para processar um formulário de data e hora
    public String processForm(@RequestParam("data_abastecimento") String dataHoraString) {

        return "redirect:/abastecimento_posto";
    }
}
