package controller;

import entity.*;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author gurkangltekin
 * 
 * bu sinifimiz, hastane nesnemizin ve veritabanindaki hastane verilerini arayuzde
 * goruleyebilmemiz icin nesne ve arayuz arasinda haberlesme ve kontrol gorevi goruyor.
 */
@Named
@SessionScoped
public class HospitalController extends Controller implements Serializable {
    
    
    @Override
    public void clearForm(){
        this.setHospital(new hospital());
    }
    
    @Override
    public void update(){
        this.getHospitalDao().update(this.getHospital());
        this.setHospital(new hospital());
    }
    
    @Override
    public void updateForm(Object obj){
        hospital hospital = (hospital)obj;
        this.setHospital(hospital);
    }
    
    @Override
    public void deleteConfirm(Object obj){
        hospital hospital = (hospital)obj;
        this.setHospital(hospital);
    }
    
    @Override
    public void delete(){
        this.getHospitalDao().delete(this.getHospital());
        this.setHospital(new hospital());
    }
    
    @Override
    public void create(){
        this.getHospitalDao().insert(this.getHospital());
        this.setHospital(new hospital());
    }
    
}
