package br.dev.fabricio.financeiro.requests;

import br.dev.fabricio.financeiro.enums.EntradaSaidaSaldoEnum;
import br.dev.fabricio.financeiro.enums.ReceitaDespesaEnum;

public class ContaRequest {
  private String nome;
  private EntradaSaidaSaldoEnum entradaSaidaSaldo;
  private ReceitaDespesaEnum receitaDespesa;



  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public EntradaSaidaSaldoEnum getEntradaSaidaSaldo() {
    return entradaSaidaSaldo;
  }

  public void setEntradaSaidaSaldo(EntradaSaidaSaldoEnum entradaSaidaSaldo) {
    this.entradaSaidaSaldo = entradaSaidaSaldo;
  }

  public ReceitaDespesaEnum getReceitaDespesa() {
    return receitaDespesa;
  }

  public void setReceitaDespesa(ReceitaDespesaEnum receitaDespesa) {
    this.receitaDespesa = receitaDespesa;
  }
}
