/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CDIBean;

import client.CompanyClient;
import client.HospitalClient;
import client.insutypeClient;
import client.policyClient;
import client.taiClient;
import client.tpiClient;
import entity.CompReg;
import entity.Hospital;
import entity.Policy;
import entity.TerminsuPi;
import java.util.ArrayList;
import java.util.Collection;
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
@Named(value = "dashboardBean")
@RequestScoped
public class dashboardBean {
insutypeClient ic;
CompanyClient cc;
policyClient pc;
  HospitalClient client;
tpiClient tpc;
Response res;



  Collection<Policy> pol;
   GenericType<Collection<Policy>> gen_pol;
   
   Collection<CompReg> comp;
   GenericType<Collection<CompReg>> comp_add;
 
      Collection<Hospital> hp;
   GenericType<Collection<Hospital>> hp_add;
   
    Collection<TerminsuPi> tpi;
   GenericType<Collection<TerminsuPi>> tpi_add;
    public dashboardBean() {
           HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       String token="";

        token = request.getSession().getAttribute("token").toString();
       System.out.println("Token="+token);
        
        //String token1 = request.getHeader("Authorization").substring("Bearer ".length());
      // System.out.println("Token="+token);
        client=new HospitalClient(token);
         ic=new insutypeClient(token);
          cc=new CompanyClient(token);
           tpc=new tpiClient(token);
           pc=new policyClient(token);
           
           hp=new ArrayList<Hospital>();
            hp_add=new GenericType<Collection<Hospital>>(){};
            tpi=new ArrayList<TerminsuPi>();
            tpi_add=new GenericType<Collection<TerminsuPi>>(){};
            comp=new ArrayList<CompReg>();
            comp_add=new GenericType<Collection<CompReg>>(){};
            pol=new ArrayList<Policy>();
            gen_pol=new GenericType<Collection<Policy>>(){};
            hp=new ArrayList<Hospital>();
            hp_add=new GenericType<Collection<Hospital>>(){};
    }
    
}
