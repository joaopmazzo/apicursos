package br.com.mazzo.apicursos.cursos.module.controller;

import br.com.mazzo.apicursos.cursos.module.dto.CreateCursoDTO;
import br.com.mazzo.apicursos.cursos.module.dto.CursosDTO;
import br.com.mazzo.apicursos.cursos.module.usecase.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursosController {

    private final CreateCursoUseCase createCursoUseCase;
    private final RetrieveAllCursosUseCase retrieveAllCursosUseCase;
    private final UpdateCursoUseCase updateCursoUseCase;
    private final DeleteCursoUseCase deleteCursoUseCase;
    private final InactiveCourseUseCase inactiveCourseUseCase;
    private final ActiveCourseUseCase activeCourseUseCase;

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody @Valid CreateCursoDTO createCursoDTO,
                                         UriComponentsBuilder uriBuilder) {
        try {
            CursosDTO cursoCriado = createCursoUseCase.execute(createCursoDTO);

            URI location = uriBuilder
                    .path("/cursos/{id}")
                    .buildAndExpand(cursoCriado.getId())
                    .toUri();

            return ResponseEntity.created(location).body(cursoCriado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<Object> getAll() {
        try {
            return ResponseEntity.ok().body(retrieveAllCursosUseCase.execute());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") UUID id,
                                         @RequestBody @Valid CreateCursoDTO createCursoDTO) {
        try {
            return ResponseEntity.ok().body(updateCursoUseCase.execute(id, createCursoDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") UUID id) {
        try {
            deleteCursoUseCase.execute(id);
            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/inactive")
    public ResponseEntity<Object> inactiveCourse(@PathVariable("id") UUID id) {
        try {
            return ResponseEntity.ok().body(inactiveCourseUseCase.execute(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Object> activeCourse(@PathVariable("id") UUID id) {
        try {
            return ResponseEntity.ok().body(activeCourseUseCase.execute(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
