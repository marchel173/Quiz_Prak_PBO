/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Marchel
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.CategoryUser;
import model.User;

public class QueryController {
    
    DatabaseHandler conn = new DatabaseHandler();
    
    public boolean insertUser(User user) {
        conn.connect();
        String query = "INSERT INTO `user`(`name`, `email`, `password`, `id_category`) VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getIdCategory());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public User selectUser(String email, String password) {
        conn.connect();
        String query = "SELECT `id_user`, `name`, `email`, `password`, `id_category` FROM `user` WHERE email='" + email + "' AND password='" + password + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            User user = new User();

            while (result.next()) {
                user.setIdUser(result.getInt("id_user"));
                user.setName(result.getString("name"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                user.setIdCategory(result.getInt("id_category"));
            }

            if (user.getIdUser() != 0) {
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<User> selectUserByCategory(String category) {
        conn.connect();

        CategoryUser categoryUser = selectCategoryUserByName(category);
        String query = "SELECT `id_user`, `name`, `email`, `password`, `id_category` FROM `user` WHERE id_category='" + categoryUser.getIdCategory() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<User> users = new ArrayList<>();

            while (result.next()) {
                User user = new User();
                user.setIdUser(result.getInt("id_user"));
                user.setName(result.getString("name"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                user.setIdCategory(result.getInt("id_category"));
                users.add(user);
            }

            return users;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<CategoryUser> selectCategoryUser() {
        conn.connect();
        String query = "SELECT `id_category`, `name` FROM `categoryuser` WHERE 1";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<CategoryUser> categories = new ArrayList<>();
            
            while (result.next()) {
                CategoryUser categoryUser = new CategoryUser();
                categoryUser.setIdCategory(result.getInt("id_category"));
                categoryUser.setName(result.getString("name"));
                categories.add(categoryUser);
            }

            return categories;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public CategoryUser selectCategoryUserByName(String name) {
        conn.connect();
        String query = "SELECT `id_category`, `name` FROM `categoryuser` WHERE name='" + name +"'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            CategoryUser categoryUser = new CategoryUser();
            
            while (result.next()) {
                categoryUser.setIdCategory(result.getInt("id_category"));
                categoryUser.setName(result.getString("name"));
            }

            return categoryUser;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateUser(int idUser, User user) {
        conn.connect();
        String query = "UPDATE `user` SET `name`=?,`email`=?,`password`=?,`id_category`=? WHERE `id_user`=?";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getIdCategory());
            stmt.setInt(5, idUser);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public boolean deleteUser(int idUser) {
        conn.connect();
        String query = "DELETE FROM `user` WHERE `id_user`=?";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, idUser);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}