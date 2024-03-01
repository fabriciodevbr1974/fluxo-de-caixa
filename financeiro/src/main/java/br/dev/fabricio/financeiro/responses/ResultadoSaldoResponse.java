package br.dev.fabricio.financeiro.responses;

import java.math.BigDecimal;

public class ResultadoSaldoResponse {

  private BigDecimal valorPrevisto;
  private BigDecimal valorRealizado;

  public ResultadoSaldoResponse(BigDecimal valorPrevisto, BigDecimal valorRealizado) {
    this.valorPrevisto = valorPrevisto;
    this.valorRealizado = valorRealizado;
  }

  public BigDecimal getValorPrevisto() {
    return valorPrevisto;
  }

  public BigDecimal getValorRealizado() {
    return valorRealizado;
  }

  public void setValorPrevisto(BigDecimal valorPrevisto) {
    this.valorPrevisto = valorPrevisto;
  }

  public void setValorRealizado(BigDecimal valorRealizado) {
    this.valorRealizado = valorRealizado;
  }
}
