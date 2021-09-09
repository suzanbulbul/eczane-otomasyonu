/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gurkangltekin
 */
public class recipe {
    private int id;
    private Date date;
    private String diagnosis;
    private int sick;
    private int doctor;
    private Date last_update;
    private List<medicine> medicines;

    public recipe() {
    }

    public int getId() {
        return id;
    }

    public recipe(int id, Date date, String diagnosis, int sick, int doctor, Date last_update) {
        this.id = id;
        this.date = date;
        this.diagnosis = diagnosis;
        this.sick = sick;
        this.doctor = doctor;
        this.last_update = last_update;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public int getSick() {
        return sick;
    }

    public void setSick(int sick) {
        this.sick = sick;
    }

    public int getDoctor() {
        return doctor;
    }

    public void setDoctor(int doctor) {
        this.doctor = doctor;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public List<medicine> getMedicines() {
        if(this.medicines == null){
            this.medicines = new ArrayList();
        }
        return medicines;
    }

    public void setMedicines(List<medicine> medicines) {
        this.medicines = medicines;
    }
}
