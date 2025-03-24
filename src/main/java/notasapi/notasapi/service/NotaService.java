package notasapi.notasapi.service;

import notasapi.notasapi.repository.NotaRepository;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

import notasapi.notasapi.entity.Nota;
import notasapi.notasapi.dto.NotaDTO;


@Service
public class NotaService {
    private final NotaRepository notaRepository;

    public NotaService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    public List<NotaDTO> obtenerNotas() {
        return notaRepository.findAll()
                .stream()
                .map(this::toDto) // Conversión manual
                .collect(Collectors.toList());
    }

    public NotaDTO obtenerNotaPorId(Long id) {
        Nota nota = notaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota no encontrada"));
        return toDto(nota);
    }

    public NotaDTO crearNota(NotaDTO notaDTO) {
        Nota nota = toEntity(notaDTO);
        return toDto(notaRepository.save(nota));
    }

    public NotaDTO actualizarNota(Long id, NotaDTO notaDTO) {
        Nota nota = notaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota no encontrada"));
        nota.setTitulo(notaDTO.getTitulo());
        nota.setContenido(notaDTO.getContenido());
        return toDto(notaRepository.save(nota));
    }

    public void eliminarNota(Long id) {
        notaRepository.deleteById(id);
    }

    // Métodos de conversión manual
    private NotaDTO toDto(Nota nota) {
        return new NotaDTO(nota.getId(), nota.getTitulo(), nota.getContenido(), nota.getFechaCreacion());
    }

    private Nota toEntity(NotaDTO notaDTO) {
        return new Nota(notaDTO.getId(), notaDTO.getTitulo(), notaDTO.getContenido(), notaDTO.getFechaCreacion());
    }
}