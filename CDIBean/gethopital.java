/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CDIBean;

import client.HospitalClient;
import entity.Hospital;
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
@Named(value = "gethopital")
@RequestScoped
public class gethopital {
HospitalClient client;
     Response res;
      Collection<Hospital> h;
   GenericType<Collection<Hospital>> gh;
   
      Hospital hi;
   GenericType<Hospital> ghi;
    public gethopital() {
           HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       String token="";

        token = request.getSession().getAttribute("token").toString();
       System.out.println("Token="+token);
        
       client=new HospitalClient(token);
       
        h=new ArrayList<Hospital>();
            gh=new GenericType<Collection<Hospital>>(){};
//                  hi=new ArrayList<Hospital>();
//            ghi=new GenericType<Collection<Hospital>>(){};
    }

    public Hospital getHi() {
        return hi;
    }

    public void setHi(Hospital hi) {
        this.hi = hi;
    }

    public GenericType<Hospital> getGhi() {
        return ghi;
    }

    public void setGhi(GenericType<Hospital> ghi) {
        this.ghi = ghi;
    }

 

    public HospitalClient getClient() {
        return client;
    }

    public void setClient(HospitalClient client) {
        this.client = client;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public Collection<Hospital> getH() {
          res = client.getAllhospitalc_XML(Response.class);
       
        h = res.readEntity(gh);
        
        return h;
    }

    public void setH(Collection<Hospital> h) {
        this.h = h;
    }

    public GenericType<Collection<Hospital>> getGh() {
        return gh;
    }

    public void setGh(GenericType<Collection<Hospital>> gh) {
        this.gh = gh;
    }
        public String gethospital(Integer hospitalId) {
           hi = new  Hospital();
    
         ghi = new GenericType<Hospital>(){};
        res = client.getHospitalByhId_XML(Response.class, hospitalId.toString());
       hi = res.readEntity(ghi);
       

        return "hospitaldetails.jsf";
    }
}
