package br.dev.fabricio.financeiro.controllers;

import br.dev.fabricio.financeiro.requests.ContaRequest;
import br.dev.fabricio.financeiro.responses.ContaResponse;
import br.dev.fabricio.financeiro.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

  @Autowired
  private ContaService contaService;

  @PostMapping
  public ResponseEntity<?> insert(@RequestBody ContaRequest contaRequest) {
    try {
      ContaResponse contaResponse = contaService.insert(contaRequest);
      return ResponseEntity.status(HttpStatus.CREATED).body(contaResponse);

    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @GetMapping
  public ResponseEntity<List<ContaResponse>> findAll() {
    return ResponseEntity.status(HttpStatus.OK).body(contaService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id) {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(contaService.findById(id));

    } catch (RuntimeException e){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> insert(@PathVariable Long id,  @RequestBody ContaRequest contaRequest) {
    try {
      ContaResponse contaResponse = contaService.update(id, contaRequest);
      return ResponseEntity.status(HttpStatus.CREATED).body(contaResponse);

    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

}
