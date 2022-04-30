/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CDIBean;

import client.carddetailsClient;
import client.loginClient;
import client.tpiClient;
import ejb.adminBeanLocal;
import ejb.clientBeanLocal;
import entity.Login;
import entity.Termcarddetails;
import entity.TerminsuPi;
import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Convert;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Hardik Shali
 */
@Named(value = "tpiBean")
@RequestScoped
public class tpiBean {
    @EJB adminBeanLocal ub;
    @EJB clientBeanLocal cbl;
     tpiClient client;
     loginClient lc;
     carddetailsClient cl;
     Response res;
     
     Collection<Login> l;
   GenericType<Collection<Login>> gl;
      Collection<TerminsuPi> tpi;
   GenericType<Collection<TerminsuPi>> tpi_add;
   
         Collection<TerminsuPi> t;
   GenericType<Collection<TerminsuPi>> tp;
   
         Collection<TerminsuPi> t1;
   GenericType<Collection<TerminsuPi>> tp1;
          Collection<Termcarddetails> tc;
   GenericType<Collection<Termcarddetails>> gc;
   int loginid;
   int lid;
 int id,isdelete=1,isexpire=1;
    String planId,clientname, gender,lifestage,bday ,education,smoke,income,cover,coverage,insuCustId="1";
   long mobile;
           int tid,pid; 
           
        private HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            /**
     * Creates a new instance of tpiBean
     */
    public tpiBean() {

                      HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       String token="";

        token = request.getSession().getAttribute("token").toString();
       System.out.println("Token="+token);
        
         client=new tpiClient(token);
           lc=new loginClient(token);
                 tpi=new ArrayList<TerminsuPi>();
            tpi_add=new GenericType<Collection<TerminsuPi>>(){};
             client=new tpiClient(token);
            t=new ArrayList<TerminsuPi>();
            tp=new GenericType<Collection<TerminsuPi>>(){};
            
             t1=new ArrayList<TerminsuPi>();
            tp1=new GenericType<Collection<TerminsuPi>>(){};
            
             tc=new ArrayList<Termcarddetails>();
            gc=new GenericType<Collection<Termcarddetails>>(){};
//            
       l=new ArrayList<Login>();
            gl=new GenericType<Collection<Login>>(){};
    }

    public Collection<Termcarddetails> getTc() {
         loginid=(Integer) session.getAttribute("lid");
         tc = cbl.getcardbylid(loginid);
        return tc;
    }

    public void setTc(Collection<Termcarddetails> tc) {
        this.tc = tc;
    }

    public GenericType<Collection<Termcarddetails>> getGc() {
        return gc;
    }

    public void setGc(GenericType<Collection<Termcarddetails>> gc) {
        this.gc = gc;
    }

    public carddetailsClient getCl() {
        return cl;
    }

    public void setCl(carddetailsClient cl) {
        this.cl = cl;
    }

    public int getLoginid() {
        return loginid;
    }

    public void setLoginid(int loginid) {
        this.loginid = loginid;
    }

