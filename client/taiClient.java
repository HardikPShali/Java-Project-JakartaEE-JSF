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
 *        taiClient client = new taiClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Hardik
 */
public class taiClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/project8/webresources";

    public taiClient(String token) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
         client.register(new RestFilter(token));
        webTarget = client.target(BASE_URI).path("generic");
    }

    public <T> T getAllTai_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("gettai");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllTai_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("gettai");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateTai_XML(Object requestEntity, String aid, String tid, String occupation, String weight, String heightf, String heighti, String mother, String father, String address, String isdelete, String loginid, String insuCustId, String isexpire) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateTai/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}", new Object[]{aid, tid, occupation, weight, heightf, heighti, mother, father, address, isdelete, loginid, insuCustId, isexpire})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updateTai_JSON(Object requestEntity, String aid, String tid, String occupation, String weight, String heightf, String heighti, String mother, String father, String address, String isdelete, String loginid, String insuCustId, String isexpire) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateTai/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}", new Object[]{aid, tid, occupation, weight, heightf, heighti, mother, father, address, isdelete, loginid, insuCustId, isexpire})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getlastTpiId_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getlastTpiId");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getlastTpiId_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getlastTpiId");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addTai_XML(Object requestEntity, String tid, String occupation, String weight, String heightf, String heighti, String mother, String father, String address, String isdelete, String loginid, String insuCustId, String isexpire) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addTai/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}", new Object[]{tid, occupation, weight, heightf, heighti, mother, father, address, isdelete, loginid, insuCustId, isexpire})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void addTai_JSON(Object requestEntity, String tid, String occupation, String weight, String heightf, String heighti, String mother, String father, String address, String isdelete, String loginid, String insuCustId, String isexpire) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addTai/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}", new Object[]{tid, occupation, weight, heightf, heighti, mother, father, address, isdelete, loginid, insuCustId, isexpire})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void deleteTai(String aid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteTai/{0}", new Object[]{aid})).request().delete();
    }

    public void close() {
        client.close();
    }
    
}
