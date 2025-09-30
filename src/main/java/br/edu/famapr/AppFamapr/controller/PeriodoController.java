package br.edu.famapr.AppFamapr.controller;

import br.edu.famapr.AppFamapr.dto.periodo.PeriodoRequestDTO;
import br.edu.famapr.AppFamapr.dto.periodo.PeriodoResponseDTO;
import br.edu.famapr.AppFamapr.model.Periodo;
import br.edu.famapr.AppFamapr.repository.PeriodoRepository;
import br.edu.famapr.AppFamapr.service.PeriodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/periodos")
@CrossOrigin(origins = "*")
public class PeriodoController {

    private final PeriodoService periodoService;

    public PeriodoController(PeriodoService periodoService) {
        this.periodoService = periodoService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<PeriodoResponseDTO>> findAll() {
        return ResponseEntity.ok(periodoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeriodoResponseDTO> findById(@PathVariable Integer id) {
        return periodoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<Optional<PeriodoResponseDTO>> findByCursoId(@PathVariable Integer cursoId) {
        Optional<PeriodoResponseDTO> periodos = periodoService.findByCursoId(cursoId);
        return periodos.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(periodos);
    }

    @PostMapping
    public ResponseEntity<PeriodoResponseDTO> create(@RequestBody PeriodoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(periodoService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeriodoResponseDTO> update(@PathVariable Integer id,
                                                     @RequestBody PeriodoRequestDTO dto) {
        return periodoService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (periodoService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}