package notasapi.notasapi.controller;

import notasapi.notasapi.service.NotaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import notasapi.notasapi.dto.NotaDTO;

@RestController
@RequestMapping("/api/notas")
@RequiredArgsConstructor
public class NotaController {
    private final NotaService notaService;

    @GetMapping
    public ResponseEntity<List<NotaDTO>> obtenerNotas() {
        return ResponseEntity.ok(notaService.obtenerNotas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotaDTO> obtenerNotaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(notaService.obtenerNotaPorId(id));
    }

    @PostMapping
    public ResponseEntity<NotaDTO> crearNota(@Valid @RequestBody NotaDTO notaDTO) {
        return ResponseEntity.ok(notaService.crearNota(notaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotaDTO> actualizarNota(@PathVariable Long id, @Valid @RequestBody NotaDTO notaDTO) {
        return ResponseEntity.ok(notaService.actualizarNota(id, notaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNota(@PathVariable Long id) {
        notaService.eliminarNota(id);
        return ResponseEntity.noContent().build();
    }
}
