package com.app.mina.domain.equipamento;

import jakarta.persistence.*;

@Entity
@Table(name = "equipamento")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tag;
    private String categoria_ref;
    private String rfid;
    private Boolean habilitar;
    private String empresa_ref;
    private String cc_ref;
    private String sigla_cat_FK;
    private String cnpj;
    private String descricao;

    public Equipamento(DadosCadastroEquipamento dados) {
        this.tag = dados.tag();
        this.categoria_ref = dados.categoria_ref();
        this.rfid = dados.rfid();
        this.habilitar = dados.habilitar();
        this.empresa_ref = dados.empresa_ref();
        this.cc_ref = dados.cc_ref();
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
                ", categoria_ref='" + categoria_ref + '\'' +
                ", rfid='" + rfid + '\'' +
                ", habilitar=" + habilitar +
                ", empresa_ref='" + empresa_ref + '\'' +
                ", cc_ref='" + cc_ref + '\'' +
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
        return categoria_ref;
    }

    public String getRfid() {
        return rfid;
    }

    public Boolean getHabilitar() {
        return habilitar;
    }

    public String getEmpresa() {
        return empresa_ref;
    }

    public String getCustos() {
        return cc_ref;
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
        this.categoria_ref = dados.categoria_ref();
        this.rfid = dados.rfid();
        this.habilitar = dados.habilitar();
        this.empresa_ref = dados.empresa_ref();
        this.cc_ref = dados.cc_ref();
        this.sigla_cat_FK = dados.sigla_cat_FK();
        this.cnpj = dados.cnpj();
        this.descricao = dados.descricao();
    }
}
