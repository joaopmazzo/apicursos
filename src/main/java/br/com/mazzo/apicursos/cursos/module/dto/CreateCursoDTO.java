package br.com.mazzo.apicursos.cursos.module.dto;

import br.com.mazzo.apicursos.cursos.module.enums.CategoryEnums;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateCursoDTO(@NotNull @NotBlank @Size(min = 10, max = 100) String name,
                             @NotNull CategoryEnums category) {

}
