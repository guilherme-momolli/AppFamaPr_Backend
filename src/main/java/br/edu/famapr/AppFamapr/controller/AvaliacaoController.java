package br.edu.famapr.AppFamapr.controller;

import br.edu.famapr.AppFamapr.dto.avaliacao.AvaliacaoRequestDTO;
import br.edu.famapr.AppFamapr.dto.avaliacao.AvaliacaoResponseDTO;
import br.edu.famapr.AppFamapr.service.AvaliacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avaliacoes")
@CrossOrigin(origins = "*")
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<AvaliacaoResponseDTO>> findAll() {
        return ResponseEntity.ok(avaliacaoService.findAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<AvaliacaoResponseDTO> findById(@PathVariable Integer id) {
        return avaliacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/crate")
    public ResponseEntity<AvaliacaoResponseDTO> create(@RequestBody AvaliacaoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoService.create(dto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AvaliacaoResponseDTO> update(@PathVariable Integer id,
                                                       @RequestBody AvaliacaoRequestDTO dto) {
        return avaliacaoService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (avaliacaoService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
