package controller;

import entity.pw;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author gurkangltekin
 * 
 * bu sinifimiz, ecza deposu nesnemizin ve veritabanindaki ilac verilerini arayuzde
 * goruleyebilmemiz icin nesne ve arayuz arasinda haberlesme ve kontrol gorevi goruyor.
 */
@Named
@SessionScoped
public class PwController extends Controller implements Serializable {
    
    @Override
    public void clearForm(){
        this.setPw(new pw());
    }
    
    @Override
    public void update(){
        this.getPwDao().update(this.getPw());
        this.setPw(new pw());
    }
    
    @Override
    public void updateForm(Object obj){
        pw pW = (pw)obj;
        this.setPw(pW);
    }
    
    @Override
    public void deleteConfirm(Object obj){
        pw pW = (pw)obj;
        this.setPw(pW);
    }
    
    @Override
    public void delete(){
        this.getPwDao().delete(this.getPw());
        this.setPw(new pw());
    }
    
    @Override
    public void create(){
        this.getPwDao().insert(this.getPw());
        this.setPw(new pw());
    }
}