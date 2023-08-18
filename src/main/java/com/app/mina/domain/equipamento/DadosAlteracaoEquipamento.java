package com.app.mina.domain.equipamento;

public record DadosAlteracaoEquipamento(Long id, String tag, String categoria_ref, String rfid, Boolean habilitar, String empresa_ref, String cc_ref, String sigla_cat_FK, String cnpj, String descricao) {
}
