package util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gurkangltekin
 * 
 * Bu sinifimda veritabanina baglanabilmek icin gerekli implementasyonlari
 * gerceklestirdik, sunucu kullanici adi ve sifre bilgilerini veritabani kutuphanelerini 
 * projemize dahil ettik.
 */
public class DBConnection {
    
    //veritabanı sunucumuza baglanma islemlerini gerceklestiriyoruz.
    public Connection connect(){
        Connection c = null;
        
        try{
            Class.forName("org.postgresql.Driver").newInstance();
            c = DriverManager.getConnection("jdbc:postgresql://localhost/nyym_eczane?user=postgres&password=123");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }
        
   
        
        return c;
    }
        
}
