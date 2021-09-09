package controller;

import entity.*;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author gurkangltekin
 * 
 * bu sinifimiz, hasta nesnemizin ve veritabanindaki ilac verilerini arayuzde
 * goruleyebilmemiz icin nesne ve arayuz arasinda haberlesme ve kontrol gorevi goruyor.
 */
@Named
@SessionScoped
public class SickController extends Controller implements Serializable {
    
    /*bir hastaya ilac satisi yapildigi zaman Sat butonuna basildiginda bu metod
    devreye girecek ve bu metod araciligirla secilen hastaya secilen ilaclarin
    satildigi bilgisi hasta_ilac tablosuna kayit edilecek.*/
    public void sell(){
        this.getSickDao().sell(this.getSelectedItem1(), this.getSelectedMedicines());
        this.setSelectedMedicines(null);
        this.setSelectedItem1(0);
    }
    
    public String detail(sick sick){
        this.setSick(sick);
        return "/secret/sick_detail";
    }
    
    public void deleteConfirmMedicine(Object obj){
        medicine medicine = (medicine)obj;
        this.setMedicine(medicine);
    }
    
    public void deleteSickMedicine(){
        this.getMedicineDao().deleteSickMedicine(this.getMedicine());
        this.getSick().setMedicines(this.getMedicineDao().getSickMedicines(this.getSick().getId()));
    }
    
    public void deleteConfirmRecipe(Object obj){
        recipe recipe = (recipe)obj;
        this.setRecipe(recipe);
    }
    
    public void deleteSickRecipe(){
        this.getRecipeDao().delete(this.getRecipe());
    }
    
    @Override
    public void clearForm(){
        this.setSick(new sick());
    }
    
    @Override
    public void update(){
        this.getSickDao().update(this.getSick());
        this.setSick(new sick());
    }
    
    @Override
    public void updateForm(Object obj){
        sick sick = (sick)obj;
        this.setSick(sick);
    }
    
    @Override
    public void deleteConfirm(Object obj){
        sick sick = (sick)obj;
        this.setSick(sick);
    }
    
    @Override
    public void delete(){
        this.getSickDao().delete(this.getSick());
        this.setSick(new sick());
    }
    
    @Override
    public void create(){
        this.getSickDao().insert(this.getSick());
        this.setSick(new sick());
    }
}
