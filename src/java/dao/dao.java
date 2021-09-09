/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import util.DBConnection;

/**
 *
 * @author gurkangltekin
 */
abstract public class dao {
        
    /*dbconnection sinifi, bizim tarafimizdan olusturulan veritabani ile haberlesmemizi saglayan, 
    veritabani serverimiza baglanmamizi saglayacak bilgilerin bulundugu siniftir.*/
    DBConnection db = new DBConnection();
    Connection c = db.connect();
    
    abstract void delete(Object obj);
    abstract void insert(Object obj);
    abstract void update(Object obj);
    
    
    public DBConnection getDb() {
        return db;
    }

    public Connection getC() {
        return c;
    }
    
}
