package br.com.mazzo.apicursos.cursos.exceptions;

public class CourseNameFoundException extends RuntimeException {
    public CourseNameFoundException(String name) {
        super("Nome de Curso (" + name + ") já cadastrado");
    }
}
