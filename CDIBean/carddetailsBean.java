/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CDIBean;

import client.carddetailsClient;
import client.policyClient;
import client.taiClient;
import client.tpiClient;
import ejb.clientBean;
import ejb.clientBeanLocal;
import entity.Policy;
import entity.Termcarddetails;
import entity.TerminsuAi;
import entity.TerminsuPi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Hardik
 */
@Named(value = "carddetailsBean")
@RequestScoped
public class carddetailsBean {
    @EJB clientBeanLocal cb;
     carddetailsClient client;
     taiClient tc;
    policyClient pc;
     Response res;
      Collection<Termcarddetails> tcd;
   GenericType<Collection<Termcarddetails>> gtcd;
   
    Collection<Termcarddetails> tcd1;
   GenericType<Collection<Termcarddetails>> gtcd1;
   
     Collection<TerminsuPi> t;
   GenericType<Collection<TerminsuPi>> gt;
   
   Collection<Policy> i;
   GenericType<Collection<Policy>> ig;

   int termpiId, paymentno;
           String name,paymentMethod,status,date; 
                   float amount;
    public carddetailsBean() {
          HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       String token="";

        token = request.getSession().getAttribute("token").toString();
       System.out.println("Token="+token);
        
         client=new carddetailsClient(token);
          tcd=new ArrayList<Termcarddetails>();
            gtcd=new GenericType<Collection<Termcarddetails>>(){};
            
            client=new carddetailsClient(token);
          tcd1=new ArrayList<Termcarddetails>();
            gtcd1=new GenericType<Collection<Termcarddetails>>(){};
            
             tc=new taiClient(token);
                t=new ArrayList<TerminsuPi>();
            gt=new GenericType<Collection<TerminsuPi>>(){};
            
            pc=new policyClient(token);
             i=new ArrayList<Policy>();
            ig=new GenericType<Collection<Policy>>(){};
            
    }

    public taiClient getTc() {
        return tc;
    }

    public void setTc(taiClient tc) {
        this.tc = tc;
    }

    public int getTermpiId() {
        return termpiId;
    }

    public void setTermpiId(int termpiId) {
        this.termpiId = termpiId;
    }

    public int getPaymentno() {
        return paymentno;
    }

    public void setPaymentno(int paymentno) {
        this.paymentno = paymentno;
    }

    public String getName() {
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
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public policyClient getPc() {
        return pc;
    }

    public void setPc(policyClient pc) {
        this.pc = pc;
    }

   

    public Collection<Policy> getI() {
          GenericType<Collection<Policy>> ig = new GenericType<Collection<Policy>>(){};
        res = pc.getlastpolId_XML(Response.class);
        i = res.readEntity(ig);
               
      
        return i;
    }

    public void setI(Collection<Policy> i) {
        this.i = i;
    }

    public GenericType<Collection<Policy>> getIg() {
        return ig;
    }

    public void setIg(GenericType<Collection<Policy>> ig) {
        this.ig = ig;
    }


   

    public clientBeanLocal getCb() {
        return cb;
    }

    public void setCb(clientBeanLocal cb) {
        this.cb = cb;
    }

   

    public Collection<TerminsuPi> getT() {
           res = tc.getlastTpiId_XML(Response.class);
       
        t = res.readEntity(gt);
        return t;
    }

    public void setT(Collection<TerminsuPi> t) {
        this.t = t;
    }

    public GenericType<Collection<TerminsuPi>> getGt() {
        return gt;
    }

    public void setGt(GenericType<Collection<TerminsuPi>> gt) {
        this.gt = gt;
    }

    public Collection<Termcarddetails> getTcd1() {
        return tcd1;
    }

    public void setTcd1(Collection<Termcarddetails> tcd1) {
        this.tcd1 = tcd1;
    }

    public GenericType<Collection<Termcarddetails>> getGtcd1() {
        return gtcd1;
    }

    public void setGtcd1(GenericType<Collection<Termcarddetails>> gtcd1) {
        this.gtcd1 = gtcd1;
    }

    public carddetailsClient getClient() {
        return client;
    }

    public void setClient(carddetailsClient client) {
        this.client = client;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public Collection<Termcarddetails> getTcd() {
         res = client.getAllTCD_XML(Response.class);
        System.out.println(res);
        tcd = res.readEntity(gtcd);
        System.out.println(tcd);
        return tcd;
    }

    public void setTcd(Collection<Termcarddetails> tcd) {
        this.tcd = tcd;
    }

    public GenericType<Collection<Termcarddetails>> getGtcd() {
        return gtcd;
    }

    public void setGtcd(GenericType<Collection<Termcarddetails>> gtcd) {
        this.gtcd = gtcd;
    }

   

   

 
    public String addtcd()
    {

        Collection<TerminsuPi> t = new  ArrayList<TerminsuPi>();
         GenericType<Collection<TerminsuPi>> gt = new GenericType<Collection<TerminsuPi>>(){};
      
        res = tc.getlastTpiId_XML(Response.class);
        t = res.readEntity(gt);     
         for(TerminsuPi pl:t)
         {
cb.addTCD(pl.getId(), paymentno, name, paymentMethod, status, amount, date);
// client.addTCD_XML(new Termcarddetails(),pl.getId()+"",paymentno+"",name, paymentMethod,status,amount+"",date);       
         }

         return "test.jsf";
    }

}
