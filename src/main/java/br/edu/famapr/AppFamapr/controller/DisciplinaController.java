package br.edu.famapr.AppFamapr.controller;

import br.edu.famapr.AppFamapr.dto.disciplina.DisciplinaRequestDTO;
import br.edu.famapr.AppFamapr.dto.disciplina.DisciplinaResponseDTO;
import br.edu.famapr.AppFamapr.model.Disciplina;
import br.edu.famapr.AppFamapr.repository.DisciplinaRepository;
import br.edu.famapr.AppFamapr.service.DisciplinaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disciplinas")
@CrossOrigin(origins = "*")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<DisciplinaResponseDTO>> findAll() {
        return ResponseEntity.ok(disciplinaService.findAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<DisciplinaResponseDTO> findById(@PathVariable Integer id) {
        return disciplinaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<DisciplinaResponseDTO> create(@RequestBody DisciplinaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaService.create(dto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DisciplinaResponseDTO> update(@PathVariable Integer id,
                                                        @RequestBody DisciplinaRequestDTO dto) {
        return disciplinaService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (disciplinaService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}