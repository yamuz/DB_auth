package bitlab.entities;

public class User {
    private int id;
    private String login;
    private String password;
    private String fullname;

    public User(int id, String login, String password, String fullname) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.fullname = fullname;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}

