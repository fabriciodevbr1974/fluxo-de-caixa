package br.dev.fabricio.financeiro.services;

import br.dev.fabricio.financeiro.entities.BancoEntity;
import br.dev.fabricio.financeiro.entities.ContaEntity;
import br.dev.fabricio.financeiro.entities.LancamentoEntity;
import br.dev.fabricio.financeiro.repositories.BancoRepository;
import br.dev.fabricio.financeiro.repositories.ContaRepository;
import br.dev.fabricio.financeiro.repositories.LancamentoRepository;
import br.dev.fabricio.financeiro.requests.LancamentoRequest;
import br.dev.fabricio.financeiro.responses.LancamentoResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService {

  //  @Autowired
  private final LancamentoRepository lancamentoRepository;
  //
//  @Autowired
  private final ContaRepository contaRepository;
  //
//  @Autowired
  private final BancoRepository bancoRepository;

  public LancamentoService(LancamentoRepository lancamentoRepository, ContaRepository contaRepository, BancoRepository bancoRepository) {
    this.lancamentoRepository = lancamentoRepository;
    this.contaRepository = contaRepository;
    this.bancoRepository = bancoRepository;
  }

  @Transactional
  public LancamentoResponse insert(LancamentoRequest lancamentoRequest) {
    Optional<ContaEntity> optionalContaEntity = contaRepository.findById(lancamentoRequest.getConta().getId());
    if (optionalContaEntity.isEmpty()) {
      throw new RuntimeException(String.format("Conta de código %d não encontrada", lancamentoRequest.getConta().getId()));
    }


    Optional<BancoEntity> optionalBancoEntity = bancoRepository.findById(lancamentoRequest.getBanco().getId());
    if (optionalBancoEntity.isEmpty()) {
      throw new RuntimeException(String.format("Banco de código %d não encontrado", lancamentoRequest.getBanco().getId()));
    }


    LancamentoEntity lancamentoEntity = new LancamentoEntity(lancamentoRequest,
            optionalContaEntity.get(),
            optionalBancoEntity.get());

    lancamentoEntity = lancamentoRepository.save(lancamentoEntity);
    return new LancamentoResponse(lancamentoEntity);
  }

  @Transactional
  public LancamentoResponse update(Long id, LancamentoRequest lancamentoRequest) {

    Optional<LancamentoEntity> optional = lancamentoRepository.findById(id);
    if (optional.isEmpty()) {
      throw new RuntimeException(String.format("Lancamento de código %d não encontrado", id));
    }

    LancamentoEntity lancamentoEntityAtual = optional.get();
    Optional<ContaEntity> optionalContaEntity = contaRepository.findById(lancamentoRequest.getConta().getId());
    if (optionalContaEntity.isEmpty()) {
      throw new RuntimeException(String.format("Conta de código %d não encontrada", lancamentoRequest.getConta().getId()));
    }


    Optional<BancoEntity> optionalBancoEntity = bancoRepository.findById(lancamentoRequest.getBanco().getId());
    if (optionalBancoEntity.isEmpty()) {
      throw new RuntimeException(String.format("Banco de código %d não encontrado", lancamentoRequest.getBanco().getId()));
    }


    LancamentoEntity lancamentoEntity = new LancamentoEntity(lancamentoRequest, optionalContaEntity.get(), optionalBancoEntity.get());

    BeanUtils.copyProperties(lancamentoEntity, lancamentoEntityAtual, "id");

    lancamentoEntity = lancamentoRepository.save(lancamentoEntityAtual);
    return new LancamentoResponse(lancamentoEntity);
  }


  public List<LancamentoResponse> findAll() {
    List<LancamentoResponse> listLancamentoResponse = new ArrayList<>();
    List<LancamentoEntity> listLancamentoEntity = lancamentoRepository.findAll();
    listLancamentoEntity.forEach(lancamentoEntity -> listLancamentoResponse.add(new LancamentoResponse(lancamentoEntity)));
    return listLancamentoResponse;
  }

  public LancamentoResponse findById(Long id) {
    Optional<LancamentoEntity> optional = lancamentoRepository.findById(id);
    if (optional.isEmpty()) {
      throw new RuntimeException(String.format("Lancamento de código %d não encontrado", id));
    }
    LancamentoEntity lancamentoEntity = optional.get();

    return new LancamentoResponse(lancamentoEntity);
  }


}
