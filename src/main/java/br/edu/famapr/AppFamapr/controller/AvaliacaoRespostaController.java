package br.edu.famapr.AppFamapr.controller;

import br.edu.famapr.AppFamapr.dto.avaliacao_resposta.AvaliacaoRespostaRequestDTO;
import br.edu.famapr.AppFamapr.dto.avaliacao_resposta.AvaliacaoRespostaResponseDTO;
import br.edu.famapr.AppFamapr.service.AvaliacaoRespostaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/respostas")
@CrossOrigin(origins = "*")
public class AvaliacaoRespostaController {

    private final AvaliacaoRespostaService respostaService;

    public AvaliacaoRespostaController(AvaliacaoRespostaService respostaService) {
        this.respostaService = respostaService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<AvaliacaoRespostaResponseDTO>> findByAvaliacao(@RequestParam Integer avaliacaoId) {
        return ResponseEntity.ok(respostaService.findByAvaliacao(avaliacaoId));
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<AvaliacaoRespostaResponseDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(respostaService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<AvaliacaoRespostaResponseDTO> create(@RequestBody AvaliacaoRespostaRequestDTO dto) {
        AvaliacaoRespostaResponseDTO saved = respostaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AvaliacaoRespostaResponseDTO> update(
            @PathVariable Integer id,
            @RequestBody AvaliacaoRespostaRequestDTO dto
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(respostaService.update(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        respostaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}