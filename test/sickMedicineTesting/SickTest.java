/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sickMedicineTesting;

import dao.*;
import entity.*;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;



/**
 *
 * @author gurkangltekin
 */
public class SickTest {
    
    private SickDao sDao;
    private sick sick;
    
    @Test
    public void insertSick_Test(){
        //veritabanina deneme hasta bilgileri kayıt ediliyor...
        this.getSick().setName("Deneme Ad");
        this.getSick().setSurname("Deneme Soyad");
        this.getsDao().insert(this.getSick());
        List<sick> sList = this.getsDao().getSick();
        //veritabanindaki bilgileri cekme islemi yapiliyor...
        int i = sList.size();
        //veritabanina son eklenen hasta bilgisi cekiliyor
        sick sLast = sList.get(i-1);
        //ekledigimiz son hasta ile karsilastiriliyor
        Assert.assertEquals(this.getSick().getName(), sLast.getName());
        Assert.assertEquals(this.getSick().getSurname(), sLast.getSurname());
        //eklenen deneme hasta siliniyor...
        this.getsDao().delete(sLast);
    }

    public SickDao getsDao() {
        if(this.sDao == null)
            this.sDao = new SickDao();
        return sDao;
    }

    public sick getSick() {
        if(this.sick == null)
            this.sick = new sick();
        return sick;
    }
    
}
