/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CDIBean;

import client.CompanyClient;
import entity.CompReg;
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
 * @author Hardik
 */
@Named(value = "companyBean")
@RequestScoped
public class companyBean {

    CompanyClient client;
     Response res;
     
     Collection<CompReg> cr;
   GenericType<Collection<CompReg>> cr_add;
   
     Collection<CompReg> c1;
   GenericType<Collection<CompReg>> gc1;
   
     Collection<CompReg> c2;
   GenericType<Collection<CompReg>> gc2;
   
      Collection<CompReg> c3;
   GenericType<Collection<CompReg>> gc3;
   Integer compId;
   String name,address,email,website,city,image;
private Part filename;
Integer pincode;
long contactno;




    public companyBean() {
       
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       String token="";
       String user="";

        token = request.getSession().getAttribute("token").toString();
       System.out.println("Token="+token);
//        user=request.getSession().getAttribute("uname").toString();
//        System.out.println("Username="+user);
        //String token1 = request.getHeader("Authorization").substring("Bearer ".length());
      // System.out.println("Token="+token);
        client=new CompanyClient(token);
           
       cr=new ArrayList<CompReg>();
            cr_add=new GenericType<Collection<CompReg>>(){};
             c1=new ArrayList<CompReg>();
            gc1=new GenericType<Collection<CompReg>>(){};
            
          
            c2=new ArrayList<CompReg>();
            gc2=new GenericType<Collection<CompReg>>(){};
             c3=new ArrayList<CompReg>();
            gc3=new GenericType<Collection<CompReg>>(){};
    }

    public Collection<CompReg> getC3() {
        return c3;
    }

    public void setC3(Collection<CompReg> c3) {
        this.c3 = c3;
    }

    public GenericType<Collection<CompReg>> getGc3() {
        return gc3;
    }

    public void setGc3(GenericType<Collection<CompReg>> gc3) {
        this.gc3 = gc3;
    }
    
public Collection<CompReg> getC1() {
         res = client.databyisdelete1_XML(Response.class);
   
        c1 = res.readEntity(gc1);
      
        return c1;
    }

    public void setC1(Collection<CompReg> c1) {
        this.c1 = c1;
    }

    public GenericType<Collection<CompReg>> getGc1() {
        return gc1;
    }

    public void setGc1(GenericType<Collection<CompReg>> gc1) {
        this.gc1 = gc1;
    }

    public Collection<CompReg> getC2() {
         res = client.databyisdelete_XML(Response.class);
   
        c2 = res.readEntity(gc2);
        return c2;
    }

    public void setC2(Collection<CompReg> c2) {
        this.c2 = c2;
    }

    public GenericType<Collection<CompReg>> getGc2() {
        return gc2;
    }

    public void setGc2(GenericType<Collection<CompReg>> gc2) {
        this.gc2 = gc2;
    }

