package entity;

import java.sql.Date;

/**
 * @author gurkangltekin
 * 
 * bu sinifimiz veritabanimizdaki hastane tablomuzun java tarafindan nesnelestirilmis
 * halini temsil etmekte...
 * 
 */
public class hospital {
    private int id;
    private String name;
    private String address;
    private Date last_update;

    public hospital() {
    }

    public hospital(int id, String name, String address, Date last_update) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.last_update = last_update;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
    
}
