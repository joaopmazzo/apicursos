package br.com.mazzo.apicursos.cursos.exceptions;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException() {
        super("Curso não encontrado");
    }
}
