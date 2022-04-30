/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CDIBean;

import client.hiClient;
import ejb.clientBeanLocal;
import entity.HealthInsu;
import entity.Hicarddetails;
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
 * @author Mayur Rana
 */
@Named(value = "healthinsuBean")
@RequestScoped
public class healthinsuBean {
   @EJB clientBeanLocal cbl; 
   hiClient client;
     Response res;
      Collection<HealthInsu> hi;
   GenericType<Collection<HealthInsu>> hi_add;
      Collection<HealthInsu> hc;
   GenericType<Collection<HealthInsu>> hc_add;
          Collection<Hicarddetails> tc;
   GenericType<Collection<Hicarddetails>> gc;

    public Collection<HealthInsu> getHc() {
         res = client.getAllHipolicy_XML(Response.class);
        System.out.println(res);
        hc = res.readEntity(hc_add);
        System.out.println(hc);
       
        return hc;
    }

    public void setHc(Collection<HealthInsu> hc) {
        this.hc = hc;
    }

    public GenericType<Collection<HealthInsu>> getHc_add() {
        
        return hc_add;
    }

    public void setHc_add(GenericType<Collection<HealthInsu>> hc_add) {
        this.hc_add = hc_add;
    }

long mobileno;
float suminsured=500;
float weight;
int policyId,hid;
int loginid;

int isdelete=1;
String clientname,gender,emailid,state,city,pincode
        ,plantype,dobi,height,insuCustId="1",address;
private HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    public healthinsuBean() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       String token="";

        token = request.getSession().getAttribute("token").toString();
       System.out.println("Token="+token);
         client=new hiClient(token);
            hi=new ArrayList<HealthInsu>();
            hi_add=new GenericType<Collection<HealthInsu>>(){};
            
             hc=new ArrayList<HealthInsu>();
            hc_add=new GenericType<Collection<HealthInsu>>(){};
                 tc=new ArrayList<Hicarddetails>();
            gc=new GenericType<Collection<Hicarddetails>>(){};
    }

    public Collection<Hicarddetails> getTc() {
         loginid=(Integer) session.getAttribute("lid");
         tc = cbl.gethicardbylid(loginid);
        return tc;
    }

    public void setTc(Collection<Hicarddetails> tc) {
        this.tc = tc;
    }

    public GenericType<Collection<Hicarddetails>> getGc() {
        return gc;
    }

    public void setGc(GenericType<Collection<Hicarddetails>> gc) {
        this.gc = gc;
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

    public hiClient getClient() {
        return client;
    }

    public void setClient(hiClient client) {
        this.client = client;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public Collection<HealthInsu> getHi() {
         res = client.getlastHiId_XML(Response.class);
        System.out.println(res);
        hi = res.readEntity(hi_add);
        System.out.println(hi);
        return hi;
    }

    public void setHi(Collection<HealthInsu> hi) {
        this.hi = hi;
    }

    public GenericType<Collection<HealthInsu>> getHi_add() {
        return hi_add;
    }

    public void setHi_add(GenericType<Collection<HealthInsu>> hi_add) {
        this.hi_add = hi_add;
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
    public void addallhi()
    {
        loginid=(Integer) session.getAttribute("lid");
        try
        {
             Collection<HealthInsu> hi= new  ArrayList<HealthInsu>();
         GenericType<Collection<HealthInsu>> hi_add = new GenericType<Collection<HealthInsu>>(){};
      
        res = client.getlastHiId_XML(Response.class);
        hi = res.readEntity(hi_add);     
         for(HealthInsu pl:hi)
         {
        client.updateHi_JSON(new HealthInsu(),pl.getHid()+"",pl.getPolicyId().getPolicyId()+"",clientname,gender,mobileno+"",emailid,state,city,pincode,plantype,suminsured+"",dobi,height,weight+"",loginid+"",isdelete+"",insuCustId+"",address);
        FacesContext.getCurrentInstance().getExternalContext().redirect("himember.jsf");
         }
       
        }
    catch(IOException | ClientErrorException e)
        {
            System.out.println(e.getMessage());
        }
    }
      public void addhi(Integer policyId)    {
          loginid=(Integer) session.getAttribute("lid");
        try
        {
        client.addHi_JSON(new HealthInsu(),policyId+"",clientname,gender,mobileno+"",emailid,state,city,pincode,plantype,suminsured+"",dobi,height,weight+"",loginid+"",isdelete+"",insuCustId+"",address);
        FacesContext.getCurrentInstance().getExternalContext().redirect("healthinsu.jsf");
        }
    catch(IOException | ClientErrorException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }
public String updateclick(Integer hid){
        HealthInsu hc = new HealthInsu();
        GenericType<HealthInsu> hc_add = new GenericType<HealthInsu>(){};
        res = client.gethealthinsuById_XML(Response.class,hid+"");
        hc= res.readEntity(hc_add);
      
       clientname=hc.getClientname();
       gender=hc.getGender();
       mobileno=hc.getMobileno();
       emailid=hc.getEmailid();
       state=hc.getState();
       city=hc.getCity();
       pincode=hc.getPincode();
       plantype=hc.getPlantype();
       dobi=hc.getDobi();
       height=hc.getHeight();
       weight=hc.getWeight();
       address=hc.getAddress();
       
       
        
                
        this.hid=hc.getHid();
        
         
        return "updateinsured.xhtml";
    }
      public String updateinsured()    {
          loginid=(Integer) session.getAttribute("lid");
        Collection<HealthInsu> hc = new  ArrayList<HealthInsu>();
         GenericType<Collection<HealthInsu>> hc_add = new GenericType<Collection<HealthInsu>>(){};
      
        res = client.getlastHiId_XML(Response.class);
        hc = res.readEntity(hc_add);     
         for(HealthInsu pl:hc)
         {
//             out.println("<h4>"+ pl.getId()+"<h4>"+ pl.getPlanId().getPolicyId());
         
     
        client.updateHi_XML(new HealthInsu(),pl.getHid()+"",pl.getPolicyId().getPolicyId()+"",clientname,gender,mobileno+"",emailid,state,city,pincode,plantype,suminsured+"",dobi,height,weight+"",loginid+"",isdelete+"",insuCustId+"",address);
       
         }
//        client.updateTpi_JSON(new TerminsuPi(), id+"", planId+"", clientname, gender, lifestage, bday, mobile+"", education, smoke, income, cover, coverage, isdelete+"", loginid+"", insuCustId, isexpire+"");
        return "himember?faces-redirect=true";
    }
       public String pay()
    {
       
    return "hiaddpayment?faces-redirect=true";
    }
   
}
