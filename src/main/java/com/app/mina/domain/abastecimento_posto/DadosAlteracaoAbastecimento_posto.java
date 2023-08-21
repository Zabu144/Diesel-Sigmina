package com.app.mina.domain.abastecimento_posto;

import java.util.Date;

public record DadosAlteracaoAbastecimento_posto(Long id, Date data_abastecimento, Double litros, String equipamento, String trabalhador, String cc_ref) {

}
