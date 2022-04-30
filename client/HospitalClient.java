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
 *        HospitalClient client = new HospitalClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Hardik
 */
public class HospitalClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/insurancehubSecure/webresources";

    public HospitalClient(String token) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        client.register(new RestFilter(token));
        webTarget = client.target(BASE_URI).path("generic");
    }

    public void addhospital_XML(Object requestEntity, String name, String address, String emailid, String website, String city, String pincode, String image, String contactno) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addhospital/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{name, address, emailid, website, city, pincode, image, contactno})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void addhospital_JSON(Object requestEntity, String name, String address, String emailid, String website, String city, String pincode, String image, String contactno) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addhospital/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{name, address, emailid, website, city, pincode, image, contactno})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getHospitalByhid_XML(Class<T> responseType, String hospitalId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getHospitalByhid/{0}", new Object[]{hospitalId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getHospitalByhid_JSON(Class<T> responseType, String hospitalId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getHospitalByhid/{0}", new Object[]{hospitalId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getHospitalByhId_XML(Class<T> responseType, String hospitalId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getHospitalByhId/{0}", new Object[]{hospitalId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getHospitalByhId_JSON(Class<T> responseType, String hospitalId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getHospitalByhId/{0}", new Object[]{hospitalId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getHospitalById_XML(Class<T> responseType, String hospitalId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getHospitalById/{0}", new Object[]{hospitalId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getHospitalById_JSON(Class<T> responseType, String hospitalId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getHospitalById/{0}", new Object[]{hospitalId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updatehospital_XML(Object requestEntity, String hospitalId, String name, String address, String emailid, String website, String city, String pincode, String image, String contactno) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatehospital/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}", new Object[]{hospitalId, name, address, emailid, website, city, pincode, image, contactno})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updatehospital_JSON(Object requestEntity, String hospitalId, String name, String address, String emailid, String website, String city, String pincode, String image, String contactno) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatehospital/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}", new Object[]{hospitalId, name, address, emailid, website, city, pincode, image, contactno})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getAllhospital_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("gethospital");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllhospital_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("gethospital");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deletehospital(String hospitalId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deletehospital/{0}", new Object[]{hospitalId})).request().delete();
    }

    public <T> T getAllhospitalc_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("gethospitalc");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllhospitalc_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("gethospitalc");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
