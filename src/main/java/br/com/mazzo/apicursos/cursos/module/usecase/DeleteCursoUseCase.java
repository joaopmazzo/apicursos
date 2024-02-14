package br.com.mazzo.apicursos.cursos.module.usecase;

import br.com.mazzo.apicursos.cursos.module.service.CursosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteCursoUseCase {

    private final CursosService cursosService;

    public void execute(UUID id) {
        cursosService.deleteById(id);
    }

}
