package br.dev.fabricio.financeiro.controllers;

import br.dev.fabricio.financeiro.requests.BancoRequest;
import br.dev.fabricio.financeiro.responses.BancoResponse;
import br.dev.fabricio.financeiro.responses.HealthResponse;
import br.dev.fabricio.financeiro.services.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.financeiro}"+"/bancos")
public class BancoController {

  @Autowired
  private BancoService bancoService;

  @PostMapping
  public ResponseEntity<?> insert(@RequestBody BancoRequest bancoRequest) {
    try {
      BancoResponse bancoResponse = bancoService.insert(bancoRequest);
      return ResponseEntity.status(HttpStatus.CREATED).body(bancoResponse);

    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @GetMapping
  public ResponseEntity<List<BancoResponse>> findAll() {
    return ResponseEntity.status(HttpStatus.OK).body(bancoService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id) {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(bancoService.findById(id));

    } catch (RuntimeException e){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> insert(@PathVariable Long id,  @RequestBody BancoRequest bancoRequest) {
    try {
      BancoResponse bancoResponse = bancoService.update(id, bancoRequest);
      return ResponseEntity.status(HttpStatus.CREATED).body(bancoResponse);

    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @GetMapping("/health")
  public ResponseEntity<HealthResponse> health(){
    return ResponseEntity.ok(new HealthResponse("200", "Endpoint /bancos está no ar"));
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id){
    bancoService.delete(id);
  }

}
