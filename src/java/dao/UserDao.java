/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gurkangltekin
 */
public class UserDao extends dao{

    public List<User> getUser() {
        
        List<User> userList = new ArrayList();
        
        try{
            PreparedStatement st = this.getC().prepareStatement("select * from users");
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                User tmp = new User();
                tmp.setUsername(rs.getString("username"));
                tmp.setPassword(rs.getString("password"));
                tmp.setAuth(rs.getString("auth"));
                userList.add(tmp);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return userList;
    }
    
    public User login(User user){
        User u = null;
        
        try{
            
            PreparedStatement pst = this.getC().prepareStatement("select * from users where username = ? and password = ?");
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                
                u = new User();
                u.setUsername(user.getUsername());
                u.setPassword(user.getPassword());
                u.setAuth(rs.getString("auth"));
                
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return u;
    }

    @Override
    public void delete(Object obj) {
        User user = (User) obj;
        try{
            PreparedStatement st = this.getC().prepareStatement("delete from users where username = ?");
            st.setString(1, user.getUsername());
            st.executeUpdate();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insert(Object obj) {
        User user = (User) obj;
        try{
            PreparedStatement st = this.getC().prepareStatement("insert into users (username, password, auth) values(?,?,?)");
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            st.setString(3, user.getAuth());
            st.executeUpdate();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public boolean insert(User user) {
        boolean check = false;
        try{
            PreparedStatement st = this.getC().prepareStatement("insert into users (username, password, auth) values(?,?,?)");
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            st.setString(3, user.getAuth());
            st.executeUpdate();
            
        }catch(SQLException e){
            check = true;
            System.out.println(e.getMessage());
        }
        return check;
    }

    @Override
    public void update(Object obj) {
        User user = (User) obj;
        try{
            PreparedStatement st = this.getC().prepareStatement("update users set password = ?, auth = ? where username = ?");
            st.setString(1, user.getPassword());
            st.setString(2, user.getAuth());
            st.setString(3, user.getUsername());
            st.executeUpdate();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void createUser(User user) {
        try{
            PreparedStatement st = this.getC().prepareStatement("insert into users (username, password, auth) values(?,?,?)");
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            st.setString(3, user.getAuth());
            st.executeUpdate();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
}
