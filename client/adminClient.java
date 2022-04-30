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
 *        adminClient client = new adminClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Hardik
 */
public class adminClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/project8/webresources";

    public adminClient(String token) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
         client.register(new RestFilter(token));
        webTarget = client.target(BASE_URI).path("generic");
    }

    public void updateInsutype_XML(Object requestEntity, String insuTypeId, String type) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateinsutype/{0}/{1}", new Object[]{insuTypeId, type})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updateInsutype_JSON(Object requestEntity, String insuTypeId, String type) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateinsutype/{0}/{1}", new Object[]{insuTypeId, type})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void removeInsutype(String insuTypeId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeInsutype/{0}", new Object[]{insuTypeId})).request().delete();
    }

    public void addInsutype_XML(Object requestEntity, String type) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addinsutype/{0}", new Object[]{type})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void addInsutype_JSON(Object requestEntity, String type) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addinsutype/{0}", new Object[]{type})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getAllTypes_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllTypes_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
