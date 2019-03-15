/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Controller;


import Entitys.*;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.xml.registry.infomodel.User;


/**
 *
 * @author USER
 */

@SessionScoped
@ManagedBean(name = "controlCuentas")
public class controlCuentas {
    
    private boolean isLogin = false;
    private Users user = new Users();

    public boolean isIsLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    
    public void verificarLogin(){
        
        if(!this.isLogin){
            redireccionar("Login.xhtml");
        }
    }
    
    private void redireccionar(String url){
        
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.getExternalContext().redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(controlCuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
}
