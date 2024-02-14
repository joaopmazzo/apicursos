package br.com.mazzo.apicursos.cursos.module.usecase;

import br.com.mazzo.apicursos.cursos.module.dto.CursosDTO;
import br.com.mazzo.apicursos.cursos.module.mapper.CursosMapper;
import br.com.mazzo.apicursos.cursos.module.service.CursosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ActiveCourseUseCase {

    private final CursosService cursosService;
    private final CursosMapper cursosMapper;

    public CursosDTO execute(UUID id) {
        return cursosMapper.entityToDto(cursosService.activeCourse(id));
    }

}
