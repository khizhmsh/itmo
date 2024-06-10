package org.example.exceptions;

public class NotRegisterException extends Exception{
    public NotRegisterException(){
        super("Сначала войдите или зарегистрируйтесь введите \nreg *name* *password* \nlogin *name* *password*");
    }
}