    public Collection<Login> getL() {
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

    public adminBeanLocal getUb() {
        return ub;
    }

    public void setUb(adminBeanLocal ub) {
        this.ub = ub;
    }
// public int getLoginid() {
//        return loginid;
//    }
//
//    public void setLoginid(int loginid) {
//        this.loginid = loginid;
//    }
    
    public Collection<TerminsuPi> getT1() {
//        Collection<Login> l = new  ArrayList<Login>();
//         GenericType<Collection<Login>> gl = new GenericType<Collection<Login>>(){};
//       lid=(Integer) session.getAttribute("lid");
//        res = lc.getuserById_XML(Response.class,lid+"");
//        l = res.readEntity(gl);   
//        for(Login pl:l)
//         {
//        t1 = new ArrayList<TerminsuPi>();
//        tp1 = new GenericType<Collection<TerminsuPi>>(){};
//        res = cl.getHistory_XML(Response.class,pl.getLid().toString());
//        t1 = res.readEntity(tp1);
//         
//        
//         }

//  Collection<TerminsuPi> t1 = new  ArrayList<TerminsuPi>();
//         GenericType<Collection<TerminsuPi>> tp1 = new GenericType<Collection<TerminsuPi>>(){};
      
        
//        t1 = res.readEntity(tp1);   
//        for(TerminsuPi pl:t1)
//         {
//        l = new ArrayList<Login>();
//        gl = new GenericType<Collection<Login>>(){};
//        res = lc.getuserById_XML(Response.class,pl.getLoginid().getLid().toString());
//        l = res.readEntity(gl);
//         
//        System.out.print(pl.getClientname());
//         }
       
        return t1;
    }

    public void setT1(Collection<TerminsuPi> t1) {
        this.t1 = t1;
    }

    public GenericType<Collection<TerminsuPi>> getTp1() {
        return tp1;
    }

    public void setTp1(GenericType<Collection<TerminsuPi>> tp1) {
        this.tp1 = tp1;
    }

    public loginClient getLc() {
        return lc;
    }

    public void setLc(loginClient lc) {
        this.lc = lc;
    }

    public clientBeanLocal getCbl() {
        return cbl;
    }

    public void setCbl(clientBeanLocal cbl) {
        this.cbl = cbl;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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

  

    public tpiClient getClient() {
        return client;
    }

    public void setClient(tpiClient client) {
        this.client = client;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public Collection<TerminsuPi> getTpi() {
         res = client.getAllTpi_XML(Response.class);
        System.out.println(res);
        tpi = res.readEntity(tpi_add);
        System.out.println(tpi);
       
        return tpi;
    }

    public void setTpi(Collection<TerminsuPi> tpi) {
        this.tpi = tpi;
    }

    public GenericType<Collection<TerminsuPi>> getTpi_add() {
        return tpi_add;
    }

    public void setTpi_add(GenericType<Collection<TerminsuPi>> tpi_add) {
        this.tpi_add = tpi_add;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
     
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }


    public int getIsexpire() {
        return isexpire;
    }

    public void setIsexpire(int isexpire) {
        this.isexpire = isexpire;
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

    public String getLifestage() {
        return lifestage;
    }

    public void setLifestage(String lifestage) {
        this.lifestage = lifestage;
    }

    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    public String getInsuCustId() {
        return insuCustId;
    }

    public void setInsuCustId(String insuCustId) {
        this.insuCustId = insuCustId;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<TerminsuPi> getT() {
         
        res = client.getlastTiId_XML(Response.class);
       
        t = res.readEntity(tp);
    
        return t;
    }

    public void setT(Collection<TerminsuPi> t) {
        this.t = t;
    }

    public GenericType<Collection<TerminsuPi>> getTp() {
        return tp;
    }

    public void setTp(GenericType<Collection<TerminsuPi>> tp) {
        this.tp = tp;
    }
    
     public void addtpi(int planId)
    { 
        loginid=(Integer) session.getAttribute("lid");
        try
        {
        client.addTpi_XML(new TerminsuPi(),planId+"",clientname,gender,lifestage,bday,mobile+"",education,smoke,income,cover,coverage,isdelete+"",loginid+"",
        insuCustId,isexpire+"");
        FacesContext.getCurrentInstance().getExternalContext().redirect("terminsu.jsf");
        }
    catch(IOException | ClientErrorException e)
        {
            System.out.println(e.getMessage());
        }
    }
      public String addallTpi(){
          loginid=(Integer) session.getAttribute("lid");
        Collection<TerminsuPi> t = new  ArrayList<TerminsuPi>();
         GenericType<Collection<TerminsuPi>> tp = new GenericType<Collection<TerminsuPi>>(){};
      
        res = client.getlastTiId_XML(Response.class);
        t = res.readEntity(tp);     
         for(TerminsuPi pl:t)
         {
//             out.println("<h4>"+ pl.getId()+"<h4>"+ pl.getPlanId().getPolicyId());
         
//     cbl.updateTpi(pl.getId(), pl.getPlanId().getPolicyId(), clientname, gender, lifestage, bday, mobile, education, smoke, income, cover, coverage, isdelete, pl.getLoginid().getLid(), insuCustId, isexpire);
        client.updateTpi_XML(new TerminsuPi(),pl.getId()+"",pl.getPlanId().getPolicyId()+"",clientname,gender,lifestage,bday,mobile+"",education,smoke,income,cover,coverage,isdelete+"",loginid+"",insuCustId,isexpire+"");
       
         }
          return "tipolicy?faces-redirect=true";
    }
   public String edit_click(Integer id){
        TerminsuPi t = new TerminsuPi();
        GenericType<TerminsuPi> grr = new GenericType<TerminsuPi>(){};
        res = client.getTerminsuPiById_XML(Response.class,id+"");
        t = res.readEntity(grr);
       planId=t.getPlanId().getName();
       clientname=t.getClientname();
       gender=t.getGender();
       lifestage=t.getLifestage();
       bday=t.getBday();
       mobile=t.getMobile();
       education=t.getEducation();
       smoke=t.getSmoke();
       income=t.getIncome();
       cover=t.getCover();
       coverage=t.getCoverage();
               
       
       
        
                
        this.id=t.getId();
        
         
        return "updatetermpi.xhtml";
    }
       public String updateTermPi(){
           loginid=(Integer) session.getAttribute("lid");
              Collection<TerminsuPi> t = new  ArrayList<TerminsuPi>();
         GenericType<Collection<TerminsuPi>> tp = new GenericType<Collection<TerminsuPi>>(){};
      
        res = client.getlastTiId_XML(Response.class);
        t = res.readEntity(tp);     
         for(TerminsuPi pl:t)
         {
//             out.println("<h4>"+ pl.getId()+"<h4>"+ pl.getPlanId().getPolicyId());
         
     
        client.updateTpi_XML(new TerminsuPi(),pl.getId()+"",pl.getPlanId().getPolicyId()+"",clientname,gender,lifestage,bday,mobile+"",education,smoke,income,cover,coverage,isdelete+"",loginid+"",insuCustId,isexpire+"");
       
         }
//        client.updateTpi_JSON(new TerminsuPi(), id+"", planId+"", clientname, gender, lifestage, bday, mobile+"", education, smoke, income, cover, coverage, isdelete+"", loginid+"", insuCustId, isexpire+"");
        return "tipolicy?faces-redirect=true";
    }
       public String next()
       {
            return "paymentoptions?faces-redirect=true";
       }
        public String pay()
       {
            return "addpayment?faces-redirect=true";
       }
      public Collection<TerminsuPi> getHistory() {
         
         Collection<Login> l = new  ArrayList<Login>();
         GenericType<Collection<Login>> gl = new GenericType<Collection<Login>>(){};
       loginid=(Integer) session.getAttribute("lid");
        res = lc.getuserById_XML(Response.class,loginid+"");
        l = res.readEntity(gl);   
        for(Login pl:l)
         {
        t1 = new ArrayList<TerminsuPi>();
        tp1 = new GenericType<Collection<TerminsuPi>>(){};
        res = client.getTerminsuPiBylId_XML(Response.class,pl.getLid().toString());
        t1 = res.readEntity(tp1);
        
         }
       
        
        return t1;
    }
}
