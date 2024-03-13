package br.dev.fabricio.financeiro.services;

import br.dev.fabricio.financeiro.entities.BancoEntity;
import br.dev.fabricio.financeiro.repositories.BancoRepository;
import br.dev.fabricio.financeiro.requests.BancoRequest;
import br.dev.fabricio.financeiro.responses.BancoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BancoService {

  @Autowired
  private BancoRepository bancoRepository;


  @Transactional
  public BancoResponse insert(BancoRequest bancoRequest) {
    BancoEntity bancoEntity = new BancoEntity(bancoRequest);
    bancoEntity = bancoRepository.save(bancoEntity);
    return new BancoResponse(bancoEntity);
  }

  @Transactional
  public BancoResponse update(Long id, BancoRequest bancoRequest) {

    Optional<BancoEntity> optional = bancoRepository.findById(id);
    if (optional.isEmpty()) {
      throw new RuntimeException(String.format("Banco de código %d não encontrado", id));
    }

    BancoEntity bancoEntityAtual = optional.get();
    BancoEntity bancoEntity = new BancoEntity(bancoRequest);
    bancoEntity.setId(bancoEntityAtual.getId());

    bancoEntity = bancoRepository.save(bancoEntity);
    return new BancoResponse(bancoEntity);
  }


  public List<BancoResponse> findAll() {
    List<BancoResponse> listBancoResponse = new ArrayList<>();
    List<BancoEntity> listBancoEntity = bancoRepository.findAll();
    listBancoEntity.forEach(bancoEntity -> listBancoResponse.add(new BancoResponse(bancoEntity)));
    return listBancoResponse;
  }

  public BancoResponse findById(Long id) {
    Optional<BancoEntity> optional = bancoRepository.findById(id);
    if (optional.isEmpty()) {
      throw new RuntimeException(String.format("Banco de código %d não encontrado", id));
    }
    BancoEntity bancoEntity = optional.get();

    return new BancoResponse(bancoEntity);
  }


  public void delete(Long id) {
    bancoRepository.deleteById(id);
  }
}
