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
 * bu sinifimiz veritabanimizdaki doktor tablomuzun java tarafindan nesnelestirilmis
 * halini temsil etmekte...
 * 
 */
public class doctor {
    private int id;
    private String name;
    private String surname;
    private String branch;
    private hospital hospital;
    private Date last_update;

    public doctor() {
    }

    public doctor(int id, String name, String surname,String branch, Date last_update) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.branch = branch;
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

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public hospital getHospital() {
        return hospital;
    }

    public void setHospital(hospital hospital) {
        this.hospital = hospital;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
}