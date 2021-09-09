/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipeTesting;

import dao.*;
import entity.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gurkangltekin
 */
public class recipeTest {
    
    private recipe recipe;
    private RecipeDao rDao;
    private MedicineDao mDao;
    
    
    
    @Test
    public void insertHospital_testing(){
        //veritabanina deneme hastane bilgileri kayıt ediliyor...
        this.getRecipe().setSick(2);
        List<medicine> medicines = this.getmDao().getMedicine();
        for(int i = 0 ; i < 3 ; i++) {
            this.getRecipe().getMedicines().add(medicines.get(i));
        }
        this.getRecipe().setDate(Date.valueOf(LocalDate.now()));
        this.getRecipe().setDiagnosis("Deneme Teşhis");
        this.getRecipe().setDoctor(6);
        this.getrDao().insert(this.getRecipe());
        //veritabanindaki bilgileri cekme islemi yapiliyor...
        List<recipe> rList = this.getrDao().getRecipe();
        int i = rList.size();
        //veritabanina son eklenen hastane bilgisi cekiliyor
        recipe rLast = rList.get(i-1);
        //ekledigimiz son hastane ile karsilastiriliyor
        Assert.assertEquals(this.getRecipe().getSick(), rLast.getSick());
        Assert.assertEquals(this.getRecipe().getDate(), rLast.getDate());
        Assert.assertEquals(this.getRecipe().getDoctor(), rLast.getDoctor());
        for(i = 0 ; i < rLast.getMedicines().size() ; i++){
            Assert.assertEquals(this.getRecipe().getMedicines().get(i), rLast.getMedicines().get(i));
        }
        Assert.assertEquals(this.getRecipe().getDiagnosis(), rLast.getDiagnosis());
        //eklenen deneme hastane siliniyor...
        //this.getrDao().delete(rLast);
    }

    public MedicineDao getmDao() {
        if(this.mDao == null)
            this.mDao = new MedicineDao();
        return mDao;
    }
    
    public recipe getRecipe() {
        if(this.recipe == null)
            this.recipe = new recipe();
        return recipe;
    }

    public RecipeDao getrDao() {
        if(this.rDao == null)
            this.rDao = new RecipeDao();
        return rDao;
    }
}
