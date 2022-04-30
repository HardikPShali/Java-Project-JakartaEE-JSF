/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CDIBean;

import client.hiClient;
import client.policyClient;

import entity.HealthInsu;
import entity.Policy;
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
@Named(value = "hiplanBean")
@RequestScoped
public class hiplanBean {
 policyClient pc;
 hiClient hc;
    Response res;
       Collection<Policy> i;
   GenericType<Collection<Policy>> ig;
 Integer policyNo;
 
 long mobileno;
float suminsured;
float weight;
int policyId;
int loginid=10;

int isdelete=11;
String clientname,gender,emailid,state,city,pincode
        ,plantype,dobi,height,insuCustId="1",address;
    /**
     * Creates a new instance of hiplanBean
     */
    public hiplanBean() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       String token="";

        token = request.getSession().getAttribute("token").toString();
       System.out.println("Token="+token);
         pc=new policyClient(token);
            i=new ArrayList<Policy>();
            ig=new GenericType<Collection<Policy>>(){};
    }

    public policyClient getPc() {
        return pc;
    }

    public Response getRes() {
        return res;
    }

    public hiClient getHc() {
        return hc;
    }

    public void setHc(hiClient hc) {
        this.hc = hc;
    }

    public long getMobileno() {
        return mobileno;
    }

    public void setMobileno(long mobileno) {
        this.mobileno = mobileno;
    }

    public float getSuminsured() {
        return suminsured;
    }

    public void setSuminsured(float suminsured) {
        this.suminsured = suminsured;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getPolicyId() {
        return policyId;
    }

    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }

    public int getLoginid() {
        return loginid;
    }

    public void setLoginid(int loginid) {
        this.loginid = loginid;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPlantype() {
        return plantype;
    }

    public void setPlantype(String plantype) {
        this.plantype = plantype;
    }

    public String getDobi() {
        return dobi;
    }

    public void setDobi(String dobi) {
        this.dobi = dobi;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getInsuCustId() {
        return insuCustId;
    }

    public void setInsuCustId(String insuCustId) {
        this.insuCustId = insuCustId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Collection<Policy> getI() {
        res = pc.findnpno_XML(Response.class);
        System.out.println(res);
        i = res.readEntity(ig);
        System.out.println(i);
        return i;
    }

    public GenericType<Collection<Policy>> getIg() {
        return ig;
    }

    public Integer getPolicyNo() {
        return policyNo;
    }
//    public void addhi(Integer policyId)    {
//        try
//        {
//        hc.addHi_XML(new HealthInsu(),policyId+"",clientname,gender,mobileno+"",emailid,state,city,pincode,plantype,suminsured+"",dobi,height,weight+"",loginid+"",isdelete+"",insuCustId+"",address);
//        FacesContext.getCurrentInstance().getExternalContext().redirect("healthinsu.jsf");
//        }
//    catch(IOException | ClientErrorException e)
//        {
//            System.out.println(e.getMessage());
//        }
//    }
    
}
