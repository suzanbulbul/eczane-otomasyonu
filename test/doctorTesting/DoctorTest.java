/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctorTesting;

import dao.*;
import entity.*;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author gurkangltekin
 */
public class DoctorTest {
    
    private doctor doctor;
    private DoctorDao dDao;
    private HospitalDao hDao;
    
    @Test
    public void insertDoctor_test(){
        this.getDoctor().setName("Deneme Doktor Adı");
        this.getDoctor().setSurname("Deneme Doktor Soyadı");
        this.getDoctor().setBranch("Deneme Doktor Branşı");
        List<hospital> hList = this.gethDao().getHospital();
        int size = hList.size();
        this.getDoctor().setHospital(hList.get(size-1));
        this.getdDao().insert(this.getDoctor());
        List<doctor> dList = this.getdDao().getDoctor();
        size = dList.size();
        doctor dLast = dList.get(size-1);
        Assert.assertEquals(this.getDoctor().getName(), dLast.getName());
        Assert.assertEquals(this.getDoctor().getSurname(), dLast.getSurname());
        Assert.assertEquals(this.getDoctor().getBranch(), dLast.getBranch());
        Assert.assertEquals(this.getDoctor().getHospital().getId(), dLast.getHospital().getId());
        this.getdDao().delete(dLast);
    }

    public doctor getDoctor() {
        if(this.doctor == null)
            this.doctor = new doctor();
        return doctor;
    }

    public DoctorDao getdDao() {
        if(this.dDao == null)
            this.dDao = new DoctorDao();
        return dDao;
    }

    public HospitalDao gethDao() {
        if(this.hDao == null)
            this.hDao = new HospitalDao();
        return hDao;
    }
    
    
}
