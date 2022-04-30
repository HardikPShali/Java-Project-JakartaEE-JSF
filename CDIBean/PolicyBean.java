/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CDIBean;

import client.CompanyClient;
import client.insutypeClient;
import client.policyClient;
import entity.CompReg;
import entity.InsuType;
import entity.Policy;

import java.io.IOException;
import static java.lang.System.out;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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
 * @author Hardik
 */
@Named(value = "policyBean")
@RequestScoped
public class PolicyBean {
insutypeClient ic;
CompanyClient cc;
policyClient pc;
Response res;



  Collection<Policy> pol;
   GenericType<Collection<Policy>> gen_pol;

   
 Collection<CompReg> comp;
   GenericType<Collection<CompReg>> comp_add;
   int compId;

Collection<InsuType> itype;
   GenericType<Collection<InsuType>> insutype_add;
   
   Collection<Policy> i;
   GenericType<Collection<Policy>> ig;

     Collection<Policy> p1;
   GenericType<Collection<Policy>> gp1;
   
     Collection<Policy> p2;
   GenericType<Collection<Policy>> gp2;
   
       Collection<Policy> p3;
   GenericType<Collection<Policy>> gp3;
   Integer policyId,policyNo,noOfPerson,totalAdult,noOfSon,noOfDaughter,sumInsured;
   String name,issuedate,validity,cost,insuCompId,insuTypeId;

Integer pNo=100;
   
   
    public PolicyBean() {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       String token="";

        token = request.getSession().getAttribute("token").toString();
       System.out.println("Token="+token);
        
        pc=new policyClient(token);
         cc=new CompanyClient(token);
          ic=new insutypeClient(token);
           
       pol=new ArrayList<Policy>();
            gen_pol=new GenericType<Collection<Policy>>(){};
             comp=new ArrayList<CompReg>();
comp_add=new GenericType<Collection<CompReg>>(){};
itype=new ArrayList<InsuType>();
insutype_add=new GenericType<Collection<InsuType>>(){};
 p1=new ArrayList<Policy>();
            gp1=new GenericType<Collection<Policy>>(){};
            
            
            p2=new ArrayList<Policy>();
            gp2=new GenericType<Collection<Policy>>(){};
            
             
            p3=new ArrayList<Policy>();
            gp3=new GenericType<Collection<Policy>>(){};

    }
 public Collection<Policy> getP3() {
        return p3;
    }

    public void setP3(Collection<Policy> p3) {
        this.p3 = p3;
    }

    public GenericType<Collection<Policy>> getGp3() {
        return gp3;
    }

    public void setGp3(GenericType<Collection<Policy>> gp3) {
        this.gp3 = gp3;
    }

    public Collection<Policy> getP1() {
        res = pc.databyisdeletepol_XML(Response.class);
       
        p1 = res.readEntity(gp1);
       
        return p1;
    }

    public void setP1(Collection<Policy> p1) {
        this.p1 = p1;
    }

    public GenericType<Collection<Policy>> getGp1() {
        return gp1;
    }

    public void setGp1(GenericType<Collection<Policy>> gp1) {
        this.gp1 = gp1;
    }

    public Collection<Policy> getP2() {
            res = pc.databyisdeletepol1_XML(Response.class);
       
        p2 = res.readEntity(gp2);
        return p2;
    }

    public void setP2(Collection<Policy> p2) {
        this.p2 = p2;
    }

    public GenericType<Collection<Policy>> getGp2() {
        return gp2;
    }

    public void setGp2(GenericType<Collection<Policy>> gp2) {
        this.gp2 = gp2;
    }
    public Collection<Policy> getI() {
//        res = pc.getPolicy_XML(Response.class);
//        System.out.println(res);
//        pol = res.readEntity(gen_pol);
//        System.out.println(pol);
    return i;
       
        
    }

    public Integer getpNo() {
        return pNo;
    }

