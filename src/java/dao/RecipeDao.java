package dao;

import java.sql.*;
import java.util.*;
import entity.*;

/**
 *
 * @author gurkangltekin
 *
 * Bu Sinifimiz, java tarafindan olusturdugumuz hasta tablomuzun
 * nesnelestirilmis haline veritabanındaki bilgileri eklememizde yardimci
 * olacak.
 */
public class RecipeDao extends dao {

    /*ilacdao sinifimizin nesnesinin hasta sinifinda olmasinin sebebi, her hastanin
    aldigi ilaclarin bilgisini hasta içerisinde barindirabilmek icin ilacdao 
    sinifini hastadao sinifimiza entegre etme ihtiyaci doguyor.*/
    private MedicineDao mDao;

    private SickDao sDao;
    private DoctorDao dDao;
    
    public recipe find(int id){
        recipe recipe = null;
        try{
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from recipe where id = " + id);
            
            rs.next();
            
            recipe = new recipe(rs.getInt("id"), rs.getDate("date"), rs.getString("diagnosis"), rs.getInt("sick_id"), rs.getInt("doctor_id"), rs.getDate("last_update"));
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return recipe;
    }

    public List<Integer> getRecipeMedicines(int recipeId) {
        List<Integer> selectedMedicines = new ArrayList<>();
        try {
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from recipe_medicine where recipe_id = " + recipeId);
            while (rs.next()) {
                selectedMedicines.add(rs.getInt("medicine_id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return selectedMedicines;
    }
    
    public List<recipe> getSickRecipe(int sickId) {
        List<recipe> sickRecipes = new ArrayList<>();
        try {
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from recipe where sick_id = " + sickId);
            while (rs.next()) {
                sickRecipes.add(new recipe(rs.getInt("id"), rs.getDate("date"), rs.getString("diagnosis"), rs.getInt("sick_id"), rs.getInt("doctor_id"), rs.getDate("last_update")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sickRecipes;
    }

    public void createRecipeMedicine(List<Integer> selectedMedicines, int id, int sickId) {
        try {
            Statement st = this.getC().createStatement();

            int size = selectedMedicines.size();
            int check = 0, i, j, size2;
            if (id == 0) {
                for (i = 0; i < size; i++) {
                    st.executeUpdate("insert into recipe_medicine (recipe_id, medicine_id) values (" + this.getLastRecipe() + ", " + selectedMedicines.get(i) + ")");
                    st.executeUpdate("insert into sick_medicine (sick, medicine_id) values (" + sickId + ", " + selectedMedicines.get(i) + ")");
                }
            } else {
                
                List<Integer> mList = new ArrayList();
                ResultSet rs = st.executeQuery("select * from recipe_medicine where recipe_id = " + id);
                
                while(rs.next()){
                    mList.add(rs.getInt("medicine_id"));
                }
                
                size2 = mList.size();
                
                for(i = 0 ; i < size ; i++){
                    j = 0;
                    while(j < size2){
                        if(mList.get(j) == selectedMedicines.get(i)){
                            check = 1;
                            System.out.println("deneme");
                        }
                        j++;
                    }
                    if(check != 1){
                        st.executeUpdate("insert into recipe_medicine (recipe_id, medicine_id) values (" + id + ", " + selectedMedicines.get(i) + ")");
                        st.executeUpdate("insert into sick_medicine (sick, medicine_id) values (" + sickId + ", " + selectedMedicines.get(i) + ")");
                        System.out.println(selectedMedicines.get(i));
                    }
                    if(check == 1){
                        check = 0;
                    }
                }

                
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getLastRecipe() {
        int id = 0;
        try {
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from recipe order by id desc limit 1");
            rs.next();
            id = rs.getInt("id");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return id;
    }

    /*bu metodumuz veritabanındaki hasta tablomuzdas bulunan tum satirlari
    *burada liste haline getirerek somutlastirma islemini gerceklestiriyoruz
     */
    public List<recipe> getRecipe() {
        List<recipe> recipeList = new ArrayList();

        try {
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from recipe");

            while (rs.next()) {
                recipe tmp = new recipe();
                tmp.setId(rs.getInt("id"));
                tmp.setDate(rs.getDate("date"));
                tmp.setDiagnosis(rs.getString("diagnosis"));
                tmp.setSick(rs.getInt("sick_id"));
                tmp.setDoctor(rs.getInt("doctor_id"));
                tmp.setMedicines(this.getmDao().getRecipeMedicines(rs.getInt("id")));
                tmp.setLast_update(rs.getDate("last_update"));
                recipeList.add(tmp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return recipeList;
    }

    /*Bu metodumuz hasta tablosuna yeni ilac bilgilerinin girislerini
    gerceklestirebilmemiz icin gerekli kod parcaciklarini barindiriyor.
     */
    @Override
    public void insert(Object obj) {
        recipe recipe = (recipe) obj;
        try {
            Statement st = this.getC().createStatement();
            st.executeUpdate("insert into recipe (date, diagnosis, sick_id, doctor_id) values('"
                    + recipe.getDate() + "', '" + recipe.getDiagnosis() + "', "
                    + recipe.getSick() + ", " + recipe.getDoctor() + ")");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*Bu metodumuz hasta tablomuzda yanlis girilen veya artik veritabanimizda
    bulunmasini gerektirmeyecek hasta bilgilerini silmemize yariyor.*/
    @Override
    public void delete(Object obj) {
        recipe recipe = (recipe) obj;
        try {
            Statement st = this.getC().createStatement();
            st.executeUpdate("delete from recipe where id=" + recipe.getId());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*Bu metodumuz, tablomuzda yanlis girilen veya bilgisi degisen bir hasta
    bilgisinin guncellenmesini gerceklestiren kod parcaciklarini barindiriyor.*/
    @Override
    public void update(Object obj) {
        recipe recipe = (recipe) obj;
        try {
            Statement st = this.getC().createStatement();
            st.executeUpdate("update recipe set date = '" + recipe.getDate()
                    + "', diagnosis = '" + recipe.getDiagnosis() + "', sick_id = "
                    + recipe.getSick() + ", doctor_id = " + recipe.getDoctor()
                    + " where id = " + recipe.getId());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public MedicineDao getmDao() {
        //nesnemizin null gelme olasiligini ortadan kaldirmak amaciyla kontrol gerceklestiriyoruz
        if (this.mDao == null) {
            this.mDao = new MedicineDao();
        }
        return mDao;
    }

    public SickDao getsDao() {
        if (this.sDao == null) {
            this.sDao = new SickDao();
        }
        return sDao;
    }

    public DoctorDao getdDao() {
        if (this.dDao == null) {
            this.dDao = new DoctorDao();
        }
        return dDao;
    }

}
