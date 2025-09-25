package br.edu.famapr.AppFamapr.exception.curso;

public class CursoNotFoundException extends RuntimeException {
    public CursoNotFoundException(String message) {
        super(message);
    }
}
