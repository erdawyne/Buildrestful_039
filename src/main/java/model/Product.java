/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ERDA WYNE
 */
public class Product {              //membuat method get set  class product yg berisi id, name
    private String id;
    private String name;

    public String getId() {         //mengembalikan nilai pada dari variable dengan menggunakan fungsi return
        return id;
    }

    public void setId(String id) {  //set merupakan method void untuk mensetting atau memberikan nilai pada variable
        this.id = id;
    }

    public String getName() {               //mengembalikan nilai pada dari variable dengan menggunakan fungsi return
        return name;
    }

    public void setName(String name) {   //set merupakan method void untuk mensetting atau memberikan nilai pada variable
        this.name = name;
    }
    
}
