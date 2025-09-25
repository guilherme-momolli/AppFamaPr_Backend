package br.edu.famapr.AppFamapr.controller;

import br.edu.famapr.AppFamapr.model.Periodo;
import br.edu.famapr.AppFamapr.repository.PeriodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/periodos")
@CrossOrigin(origins = "*")
public class PeriodoController {

    private final PeriodoRepository periodoRepository;

    public PeriodoController(PeriodoRepository periodoRepository) {
        this.periodoRepository = periodoRepository;
    }

    @GetMapping
    public ResponseEntity<List<Periodo>> listarTodos() {
        return ResponseEntity.ok(periodoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Periodo> buscarPorId(@PathVariable Integer id) {
        return periodoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Periodo> criar(@RequestBody Periodo periodo) {
        return ResponseEntity.ok(periodoRepository.save(periodo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Periodo> atualizar(@PathVariable Integer id, @RequestBody Periodo periodoAtualizado) {
        return periodoRepository.findById(id)
                .map(periodo -> {
                    periodo.setPeriodo(periodoAtualizado.getPeriodo());
                    periodo.setAbreviacao(periodoAtualizado.getAbreviacao());
                    return ResponseEntity.ok(periodoRepository.save(periodo));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        return periodoRepository.findById(id)
                .map(periodo -> {
                    periodoRepository.delete(periodo);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

