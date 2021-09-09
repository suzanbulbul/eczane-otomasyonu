/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 * @author gurkangltekin
 * 
 * bu sinifimiz veritabanimizdaki ilac tablomuzun java tarafindan nesnelestirilmis
 * halini temsil etmekte...
 * 
 */
public class medicine {
    
    private int id;
    private String name;
    private Date exd;
    private int stock;
    private Date last_update;

    public medicine() {
    }

    public medicine(int id, String name, Date exd, int stock, Date last_update) {
        this.id = id;
        this.name = name;
        this.exd = exd;
        this.stock = stock;
        this.last_update = last_update;
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

    public Date getExd() {
        return exd;
    }

    public void setExd(Date exd) {
        this.exd = exd;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
    
    
    
}
