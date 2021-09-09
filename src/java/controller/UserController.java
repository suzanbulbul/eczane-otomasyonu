/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDao;
import entity.User;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author gurkangltekin
 */
@Named
@ViewScoped
public class UserController extends Controller implements Serializable {

    @Override
    public void clearForm() {
        this.setUser(new User());
    }

    @Override
    public void update() {
        if (this.getUser().getPassword().equals("")) {
            FacesContext.getCurrentInstance().addMessage("userForm:inputPassword", new FacesMessage("Parola Boş Olamaz"));
        } else {
            this.getUserDao().update(this.getUser());
            this.clearForm();
        }

    }

    @Override
    public void updateForm(Object obj) {
        User user = (User) obj;
        this.setUser(user);
    }

    @Override
    public void deleteConfirm(Object obj) {
        User user = (User) obj;
        this.setUser(user);
    }

    @Override
    public void delete() {
        this.getUserDao().delete(this.getUser());
    }

    @Override
    public void create() {
        if (this.getUser().getUsername().equals("")) {
            FacesContext.getCurrentInstance().addMessage("userForm:inputUsername", new FacesMessage("Kullanıcı Adı Boş Olamaz"));
            this.setUser(null);
        } else {
            if (this.getUser().getPassword().equals("")) {
                FacesContext.getCurrentInstance().addMessage("userForm:inputPassword", new FacesMessage("Parola Boş Olamaz"));
                this.setUser(null);
            } else {
                if (this.getUserDao().insert(this.getUser())) {
                    FacesContext.getCurrentInstance().addMessage("userForm", new FacesMessage("Bu kullanıcı adı zaten var!"));
                    this.setUser(null);
                } else {
                    this.clearForm();
                }
            }
        }
    }

}
