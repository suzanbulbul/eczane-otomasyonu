/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwhospitaltesting;

import dao.HospitalDao;
import entity.hospital;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author gurkangltekin
 */
public class HospitalTest {
    
    public hospital hospital;
    public HospitalDao hDao;
    
    @Test
    public void insertHospital_testing(){
        //veritabanina deneme hastane bilgileri kayıt ediliyor...
        this.getHospital().setName("Hastane Ekleme Testi");
        this.getHospital().setAddress("Hastane adresi");
        this.gethDao().insert(this.getHospital());
        //veritabanindaki bilgileri cekme islemi yapiliyor...
        List<hospital> hList = this.gethDao().getHospital();
        int i = hList.size();
        //veritabanina son eklenen hastane bilgisi cekiliyor
        hospital hLast = hList.get(i-1);
        //ekledigimiz son hastane ile karsilastiriliyor
        Assert.assertEquals(this.getHospital().getName(), hLast.getName());
        Assert.assertEquals(this.getHospital().getAddress(), hLast.getAddress());
        //eklenen deneme hastane siliniyor...
        this.gethDao().delete(hLast);
    }

    public hospital getHospital() {
        if(this.hospital == null)
            this.hospital = new hospital();
        return hospital;
    }

    public HospitalDao gethDao() {
        if(this.hDao == null)
            this.hDao = new HospitalDao();
        return hDao;
    }
}
