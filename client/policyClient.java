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
 *        policyClient client = new policyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Hardik
 */
public class policyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/insurancehubSecure/webresources";

    public policyClient(String token) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
         client.register(new RestFilter(token));
        webTarget = client.target(BASE_URI).path("generic");
    }

    public <T> T findByPolicyNo_XML(Class<T> responseType, String policyNo) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getpolicybyNo/{0}", new Object[]{policyNo}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T findByPolicyNo_JSON(Class<T> responseType, String policyNo) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getpolicybyNo/{0}", new Object[]{policyNo}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getPolicyadmin_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getPolicyadmin");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getPolicyadmin_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getPolicyadmin");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T databyisdeletepol1_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getisdeletepol1");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T databyisdeletepol1_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getisdeletepol1");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T databyisdeletepol_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getisdeletepol");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T databyisdeletepol_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getisdeletepol");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getPolicy_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getpolicy");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getPolicy_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getpolicy");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllTypeById_XML(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllTypeById/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllTypeById_JSON(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllTypeById/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removePolicy(String policyId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deletePolicy/{0}", new Object[]{policyId})).request().delete();
    }

    public <T> T findBypolno_XML(Class<T> responseType, String policyNo) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findBypolno/{0}", new Object[]{policyNo}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T findBypolno_JSON(Class<T> responseType, String policyNo) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findBypolno/{0}", new Object[]{policyNo}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getallPolicybyNo_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getpolicybyNo");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getallPolicybyNo_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getpolicybyNo");
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

    public void addPolicy_XML(Object requestEntity, String policyNo, String name, String insuTypeId, String insuCompId, String issuedate, String validity, String noOfPerson, String totalAdult, String noOfSon, String noOfDaughter, String sumInsured, String cost) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addPolicy/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}", new Object[]{policyNo, name, insuTypeId, insuCompId, issuedate, validity, noOfPerson, totalAdult, noOfSon, noOfDaughter, sumInsured, cost})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void addPolicy_JSON(Object requestEntity, String policyNo, String name, String insuTypeId, String insuCompId, String issuedate, String validity, String noOfPerson, String totalAdult, String noOfSon, String noOfDaughter, String sumInsured, String cost) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addPolicy/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}", new Object[]{policyNo, name, insuTypeId, insuCompId, issuedate, validity, noOfPerson, totalAdult, noOfSon, noOfDaughter, sumInsured, cost})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void updatePolicy_XML(Object requestEntity, String policyId, String policyNo, String name, String insuTypeId, String insuCompId, String issuedate, String validity, String noOfPerson, String totalAdult, String noOfSon, String noOfDaughter, String sumInsured, String cost) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatePolicy/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}", new Object[]{policyId, policyNo, name, insuTypeId, insuCompId, issuedate, validity, noOfPerson, totalAdult, noOfSon, noOfDaughter, sumInsured, cost})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updatePolicy_JSON(Object requestEntity, String policyId, String policyNo, String name, String insuTypeId, String insuCompId, String issuedate, String validity, String noOfPerson, String totalAdult, String noOfSon, String noOfDaughter, String sumInsured, String cost) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatePolicy/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}", new Object[]{policyId, policyNo, name, insuTypeId, insuCompId, issuedate, validity, noOfPerson, totalAdult, noOfSon, noOfDaughter, sumInsured, cost})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getpolicyById_XML(Class<T> responseType, String policyId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getPolicyById/{0}", new Object[]{policyId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getpolicyById_JSON(Class<T> responseType, String policyId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getPolicyById/{0}", new Object[]{policyId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updatedelPolicy_XML(Object requestEntity, String policyId, String policyNo, String name, String insuTypeId, String insuCompId, String issuedate, String validity, String noOfPerson, String totalAdult, String noOfSon, String noOfDaughter, String sumInsured, String cost, String isdelete) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatedelPolicy/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}", new Object[]{policyId, policyNo, name, insuTypeId, insuCompId, issuedate, validity, noOfPerson, totalAdult, noOfSon, noOfDaughter, sumInsured, cost, isdelete})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updatedelPolicy_JSON(Object requestEntity, String policyId, String policyNo, String name, String insuTypeId, String insuCompId, String issuedate, String validity, String noOfPerson, String totalAdult, String noOfSon, String noOfDaughter, String sumInsured, String cost, String isdelete) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatedelPolicy/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}", new Object[]{policyId, policyNo, name, insuTypeId, insuCompId, issuedate, validity, noOfPerson, totalAdult, noOfSon, noOfDaughter, sumInsured, cost, isdelete})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }
 public <T> T findnpno_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getnpno");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T findnpno_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getnpno");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    public void close() {
        client.close();
    }
    
}
