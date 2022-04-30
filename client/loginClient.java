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
 *        loginClient client = new loginClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Hardik
 */
public class loginClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/insurancehubSecure/webresources";

    public loginClient(String token) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        client.register(new RestFilter(token));
        webTarget = client.target(BASE_URI).path("generic");
    }

    public void addUser_XML(Object requestEntity, String roleId, String username, String emailid, String password) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addUser/{0}/{1}/{2}/{3}", new Object[]{roleId, username, emailid, password})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void addUser_JSON(Object requestEntity, String roleId, String username, String emailid, String password) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addUser/{0}/{1}/{2}/{3}", new Object[]{roleId, username, emailid, password})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getuserById_XML(Class<T> responseType, String lid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getuserById/{0}", new Object[]{lid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getuserById_JSON(Class<T> responseType, String lid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getuserById/{0}", new Object[]{lid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllUser_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllUser");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllUser_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllUser");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateUser_XML(Object requestEntity, String lid, String roleId, String username, String emailid, String password) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateUser/{0}/{1}/{2}/{3}/{4}", new Object[]{lid, roleId, username, emailid, password})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updateUser_JSON(Object requestEntity, String lid, String roleId, String username, String emailid, String password) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateUser/{0}/{1}/{2}/{3}/{4}", new Object[]{lid, roleId, username, emailid, password})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getAllUserWiseEmail_XML(Class<T> responseType, String emailid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("displayEmail/{0}", new Object[]{emailid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllUserWiseEmail_JSON(Class<T> responseType, String emailid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("displayEmail/{0}", new Object[]{emailid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllUserByEmail_XML(Class<T> responseType, String emailid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("displayWiseEmail/{0}", new Object[]{emailid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllUserByEmail_JSON(Class<T> responseType, String emailid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("displayWiseEmail/{0}", new Object[]{emailid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
