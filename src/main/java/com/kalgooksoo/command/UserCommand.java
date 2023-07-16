package com.kalgooksoo.command;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserCommand {

    /**
     * 식별자
     */
    private Long id;

    /**
     * 아이디(Alternate Key)
     */
    @NotBlank
    private String username;

    /**
     * 이름
     */
    private String name;

    /**
     * 패스워드
     */
    @NotBlank
    private String password;

    /**
     * 이메일
     */
    @Email
    private String email;

    /**
     * 연락처
     */
    @NotBlank
    private String contactNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
