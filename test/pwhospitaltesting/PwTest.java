/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwhospitaltesting;

import entity.*;
import dao.*;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author gurkangltekin
 */
public class PwTest {
    
    public pw pw;
    public PwDAO pwDao;
    
    @Test
    public void insertPw_testing(){
        //veritabanina deneme ecza deposu bilgileri kayıt ediliyor...
        this.getPw().setName("Ecza Deposu Ekleme Testi");
        this.getPw().setPhone_number(4222210132L);
        this.getPw().setDept(1500);
        this.getPwDao().insert(this.getPw());
        //veritabanindaki bilgileri cekme islemi yapiliyor...
        List<pw> pwList = this.getPwDao().getPw();
        int i = pwList.size();
        //veritabanina son eklenen ecza deposu bilgisi cekiliyor
        pw pwLast = pwList.get(i-1);
        //ekledigimiz son ecza deposu ile karsilastiriliyor
        Assert.assertEquals(this.getPw().getName(), pwLast.getName());
        Assert.assertEquals(this.getPw().getDept(), pwLast.getDept());
        Assert.assertEquals(this.getPw().getPhone_number(), pwLast.getPhone_number());
        //eklenen deneme ecza deposu siliniyor...
        this.getPwDao().delete(pwLast);
    }
    
    public pw getPw() {
        if(this.pw == null)
            this.pw = new pw();
        return pw;
    }

    public PwDAO getPwDao() {
        if(this.pwDao == null)
            this.pwDao = new PwDAO();
        return pwDao;
    }
}
