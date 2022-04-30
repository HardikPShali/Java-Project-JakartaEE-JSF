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
import ejb.clientBeanLocal;
import entity.Policy;
import entity.Termcarddetails;
import entity.TerminsuPi;
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
 * @author Hardik
 */
@Named(value = "updatestatusBean")
@RequestScoped
public class updatestatusBean {
 carddetailsClient client;
   tpiClient tp;
     taiClient tc;
         policyClient pc;
    @EJB clientBeanLocal cb;
     Response res;
      Collection<Termcarddetails> tcd;
   GenericType<Collection<Termcarddetails>> gtcd;
   
     Collection<Termcarddetails> tcd1;
   GenericType<Collection<Termcarddetails>> gtcd1;
   
        Collection<Termcarddetails> tcd2;
   GenericType<Collection<Termcarddetails>> gtcd2;
   
     Collection<TerminsuPi> t;
   GenericType<Collection<TerminsuPi>> gt;
   
      Collection<Policy> i;
   GenericType<Collection<Policy>> ig;
   
     Collection<TerminsuPi> tpi;
   GenericType<Collection<TerminsuPi>> gtpi;
   int rn;
   int cid,termpiId,paymentno;
           String name,paymentMethod,status,date; 
                   float amount;
    public updatestatusBean() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       String token="";

        token = request.getSession().getAttribute("token").toString();
       System.out.println("Token="+token);
        
         client=new carddetailsClient(token);
          tcd=new ArrayList<Termcarddetails>();
            gtcd=new GenericType<Collection<Termcarddetails>>(){};
             tcd2=new ArrayList<Termcarddetails>();
            gtcd2=new GenericType<Collection<Termcarddetails>>(){};
        pc=new policyClient(token);
             i=new ArrayList<Policy>();
            ig=new GenericType<Collection<Policy>>(){};
            
             tc=new taiClient(token);
                t=new ArrayList<TerminsuPi>();
            gt=new GenericType<Collection<TerminsuPi>>(){};
            
            tp=new tpiClient(token);
    }

    public carddetailsClient getClient() {
        return client;
    }

    public void setClient(carddetailsClient client) {
        this.client = client;
    }

    public tpiClient getTp() {
        return tp;
    }

    public void setTp(tpiClient tp) {
        this.tp = tp;
    }

    public taiClient getTc() {
        return tc;
    }

    public void setTc(taiClient tc) {
        this.tc = tc;
    }

    public policyClient getPc() {
        return pc;
    }

    public void setPc(policyClient pc) {
        this.pc = pc;
    }

    public clientBeanLocal getCb() {
        return cb;
    }

    public void setCb(clientBeanLocal cb) {
        this.cb = cb;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public Collection<Termcarddetails> getTcd() {
              res = client.getAllTCD_XML(Response.class);
       
        tcd = res.readEntity(gtcd);
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

    public Collection<Termcarddetails> getTcd1() {
               GenericType<Collection<Termcarddetails>> gtcd1 = new GenericType<Collection<Termcarddetails>>(){};
        res = client.getLastcard_XML(Response.class);
        tcd1 = res.readEntity(gtcd1);
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

    public Collection<Termcarddetails> getTcd2() {
                 res = client.getAllTCDadmin_XML(Response.class);
       
        tcd2 = res.readEntity(gtcd2);
        return tcd2;
    }

    public void setTcd2(Collection<Termcarddetails> tcd2) {
        this.tcd2 = tcd2;
    }

    public GenericType<Collection<Termcarddetails>> getGtcd2() {
        return gtcd2;
    }

    public void setGtcd2(GenericType<Collection<Termcarddetails>> gtcd2) {
        this.gtcd2 = gtcd2;
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

    public Collection<TerminsuPi> getTpi() {
        return tpi;
    }

    public void setTpi(Collection<TerminsuPi> tpi) {
        this.tpi = tpi;
    }

    public GenericType<Collection<TerminsuPi>> getGtpi() {
        return gtpi;
    }

    public void setGtpi(GenericType<Collection<TerminsuPi>> gtpi) {
        this.gtpi = gtpi;
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
    
    public String edit_click(Integer cid){
        Termcarddetails p = new Termcarddetails();
        GenericType<Termcarddetails> grr = new GenericType<Termcarddetails>(){};
        res = client.getpaymentById_XML(Response.class, cid.toString());
        p = res.readEntity(grr);
        termpiId=p.getTermpiId().getId();
        paymentno=p.getPaymentno();
        name=p.getName();
        paymentMethod=p.getPaymentMethod();
        status=p.getStatus();
        amount=p.getAmount();
        date=p.getDate();
        this.cid=p.getCid();

        return "updatestatus.xhtml";
    }
     public String updateStatus(){
        client.updateStatus_JSON(new Termcarddetails(),cid+"", termpiId+"",paymentno+"",name, paymentMethod,status,amount+"",date);
        return "dashboard.xhtml";
    }
}
