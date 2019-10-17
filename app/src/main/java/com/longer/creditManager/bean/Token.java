package com.longer.creditManager.bean;

public class Token {

    public static String token;

    public Token() {
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        Token.token = token;
    }
}
