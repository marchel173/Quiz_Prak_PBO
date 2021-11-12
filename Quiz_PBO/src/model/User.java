/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Marchel
 */
public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private int idCategory;

    public User() {
    }

    public User(int id, String name, String email, String password, int idCategory) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.idCategory = idCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String phone) {
        this.password = password;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + ", passwor=" + password + ", idCategory=" + idCategory + '}';
    }
}
