package br.dev.fabricio.financeiro.responses;

import br.dev.fabricio.financeiro.entities.ContaEntity;
import br.dev.fabricio.financeiro.enums.EntradaSaidaSaldoEnum;
import br.dev.fabricio.financeiro.enums.ReceitaDespesaEnum;

public class ContaResponse {
  private Long id;
  private String nome;

  private EntradaSaidaSaldoEnum entradaSaidaSaldo;
  private ReceitaDespesaEnum receitaDespesa;




  public ContaResponse(ContaEntity contaEntity) {
    this.id = contaEntity.getId();
    this.nome = contaEntity.getNome();
    this.entradaSaidaSaldo = contaEntity.getEntradaSaidaSaldo() == null ? null : EntradaSaidaSaldoEnum.valueOf(contaEntity.getEntradaSaidaSaldo());
    this.receitaDespesa = contaEntity.getReceitaDespesa() == null ? null : ReceitaDespesaEnum.valueOf(contaEntity.getReceitaDespesa());
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
