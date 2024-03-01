package br.dev.fabricio.financeiro.services;

import br.dev.fabricio.financeiro.entities.BancoEntity;
import br.dev.fabricio.financeiro.entities.LancamentoEntity;
import br.dev.fabricio.financeiro.enums.EntradaSaidaSaldoEnum;
import br.dev.fabricio.financeiro.repositories.LancamentoRepository;
import br.dev.fabricio.financeiro.responses.ResultadoSaldoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Qualifier("findByAnoAndMes")
@Service
public class ResultadosFindByAnoAndMesService implements Resultados {

  @Autowired
  private LancamentoRepository lancamentoRepository;

  @Override
  public ResultadoSaldoResponse saldo(Integer ano, Integer mes) {
    return getResultados(lancamentoRepository.findByAnoAndMes(ano, mes));
  }

  @Override
  public ResultadoSaldoResponse saldoNative(Integer ano, Integer mes, Long bancoId) {
    return getResultados(lancamentoRepository.findByAnoAndMesAndBancoNative(ano, mes, bancoId));
  }

  @Override
  public ResultadoSaldoResponse saldo(Integer ano, Integer mes, Long bancoId) {
    return getResultados(lancamentoRepository.findByAnoAndMesAndBanco(ano, mes, new BancoEntity(bancoId)));
  }

  private ResultadoSaldoResponse getResultados(List<LancamentoEntity> lancamentoEntityList) {
    BigDecimal saldoInicialPrevisto = BigDecimal.ZERO;
    BigDecimal entradasPrevisto = BigDecimal.ZERO;
    BigDecimal saidasPrevisto = BigDecimal.ZERO;

    BigDecimal saldoInicialRealizado = BigDecimal.ZERO;
    BigDecimal entradasRealizado = BigDecimal.ZERO;
    BigDecimal saidasRealizado = BigDecimal.ZERO;

    for (LancamentoEntity lancamento : lancamentoEntityList) {
      if (lancamento.getConta().getEntradaSaidaSaldo().equals(EntradaSaidaSaldoEnum.SALDO.name())) {
        saldoInicialPrevisto = saldoInicialPrevisto.add(lancamento.getValorPrevisto());
        saldoInicialRealizado = saldoInicialRealizado.add(lancamento.getValorRealizado());
      }
      if (lancamento.getConta().getEntradaSaidaSaldo().equals(EntradaSaidaSaldoEnum.ENTRADA.name())) {
        entradasPrevisto = entradasPrevisto.add(lancamento.getValorPrevisto());
        entradasRealizado = entradasRealizado.add(lancamento.getValorRealizado());
      }
      if (lancamento.getConta().getEntradaSaidaSaldo().equals(EntradaSaidaSaldoEnum.SAIDA.name())) {
        saidasPrevisto = saidasPrevisto.add(lancamento.getValorPrevisto());
        saidasRealizado = saidasRealizado.add(lancamento.getValorRealizado());
      }
    }

    BigDecimal resultadoPrevisto = saldoInicialPrevisto.add(entradasPrevisto).subtract(saidasPrevisto);
    BigDecimal resultadoRealizado = saldoInicialRealizado.add(entradasRealizado).subtract(saidasRealizado);

    return new ResultadoSaldoResponse(resultadoPrevisto, resultadoRealizado);
  }


}
