package model;

public class UserLogin {

    private String password;
    private String email;

    public UserLogin(String password,String email) {
        this.password = password;
        this.email = email;
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
}
