package com.app.mina.domain.equipamento;

import jakarta.persistence.*;

@Entity
@Table(name = "equipamento")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tag;
    private String categoria;
    private String rfid;
    private Boolean habilitar;
    private String empresa;
    private String custos;
    private String sigla_cat_FK;
    private String cnpj;
    private String descricao;

    public Equipamento(DadosCadastroEquipamento dados) {
        this.tag = dados.tag();
        this.categoria = dados.categoria();
        this.rfid = dados.rfid();
        this.habilitar = dados.habilitar();
        this.empresa = dados.empresa();
        this.custos = dados.custos();
        this.sigla_cat_FK = dados.sigla_cat_FK();
        this.cnpj = dados.cnpj();
        this.descricao = dados.descricao();
    }

    public Equipamento(){}

    @Override
    public String toString() {
        return "Equipamento{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                ", categoria='" + categoria + '\'' +
                ", rfid='" + rfid + '\'' +
                ", habilitar=" + habilitar +
                ", empresa='" + empresa + '\'' +
                ", custos='" + custos + '\'' +
                ", sigla_cat_FK='" + sigla_cat_FK + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getRfid() {
        return rfid;
    }

    public Boolean getHabilitar() {
        return habilitar;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getCustos() {
        return custos;
    }
    public String getSigla_cat_FK() {
        return sigla_cat_FK;
    }
    public String getCnpj() {
        return cnpj;
    }
    public String getDescricao() {
        return descricao;
    }

    public void atualizaDados(DadosAlteracaoEquipamento dados) {
        this.tag = dados.tag();
        this.categoria = dados.categoria();
        this.rfid = dados.rfid();
        this.habilitar = dados.habilitar();
        this.empresa = dados.empresa();
        this.custos = dados.custos();
        this.sigla_cat_FK = dados.sigla_cat_FK();
        this.cnpj = dados.cnpj();
        this.descricao = dados.descricao();
    }
}
