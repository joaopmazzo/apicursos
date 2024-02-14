package br.com.mazzo.apicursos.cursos.module.usecase;

import br.com.mazzo.apicursos.cursos.module.dto.CursosDTO;
import br.com.mazzo.apicursos.cursos.module.mapper.CursosMapper;
import br.com.mazzo.apicursos.cursos.module.service.CursosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrieveAllCursosUseCase {

    private final CursosService cursosService;
    private final CursosMapper cursosMapper;

    public List<CursosDTO> execute() {
        return cursosMapper.entitiesToDtos(cursosService.getAll());
    }

}
