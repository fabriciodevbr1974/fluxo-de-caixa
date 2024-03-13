package br.dev.fabricio.financeiro.controllers;

import br.dev.fabricio.financeiro.requests.LancamentoRequest;
import br.dev.fabricio.financeiro.responses.LancamentoResponse;
import br.dev.fabricio.financeiro.services.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.financeiro}"+"/lancamentos")
public class LancamentoController {

  @Autowired
  private LancamentoService lancamentoService;

  @PostMapping
  public ResponseEntity<?> insert(@RequestBody LancamentoRequest lancamentoRequest) {
    try {
      LancamentoResponse lancamentoResponse = lancamentoService.insert(lancamentoRequest);
      return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoResponse);

    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @GetMapping
  public ResponseEntity<List<LancamentoResponse>> findAll(){
    return ResponseEntity.ok(lancamentoService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<LancamentoResponse> findById(@PathVariable Long id){
    return ResponseEntity.ok(lancamentoService.findById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> insert(@PathVariable Long id, @RequestBody LancamentoRequest lancamentoRequest) {
    try {
      LancamentoResponse lancamentoResponse = lancamentoService.update(id, lancamentoRequest);
      return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoResponse);

    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }


}
