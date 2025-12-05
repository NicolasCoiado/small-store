package dev.nvnk.SmallStore.exception;

public class UserCpfAlreadyInUseException extends RuntimeException {
    public UserCpfAlreadyInUseException(String message) {
        super(message);
    }
}
