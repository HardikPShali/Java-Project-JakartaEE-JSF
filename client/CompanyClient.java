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
 *        CompanyClient client = new CompanyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Hardik
 */
public class CompanyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/insurancehubSecure/webresources";

    public CompanyClient(String token) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
         client.register(new RestFilter(token));
        webTarget = client.target(BASE_URI).path("generic");
    }

    public void removeComp(String compId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeComp/{0}", new Object[]{compId})).request().delete();
    }

    public void addComp_XML(Object requestEntity, String name, String address, String email, String website, String city, String pincode, String image, String contactno) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("createComp/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{name, address, email, website, city, pincode, image, contactno})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void addComp_JSON(Object requestEntity, String name, String address, String email, String website, String city, String pincode, String image, String contactno) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("createComp/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{name, address, email, website, city, pincode, image, contactno})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T databyisdelete_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getisdelete");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T databyisdelete_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getisdelete");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllcomps_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getcomp");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllcomps_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getcomp");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updatedelComp_XML(Object requestEntity, String compId, String name, String address, String email, String website, String city, String pincode, String image, String contactno, String isdelete) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateComp/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}", new Object[]{compId, name, address, email, website, city, pincode, image, contactno, isdelete})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updatedelComp_JSON(Object requestEntity, String compId, String name, String address, String email, String website, String city, String pincode, String image, String contactno, String isdelete) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateComp/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}", new Object[]{compId, name, address, email, website, city, pincode, image, contactno, isdelete})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T databyisdelete1_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getisdelete1");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T databyisdelete1_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getisdelete1");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T findBycompin_XML(Class<T> responseType, String pincode) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getcompin/{0}", new Object[]{pincode}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T findBycompin_JSON(Class<T> responseType, String pincode) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getcompin/{0}", new Object[]{pincode}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCompRegById_XML(Class<T> responseType, String compId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCompRegById/{0}", new Object[]{compId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getCompRegById_JSON(Class<T> responseType, String compId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCompRegById/{0}", new Object[]{compId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateComp_XML(Object requestEntity, String compId, String name, String address, String email, String website, String city, String pincode, String image, String contactno) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateComp/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}", new Object[]{compId, name, address, email, website, city, pincode, image, contactno})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updateComp_JSON(Object requestEntity, String compId, String name, String address, String email, String website, String city, String pincode, String image, String contactno) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateComp/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}", new Object[]{compId, name, address, email, website, city, pincode, image, contactno})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void close() {
        client.close();
    }
    
}
