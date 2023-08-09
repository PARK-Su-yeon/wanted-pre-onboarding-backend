package com.example.wantedpreonboardingbackend.User.exception;

public class WrongCredintialsException extends Exception {
    public WrongCredintialsException(String usernameOrPasswordIncorrect) {
        super(usernameOrPasswordIncorrect);
    }
}
