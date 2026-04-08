package com.example.cert1.exception;

public class TareaNotFoundException extends RuntimeException {
    public TareaNotFoundException(int id) {
        super("Tarea con id " + id + " no encontrada");
    }
}