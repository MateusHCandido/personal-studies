package exceptionHandling.project01.model.exceptions;

public class AccountException extends RuntimeException{
    public AccountException(String message){
        super(message);
    }
}
