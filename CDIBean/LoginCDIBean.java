/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CDIBean;

import client.loginClient;
import ejb.adminBeanLocal;
import entity.Login;
import entity.Role;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Hardik
 */
@Named(value = "loginCDIBean")
@RequestScoped
public class LoginCDIBean {
loginClient lc;
Response res;
@EJB adminBeanLocal ub;
  Collection<Login> l;
   GenericType<Collection<Login>> gl;

   
 Collection<Role> r;
   GenericType<Collection<Role>> gr;
   Integer lid;
   String uid,uname;
   int roleId=2,rid;
   String name,username,emailid,password;
     private HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    public LoginCDIBean() {
//        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//       String token="";
//
//        token = request.getSession().getAttribute("token").toString();
//       System.out.println("Token="+token);
//       System.out.println("In JWT Auth Mechanism "+ request.getSession().getAttribute("logged-group"));
//        lc = new loginClient();
        l = new ArrayList<Login>();
        gl = new GenericType<Collection<Login>>(){}; 

        
        r = new ArrayList<Role>();
        gr = new GenericType<Collection<Role>>(){}; 
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public loginClient getLc() {
        return lc;
    }

    public void setLc(loginClient lc) {
        this.lc = lc;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public Collection<Login> getL() {
          res = lc.getAllUser_XML(Response.class);
        
        l = res.readEntity(gl);
        
        return l;
    }

    public void setL(Collection<Login> l) {
        this.l = l;
    }

    public GenericType<Collection<Login>> getGl() {
        return gl;
    }

    public void setGl(GenericType<Collection<Login>> gl) {
        this.gl = gl;
    }

    public Collection<Role> getR() {
          
        return r;
    }

    public void setR(Collection<Role> r) {
        this.r = r;
    }

    public GenericType<Collection<Role>> getGr() {
        return gr;
    }

    public void setGr(GenericType<Collection<Role>> gr) {
        this.gr = gr;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public adminBeanLocal getUb() {
        return ub;
    }

    public void setUb(adminBeanLocal ub) {
        this.ub = ub;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    
    public void addUser() {
        try {
            ub.addUser(roleId, username, emailid, password);
//            lc.addUser_JSON(new Login(),roleId+"", username, emailid, password);
            FacesContext.getCurrentInstance().getExternalContext().redirect("Login.jsf");
        } catch (IOException | ClientErrorException e) {
            System.out.println(e.getMessage());
        }
        
       
    }
    public Collection<Login> getAllUserWiseEmail()
    {
        uid=(String) session.getAttribute("id");
        System.out.println(uid);
        return ub.getAllUserByEmail(uid);
       
    }
     public String edit(Integer lid) {

        Login l = new Login();
        GenericType<Login> gl = new GenericType<Login>(){};
        res = lc.getuserById_XML(Response.class, lid+"");
        l = res.readEntity(gl);

          username = l.getUsername();
          password = l.getPassword();
          emailid=l.getEmailid();

       this.lid=l.getLid();
      

       
        
        return "UpdateProfile.jsf";
    }
       public String updateProfile() {
//           ub.updateUser(lid, roleId, username, emailid, password);
     
        lc.updateUser_JSON(new Login(), lid+"",roleId+"", username, emailid,password);
        
        return "Profileinfo.jsf";
    }
   
}   
