package controller;

import entity.*;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author gurkangltekin
 * 
 * bu sinifimiz, ilac nesnemizin ve veritabanindaki ilac verilerini arayuzde
 * goruleyebilmemiz icin nesne ve arayuz arasinda haberlesme ve kontrol gorevi goruyor.
 */
@Named
@SessionScoped
public class MedicineController extends Controller implements Serializable{
    
    @Override
    public void clearForm(){
        this.setMedicine(new medicine());
    }
    
    @Override
    public void update(){
        this.getMedicineDao().update(this.getMedicine());
        this.setMedicine(new medicine());
    }
    
    @Override
    public void updateForm(Object obj){
        medicine medicine = (medicine)obj;
        this.setMedicine(medicine);
    }
    
    @Override
    public void deleteConfirm(Object obj){
        medicine medicine = (medicine)obj;
        this.setMedicine(medicine);
    }
    
    @Override
    public void delete(){
        this.getMedicineDao().delete(this.getMedicine());
        this.setMedicine(new medicine());
    }
    
    @Override
    public void create(){
        this.getMedicineDao().insert(this.getMedicine());
        this.setMedicine(new medicine());
    }
}