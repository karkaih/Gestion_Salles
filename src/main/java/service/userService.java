package service;

import beans.EmailMessage;
import beans.user;
import connexion.Connexion;
import controller.UserController;
import dao.IDao;

import javax.servlet.http.HttpSession;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class userService implements IDao<user> {

    @Override
    public boolean create(user o){
        try {
            PreparedStatement pr = Connexion.PreparedSQLStatement("INSERT INTO user VALUE(null,?,?,?,?,?,?,?)");
            assert pr != null;
            pr.setString(1,o.getUsername());
            pr.setString(2,(o.getPassword()));
            pr.setString(3,"simpleUser");
            pr.setString(4,o.getFullName());
            pr.setString(5,o.getEmail());
            pr.setString(6,o.getCity());
            pr.setString(7,o.getState());
            
            if(pr.executeUpdate() !=0)
                return  true;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    @Override
    public boolean delete(int o) {
        try {
            PreparedStatement pr = Connexion.PreparedSQLStatement("DELETE FROM user WHERE id = ?");
            assert pr != null;
            pr.setInt(1,o);
            if(pr.executeUpdate() !=0)
                return  true;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(user o) {
        try {
            PreparedStatement pr = Connexion.PreparedSQLStatement("UPDATE user SET fullName = ?, state = ?,level = ? ,city = ?,email = ?  , username= ? WHERE id = ?");
            assert pr != null;
            pr.setString(1,o.getFullName());
            pr.setString(2,o.getState());
            pr.setString(3,o.getLevel());
            pr.setString(4,o.getCity());
            pr.setString(5,o.getEmail());
            pr.setString(6,o.getUsername());
            pr.setInt(7,o.getId());
            if(pr.executeUpdate() !=0)
                return  true;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<user> findAll() {
        List<user> userList = new ArrayList<>();
        try {
            PreparedStatement pr = Connexion.PreparedSQLStatement("SELECT * FROM user");
            assert pr != null;
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next())
                userList.add(new user(resultSet.getInt("id"),resultSet.getString("fullName"),resultSet.getString("username"),resultSet.getString("password"),resultSet.getString("email"),resultSet.getString("city"),resultSet.getString("state"),resultSet.getString("level")));
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
    
    public List<user> findAll2() {
        List<user> userList = new ArrayList<>();
        try {
            PreparedStatement pr = Connexion.PreparedSQLStatement("SELECT * FROM user where username Not Like '"+UserController.currentUser.getUsername()+"'");
            assert pr != null;
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next())
                userList.add(new user(resultSet.getInt("id"),resultSet.getString("fullName"),resultSet.getString("username"),resultSet.getString("password"),resultSet.getString("email"),resultSet.getString("city"),resultSet.getString("state"),resultSet.getString("level")));
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public user findById(int id) {
        try {
            PreparedStatement pr = Connexion.PreparedSQLStatement("SELECT * FROM user WHERE id = ?");
            assert pr != null;
            pr.setInt(1,id);
            ResultSet resultSet = pr.executeQuery();
            if (resultSet.next())
                return new user(resultSet.getInt("id"),resultSet.getString("fullName"),resultSet.getString("username"),resultSet.getString("password"),resultSet.getString("email"),resultSet.getString("city"),resultSet.getString("state"),resultSet.getString("level"));
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean sendEmailRest(String email,int id) {
        EmailMessage emailbean = new EmailMessage();
        emailbean.setSubject("Reset your password for Servlet JSP APP\n");
        emailbean.setMessage(
                "Message\n" +
                "Hello,\n" +
                "\n" +
                "Follow this link to reset your Servlet JSP APP password for your "+email+" account.\n" +
                "\n" +
                "http://localhost:8080/Servlet1_war/deskapp2-master/reset-password.html?id="+id+"\n" +
                "\n" +
                "If you didn’t ask to reset your password, you can ignore this email.\n" +
                "\n" +
                "Thanks,\n" +
                "\n" +
                "Your Servlet JSP APP team");
        try {

            EmailUtility.sendMail(emailbean);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
