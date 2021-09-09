/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDao;
import entity.User;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author gurkangltekin
 */
@Named
@RequestScoped
public class LoginController implements Serializable {

    private String username;
    private String password;

    private UserDao userDao;
    private User user;

    public String login() {
        User u = this.getUserDao().login(this.getUser());

        if (this.getUser().getUsername().equals("")) {
            FacesContext.getCurrentInstance().addMessage("userLogin:inputUsername", new FacesMessage("Kullanıcı Adı Boş Olamaz"));
            return "/login.xhtml";
        } else {
            if (this.getUser().getPassword().equals("")) {
                FacesContext.getCurrentInstance().addMessage("userLogin:inputPassword", new FacesMessage("Parola Boş Olamaz"));
                return "/login.xhtml";
            } else {
                if (u != null) {
                    if (u.getAuth().equals("kalfa") || u.getAuth().equals("eczaci")) {
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("eczaci", u);
                        return "/index.xhtml";
                    } else {
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("eczaci", u);
                        return "/login.xhtml";
                    }
                } else {
                    FacesContext.getCurrentInstance().addMessage("userLogin", new FacesMessage("Hatali Kullanıcı Adı veya Şifre"));
                    return "/login.xhtml";
                }
            }
        }

    }

    public User getUser() {
        if (this.user == null) {
            this.user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDao getUserDao() {
        if (this.userDao == null) {
            this.userDao = new UserDao();
        }
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
