package entity;


import java.sql.Date;

/**
 * @author gurkangltekin
 * 
 * bu sinifimiz veritabanimizdaki ecza deposu tablomuzun java tarafindan nesnelestirilmis
 * halini temsil etmekte...
 * 
 */
public class pw {
    private int id;
    private String name;
    private int dept;
    private Long phone_number;
    private Date last_update;

    public pw() {
    }

    public pw(int id, String name, int dept, Long phone_number, Date last_update) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.phone_number = phone_number;
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

    public int getDept() {
        return dept;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }

    public Long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "pw{" + "id=" + id + ", name=" + name + ", dept=" + dept + ", phone_number=" + phone_number + ", last_update=" + last_update + '}';
    }
    
    
}