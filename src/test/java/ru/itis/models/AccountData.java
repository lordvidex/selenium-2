package ru.itis.models;

import lombok.Data;


@Data
public class AccountData {
    private final String username;
    private final String password;

    public AccountData(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
