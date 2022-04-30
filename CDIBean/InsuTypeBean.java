/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CDIBean;

import client.insutypeClient;
import entity.InsuType;
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
@Named(value = "insuTypeBean")
@RequestScoped
public class InsuTypeBean {
insutypeClient client;
     Response res;
        Collection<InsuType> itype;
   GenericType<Collection<InsuType>> insutype_add;
   int insutype;
   String type;

   
    public insutypeClient getClient() {
        return client;
    }

    public int getInsutype() {
        return insutype;
    }

    public void setInsutype(int insutype) {
        this.insutype = insutype;
    }

    public void setClient(insutypeClient client) {
        this.client = client;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public Collection<InsuType> getItype() {
         res = client.getAllTypes_XML(Response.class);
        System.out.println(res);
        itype = res.readEntity(insutype_add);
        System.out.println(itype);
       
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

    public String getType() {
        return type;
    }

    /**
     * Creates a new instance of InsuTypeBean
     * @param type
     */
    public void setType(String type) {   
        this.type = type;
    }

    public InsuTypeBean() {
       
              HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       String token="";

        token = request.getSession().getAttribute("token").toString();
       System.out.println("Token="+token);
        
        client=new insutypeClient(token);
           
       itype=new ArrayList<InsuType>();
        insutype_add=new GenericType<Collection<InsuType>>(){};
    }
      public void addInsuType()
    {
        try
        {
        client.addInsutype_JSON(new InsuType(),type);
        FacesContext.getCurrentInstance().getExternalContext().redirect("viewinsutype.jsf");
        }
    catch(IOException | ClientErrorException e)
        {
            System.out.println(e.getMessage());
        }
    }
       public void removetype(int insuTypeId)
    {
         try
        {
        client.removeInsutype(insuTypeId+"");
        }
    catch(ClientErrorException e)
        {
            System.out.println(e.getMessage());
        }
    }
//        public String removetype(Integer insuTypeId){
//        client.removeInsutype(insuTypeId.toString());
//        return "viewinsutype?faces-redirect=true";
//    }
       
           public String edit_click(Integer insutype){
        InsuType it = new InsuType();
        GenericType<InsuType> grr = new GenericType<InsuType>(){};
        res = client.getInsuTypeById_XML(Response.class, insutype.toString());
        it = res.readEntity(grr);
        type = it.getType();
        this.insutype=it.getInsuTypeId();
        return "updateinsutype.xhtml";
    }
    
  public String updateInsutype(){
        client.updateInsutype_JSON(new InsuType(), insutype+"", type);
        return "viewinsutype?faces-redirect=true";
    }
    
}
