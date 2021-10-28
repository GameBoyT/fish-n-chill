package com.tim23.fishnchill.user.DTO;

// DTO za login
public class AuthenticationDTO {
	
    private String username;
    private String password;

    public AuthenticationDTO() {
        super();
    }

    public AuthenticationDTO(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
