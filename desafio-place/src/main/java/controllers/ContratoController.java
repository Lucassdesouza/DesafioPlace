package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import entities.Contrato;
import services.ContratoService;

import java.util.List;

@RestController
@RequestMapping("/contratos")

public class ContratoController {
    @Autowired
    private ContratoService contratoService;


    @PostMapping
    public ResponseEntity<Contrato>
    criarContrato(@RequestBody Contrato contrato) {
        Contrato novoContrato = contratoService.criarContrato(contrato);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoContrato);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> buscarContratoPorId(@PathVariable Long id) {
        Contrato contrato = contratoService.buscarContratoPorId(id);
        if (contrato != null) {
            return ResponseEntity.ok(contrato);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Contrato>> listarTodosContratos() {
        List<Contrato> contratos = contratoService.listarTodosContratos();
        return ResponseEntity.ok(contratos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrato> atualizarContrato(@PathVariable Long id, @RequestBody Contrato contrato) {
        Contrato contratoAtualizado
 = contratoService.atualizarContrato(id, contrato);
        if (contratoAtualizado != null) {
            return ResponseEntity.ok(contratoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarContrato(@PathVariable Long id) {
        if (contratoService.deletarContrato(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}