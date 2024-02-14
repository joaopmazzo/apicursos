package br.com.mazzo.apicursos.cursos.module.entity;

import br.com.mazzo.apicursos.cursos.module.enums.CategoryEnums;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "cursos")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CursosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Size(min = 5, max = 100)
    private String name;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private CategoryEnums category;

    @NotNull
    private Boolean active;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public CursosEntity merge(CursosEntity cursosEntity) {
        this.name = cursosEntity.getName();
        this.category = cursosEntity.getCategory();
        return this;
    }

}
