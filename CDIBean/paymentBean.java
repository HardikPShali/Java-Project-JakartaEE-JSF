/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CDIBean;

import client.carddetailsClient;
import client.feedbackClient;
import client.policyClient;
import client.taiClient;
import client.tpiClient;
import ejb.clientBeanLocal;
import entity.Feedback;
import entity.Policy;
import entity.Termcarddetails;
import entity.TerminsuPi;
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
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Hardik
 */
@Named(value = "paymentBean")
@RequestScoped
public class paymentBean {
 carddetailsClient client;
 feedbackClient fc;
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
   
      Collection<Termcarddetails> tcd3;
   GenericType<Collection<Termcarddetails>> gtcd3;
   
     Collection<TerminsuPi> t;
   GenericType<Collection<TerminsuPi>> gt;
   
      Collection<Policy> i;
   GenericType<Collection<Policy>> ig;
   
     Collection<TerminsuPi> tpi;
   GenericType<Collection<TerminsuPi>> gtpi;
   
     Collection<Feedback> f;
   GenericType<Collection<Feedback>> gf;
   int rn;
   int cid,termpiId,paymentno;
           String name,paymentMethod,status,date,msg; 
                   float amount;
                     private HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    public paymentBean() {
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
               tcd3=new ArrayList<Termcarddetails>();
            gtcd3=new GenericType<Collection<Termcarddetails>>(){};
        pc=new policyClient(token);
             i=new ArrayList<Policy>();
            ig=new GenericType<Collection<Policy>>(){};
            
             tc=new taiClient(token);
                t=new ArrayList<TerminsuPi>();
            gt=new GenericType<Collection<TerminsuPi>>(){};
            
            tp=new tpiClient(token);
      fc=new feedbackClient(token);
          f=new ArrayList<Feedback>();
            gf=new GenericType<Collection<Feedback>>(){};
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public feedbackClient getFc() {
        return fc;
    }

    public void setFc(feedbackClient fc) {
        this.fc = fc;
    }

    public Collection<Feedback> getF() {
        
            res = fc.getAllFeedback_XML(Response.class);
       
        f = res.readEntity(gf);
        return f;
    }

    public void setF(Collection<Feedback> f) {
        this.f = f;
    }

    public GenericType<Collection<Feedback>> getGf() {
        return gf;
    }

    public void setGf(GenericType<Collection<Feedback>> gf) {
        this.gf = gf;
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

    public Collection<Termcarddetails> getTcd3() {
        rn=(Integer)session.getAttribute("lid");
        
            res = client.getAllTCD_XML(Response.class);
       
        tcd3 = res.readEntity(gtcd3);
        return tcd3;
    }

    public void setTcd3(Collection<Termcarddetails> tcd3) {
        this.tcd3 = tcd3;
    }

    public GenericType<Collection<Termcarddetails>> getGtcd3() {
        return gtcd3;
    }

    public void setGtcd3(GenericType<Collection<Termcarddetails>> gtcd3) {
        this.gtcd3 = gtcd3;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public carddetailsClient getClient() {
        return client;
    }

    public void setClient(carddetailsClient client) {
        this.client = client;
    }

    public taiClient getTc() {
        return tc;
    }

    public void setTc(taiClient tc) {
        this.tc = tc;
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

    public int getTermpiId() {
        return termpiId;
    }

    public void setTermpiId(int termpiId) {
        this.termpiId = termpiId;
    }

    public tpiClient getTp() {
        return tp;
    }

    public void setTp(tpiClient tp) {
        this.tp = tp;
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
        Collection<TerminsuPi> tpi= new  ArrayList<TerminsuPi>();
         GenericType<Collection<TerminsuPi>> gtpi = new GenericType<Collection<TerminsuPi>>(){};
      
        res = tp.getlastTiId_XML(Response.class);
        tpi = res.readEntity(gtpi);     
         for(TerminsuPi pl:tpi)
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
         Collection<TerminsuPi> tpi= new  ArrayList<TerminsuPi>();
         GenericType<Collection<TerminsuPi>> gtpi = new GenericType<Collection<TerminsuPi>>(){};
      
        res = tp.getlastTiId_XML(Response.class);
        tpi = res.readEntity(gtpi);     
         for(TerminsuPi pl:tpi)
         {
            amount=(Float.parseFloat(pl.getPlanId().getCost())*18/100)+(Float.parseFloat(pl.getPlanId().getCost()));
         }
      
         
        return amount;
    }

    public void setAmount(float amount) {
        
        this.amount = amount;
    }
        public String addtcd()
    {

        Collection<TerminsuPi> t = new  ArrayList<TerminsuPi>();
         GenericType<Collection<TerminsuPi>> gt = new GenericType<Collection<TerminsuPi>>(){};
      
        res = tc.getlastTpiId_XML(Response.class);
        t = res.readEntity(gt);     
         for(TerminsuPi pl:t)
         {
//cb.addTCD(pl.getId(), paymentno, name, paymentMethod, status, amount, date);
 client.addTCD_XML(new Termcarddetails(),pl.getId()+"",paymentno+"",name, paymentMethod,"Complete",amount+"",date);       
         }

         return "invoice.jsf?faces-redirect=true";
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


        return "updatestatus?faces-redirect=true";
    }
             public String updateStatus(){
                 client.updateStatus_JSON(new Termcarddetails(),cid+"", termpiId+"",paymentno+"",name, paymentMethod,status,amount+"",date);
        return "dashboard?faces-redirect=true";
    }
                       public String addreview(){
        return "index?faces-redirect=true";
    }
    public String addfeeback()
    {
rn=(Integer)session.getAttribute("lid");
        Collection<TerminsuPi> f = new  ArrayList<TerminsuPi>();
         GenericType<Collection<TerminsuPi>> gf = new GenericType<Collection<TerminsuPi>>(){};
      
        res = tc.getlastTpiId_XML(Response.class);
        f = res.readEntity(gf);     
         for(TerminsuPi pl:f)
         {
             cb.addFeedback(rn, pl.getPlanId().getPolicyId(), msg);
//             fc.addfeedback_JSON(new Feedback(), rn+"", pl.getPlanId().getPolicyId()+"", msg);
      
         }

         return "index.jsf?faces-redirect=true";
    }
}
