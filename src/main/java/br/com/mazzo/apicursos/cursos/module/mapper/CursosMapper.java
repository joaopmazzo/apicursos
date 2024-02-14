package br.com.mazzo.apicursos.cursos.module.mapper;

import br.com.mazzo.apicursos.cursos.module.dto.CreateCursoDTO;
import br.com.mazzo.apicursos.cursos.module.dto.CursosDTO;
import br.com.mazzo.apicursos.cursos.module.entity.CursosEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CursosMapper {

    CursosMapper INSTANCE = Mappers.getMapper( CursosMapper.class );

    CursosEntity DtoToEntity(CreateCursoDTO createCursoDTO);

    CursosDTO entityToDto(CursosEntity cursosEntity);
    List<CursosDTO> entitiesToDtos(List<CursosEntity> cursosEntities);

}
