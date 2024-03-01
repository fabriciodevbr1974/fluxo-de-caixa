package br.dev.fabricio.financeiro.services;

import br.dev.fabricio.financeiro.entities.ContaEntity;
import br.dev.fabricio.financeiro.repositories.ContaRepository;
import br.dev.fabricio.financeiro.requests.ContaRequest;
import br.dev.fabricio.financeiro.responses.ContaResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

  @Autowired
  private ContaRepository contaRepository;


  @Transactional
  public ContaResponse insert(ContaRequest contaRequest) {
    ContaEntity contaEntity = new ContaEntity(contaRequest);
    contaEntity = contaRepository.save(contaEntity);
    return new ContaResponse(contaEntity);
  }

  @Transactional
  public ContaResponse update(Long id, ContaRequest contaRequest) {

    Optional<ContaEntity> optional = contaRepository.findById(id);
    if (optional.isEmpty()) {
      throw new RuntimeException(String.format("Conta de código %d não encontrado", id));
    }

    ContaEntity contaEntityAtual = optional.get();
    ContaEntity contaEntity = new ContaEntity(contaRequest);

    BeanUtils.copyProperties(contaEntity, contaEntityAtual, "id");

    contaEntity = contaRepository.save(contaEntityAtual);
    return new ContaResponse(contaEntity);
  }


  public List<ContaResponse> findAll() {
    List<ContaResponse> listContaResponse = new ArrayList<>();
    List<ContaEntity> listContaEntity = contaRepository.findAll();
    listContaEntity.forEach(contaEntity -> listContaResponse.add(new ContaResponse(contaEntity)));
    return listContaResponse;
  }

  public ContaResponse findById(Long id) {
    Optional<ContaEntity> optional = contaRepository.findById(id);
    if(optional.isEmpty()){
      throw new RuntimeException(String.format("Conta de código %d não encontrado", id));
    }
    ContaEntity contaEntity = optional.get();

    return new ContaResponse(contaEntity);
  }


}
