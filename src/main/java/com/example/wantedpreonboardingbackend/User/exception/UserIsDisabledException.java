package com.example.wantedpreonboardingbackend.User.exception;

public class UserIsDisabledException extends Exception {
    public UserIsDisabledException(String userIsDisabled) {
        super(userIsDisabled);
    }
}
