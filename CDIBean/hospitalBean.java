/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CDIBean;

import client.HospitalClient;
import entity.Hospital;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Mayur Rana
 */
@Named(value = "hospitalBean")
@RequestScoped
public class hospitalBean {
    
HospitalClient client;
     Response res;
      Collection<Hospital> hp;
   GenericType<Collection<Hospital>> hp_add;
   

   
   String name,address,emailid,website,city,image;
Integer pincode;
long contactno;
Integer hospitalId;
private Part filename;

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }
    /**
     * Creates a new instance of hospitalBean
     */
    public hospitalBean() {
  
           HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       String token="";

        token = request.getSession().getAttribute("token").toString();
       System.out.println("Token="+token);
        
       client=new HospitalClient(token);
           
      
            hp=new ArrayList<Hospital>();
            hp_add=new GenericType<Collection<Hospital>>(){};
            
//            h=new ArrayList<Hospital>();
//            gh=new GenericType<Collection<Hospital>>(){};
    }

   

  
    public HospitalClient getClient() {
        return client;
    }

    public void setClient(HospitalClient client) {
        this.client = client;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public Collection<Hospital> getHp() {
        res = client.getAllhospital_XML(Response.class);
        System.out.println(res);
        hp = res.readEntity(hp_add);
        System.out.println(hp);
       
        return hp;
    }

    public void setHp(Collection<Hospital> hp) {
        this.hp = hp;
    }

    public GenericType<Collection<Hospital>> getHp_add() {
        return hp_add;
    }

    public void setHp_add(GenericType<Collection<Hospital>> hp_add) {
        this.hp_add = hp_add;
    }

    public String getName() {
        return name;
    }

    public Part getFilename() {
        return filename;
    }

    public void setFilename(Part filename) {
        this.filename = filename;
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

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public long getContactno() {
        return contactno;
    }

    public void setContactno(long contactno) {
        this.contactno = contactno;
    }
            public void addhospital()
    {
        String folder="D:/Sem 8/JAVA/insurancehubSecure/web/AdminSite/upload/hospital";
       String f1=null;
        try(InputStream input=filename.getInputStream()){
            f1=filename.getSubmittedFileName();
      
            Files.copy(input, new File(folder,f1).toPath());
          
            
        }catch(Exception e)
        {
        }
        try
        {
		client.addhospital_JSON(new Hospital(),name,address,emailid,website,city,pincode+"",f1,contactno+"");
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("viewhospital.jsf");
        }
    catch(IOException | ClientErrorException e)
        {
            System.out.println(e.getMessage());
        }    }
            
                 public void removeHospital(int hospitalId)
    {
         try
        {
        client.deletehospital(hospitalId+"");
        }
    catch(ClientErrorException e)
        {
            System.out.println(e.getMessage());
        }
    }
            public String edit_click(Integer hospitalId){
        Hospital p = new Hospital();
        GenericType<Hospital> grr = new GenericType<Hospital>(){};
        res = client.getHospitalById_XML(Response.class, hospitalId.toString());
        p = res.readEntity(grr);
        name=p.getName();
        address = p.getAddress();
        emailid=p.getEmailid();
        website=p.getWebsite();
        city=p.getCity();
        pincode=p.getPincode();
//        filename=p.getImage();
        contactno=p.getContactno();    
        this.hospitalId=p.getHospitalId();
        return "updatehospital.xhtml";
    }        
          
      public String updatehospital(){
         String folder="D:/Sem 8/JAVA/insurancehubSecure/web/AdminSite/upload/hospital";
       String f1=null;
        try(InputStream input=filename.getInputStream()){
            f1=filename.getSubmittedFileName();
      
            Files.copy(input, new File(folder,f1).toPath());
          
            
        }catch(Exception e)
        {
        }
        try
        {
        client.updatehospital_JSON(new Hospital(),hospitalId+"",name,address,emailid,website,city,pincode+"",f1,contactno+"");
        FacesContext.getCurrentInstance().getExternalContext().redirect("viewhospital.jsf");
        }
    catch(IOException | ClientErrorException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
 }      
   
                 
    }
    

