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

    private int idUser;
    private String name;
    private String email;
    private String password;
    private int idCategory;

    public User() {
    }

    public User(String name, String email, String password, int idCategory) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.idCategory = idCategory;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
        return "User{" + "id=" + idUser + ", name=" + name + ", email=" + email + ", passwor=" + password + ", idCategory=" + idCategory + '}';
    }
}
