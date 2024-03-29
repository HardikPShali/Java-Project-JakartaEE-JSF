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
 *        inquiryClient client = new inquiryClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Hardik
 */
public class inquiryClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/insurancehubSecure/webresources";

    public inquiryClient(String token) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
            client.register(new RestFilter(token));
        webTarget = client.target(BASE_URI).path("generic");
    }

    public void addinquiry_XML(Object requestEntity, String name, String email, String suminsured, String mobile, String totalmember, String pincode, String insuType) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addinquiry/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{name, email, suminsured, mobile, totalmember, pincode, insuType})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void addinquiry_JSON(Object requestEntity, String name, String email, String suminsured, String mobile, String totalmember, String pincode, String insuType) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addinquiry/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{name, email, suminsured, mobile, totalmember, pincode, insuType})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getAllinquiry_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getinquiry");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllinquiry_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getinquiry");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
