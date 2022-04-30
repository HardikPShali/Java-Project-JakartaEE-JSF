/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CDIBean;

import client.policyClient;
import client.tpiClient;
import entity.Policy;
import entity.TerminsuPi;
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
 * @author Hardik
 */
@Named(value = "termplansdisplayBean")
@RequestScoped
public class termplansdisplayBean {

policyClient pc;
    Response res;
       Collection<Policy> i;
   GenericType<Collection<Policy>> ig;
 Integer policyNo=100;

   
    public termplansdisplayBean() {
 
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

    public void setPc(policyClient pc) {
        this.pc = pc;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public Collection<Policy> getI() {
           GenericType<Collection<Policy>> ig = new GenericType<Collection<Policy>>(){};
        res = pc.findByPolicyNo_XML(Response.class, policyNo.toString());
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

    public Integer getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(Integer policyNo) {
        this.policyNo = policyNo;
    }


}