    public void setpNo(Integer pNo) {
        this.pNo = pNo;
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

    
   


    

    public insutypeClient getIc() {
        return ic;
    }

    public void setIc(insutypeClient ic) {
        this.ic = ic;
    }

    public CompanyClient getCc() {
        return cc;
    }

    public void setCc(CompanyClient cc) {
        this.cc = cc;
    }

    public Collection<CompReg> getComp() {
         res=cc.getAllcomps_XML(Response.class);
        comp=res.readEntity(comp_add);
        return comp;
       
    }

    public void setComp(Collection<CompReg> comp) {
        this.comp = comp;
    }

    public GenericType<Collection<CompReg>> getComp_add() {
        return comp_add;
    }

    public void setComp_add(GenericType<Collection<CompReg>> comp_add) {
        this.comp_add = comp_add;
    }

    public int getCompId() {
        return compId;
    }

    public void setCompId(int compId) {
        this.compId = compId;
    }

    public Collection<InsuType> getItype() {
            res=ic.getAllTypes_XML(Response.class);
        itype=res.readEntity(insutype_add);
      
        return itype;
    }

    public void setItype(Collection<InsuType> itype) {
        this.itype = itype;
    }

    public GenericType<Collection<InsuType>> getInsutype_add() {
        return insutype_add;
    }

    public void setInsutype_add(GenericType<Collection<InsuType>> insutype_add) {
        this.insutype_add = insutype_add;
    }
    
    public policyClient getPc() {
        return pc;
    }

    public void setPc(policyClient pc) {
        this.pc = pc;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public Collection<Policy> getPol() {
         res = pc.getPolicyadmin_XML(Response.class);
        System.out.println(res);
        pol = res.readEntity(gen_pol);
        System.out.println(pol);
       
        return pol;
    }

    public void setPol(Collection<Policy> pol) {
        this.pol = pol;
    }

    public GenericType<Collection<Policy>> getGen_pol() {
        return gen_pol;
    }

    public void setGen_pol(GenericType<Collection<Policy>> gen_pol) {
        this.gen_pol = gen_pol;
    }

    public Integer getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    public Integer getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(Integer policyNo) {
        this.policyNo = policyNo;
    }

    public String getInsuCompId() {
        return insuCompId;
    }

    public void setInsuCompId(String insuCompId) {
        this.insuCompId = insuCompId;
    }

    public String getInsuTypeId() {
        return insuTypeId;
    }

    public void setInsuTypeId(String insuTypeId) {
        this.insuTypeId = insuTypeId;
    }

    public Integer getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(Integer noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public Integer getTotalAdult() {
        return totalAdult;
    }

    public void setTotalAdult(Integer totalAdult) {
        this.totalAdult = totalAdult;
    }

    public Integer getNoOfSon() {
        return noOfSon;
    }

    public void setNoOfSon(Integer noOfSon) {
        this.noOfSon = noOfSon;
    }

    public Integer getNoOfDaughter() {
        return noOfDaughter;
    }

    public void setNoOfDaughter(Integer noOfDaughter) {
        this.noOfDaughter = noOfDaughter;
    }

    public Integer getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(Integer sumInsured) {
        this.sumInsured = sumInsured;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(String issuedate) {
        this.issuedate = issuedate;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
  
        
         public void addPolicy()
    {
        try
        {
        pc.addPolicy_JSON(new Policy(),policyNo+"",name, insuTypeId+"", insuCompId+"", issuedate, validity, noOfPerson+"", totalAdult+"", noOfSon+"", noOfDaughter+"", sumInsured+"", cost);
        FacesContext.getCurrentInstance().getExternalContext().redirect("viewpolicy.jsf");
        }
    catch(IOException | ClientErrorException e)
        {
            System.out.println(e.getMessage());
        }
    }
       public String removePolicy(Integer policyNo)
    {
         Collection<Policy> p3 = new  ArrayList<Policy>();
         GenericType<Collection<Policy>> gp3 = new GenericType<Collection<Policy>>(){};
      
        res = pc.findBypolno_XML(Response.class,policyNo.toString());
        p3 = res.readEntity(gp3);     
         for(Policy pl:p3)
         {

         

        pc.updatedelPolicy_JSON(new Policy(),pl.getPolicyId()+"",policyNo+"",pl.getName(),pl.getInsuTypeId().getInsuTypeId()+"",pl.getInsuCompId().getCompId()+"",pl.getIssuedate(),pl.getValidity(),pl.getNoOfPerson()+"",pl.getTotalAdult()+"",pl.getNoOfSon()+"",pl.getNoOfDaughter()+"",pl.getSumInsured()+"",pl.getCost(),"1");
       
         }
         return "viewdelpolicy?faces-redirect=true";
//         try
//        {
//        pc.removePolicy(policyId+"");
//        }
//    catch(ClientErrorException e)
//        {
//            System.out.println(e.getMessage());
//        }
    }
      public String edit_click(Integer policyId){
        Policy p = new Policy();
        GenericType<Policy> grr = new GenericType<Policy>(){};
        res = pc.getpolicyById_XML(Response.class, policyId.toString());
        p = res.readEntity(grr);
        policyNo=p.getPolicyNo();
        name = p.getName();
        insuTypeId=p.getInsuTypeId().getInsuTypeId().toString();
        insuCompId=p.getInsuCompId().getCompId().toString();
        issuedate=p.getIssuedate();
        validity=p.getValidity();
        noOfPerson=p.getNoOfPerson();
        totalAdult=p.getTotalAdult();
        noOfSon=p.getNoOfSon();
        noOfDaughter=p.getNoOfDaughter();
        sumInsured=p.getSumInsured();
        cost=p.getCost(); 
        
                
        this.policyId=p.getPolicyId();
        return "updatepolicy.xhtml";
    }
       public String updatePolicy(){
        pc.updatePolicy_JSON(new Policy(), policyId+"",policyNo+"",name,insuTypeId+"",insuCompId+"",issuedate,validity,noOfPerson+"",totalAdult+"",noOfSon+"",noOfDaughter+"",sumInsured+"",cost);
        return "viewpolicy?faces-redirect=true";
    }
public String getdatabyno(Integer policyNo)
{

//    pc=new policyClient(token);
    Collection<Policy> i = new  ArrayList<Policy>();
    
        GenericType<Collection<Policy>> ig = new GenericType<Collection<Policy>>(){};
        res = pc.findByPolicyNo_XML(Response.class, policyNo.toString());
       i = res.readEntity(ig);
//        for(Policy pl:i)
//            {
//            out.println("<h4>"+ pl.getPolicyId()+ " "+ pl.getPolicyNo()+"</h4>"+ " "+ pl.getName()+"</h4>"+ " "+ pl.getIssuedate()+"</h4>"+ " "+ pl.getValidity()+"</h4>"+ " "+ pl.getNoOfPerson()+"</h4>"+ " "+ pl.getTotalAdult()+"</h4>"+ " "+ pl.getNoOfSon()+"</h4>"+ " "+ pl.getNoOfDaughter()+"</h4>"+ " "+ pl.getSumInsured()+"</h4>"+ " "+ pl.getCost()+"</h4>");           
//            }
    return "test.jsf";
}
     public String Restore(Integer policyNo)
    {
         Collection<Policy> p3 = new  ArrayList<Policy>();
         GenericType<Collection<Policy>> gp3 = new GenericType<Collection<Policy>>(){};
      
        res = pc.findBypolno_XML(Response.class,policyNo.toString());
        p3 = res.readEntity(gp3);     
         for(Policy pl:p3)
         {

         

        pc.updatedelPolicy_JSON(new Policy(),pl.getPolicyId()+"",policyNo+"",pl.getName(),pl.getInsuTypeId().getInsuTypeId()+"",pl.getInsuCompId().getCompId()+"",pl.getIssuedate(),pl.getValidity(),pl.getNoOfPerson()+"",pl.getTotalAdult()+"",pl.getNoOfSon()+"",pl.getNoOfDaughter()+"",pl.getSumInsured()+"",pl.getCost(),"0");
       
         }
         return "viewpolicy?faces-redirect=true";
//         try
//        {
//        pc.removePolicy(policyId+"");
//        }
//    catch(ClientErrorException e)
//        {
//            System.out.println(e.getMessage());
//        }
    }
       
    }

    

