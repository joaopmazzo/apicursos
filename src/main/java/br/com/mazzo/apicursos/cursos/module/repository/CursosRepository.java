package br.com.mazzo.apicursos.cursos.module.repository;

import br.com.mazzo.apicursos.cursos.module.entity.CursosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CursosRepository extends JpaRepository<CursosEntity, UUID> {

    Optional<CursosEntity> findCursosEntityByName(String name);

}
