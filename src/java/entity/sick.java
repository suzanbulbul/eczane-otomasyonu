/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import java.util.List;

/**
 * @author gurkangltekin
 * 
 * bu sinifimiz veritabanimizdaki hasta tablomuzun java tarafindan nesnelestirilmis
 * halini temsil etmekte...
 * 
 */
public class sick {
    private int id;
    private String name;
    private String surname;
    private List<medicine> medicines;
    private Date last_update;

    public sick() {
    }

    public sick(int id, String name, String surname, Date last_update) {
        this.id = id;
        this.name = name;
        this.surname = surname;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<medicine> medicines) {
        this.medicines = medicines;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
    
    
}
