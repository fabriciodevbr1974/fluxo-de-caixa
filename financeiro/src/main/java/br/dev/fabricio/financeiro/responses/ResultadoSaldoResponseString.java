package br.dev.fabricio.financeiro.responses;

public class ResultadoSaldoResponseString {

  private String valorPrevisto;
  private String valorRealizado;

  public ResultadoSaldoResponseString(String valorPrevisto, String valorRealizado) {
    this.valorPrevisto = valorPrevisto;
    this.valorRealizado = valorRealizado;
  }

  public String getValorPrevisto() {
    return valorPrevisto;
  }

  public String getValorRealizado() {
    return valorRealizado;
  }

  public void setValorPrevisto(String valorPrevisto) {
    this.valorPrevisto = valorPrevisto;
  }

  public void setValorRealizado(String valorRealizado) {
    this.valorRealizado = valorRealizado;
  }
}
