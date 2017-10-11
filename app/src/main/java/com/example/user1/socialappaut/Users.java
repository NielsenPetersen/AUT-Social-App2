package com.example.user1.socialappaut;
public class Users {

    private String autEmail;
    private String firstname;
    private String lastname;
    private String password;

    public Users(){

    }

    public Users(String firstname, String lastname, String autEmail, String password){

        this.firstname = firstname;
        this.lastname = lastname;
        this.autEmail = autEmail;
        this.password = password;

    }


    public String getAutEmail() {
        return autEmail;
    }

    public void setAutEmail(String autEmail) {
        this.autEmail = autEmail;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
