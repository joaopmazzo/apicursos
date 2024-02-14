package br.com.mazzo.apicursos.cursos.module.service;

import br.com.mazzo.apicursos.cursos.exceptions.CourseNameFoundException;
import br.com.mazzo.apicursos.cursos.exceptions.CourseNotFoundException;
import br.com.mazzo.apicursos.cursos.module.dto.CreateCursoDTO;
import br.com.mazzo.apicursos.cursos.module.entity.CursosEntity;
import br.com.mazzo.apicursos.cursos.module.mapper.CursosMapper;
import br.com.mazzo.apicursos.cursos.module.repository.CursosRepository;
import br.com.mazzo.apicursos.cursos.module.usecase.CreateCursoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CursosService {

    private final CursosRepository cursosRepository;
    private final CursosMapper cursosMapper;

    @Transactional
    public CursosEntity createCurso(CreateCursoDTO createCursoDTO) {
        findCursoByName(createCursoDTO.name()).ifPresent(i -> {
            throw new CourseNameFoundException(i.getName());
        });

        CursosEntity curso = cursosMapper.DtoToEntity(createCursoDTO);
        curso.setActive(true);

        return cursosRepository.save(curso);
    }

    public List<CursosEntity> getAll() {
        return cursosRepository.findAll();
    }

    @Transactional
    public CursosEntity update(UUID id, CreateCursoDTO createCursoDTO) {
        CursosEntity curso = findCursoById(id);
        return cursosRepository.save(curso.merge(cursosMapper.DtoToEntity(createCursoDTO)));
    }

    @Transactional
    public void deleteById(UUID id) {
        CursosEntity curso = findCursoById(id);
        cursosRepository.deleteById(curso.getId());
    }

    @Transactional
    public CursosEntity inactiveCourse(UUID id) {
        CursosEntity curso = findCursoById(id);
        curso.setActive(false);

        return cursosRepository.save(curso);
    }

    @Transactional
    public CursosEntity activeCourse(UUID id) {
        CursosEntity curso = findCursoById(id);
        curso.setActive(true);

        return cursosRepository.save(curso);
    }

    public Optional<CursosEntity> findCursoByName(String name) {
        return cursosRepository.findCursosEntityByName(name);
    }

    public CursosEntity findCursoById(UUID id) {
        return cursosRepository.findById(id).orElseThrow(CourseNotFoundException::new);
    }

}
