/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CDIBean;

import client.hiClient;
import client.hicarddetailsClient;
import ejb.adminBeanLocal;
import ejb.clientBeanLocal;
import entity.HealthInsu;
import entity.Hicarddetails;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Mayur Rana
 */
@Named(value = "hipaymentBean")
@RequestScoped
public class hipaymentBean {
hicarddetailsClient client;
   hiClient hc;
   @EJB adminBeanLocal cb;
   @EJB clientBeanLocal cbl;
     Response res;
    /**
     * Creates a new instance of hipaymentBean
     */
           Collection<Hicarddetails> hcd;
   GenericType<Collection<Hicarddetails>> hcdt;
   
     Collection<Hicarddetails> hcd1;
   GenericType<Collection<Hicarddetails>> htcd1;
   
        Collection<Hicarddetails> hcd2;
   GenericType<Collection<Hicarddetails>> hcdt2;
   
     Collection<HealthInsu> h;
   GenericType<Collection<HealthInsu>> ht;
   

   
     Collection<HealthInsu> hi;
   GenericType<Collection<HealthInsu>> hit;
     int rn;
   int cid,hid,paymentno;
           String name,paymentMethod,status,date; 
                   float amount;
    public hipaymentBean() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       String token="";

        token = request.getSession().getAttribute("token").toString();
       System.out.println("Token="+token);
        client=new hicarddetailsClient(token);
          hcd=new ArrayList<Hicarddetails>();
            hcdt=new GenericType<Collection<Hicarddetails>>(){};
             hcd2=new ArrayList<Hicarddetails>();
            hcdt2=new GenericType<Collection<Hicarddetails>>(){};
            
                         hc=new hiClient(token);
                h=new ArrayList<HealthInsu>();
            ht=new GenericType<Collection<HealthInsu>>(){};
    }
    

    public hicarddetailsClient getClient() {
        return client;
    }

    public void setClient(hicarddetailsClient client) {
        this.client = client;
    }

    public hiClient getHc() {
        
    
        return hc;
    }

    public void setHc(hiClient hc) {
        this.hc = hc;
    }

    public adminBeanLocal getCb() {
        return cb;
    }

    public void setCb(adminBeanLocal cb) {
        this.cb = cb;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public Collection<Hicarddetails> getHcd() {
        
    res = client.getAllHCD_XML(Response.class);
       
        hcd = res.readEntity(hcdt);
     
     
        return hcd;
    }

    public void setHcd(Collection<Hicarddetails> hcd) {
        this.hcd = hcd;
    }

    public GenericType<Collection<Hicarddetails>> getHcdt() {
        return hcdt;
    }

    public void setHcdt(GenericType<Collection<Hicarddetails>> hcdt) {
        this.hcdt = hcdt;
    }

    public Collection<Hicarddetails> getHcd1() {
                GenericType<Collection<Hicarddetails>> htcd1 = new GenericType<Collection<Hicarddetails>>(){};
        res = client.hhigetLastcard_XML(Response.class);
        hcd1 = res.readEntity(htcd1);
       
        return hcd1;
    }

    public void setHcd1(Collection<Hicarddetails> hcd1) {
        this.hcd1 = hcd1;
    }

    public GenericType<Collection<Hicarddetails>> getHtcd1() {
        
  
        return htcd1;
    }

    public void setHtcd1(GenericType<Collection<Hicarddetails>> htcd1) {
        this.htcd1 = htcd1;
    }

    public Collection<Hicarddetails> getHcd2() {
         res = client.getAllHCDadmin_XML(Response.class);
       
        hcd2 = res.readEntity(hcdt2);
        return hcd2;
    }

    public void setHcd2(Collection<Hicarddetails> hcd2) {
        this.hcd2 = hcd2;
    }

    public GenericType<Collection<Hicarddetails>> getHcdt2() {
        return hcdt2;
    }

    public void setHcdt2(GenericType<Collection<Hicarddetails>> hcdt2) {
        this.hcdt2 = hcdt2;
    }

    public Collection<HealthInsu> getH() {
       res = hc.getlastHiId_XML(Response.class);
       
        h = res.readEntity(ht);
     
        return h;
    }

    public void setH(Collection<HealthInsu> h) {
        this.h = h;
    }

    public GenericType<Collection<HealthInsu>> getHt() {
        return ht;
    }

    public void setHt(GenericType<Collection<HealthInsu>> ht) {
        this.ht = ht;
    }

    public Collection<HealthInsu> getHi() {
        return hi;
    }

    public void setHi(Collection<HealthInsu> hi) {
        this.hi = hi;
    }

    public GenericType<Collection<HealthInsu>> getHit() {
        return hit;
    }

    public void setHit(GenericType<Collection<HealthInsu>> hit) {
        this.hit = hit;
    }

    public int getRn() {
        return rn;
    }

    public void setRn(int rn) {
        this.rn = rn;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public int getPaymentno() {
        int rn = ((int)(Math.random() * 100000)) % 1000;
//        rn=(int) Math.random();
//       rn= (int) Math.floor(Math.random());
//        rn=(int) Math.floor((Math.random() * 10) + 1);
//        paymentno=Integer.parseInt("");
        return rn;
       
    }

    public void setPaymentno(int paymentno) {
        this.paymentno = paymentno;
    }

    public String getName() {
       Collection<HealthInsu> hi= new  ArrayList<HealthInsu>();
         GenericType<Collection<HealthInsu>> hit = new GenericType<Collection<HealthInsu>>(){};
      
        res = hc.getlastHiId_XML(Response.class);
        hi = res.readEntity(hit);     
         for(HealthInsu pl:hi)
         {
            name=pl.getClientname();
         }
        
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getAmount() {
        Collection<HealthInsu> i = new  ArrayList<HealthInsu>();
         GenericType<Collection<HealthInsu>> ig = new GenericType<Collection<HealthInsu>>(){};
      
        res = hc.getlastHiId_XML(Response.class);
        i = res.readEntity(ig);     
         for(HealthInsu pl:i)
         {
            amount=Float.parseFloat(pl.getPolicyId().getCost());
         }
         
     
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    
     public String addhcd()
    {

        Collection<HealthInsu> h = new  ArrayList<HealthInsu>();
         GenericType<Collection<HealthInsu>> ht = new GenericType<Collection<HealthInsu>>(){};
      
        res = hc.getlastHiId_XML(Response.class);
        h = res.readEntity(ht);     
         for(HealthInsu pl:h)
         {
//cb.addTCD(pl.getId(), paymentno, name, paymentMethod, status, amount, date);
 client.addHCD_XML(new Hicarddetails(),pl.getHid()+"",paymentno+"",name, paymentMethod,"Complete",amount+"",date);       
         }
       return "hiinvoice.jsf?faces-redirect=true";
}
     
     public String hiedit_click(Integer cid){
        Hicarddetails p = new Hicarddetails();
        GenericType<Hicarddetails> grr = new GenericType<Hicarddetails>(){};
        res = client.higetpaymentById_XML(Response.class, cid.toString());
        p = res.readEntity(grr);
        hid=p.getHid().getHid();
        paymentno=p.getPaymentno();
        name=p.getName();
        paymentMethod=p.getPaymentMethod();
        
status=p.getStatus();
amount=p.getAmount();
date=p.getDate();
this.cid=p.getCid();


        return "updatehistatus?faces-redirect=true";
    }
     
      public String hiupdateStatus(){
                 client.hiupdateStatus_XML(new Hicarddetails(),cid+"", hid+"",paymentno+"",name, paymentMethod,status,amount+"",date);
        return "dashboard?faces-redirect=true";
    }
}
