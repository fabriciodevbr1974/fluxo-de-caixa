package br.dev.fabricio.financeiro.controllers;

import br.dev.fabricio.financeiro.responses.ResultadoSaldoResponse;
import br.dev.fabricio.financeiro.services.Resultados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resultados")
public class ResultadosController {


  @Autowired
  @Qualifier("findByAnoAndMes")
  private Resultados resultados;


  @GetMapping("/saldo")
  public ResponseEntity<ResultadoSaldoResponse> saldo(@RequestParam Integer ano, @RequestParam Integer mes) {
    return ResponseEntity.ok(resultados.saldo(ano, mes));
  }

  @GetMapping("/saldo/banco-native")
  public ResponseEntity<ResultadoSaldoResponse> saldoNative(
          @RequestParam Integer ano,
          @RequestParam Integer mes,
          @RequestParam Long bancoId) {
    return ResponseEntity.ok(resultados.saldoNative(ano, mes, bancoId));
  }

  @GetMapping("/saldo/banco")
  public ResponseEntity<ResultadoSaldoResponse> saldo(
          @RequestParam Integer ano,
          @RequestParam Integer mes,
          @RequestParam Long bancoId) {
    return ResponseEntity.ok(resultados.saldo(ano, mes, bancoId));
  }


}