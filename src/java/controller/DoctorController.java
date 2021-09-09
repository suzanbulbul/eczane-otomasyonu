package controller;

import entity.*;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author gurkangltekin
 * 
 * bu sinifimiz, doktor nesnemizin ve veritabanindaki doktor verilerini arayuzde
 * goruleyebilmemiz icin nesne ve arayuz arasinda haberlesme ve kontrol gorevi goruyor.
 */
@Named
@SessionScoped
public class DoctorController extends Controller implements Serializable {
    
    @Override
    public void clearForm(){
        this.setDoctor(new doctor());
        this.setSelectedItem1(0);
    }
    
    @Override
    public void update(){
        this.getDoctorDao().update(this.getDoctor());
        this.clearForm();
    }
    
    @Override
    public void updateForm(Object obj){
        doctor doctor = (doctor)obj;
        this.setDoctor(doctor);
        this.setSelectedItem1(doctor.getHospital().getId());
    }
    
    @Override
    public void deleteConfirm(Object obj){
        doctor doctor = (doctor)obj;
        this.setDoctor(doctor);
    }
    
    @Override
    public void delete(){
        this.getDoctorDao().delete(this.getDoctor());
        this.setDoctor(new doctor());
    }
    
    @Override
    public void create(){
        this.getDoctorDao().insert(this.getDoctor());
        this.clearForm();
    }
}