package Exceptions;

public class CouldNotFind extends Exception{
    public CouldNotFind() {
    }

    public CouldNotFind(String message) {
        super(message);
    }
}
