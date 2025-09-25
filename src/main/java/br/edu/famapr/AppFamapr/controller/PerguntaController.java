package br.edu.famapr.AppFamapr.controller;

import br.edu.famapr.AppFamapr.dto.pergunta.PerguntaRequestDTO;
import br.edu.famapr.AppFamapr.dto.pergunta.PerguntaResponseDTO;
import br.edu.famapr.AppFamapr.service.PerguntaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perguntas")
@CrossOrigin(origins = "*")
public class PerguntaController {

    private final PerguntaService perguntaService;

    public PerguntaController(PerguntaService perguntaService) {
        this.perguntaService = perguntaService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<PerguntaResponseDTO>> findAll() {
        return ResponseEntity.ok(perguntaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerguntaResponseDTO> findById(@PathVariable Integer id) {
        return perguntaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PerguntaResponseDTO> create(@RequestBody PerguntaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(perguntaService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PerguntaResponseDTO> update(@PathVariable Integer id,
                                                      @RequestBody PerguntaRequestDTO dto) {
        return perguntaService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (perguntaService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