    public Part getFilename() {
        return filename;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public void setFilename(Part filename) {
        this.filename = filename;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
    
    public CompanyClient getClient() {
        return client;
    }

    public void setClient(CompanyClient client) {
        this.client = client;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public Collection<CompReg> getCr() {
         res = client.getAllcomps_XML(Response.class);
        System.out.println(res);
        cr = res.readEntity(cr_add);
        System.out.println(cr);
        return cr;
       
    }

    public void setCr(Collection<CompReg> cr) {
        this.cr = cr;
    }

    public GenericType<Collection<CompReg>> getCr_add() {
        return cr_add;
    }

    public void setCr_add(GenericType<Collection<CompReg>> cr_add) {
        this.cr_add = cr_add;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }

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
     public void addCompany()
    {
        
        String folder="D:/Sem 8/JAVA/insurancehubSecure/web/AdminSite/upload/company";
       String f1=null;
        try(InputStream input=filename.getInputStream()){
            f1=filename.getSubmittedFileName();
      
            Files.copy(input, new File(folder,f1).toPath());
          
            
        }catch(Exception e)
        {
        }
        try
        {
        client.addComp_JSON(new CompReg(),name,address,email,website,city,pincode+"",f1,contactno+"");
        FacesContext.getCurrentInstance().getExternalContext().redirect("viewcompany.jsf");
        }
    catch(IOException | ClientErrorException e)
        {
            System.out.println(e.getMessage());
        }    }
     
     public String removeComp(Integer pincode)
    {
         Collection<CompReg> c3 = new  ArrayList<CompReg>();
         GenericType<Collection<CompReg>> gc3 = new GenericType<Collection<CompReg>>(){};
      
        res = client.findBycompin_XML(Response.class,pincode.toString());
        c3 = res.readEntity(gc1);     
         for(CompReg pl:c3)
         {

         
     
        client.updatedelComp_JSON(new CompReg(),pl.getCompId()+"",pl.getName(),pl.getAddress(),pl.getEmail(),pl.getWebsite(),pl.getCity(),pincode+"",pl.getImage(),pl.getContactno()+"","1");
       
         }
//        client.updateTpi_JSON(new TerminsuPi(), id+"", planId+"", clientname, gender, lifestage, bday, mobile+"", education, smoke, income, cover, coverage, isdelete+"", loginid+"", insuCustId, isexpire+"");
        return "viewdelcompany?faces-redirect=true";
//         try
//        {
//        client.removeComp(compId+"");
//        }
//    catch(ClientErrorException e)
//        {
//            System.out.println(e.getMessage());
//        }
    }
      public String edit_click(Integer compId){
        CompReg p = new CompReg();
        GenericType<CompReg> grr = new GenericType<CompReg>(){};
        res = client.getCompRegById_XML(Response.class, compId.toString());
        p = res.readEntity(grr);
        name=p.getName();
        address = p.getAddress();
        email=p.getEmail();
        website=p.getWebsite();
        city=p.getCity();
        pincode=p.getPincode();
//        filename=p.getImage();
        contactno=p.getContactno();    
        this.compId=p.getCompId();
        return "updatecompany.xhtml";
    }
   public String updateCompany() throws IOException{
       if(!filename.getSubmittedFileName().equals(""))
       {
            String folder="D:/Sem 8/JAVA/insurancehubSecure/web/AdminSite/upload/company";
       String f1=null;
        try(InputStream input=filename.getInputStream()){
            f1=filename.getSubmittedFileName();
      
            Files.copy(input, new File(folder,f1).toPath());
          
            
        }catch(Exception e)
        {
        }
        try
        {
        client.updateComp_JSON(new CompReg(),compId+"",name,address,email,website,city,pincode+"",f1,contactno+"");
        FacesContext.getCurrentInstance().getExternalContext().redirect("viewcompany.jsf");
        }
    catch(IOException | ClientErrorException e)
        {
            System.out.println(e.getMessage());
        }
       }
       else{
           client.updateComp_JSON(new CompReg(),compId+"",name,address,email,website,city,pincode+"","",contactno+"");
        FacesContext.getCurrentInstance().getExternalContext().redirect("viewcompany.jsf");
       }
        
        return null;
 }
    public String restore(Integer pincode)
    {
         Collection<CompReg> c3 = new  ArrayList<CompReg>();
         GenericType<Collection<CompReg>> gc3 = new GenericType<Collection<CompReg>>(){};
      
        res = client.findBycompin_XML(Response.class,pincode.toString());
        c3 = res.readEntity(gc1);     
         for(CompReg pl:c3)
         {

         
     
        client.updatedelComp_JSON(new CompReg(),pl.getCompId()+"",pl.getName(),pl.getAddress(),pl.getEmail(),pl.getWebsite(),pl.getCity(),pincode+"",pl.getImage(),pl.getContactno()+"","0");
       
         }
//        client.updateTpi_JSON(new TerminsuPi(), id+"", planId+"", clientname, gender, lifestage, bday, mobile+"", education, smoke, income, cover, coverage, isdelete+"", loginid+"", insuCustId, isexpire+"");
        return "viewcompany?faces-redirect=true";
//         try
//        {
//        client.removeComp(compId+"");
//        }
//    catch(ClientErrorException e)
//        {
//            System.out.println(e.getMessage());
//        }
    }

   
   
    
}
