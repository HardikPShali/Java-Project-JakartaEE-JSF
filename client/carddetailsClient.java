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
 *        carddetailsClient client = new carddetailsClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Hardik
 */
public class carddetailsClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/insurancehubSecure/webresources";

    public carddetailsClient(String token) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        client.register(new RestFilter(token));
        webTarget = client.target(BASE_URI).path("generic");
    }

    public <T> T getlastpolIdadmin_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getlastpolIdadmin");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getlastpolIdadmin_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getlastpolIdadmin");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addTCD_XML(Object requestEntity, String termpiId, String paymentno, String name, String paymentMethod, String status, String amount, String date) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addTCD/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{termpiId, paymentno, name, paymentMethod, status, amount, date})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void addTCD_JSON(Object requestEntity, String termpiId, String paymentno, String name, String paymentMethod, String status, String amount, String date) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addTCD/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{termpiId, paymentno, name, paymentMethod, status, amount, date})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getlastTaiId_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getlastTaiId");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getlastTaiId_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getlastTaiId");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getHistory_XML(Class<T> responseType, String lid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("gethistory/{0}", new Object[]{lid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getHistory_JSON(Class<T> responseType, String lid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("gethistory/{0}", new Object[]{lid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getlastpolId_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getlastpolId");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getlastpolId_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getlastpolId");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateStatus_XML(Object requestEntity, String cid, String termpiId, String paymentno, String name, String paymentMethod, String status, String amount, String date) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateStatus/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{cid, termpiId, paymentno, name, paymentMethod, status, amount, date})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updateStatus_JSON(Object requestEntity, String cid, String termpiId, String paymentno, String name, String paymentMethod, String status, String amount, String date) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateStatus/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{cid, termpiId, paymentno, name, paymentMethod, status, amount, date})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getpaymentById_XML(Class<T> responseType, String cid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getpaymentById/{0}", new Object[]{cid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getpaymentById_JSON(Class<T> responseType, String cid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getpaymentById/{0}", new Object[]{cid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getLastcard_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getLastcard");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getLastcard_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getLastcard");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllTCDadmin_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllTCDadmin");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllTCDadmin_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllTCDadmin");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getHistorybyLid_XML(Class<T> responseType, String lid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("gethistoryLid/{0}", new Object[]{lid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getHistorybyLid_JSON(Class<T> responseType, String lid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("gethistoryLid/{0}", new Object[]{lid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllTCD_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getcard");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllTCD_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getcard");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
