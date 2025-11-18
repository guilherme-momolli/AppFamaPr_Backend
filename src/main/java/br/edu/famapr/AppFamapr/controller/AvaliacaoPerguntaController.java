package br.edu.famapr.AppFamapr.controller;

import br.edu.famapr.AppFamapr.dto.avaliacao_pergunta.AvaliacaoPerguntaRequestDTO;
import br.edu.famapr.AppFamapr.dto.avaliacao_pergunta.AvaliacaoPerguntaResponseDTO;
import br.edu.famapr.AppFamapr.service.AvaliacaoPerguntaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perguntas")
@CrossOrigin(origins = "*")
public class AvaliacaoPerguntaController {

    private final AvaliacaoPerguntaService perguntaService;

    public AvaliacaoPerguntaController(AvaliacaoPerguntaService perguntaService) {
        this.perguntaService = perguntaService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<AvaliacaoPerguntaResponseDTO>> findAllByAvaliacao(@RequestParam Integer avaliacaoId) {
        return ResponseEntity.ok(perguntaService.findAllByAvaliacao(avaliacaoId));
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<AvaliacaoPerguntaResponseDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(perguntaService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<AvaliacaoPerguntaResponseDTO> create(@RequestBody AvaliacaoPerguntaRequestDTO dto) {
        AvaliacaoPerguntaResponseDTO saved = perguntaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AvaliacaoPerguntaResponseDTO> update(
            @PathVariable Integer id,
            @RequestBody AvaliacaoPerguntaRequestDTO dto
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(perguntaService.update(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        perguntaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}