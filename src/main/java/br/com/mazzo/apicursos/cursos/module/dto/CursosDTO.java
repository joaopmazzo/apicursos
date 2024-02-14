package br.com.mazzo.apicursos.cursos.module.dto;

import br.com.mazzo.apicursos.cursos.module.enums.CategoryEnums;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CursosDTO {

    private UUID id;

    private String name;

    private CategoryEnums category;

    private Boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
