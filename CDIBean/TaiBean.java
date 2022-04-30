/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CDIBean;

import client.taiClient;
import client.tpiClient;
import entity.TerminsuAi;
import entity.TerminsuPi;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
@Named(value = "taiBean")
@SessionScoped
public class TaiBean implements Serializable {
taiClient client;

     Response res;
      Collection<TerminsuAi> tai;
   GenericType<Collection<TerminsuAi>> tai_add;
   
   Collection<TerminsuPi> t;
   GenericType<Collection<TerminsuPi>> tp;
   
   int id;
long mobile;
   String occupation,address,mother,father,insuCustId="1";

   Integer tid,aid,weight,heightf,heighti;
   int isdelete=1,loginid=1,isexpire=1;
    public TaiBean() {
                      HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       String token="";

        token = request.getSession().getAttribute("token").toString();
       System.out.println("Token="+token);

        client=new taiClient(token);

         tai=new ArrayList<TerminsuAi>();
            tai_add=new GenericType<Collection<TerminsuAi>>(){};
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

   

    
    public Collection<TerminsuPi> getT() {
         res = client.getlastTpiId_XML(Response.class);
       
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

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public taiClient getClient() {
        return client;
    }

    public void setClient(taiClient client) {
        this.client = client;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public Collection<TerminsuAi> getTai() {
        res = client.getAllTai_XML(Response.class);
        System.out.println(res);
        tai = res.readEntity(tai_add);
        System.out.println(tai);
        return tai;
    }

    public void setTai(Collection<TerminsuAi> tai) {
        this.tai = tai;
    }

    public GenericType<Collection<TerminsuAi>> getTai_add() {
        return tai_add;
    }

    public void setTai_add(GenericType<Collection<TerminsuAi>> tai_add) {
        this.tai_add = tai_add;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getInsuCustId() {
        return insuCustId;
    }

    public void setInsuCustId(String insuCustId) {
        this.insuCustId = insuCustId;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeightf() {
        return heightf;
    }

    public void setHeightf(Integer heightf) {
        this.heightf = heightf;
    }

    public Integer getHeighti() {
        return heighti;
    }

    public void setHeighti(Integer heighti) {
        this.heighti = heighti;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    public int getLoginid() {
        return loginid;
    }

    public void setLoginid(int loginid) {
        this.loginid = loginid;
    }

    public int getIsexpire() {
        return isexpire;
    }

    public void setIsexpire(int isexpire) {
        this.isexpire = isexpire;
    }
      public void addtpi() throws IOException
    {
       Collection<TerminsuPi> t = new  ArrayList<TerminsuPi>();
         GenericType<Collection<TerminsuPi>> tp = new GenericType<Collection<TerminsuPi>>(){};
      
        res = client.getlastTpiId_XML(Response.class);
        t = res.readEntity(tp);     
         for(TerminsuPi pl:t)
         {
//             out.println("<h4>"+ pl.getId()+"<h4>"+ pl.getPlanId().getPolicyId());
         
     
        client.addTai_JSON(new TerminsuAi(),pl.getId()+"",occupation,weight+"",heightf+"",heighti+"",mother,father,address,isdelete+"",loginid+"",insuCustId,isexpire+"");
       
         }
          FacesContext.getCurrentInstance().getExternalContext().redirect("ticart.jsf");
    }
}
