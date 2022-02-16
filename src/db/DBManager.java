package db;

import bitlab.entities.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DBManager {
    private Connection cnx;

    public DBManager() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/bitlab_test?serverTimezone=UTC&useUnicode=true","root","");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public User getUsers(String login, String password){
        User result = null;
        try{
            PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM users WHERE login = ? AND password = ?");
            stmt.setString(1, login);
            stmt.setString(2, password);

            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()){
                result = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("fullname")
                );
            }
            stmt.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
