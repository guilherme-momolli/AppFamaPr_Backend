package br.edu.famapr.AppFamapr.controller;

import br.edu.famapr.AppFamapr.model.Matricula;
import br.edu.famapr.AppFamapr.repository.MatriculaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
@CrossOrigin(origins = "*")
public class MatriculaController {

    private final MatriculaRepository matriculaRepository;

    public MatriculaController(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> listarTodos() {
        return ResponseEntity.ok(matriculaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> buscarPorId(@PathVariable Integer id) {
        return matriculaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Matricula> criar(@RequestBody Matricula matricula) {
        return ResponseEntity.ok(matriculaRepository.save(matricula));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matricula> atualizar(@PathVariable Integer id, @RequestBody Matricula matriculaAtualizada) {
        return matriculaRepository.findById(id)
                .map(matricula -> {
                    matricula.setDatamatricula(matriculaAtualizada.getDatamatricula());
                    matricula.setStatus(matriculaAtualizada.getStatus());
                    matricula.setDatavigencia(matriculaAtualizada.getDatavigencia());
                    return ResponseEntity.ok(matriculaRepository.save(matricula));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        return matriculaRepository.findById(id)
                .map(matricula -> {
                    matriculaRepository.delete(matricula);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}