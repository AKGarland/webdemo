package main.java;

public class YeetUpUser {
    private String forename;
    private String surname;
    private String email;
    private String password;
    private boolean subscribe;

    public YeetUpUser(String forename, String surname, String email, String password, boolean subscribe) {
        this.forename = forename;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.subscribe = subscribe;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isSubscribe() {
        return subscribe;
    }
}
