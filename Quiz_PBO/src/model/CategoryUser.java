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
public class CategoryUser {
    private int idCategory;
    private String name;

    public CategoryUser() {
    }

    public CategoryUser(int idCategory, String name) {
        this.idCategory =  idCategory;
        this.name = name;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "categoryUser{" + "id=" + idCategory + ", name=" + name + '}';
    }
}
