/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CDIBean;


import client.himemberClient;
import entity.HealthInsu;
import entity.Himember;
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
@Named(value = "himemberBean")
@RequestScoped
public class himemberBean {
himemberClient client;
     Response res;
      Collection<Himember> him;
   GenericType<Collection<Himember>> him_add;
   
    Collection<Himember> m;
   GenericType<Collection<Himember>> m_add;
   Collection<HealthInsu> gl;
   GenericType<Collection<HealthInsu>> gln;
   
   Integer hid,loginid=1,isdelete=1;
   String membername,dobm,rtop,height,weight,insuCustId="1";
    /**
     * Creates a new instance of himemberBean
     */
    public himemberBean() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       String token="";

        token = request.getSession().getAttribute("token").toString();
       System.out.println("Token="+token);
        client=new himemberClient(token);
            him=new ArrayList<Himember>();
            him_add=new GenericType<Collection<Himember>>(){};
              m=new ArrayList<Himember>();
            m_add=new GenericType<Collection<Himember>>(){};
             gl=new ArrayList<HealthInsu>();
            gln=new GenericType<Collection<HealthInsu>>(){};
            
    }

    public himemberClient getClient() {
        return client;
    }

    public void setClient(himemberClient client) {
        this.client = client;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public Collection<Himember> getM() {
           res = client.getAllHimember_XML(Response.class);
        System.out.println(res);
        m = res.readEntity(m_add);
        System.out.println(m);
        return m;
    }

    public void setM(Collection<Himember> m) {
        this.m = m;
    }

    public GenericType<Collection<Himember>> getM_add() {
        return m_add;
    }

    public void setM_add(GenericType<Collection<Himember>> m_add) {
        this.m_add = m_add;
    }

    public Collection<Himember> getHim() {
         Collection<HealthInsu> gl = new  ArrayList<HealthInsu>();
         GenericType<Collection<HealthInsu>> gln = new GenericType<Collection<HealthInsu>>(){};
      
        res = client.getlastHiId_XML(Response.class);
        gl = res.readEntity(gln);   
        for(HealthInsu pl:gl)
         {
        him = new ArrayList<Himember>();
        him_add = new GenericType<Collection<Himember>>(){};
        res = client.getlastmembers_XML(Response.class,pl.getHid().toString());
        him = res.readEntity(him_add);
        
         }
       
        
        return him;
    }

    public void setHim(Collection<Himember> him) {
        this.him = him;
    }

    public GenericType<Collection<Himember>> getHim_add() {
        return him_add;
    }

    public void setHim_add(GenericType<Collection<Himember>> him_add) {
        this.him_add = him_add;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public Integer getLoginid() {
        return loginid;
    }

    public void setLoginid(Integer loginid) {
        this.loginid = loginid;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public String getDobm() {
        return dobm;
    }

    public void setDobm(String dobm) {
        this.dobm = dobm;
    }

    public String getRtop() {
        return rtop;
    }

    public void setRtop(String rtop) {
        this.rtop = rtop;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getInsuCustId() {
        return insuCustId;
    }

    public void setInsuCustId(String insuCustId) {
        this.insuCustId = insuCustId;
    }
    
     public void addmember()
    {
        try
        {
            Collection<HealthInsu> t = new  ArrayList<HealthInsu>();
         GenericType<Collection<HealthInsu>> tp = new GenericType<Collection<HealthInsu>>(){};
      
        res = client.getlastHiId_XML(Response.class);
        t = res.readEntity(tp);   
        for(HealthInsu pl:t)
         {
        client.addHimember_XML(new Himember(),pl.getHid()+"",membername,dobm,rtop,height,weight,loginid+"",isdelete+"",insuCustId);
         him = new ArrayList<Himember>();
        him_add = new GenericType<Collection<Himember>>(){};
        res = client.getlastmembers_XML(Response.class,pl.getHid().toString());
        him = res.readEntity(him_add);
         }
        FacesContext.getCurrentInstance().getExternalContext().redirect("viewmember.jsf");
        }
    catch(IOException | ClientErrorException e)
        {
            System.out.println(e.getMessage());
        }
    }
          public String nextbtn()
    {
       
    return "hicart?faces-redirect=true";
    }
               public String nextbtn1()
    {
       
    return "hipaymentoptions?faces-redirect=true";
    }
     public void addmoremember()
    {
        try
        {
        FacesContext.getCurrentInstance().getExternalContext().redirect("himember.jsf");
        }
    catch(IOException | ClientErrorException e)
        {
            System.out.println(e.getMessage());
        }
    }
     public String removemember(int memberid)
    {
         try
        {
        client.deleteHimember(memberid+"");
        }
    catch(ClientErrorException e)
        {
            System.out.println(e.getMessage());
        }
         return "hicart?faces-redirect=true";
    }

    public Collection<HealthInsu> getGl() {
        return gl;
    }

    public void setGl(Collection<HealthInsu> gl) {
        this.gl = gl;
    }

    public GenericType<Collection<HealthInsu>> getGln() {
        return gln;
    }

    public void setGln(GenericType<Collection<HealthInsu>> gln) {
        this.gln = gln;
    }
//    public String getlastmembers() {
//          Collection<HealthInsu> gl = new  ArrayList<HealthInsu>();
//         GenericType<Collection<HealthInsu>> gln = new GenericType<Collection<HealthInsu>>(){};
//      
//        res = client.getlastHiId_XML(Response.class);
//        gl = res.readEntity(gln);   
//        for(HealthInsu pl:gl)
//         {
//        him = new ArrayList<Himember>();
//        him_add = new GenericType<Collection<Himember>>(){};
//        res = client.getlastmembers_XML(Response.class,pl.getHid().toString());
//        him = res.readEntity(him_add);
//        
//         }
//        return "himember.jsf";
//    }

}
 