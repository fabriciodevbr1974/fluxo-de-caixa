package br.dev.fabricio.financeiro.dtos;

import br.dev.fabricio.financeiro.enums.EntradaSaidaSaldoEnum;
import br.dev.fabricio.financeiro.enums.ReceitaDespesaEnum;

public class ContaDto {
  private Long id;
  private String nome;
  private EntradaSaidaSaldoEnum entradaSaidaSaldo;
  private ReceitaDespesaEnum receitaDespesa;




  public ContaDto(Long id, String nome, EntradaSaidaSaldoEnum entradaSaidaSaldo, ReceitaDespesaEnum receitaDespesa) {
    this.id = id;
    this.nome = nome;
    this.entradaSaidaSaldo = entradaSaidaSaldo;
    this.receitaDespesa = receitaDespesa;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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
