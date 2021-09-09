package dao;

import java.util.*;
import entity.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author gurkangltekin
 * 
 * Bu Sinifimiz, java tarafindan olusturdugumuz ilac tablomuzun nesnelestirilmis
 * haline veritabanındaki bilgileri eklememizde yardimci olacak.
 */
public class MedicineDao extends dao{
        
        
      public List<medicine> getRecipeMedicines(int recipeId){
        List<medicine> mList = new ArrayList<>();
        
        try{
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from recipe_medicine where recipe_id = " + recipeId);
            
            while(rs.next()){
                mList.add(this.find(rs.getInt("medicine_id")));
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return mList;
    }
        
    /*verilen id bilgisine gore veritabanindaki o id'ye kayitli olan ilacin tum 
        bilgilerini geri donduren bir kod parcacigidir.*/
    public medicine find(int id){
        medicine medicine = null;
        try{
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from medicine where id = " + id);
            
            rs.next();
            
            medicine = new medicine(rs.getInt("id"), rs.getString("name"), rs.getDate("exd"), rs.getInt("stock"), rs.getDate("last_update"));
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return medicine;
    }
    
    /*Bu metodumuz, bir hastanin aldigi ilaclarin takibini gerceklestrirmek amaciyla
    yazilmistir. gelen hasta id'sinine gore hasta ve ilac arasinda many to many 
    iliski bulunan bulundugundan hasta_ilac tablosunda tutulan bilgileri
    hasta_ilac tablosundan hastanin adina kayitli olan tum ilaclari tablodan cekmektedir.*/
    public List<medicine> getSickMedicines(int sickId){
        List<medicine> mList = new ArrayList<>();
        
        try{
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from sick_medicine where sick = " + sickId);
            medicine m;
            while(rs.next()){
                m = this.find(rs.getInt("medicine_id"));
                m.setId(rs.getInt("id"));
                m.setLast_update(rs.getDate("last_update"));
                mList.add(m);
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return mList;
    }
      
    /*bu metodumuz veritabanındaki ilac tablomuzdas bulunan tum satirlari
    *burada liste haline getirerek somutlastirma islemini gerceklestiriyoruz
    */
    public List<medicine> getMedicine(){
        List<medicine> medicineList = new ArrayList();
        
        try{
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from medicine");
            
            while(rs.next()){
                medicine tmp = new medicine(rs.getInt("id"), rs.getString("name"), rs.getDate("exd"), rs.getInt("stock"), rs.getDate("last_update"));
                medicineList.add(tmp);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return medicineList;
    }

    /*Bu metodumuz ilac tablosuna yeni ilac bilgilerinin girislerini
    gerceklestirebilmemiz icin gerekli kod parcaciklarini barindiriyor.
    */
    @Override
    public void insert(Object obj) {
        medicine medicine = (medicine)obj;
        try{
            Statement st = this.getC().createStatement();
            st.executeUpdate("insert into medicine (name, exd, stock) values('" + medicine.getName() + "', '" + medicine.getExd() +"', " + medicine.getStock() + ")");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    /*Bu metodumuz ilac tablomuzda yanlis girilen veya artik veritabanimizda
    bulunmasini gerektirmeyecek ilac bilgilerini silmemize yariyor.*/
    @Override
    public void delete(Object obj) {
        medicine medicine = (medicine)obj;
        try{
            Statement st = this.getC().createStatement();
            st.executeUpdate("delete from medicine where id=" + medicine.getId());
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    /*Bu metodumuz, tablomuzda yanlis girilen veya bilgisi degisen bir ilac
    bilgisinin guncellenmesini gerceklestiren kod parcaciklarini barindiriyor.*/
    @Override
    public void update(Object obj) {
        medicine medicine = (medicine)obj;
        try{
            Statement st = this.getC().createStatement();
            st.executeUpdate("update medicine set name = '" + medicine.getName() + "', exd = '" + medicine.getExd()+ "', stock = " + medicine.getStock() + " where id=" + medicine.getId());
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteSickMedicine(medicine medicine) {
        try{
            Statement st = this.getC().createStatement();
            st.executeUpdate("delete from sick_medicine where id = " + medicine.getId());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}