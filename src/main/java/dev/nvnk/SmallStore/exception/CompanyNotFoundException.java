package dev.nvnk.SmallStore.exception;

public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException(String message) {
        super(message);
    }
}
