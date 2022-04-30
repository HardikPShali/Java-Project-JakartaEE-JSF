/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:GenericResource [generic]<br>
 * USAGE:
 * <pre>
 *        tpiClient client = new tpiClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Hardik
 */
public class tpiClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/insurancehubSecure/webresources";

    public tpiClient(String token) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        client.register(new RestFilter(token));
        webTarget = client.target(BASE_URI).path("generic");
    }

    public <T> T getTerminsuPiById_XML(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("gettermpiById/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getTerminsuPiById_JSON(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("gettermpiById/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllTpi_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("gettpi");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllTpi_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("gettpi");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateTpi_XML(Object requestEntity, String id, String planId, String clientname, String gender, String lifestage, String bday, String mobile, String education, String smoke, String income, String cover, String coverage, String isdelete, String loginid, String insuCustId, String isexpire) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateTpi/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}/{15}", new Object[]{id, planId, clientname, gender, lifestage, bday, mobile, education, smoke, income, cover, coverage, isdelete, loginid, insuCustId, isexpire})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updateTpi_JSON(Object requestEntity, String id, String planId, String clientname, String gender, String lifestage, String bday, String mobile, String education, String smoke, String income, String cover, String coverage, String isdelete, String loginid, String insuCustId, String isexpire) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateTpi/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}/{15}", new Object[]{id, planId, clientname, gender, lifestage, bday, mobile, education, smoke, income, cover, coverage, isdelete, loginid, insuCustId, isexpire})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getTerminsuPiBylId_XML(Class<T> responseType, String lid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("gettermpiBylId/{0}", new Object[]{lid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getTerminsuPiBylId_JSON(Class<T> responseType, String lid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("gettermpiBylId/{0}", new Object[]{lid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addTpi_XML(Object requestEntity, String planId, String clientname, String gender, String lifestage, String bday, String mobile, String education, String smoke, String income, String cover, String coverage, String isdelete, String loginid, String insuCustId, String isexpire) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addTpi/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}", new Object[]{planId, clientname, gender, lifestage, bday, mobile, education, smoke, income, cover, coverage, isdelete, loginid, insuCustId, isexpire})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void addTpi_JSON(Object requestEntity, String planId, String clientname, String gender, String lifestage, String bday, String mobile, String education, String smoke, String income, String cover, String coverage, String isdelete, String loginid, String insuCustId, String isexpire) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addTpi/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}", new Object[]{planId, clientname, gender, lifestage, bday, mobile, education, smoke, income, cover, coverage, isdelete, loginid, insuCustId, isexpire})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void deleteTpi(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteTpi/{0}", new Object[]{id})).request().delete();
    }

    public <T> T getlastTiId_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getlastTiId");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getlastTiId_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getlastTiId");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
