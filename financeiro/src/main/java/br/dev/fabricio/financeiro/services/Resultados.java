package br.dev.fabricio.financeiro.services;

import br.dev.fabricio.financeiro.responses.ResultadoSaldoResponse;

public interface Resultados {

  ResultadoSaldoResponse saldo(Integer ano, Integer mes);

  ResultadoSaldoResponse saldoNative(Integer ano, Integer mes, Long bancoId);

  ResultadoSaldoResponse saldo(Integer ano, Integer mes, Long bancoId);


}
