//package br.edu.famapr.AppFamapr.controller;
//
//
//import br.edu.famapr.AppFamapr.dto.resposta.RespostaRequestDTO;
//import br.edu.famapr.AppFamapr.dto.resposta.RespostaResponseDTO;
//import br.edu.famapr.AppFamapr.service.RespostaService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.swing.text.html.parser.Entity;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/respostas")
//@CrossOrigin(origins = "*")
//public class RespostaController {
//
//    private final RespostaService respostaService;
//
//    public RespostaController(RespostaService respostaService) {
//        this.respostaService = respostaService;
//    }
//
//    @GetMapping("/list")
//    public ResponseEntity<List<RespostaResponseDTO>> findAll() {
//        return ResponseEntity.ok(respostaService.findAll());
//    }
//
//    @GetMapping("/findById/{id}")
//    public ResponseEntity<RespostaResponseDTO> findById(@PathVariable Integer id) {
//        return ResponseEntity.ok(respostaService.findById(id));
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<RespostaResponseDTO> create(@RequestBody RespostaRequestDTO dto) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(respostaService.create(dto));
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<RespostaResponseDTO> update(@PathVariable Integer id,
//                                                      @RequestBody RespostaRequestDTO dto) {
//        RespostaResponseDTO response = respostaService.update(id, dto);
//        return ResponseEntity.ok(response);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Integer id) {
//       respostaService.delete(id);
//       return ResponseEntity.noContent().build();
//    }
//}
