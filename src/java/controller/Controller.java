package controller;

import dao.*;
import entity.*;
import java.util.List;
/**
 *
 * @author gurkangltekin
 * 
 * Bu sinifi olusturma amacim , tum controllerlarin velirli bir altyapiya hazirlanmasi,
 * birbiriyle iliskili olacak siniflarin birbiriyle olan iletisimi saglayabilmek icin
 * gerekli olacak ozellik ve metodlarin tek seferde tanimlanarak her sinif icin ayri ayri
 * olusturulup kod tekrarina girmemek. 
 * 
 * 
 * Ornek olarak doktorun calistigi hastaneyi secmek istedigimde doktor 
 * controller'a hastanecontroller sinifini inject ederek hastanecontroller sinifin
 * metod ve ozelliklerine ulasabilmeyi hedefliyordum.Bu sinif sayesinde o 
 * ozellikler ve metodlari tek seferde olusturarak yeniden
 * kod tekrarlarindan kacinmis bulunmaktayim.
 */
abstract class Controller{
    
    
    /*form uzerine yazilmis bilgilere artik ihtiyacimiz yoksa bu metod ile
    form uzerindeki verilerin temizlenmesi islemini gerceklestiriyoruz*/
    abstract void clearForm();
    
    /*form uzerindeki bilgilerde degisiklikler yapilip guncelle butonuna basildiysa
    bu metodumuz calisacak ve ilgili dao sinifimizdaki guncelle
    metoduna bilgileri gondererek veritabanindaki bilgilerin degistirilmesini
    saglayan kod parcalarinin baslangic kismidir.*/
    abstract void update();
    
    /*bir nesnenin bilgisinin guncellenmek uzere forma aktarilmasi islemini
    gerceklestiren metoddur.*/
    abstract void updateForm(Object obj);
    
    /*icinde bulunulan nesnenin bilgisinin silinmesinin onayının alinmasi icin 
    acilacak olan modal penceresine silinmesi planlanan ilac bilgilerini yazan metod.*/
    abstract void deleteConfirm(Object obj);
    
    /*silinecek olan nesnenin bilgisinin modal uzerinden onayi alinmasi durumunda
    veritabanindan silinmesi islemini gerceklestirecek olan dao metonuyla
    iletisim kuran metod*/
    abstract void delete();
    
    /*bos bir form doldurularak yeni bir nesne bilgisi girilmek isteniyorsa 
    olustur butonuna bastiktan sonra bu metod araciligiyla dao sinifimiza 
    bilgileri gondererek insert isleminin gerceklesmesini saglayan metoddur.*/
    abstract void create();
    
    
    /*List ozelliklerimiz, veritabanindan cekilen satirlarin belirli bir duzene
    gore saklanabilmesi icin dao siniflarimizda oldugu gibi controller sinifimizda 
    da ekrana yazdirabilmemiz icin bize gereklidir.*/
    private List<medicine> medicineList;
    private List<doctor> doctorList;
    private List<hospital> hospitalList;
    private List<pw> pwList;
    private List<sick> sickList;
    private List<recipe> recipeList;
    private List<User> userList;
    
    /*veritabani ile iletisim saglayabilmek adina her dao paketinin ayri birer
    nesnesini olusturmamiz gerekiyor.*/
    private MedicineDao medicineDao;
    private DoctorDao doctorDao;
    private HospitalDao hospitalDao;
    private PwDAO pwDao;
    private SickDao sickDao;
    private RecipeDao recipeDao;
    private UserDao userDao;
    
    /*icinde bulundugumuz varligi form uzerinden duzenleyebilmek veya yeni varligi
    form uzerinden alip veritabanina ekleyebilmek icin icin 1 adet tekil varlik
    nesnesine ihtiyacimiz bulunmakta.*/
    private medicine medicine;
    private doctor doctor;
    private hospital hospital;
    private sick sick;
    private pw pw;
    private recipe recipe;
    private User user;
        
    /*selectedItem1 degiskeni, ilac satilacak olan hastanın belirlenmesi ve
    gerekli satis isleminin veritabanina dogru hasta is'si ile kayıt edilmesi icin
    kullaniliyor. arayuzde secilen hastanin id bilgisini tutacak.*/
    private int selectedItem1;
    private int selectedItem2;
    
    /*arayuzde ilac satilacak olan hastaya hangi ilaclarin satilacagini sectikten
    secilen ilacların id'si bu listeye kayit edilecek ve hasta_ilac tablosunda 
    kaydedilmek uzere gunderilecek.*/
    private List<Integer> selectedMedicines;
    
    
    /*getters and setters*/
    
    
    //ilacController
    public List<medicine> getMedicineList() {
        this.medicineList = this.getMedicineDao().getMedicine();
        return medicineList;
    }

