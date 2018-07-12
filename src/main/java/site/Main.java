package site;

public class Main {

    public static void main(String[] args) {
        YeetUpUser user = new YeetUpUser("hi", "this", "works", "ok", 1);
        DBConnector.addUser(user);
    }
}
