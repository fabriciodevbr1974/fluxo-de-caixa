package br.dev.fabricio.financeiro.responses;

import br.dev.fabricio.financeiro.dtos.BancoDto;
import br.dev.fabricio.financeiro.dtos.ContaDto;
import br.dev.fabricio.financeiro.entities.LancamentoEntity;

import java.math.BigDecimal;

public class LancamentoResponse {
  private Long id;
  private ContaDto conta;
  private BancoDto banco;
  private Integer ano;
  private Integer mes;
  private Integer diaVencimento;
  private Integer diaPagamento;
  private Integer diaLancamento;
  private BigDecimal valorPrevisto;
  private BigDecimal valorRealizado;


  public LancamentoResponse(LancamentoEntity lancamentoEntity) {
    this.id = lancamentoEntity.getId();
    this.setConta(new ContaDto(lancamentoEntity.getConta().getId(), lancamentoEntity.getConta().getNome()));
    this.setBanco(new BancoDto(lancamentoEntity.getBanco().getId(), lancamentoEntity.getBanco().getNome()));
    this.ano = lancamentoEntity.getAno();
    this.mes = lancamentoEntity.getMes();
    this.diaVencimento = lancamentoEntity.getDiaVencimento();
    this.diaPagamento = lancamentoEntity.getDiaPagamento();
    this.diaLancamento = lancamentoEntity.getDiaLancamento();
    this.valorPrevisto = lancamentoEntity.getValorPrevisto();
    this.valorRealizado = lancamentoEntity.getValorRealizado();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ContaDto getConta() {
    return conta;
  }

  public void setConta(ContaDto conta) {
    this.conta = conta;
  }

  public BancoDto getBanco() {
    return banco;
  }

  public void setBanco(BancoDto banco) {
    this.banco = banco;
  }

  public Integer getAno() {
    return ano;
  }

  public void setAno(Integer ano) {
    this.ano = ano;
  }

  public Integer getMes() {
    return mes;
  }

  public void setMes(Integer mes) {
    this.mes = mes;
  }

  public Integer getDiaVencimento() {
    return diaVencimento;
  }

  public void setDiaVencimento(Integer diaVencimento) {
    this.diaVencimento = diaVencimento;
  }

  public Integer getDiaPagamento() {
    return diaPagamento;
  }

  public void setDiaPagamento(Integer diaPagamento) {
    this.diaPagamento = diaPagamento;
  }

  public Integer getDiaLancamento() {
    return diaLancamento;
  }

  public void setDiaLancamento(Integer diaLancamento) {
    this.diaLancamento = diaLancamento;
  }

  public BigDecimal getValorPrevisto() {
    return valorPrevisto;
  }

  public void setValorPrevisto(BigDecimal valorPrevisto) {
    this.valorPrevisto = valorPrevisto;
  }

  public BigDecimal getValorRealizado() {
    return valorRealizado;
  }

  public void setValorRealizado(BigDecimal valorRealizado) {
    this.valorRealizado = valorRealizado;
  }
}
