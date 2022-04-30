/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CDIBean;

import client.inquiryClient;
import entity.Inquiry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Mayur Rana
 */
@Named(value = "inquiryBean")
@RequestScoped
public class inquiryBean {
inquiryClient client;
     Response res;
      Collection<Inquiry> iq;
   GenericType<Collection<Inquiry>> iq_add;
   
   int suminsured,totalmember,pincode; 
   long mobile;
   String name, email,insuType;
    /**
     * Creates a new instance of inquiryBean
     */
    public inquiryBean() {
       
        
         HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       String token="";

        token = request.getSession().getAttribute("token").toString();
       System.out.println("Token="+token);
        
       client=new inquiryClient(token);
            iq=new ArrayList<Inquiry>();
            iq_add=new GenericType<Collection<Inquiry>>(){};
    }
    
     public void addinquiry()
    {
        try
        {
        client.addinquiry_XML(new Inquiry(),name,email,suminsured+"",mobile+"",totalmember+"",pincode+"",insuType);
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
        }
    catch(IOException | ClientErrorException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public inquiryClient getClient() {
        return client;
    }

    public void setClient(inquiryClient client) {
        this.client = client;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public Collection<Inquiry> getIq() {
         res = client.getAllinquiry_XML(Response.class);
        System.out.println(res);
        iq = res.readEntity(iq_add);
        System.out.println(iq);
        
        return iq;
    }

    public void setIq(Collection<Inquiry> iq) {
        this.iq = iq;
    }

    public GenericType<Collection<Inquiry>> getIq_add() {
        return iq_add;
    }

    public void setIq_add(GenericType<Collection<Inquiry>> iq_add) {
        this.iq_add = iq_add;
    }

    public int getSuminsured() {
        return suminsured;
    }

    public void setSuminsured(int suminsured) {
        this.suminsured = suminsured;
    }

    public int getTotalmember() {
        return totalmember;
    }

    public void setTotalmember(int totalmember) {
        this.totalmember = totalmember;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInsuType() {
        return insuType;
    }

    public void setInsuType(String insuType) {
        this.insuType = insuType;
    }
}