    public void setMedicineList(List<medicine> medicineList) {
        this.medicineList = medicineList;
    }

    public MedicineDao getMedicineDao() {
        if(this.medicineDao == null)
            this.medicineDao = new MedicineDao();
        return medicineDao;
    }

    public void setMedicineDao(MedicineDao medicineDao) {
        this.medicineDao = medicineDao;
    }

    public medicine getMedicine() {
        if(this.medicine == null)
            this.medicine = new medicine();
        return medicine;
    }

    public void setMedicine(medicine medicine) {
        this.medicine = medicine;
    }
    
    //doktorController

    public List<doctor> getDoctorList() {
        this.doctorList = this.getDoctorDao().getDoctor();
        return doctorList;
    }

    public void setDoctorList(List<doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public DoctorDao getDoctorDao() {
        if(this.doctorDao == null)
            this.doctorDao = new DoctorDao();
        return doctorDao;
    }

    public void setDoctorDao(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    public doctor getDoctor() {
        if(this.doctor == null)
            this.doctor = new doctor();
        return doctor;
    }

    public void setDoctor(doctor doctor) {
        this.doctor = doctor;
    }
    
    //HospitalController

    public List<hospital> getHospitalList() {
        this.hospitalList = this.getHospitalDao().getHospital();
        return hospitalList;
    }

    public void setHospitalList(List<hospital> hospitalList) {
        this.hospitalList = hospitalList;
    }

    public HospitalDao getHospitalDao() {
        if(this.hospitalDao == null)
            this.hospitalDao = new HospitalDao();
        return hospitalDao;
    }

    public void setHospitalDao(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    public hospital getHospital() {
        if(this.hospital == null)
            this.hospital = new hospital();
        return hospital;
    }

    public void setHospital(hospital hospital) {
        this.hospital = hospital;
    }
    
    
    //eczaDeposuController

    public List<pw> getPwList() {
        this.pwList = this.getPwDao().getPw();
        return pwList;
    }

    public void setPwList(List<pw> pwList) {
        this.pwList = pwList;
    }

    public PwDAO getPwDao() {
        if(this.pwDao == null)
            this.pwDao = new PwDAO();
        return pwDao;
    }

    public void setPwDao(PwDAO pwDao) {
        this.pwDao = pwDao;
    }

    public pw getPw() {
        if(this.pw == null)
            this.pw = new pw();
        return pw;
    }

    public void setPw(pw pw) {
        this.pw = pw;
    }
    
    //Hasta Controller

    public List<sick> getSickList() {
        this.sickList = this.getSickDao().getSick();
        return sickList;
    }

    public void setSickList(List<sick> sickList) {
        this.sickList = sickList;
    }

    public SickDao getSickDao() {
        if(this.sickDao == null)
            this.sickDao = new SickDao();
        return sickDao;
    }

    public void setSickDao(SickDao sickDao) {
        this.sickDao = sickDao;
    }

    public sick getSick() {
        if(this.sick == null)
            this.sick = new sick();
        return sick;
    }

    public void setSick(sick sick) {
        this.sick = sick;
    }

    public int getSelectedItem1() {
        return selectedItem1;
    }

    public void setSelectedItem1(int selectedItem1) {
        this.selectedItem1 = selectedItem1;
    }

    public List<Integer> getSelectedMedicines() {
        return selectedMedicines;
    }

    public void setSelectedMedicines(List<Integer> selectedMedicines) {
        this.selectedMedicines = selectedMedicines;
    }
    
    //recete

    public List<recipe> getRecipeList() {
        this.recipeList = this.getRecipeDao().getRecipe();
        return recipeList;
    }

    public void setRecipeList(List<recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public RecipeDao getRecipeDao() {
        if(this.recipeDao == null)
            this.recipeDao = new RecipeDao();
        return recipeDao;
    }

    public void setRecipeDao(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    public recipe getRecipe() {
        if(this.recipe == null)
            this.recipe = new recipe();
        return recipe;
    }

    public void setRecipe(recipe recipe) {
        this.recipe = recipe;
    }

    public int getSelectedItem2() {
        return selectedItem2;
    }

    public void setSelectedItem2(int selectedItem2) {
        this.selectedItem2 = selectedItem2;
    }

    public List<User> getUserList() {
        this.userList = this.getUserDao().getUser();
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public UserDao getUserDao() {
        if(this.userDao == null)
            this.userDao = new UserDao();
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUser() {
        if(this.user == null)
            this.user = new User();
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}