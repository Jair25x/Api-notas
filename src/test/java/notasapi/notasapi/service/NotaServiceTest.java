package notasapi.notasapi.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import notasapi.notasapi.dto.NotaDTO;
import notasapi.notasapi.entity.Nota;
import notasapi.notasapi.repository.NotaRepository;


@ExtendWith(MockitoExtension.class) // Habilita Mockito en JUnit 5
class NotaServiceTest {

    @Mock
    private NotaRepository notaRepository; // Simula la capa de repositorio

    @InjectMocks
    private NotaService notaService; // La clase a probar

    private Nota notaEjemplo;
    private NotaDTO notaDTOEjemplo;

    @BeforeEach
    void setUp() {
        // Datos de prueba
        notaEjemplo = new Nota(1L, "Título de prueba", "Contenido de prueba", null);
        notaDTOEjemplo = new NotaDTO(1L, "Título de prueba", "Contenido de prueba", null);
    }

    @Test
    void obtenerNotas_DebeRetornarListaDeNotas() {
        when(notaRepository.findAll()).thenReturn(Arrays.asList(notaEjemplo));

        List<NotaDTO> resultado = notaService.obtenerNotas();

        assertEquals(1, resultado.size());
        assertEquals(notaEjemplo.getTitulo(), resultado.get(0).getTitulo());
    }

    @Test
    void obtenerNotaPorId_CuandoExiste_DebeRetornarNota() {
        when(notaRepository.findById(1L)).thenReturn(Optional.of(notaEjemplo));

        NotaDTO resultado = notaService.obtenerNotaPorId(1L);

        assertEquals(notaEjemplo.getTitulo(), resultado.getTitulo());
    }

    @Test
    void obtenerNotaPorId_CuandoNoExiste_DebeLanzarExcepcion() {
        when(notaRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> notaService.obtenerNotaPorId(99L));
    }

    @Test
    void crearNota_DebeGuardarYRetornarNota() {
        when(notaRepository.save(any(Nota.class))).thenReturn(notaEjemplo);

        NotaDTO resultado = notaService.crearNota(notaDTOEjemplo);

        assertNotNull(resultado);
        assertEquals(notaDTOEjemplo.getTitulo(), resultado.getTitulo());
    }

    @Test
    void actualizarNota_CuandoExiste_DebeActualizarYRetornarNota() {
        when(notaRepository.findById(1L)).thenReturn(Optional.of(notaEjemplo));
        when(notaRepository.save(any(Nota.class))).thenReturn(notaEjemplo);

        NotaDTO resultado = notaService.actualizarNota(1L, new NotaDTO(1L, "Nuevo título", "Nuevo contenido", null));

        assertEquals("Nuevo título", resultado.getTitulo());
    }

    @Test
    void eliminarNota_DebeEliminarNotaPorId() {
        doNothing().when(notaRepository).deleteById(1L);

        assertDoesNotThrow(() -> notaService.eliminarNota(1L));
    }
}
