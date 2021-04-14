package ro.msg.learning.shop.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(Long id) {
        super("Could not find entity with id " + id);
    }
}