package br.edu.famapr.AppFamapr.controller;

import br.edu.famapr.AppFamapr.dto.pergunta.PerguntaRequestDTO;
import br.edu.famapr.AppFamapr.dto.pergunta.PerguntaResponseDTO;
import br.edu.famapr.AppFamapr.service.PerguntaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/api/perguntas")
//@CrossOrigin(origins = "*")
//public class PerguntaController {
//
//    private final PerguntaService perguntaService;
//
//    public PerguntaController(PerguntaService perguntaService) {
//        this.perguntaService = perguntaService;
//    }
//
//    @GetMapping("/list")
//    public ResponseEntity<List<PerguntaResponseDTO>> findAll() {
//        return ResponseEntity.ok(perguntaService.findAll());
//    }
//
//    @GetMapping("/findById/{id}")
//    public ResponseEntity<PerguntaResponseDTO> findById(@PathVariable Integer id) {
//        return ResponseEntity.ok(perguntaService.findById(id));
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<PerguntaResponseDTO> create(@RequestBody PerguntaRequestDTO dto) {
//        PerguntaResponseDTO response = perguntaService.create(dto);
//        return ResponseEntity.ok(response);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<PerguntaResponseDTO> update(@PathVariable Integer id,
//                                                      @RequestBody PerguntaRequestDTO dto) {
//        PerguntaResponseDTO responseDTO = perguntaService.update(id, dto);
//        return ResponseEntity.ok(responseDTO);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Integer id) {
//        perguntaService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//}
