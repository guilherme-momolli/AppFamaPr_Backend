package br.edu.famapr.AppFamapr.controller;

import br.edu.famapr.AppFamapr.dto.avaliacao_opcao.AvaliacaoOpcaoRequestDTO;
import br.edu.famapr.AppFamapr.dto.avaliacao_opcao.AvaliacaoOpcaoResponseDTO;
import br.edu.famapr.AppFamapr.service.AvaliacaoOpcaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/opcoes")
@CrossOrigin(origins = "*")
public class AvaliacaoOpcaoController {

    private final AvaliacaoOpcaoService opcaoService;

    public AvaliacaoOpcaoController(AvaliacaoOpcaoService opcaoService) {
        this.opcaoService = opcaoService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<AvaliacaoOpcaoResponseDTO>> findByPergunta(@RequestParam Integer perguntaId) {
        return ResponseEntity.ok(opcaoService.findByPergunta(perguntaId));
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<AvaliacaoOpcaoResponseDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(opcaoService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<AvaliacaoOpcaoResponseDTO> create(@RequestBody AvaliacaoOpcaoRequestDTO dto) {
        AvaliacaoOpcaoResponseDTO saved = opcaoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AvaliacaoOpcaoResponseDTO> update(
            @PathVariable Integer id,
            @RequestBody AvaliacaoOpcaoRequestDTO dto
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(opcaoService.update(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        opcaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
