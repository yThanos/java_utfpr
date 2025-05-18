package dev.fraporti.atividade_9.exception;

/**
 * @author vitor.rosmann on 30/04/2025
 */
public class VelocException extends Exception {
    public VelocException(String message){
        super(message);
        System.out.println(message);
    }
}
