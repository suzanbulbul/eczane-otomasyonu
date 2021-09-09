/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sickMedicineTesting;

import entity.*;
import dao.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author gurkangltekin
 */
public class MedicineTest {
    
    private MedicineDao mDao;
    private medicine medicine;
    
    @Test
    public void insertMedicine_Test() throws ParseException{
        //veritabanina deneme ilac bilgileri kayıt ediliyor...
        this.getMedicine().setName("Deneme İlaç Adı");
        this.getMedicine().setStock(100);
        this.getMedicine().setExd(new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-12"));
        this.getmDao().insert(this.getMedicine());
        List<medicine> mList = this.getmDao().getMedicine();
        //veritabanindaki bilgileri cekme islemi yapiliyor...
        int i = mList.size();
        //veritabanina son eklenen ilac bilgisi cekiliyor
        medicine mLast = mList.get(i-1);
        //ekledigimiz son ilac ile karsilastiriliyor
        Assert.assertEquals(this.getMedicine().getName(), mLast.getName());
        Assert.assertEquals(this.getMedicine().getStock(), mLast.getStock());
        Assert.assertEquals(this.getMedicine().getExd(), mLast.getExd());
        //eklenen deneme ilac siliniyor...
        this.getmDao().delete(mLast);
    }

    public MedicineDao getmDao() {
        if(this.mDao == null)
            this.mDao = new MedicineDao();
        return mDao;
    }

    public medicine getMedicine() {
        if(this.medicine == null)
            this.medicine = new medicine();
        return medicine;
    }
}
