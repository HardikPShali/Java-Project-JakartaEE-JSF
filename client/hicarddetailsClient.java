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
 *        hicarddetailsClient client = new hicarddetailsClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Hardik
 */
public class hicarddetailsClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/insurancehubSecure/webresources";

    public hicarddetailsClient(String token) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
          client.register(new RestFilter(token));
        webTarget = client.target(BASE_URI).path("generic");
    }

    public void removeInsutype(String insuTypeId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeInsutype/{0}", new Object[]{insuTypeId})).request().delete();
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

    public <T> T getmember_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getmember");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getmember_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getmember");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addHimember_XML(Object requestEntity, String hid, String membername, String dobm, String rtop, String height, String weight, String loginid, String isdelete, String insuCustId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addHimember/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}", new Object[]{hid, membername, dobm, rtop, height, weight, loginid, isdelete, insuCustId})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void addHimember_JSON(Object requestEntity, String hid, String membername, String dobm, String rtop, String height, String weight, String loginid, String isdelete, String insuCustId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addHimember/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}", new Object[]{hid, membername, dobm, rtop, height, weight, loginid, isdelete, insuCustId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
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

    public <T> T hhigetLastcard_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("higetLastcard");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T hhigetLastcard_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("higetLastcard");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
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

    public void addHi_XML(Object requestEntity, String policyId, String clientname, String gender, String mobileno, String emailid, String state, String city, String pincode, String plantype, String suminsured, String dobi, String height, String weight, String loginid, String isdelete, String insuCustId, String address) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addHi/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}/{15}/{16}", new Object[]{policyId, clientname, gender, mobileno, emailid, state, city, pincode, plantype, suminsured, dobi, height, weight, loginid, isdelete, insuCustId, address})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void addHi_JSON(Object requestEntity, String policyId, String clientname, String gender, String mobileno, String emailid, String state, String city, String pincode, String plantype, String suminsured, String dobi, String height, String weight, String loginid, String isdelete, String insuCustId, String address) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addHi/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}/{15}/{16}", new Object[]{policyId, clientname, gender, mobileno, emailid, state, city, pincode, plantype, suminsured, dobi, height, weight, loginid, isdelete, insuCustId, address})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void addTai_XML(Object requestEntity, String tid, String occupation, String weight, String heightf, String heighti, String mother, String father, String address, String isdelete, String loginid, String insuCustId, String isexpire) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addTai/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}", new Object[]{tid, occupation, weight, heightf, heighti, mother, father, address, isdelete, loginid, insuCustId, isexpire})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void addTai_JSON(Object requestEntity, String tid, String occupation, String weight, String heightf, String heighti, String mother, String father, String address, String isdelete, String loginid, String insuCustId, String isexpire) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addTai/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}", new Object[]{tid, occupation, weight, heightf, heighti, mother, father, address, isdelete, loginid, insuCustId, isexpire})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
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

    public void addinquiry_XML(Object requestEntity, String name, String email, String suminsured, String mobile, String totalmember, String pincode, String insuType) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addinquiry/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{name, email, suminsured, mobile, totalmember, pincode, insuType})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void addinquiry_JSON(Object requestEntity, String name, String email, String suminsured, String mobile, String totalmember, String pincode, String insuType) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addinquiry/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{name, email, suminsured, mobile, totalmember, pincode, insuType})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
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

    public void addPolicy_XML(Object requestEntity, String policyNo, String name, String insuTypeId, String insuCompId, String issuedate, String validity, String noOfPerson, String totalAdult, String noOfSon, String noOfDaughter, String sumInsured, String cost) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addPolicy/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}", new Object[]{policyNo, name, insuTypeId, insuCompId, issuedate, validity, noOfPerson, totalAdult, noOfSon, noOfDaughter, sumInsured, cost})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void addPolicy_JSON(Object requestEntity, String policyNo, String name, String insuTypeId, String insuCompId, String issuedate, String validity, String noOfPerson, String totalAdult, String noOfSon, String noOfDaughter, String sumInsured, String cost) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addPolicy/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}", new Object[]{policyNo, name, insuTypeId, insuCompId, issuedate, validity, noOfPerson, totalAdult, noOfSon, noOfDaughter, sumInsured, cost})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
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

    public void updatedelPolicy_XML(Object requestEntity, String policyId, String policyNo, String name, String insuTypeId, String insuCompId, String issuedate, String validity, String noOfPerson, String totalAdult, String noOfSon, String noOfDaughter, String sumInsured, String cost, String isdelete) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatedelPolicy/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}", new Object[]{policyId, policyNo, name, insuTypeId, insuCompId, issuedate, validity, noOfPerson, totalAdult, noOfSon, noOfDaughter, sumInsured, cost, isdelete})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updatedelPolicy_JSON(Object requestEntity, String policyId, String policyNo, String name, String insuTypeId, String insuCompId, String issuedate, String validity, String noOfPerson, String totalAdult, String noOfSon, String noOfDaughter, String sumInsured, String cost, String isdelete) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatedelPolicy/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}", new Object[]{policyId, policyNo, name, insuTypeId, insuCompId, issuedate, validity, noOfPerson, totalAdult, noOfSon, noOfDaughter, sumInsured, cost, isdelete})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
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

    public <T> T getAllHCD_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("higetcard");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllHCD_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("higetcard");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
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

    public void addhospital_XML(Object requestEntity, String name, String address, String emailid, String website, String city, String pincode, String image, String contactno) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addhospital/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{name, address, emailid, website, city, pincode, image, contactno})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void addhospital_JSON(Object requestEntity, String name, String address, String emailid, String website, String city, String pincode, String image, String contactno) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addhospital/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{name, address, emailid, website, city, pincode, image, contactno})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void updatedelComp_XML(Object requestEntity, String compId, String name, String address, String email, String website, String city, String pincode, String image, String contactno, String isdelete) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateComp/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}", new Object[]{compId, name, address, email, website, city, pincode, image, contactno, isdelete})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updatedelComp_JSON(Object requestEntity, String compId, String name, String address, String email, String website, String city, String pincode, String image, String contactno, String isdelete) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateComp/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}", new Object[]{compId, name, address, email, website, city, pincode, image, contactno, isdelete})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
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

    public void updateComp_XML(Object requestEntity, String compId, String name, String address, String email, String website, String city, String pincode, String image, String contactno) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateComp/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}", new Object[]{compId, name, address, email, website, city, pincode, image, contactno})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updateComp_JSON(Object requestEntity, String compId, String name, String address, String email, String website, String city, String pincode, String image, String contactno) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateComp/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}", new Object[]{compId, name, address, email, website, city, pincode, image, contactno})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
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

    public void updateTpi_XML(Object requestEntity, String id, String planId, String clientname, String gender, String lifestage, String bday, String mobile, String education, String smoke, String income, String cover, String coverage, String isdelete, String loginid, String insuCustId, String isexpire) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateTpi/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}/{15}", new Object[]{id, planId, clientname, gender, lifestage, bday, mobile, education, smoke, income, cover, coverage, isdelete, loginid, insuCustId, isexpire})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updateTpi_JSON(Object requestEntity, String id, String planId, String clientname, String gender, String lifestage, String bday, String mobile, String education, String smoke, String income, String cover, String coverage, String isdelete, String loginid, String insuCustId, String isexpire) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateTpi/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}/{15}", new Object[]{id, planId, clientname, gender, lifestage, bday, mobile, education, smoke, income, cover, coverage, isdelete, loginid, insuCustId, isexpire})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
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

    public <T> T getAllHimember_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("gethimem");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllHimember_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("gethimem");
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

    public void addTpi_XML(Object requestEntity, String planId, String clientname, String gender, String lifestage, String bday, String mobile, String education, String smoke, String income, String cover, String coverage, String isdelete, String loginid, String insuCustId, String isexpire) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addTpi/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}", new Object[]{planId, clientname, gender, lifestage, bday, mobile, education, smoke, income, cover, coverage, isdelete, loginid, insuCustId, isexpire})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void addTpi_JSON(Object requestEntity, String planId, String clientname, String gender, String lifestage, String bday, String mobile, String education, String smoke, String income, String cover, String coverage, String isdelete, String loginid, String insuCustId, String isexpire) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addTpi/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}", new Object[]{planId, clientname, gender, lifestage, bday, mobile, education, smoke, income, cover, coverage, isdelete, loginid, insuCustId, isexpire})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getlastmembers_XML(Class<T> responseType, String hid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getlastmembers/{0}", new Object[]{hid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getlastmembers_JSON(Class<T> responseType, String hid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getlastmembers/{0}", new Object[]{hid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllTypes_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getinsutype");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllTypes_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getinsutype");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeComp(String compId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeComp/{0}", new Object[]{compId})).request().delete();
    }

    public void addTCD_XML(Object requestEntity, String termpiId, String paymentno, String name, String paymentMethod, String status, String amount, String date) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addTCD/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{termpiId, paymentno, name, paymentMethod, status, amount, date})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void addTCD_JSON(Object requestEntity, String termpiId, String paymentno, String name, String paymentMethod, String status, String amount, String date) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addTCD/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{termpiId, paymentno, name, paymentMethod, status, amount, date})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void updateTai_XML(Object requestEntity, String aid, String tid, String occupation, String weight, String heightf, String heighti, String mother, String father, String address, String isdelete, String loginid, String insuCustId, String isexpire) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateTai/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}", new Object[]{aid, tid, occupation, weight, heightf, heighti, mother, father, address, isdelete, loginid, insuCustId, isexpire})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updateTai_JSON(Object requestEntity, String aid, String tid, String occupation, String weight, String heightf, String heighti, String mother, String father, String address, String isdelete, String loginid, String insuCustId, String isexpire) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateTai/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}", new Object[]{aid, tid, occupation, weight, heightf, heighti, mother, father, address, isdelete, loginid, insuCustId, isexpire})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
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

    public void deletehospital(String hospitalId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deletehospital/{0}", new Object[]{hospitalId})).request().delete();
    }

    public void updateHimember_XML(Object requestEntity, String memberid, String hid, String membername, String dobm, String rtop, String height, String weight, String loginid, String isdelete, String insuCustId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateHimember/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}", new Object[]{memberid, hid, membername, dobm, rtop, height, weight, loginid, isdelete, insuCustId})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updateHimember_JSON(Object requestEntity, String memberid, String hid, String membername, String dobm, String rtop, String height, String weight, String loginid, String isdelete, String insuCustId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateHimember/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}", new Object[]{memberid, hid, membername, dobm, rtop, height, weight, loginid, isdelete, insuCustId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getLoginById_XML(Class<T> responseType, String lid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getLoginById/{0}", new Object[]{lid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getLoginById_JSON(Class<T> responseType, String lid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getLoginById/{0}", new Object[]{lid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllHCDadmin_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllHCDadmin");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllHCDadmin_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllHCDadmin");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addComp_XML(Object requestEntity, String name, String address, String email, String website, String city, String pincode, String image, String contactno) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("createComp/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{name, address, email, website, city, pincode, image, contactno})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void addComp_JSON(Object requestEntity, String name, String address, String email, String website, String city, String pincode, String image, String contactno) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("createComp/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{name, address, email, website, city, pincode, image, contactno})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getInsuTypeById_XML(Class<T> responseType, String insuTypeId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getInsuTypeById/{0}", new Object[]{insuTypeId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getInsuTypeById_JSON(Class<T> responseType, String insuTypeId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getInsuTypeById/{0}", new Object[]{insuTypeId}));
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

    public void updatePolicy_XML(Object requestEntity, String policyId, String policyNo, String name, String insuTypeId, String insuCompId, String issuedate, String validity, String noOfPerson, String totalAdult, String noOfSon, String noOfDaughter, String sumInsured, String cost) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatePolicy/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}", new Object[]{policyId, policyNo, name, insuTypeId, insuCompId, issuedate, validity, noOfPerson, totalAdult, noOfSon, noOfDaughter, sumInsured, cost})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updatePolicy_JSON(Object requestEntity, String policyId, String policyNo, String name, String insuTypeId, String insuCompId, String issuedate, String validity, String noOfPerson, String totalAdult, String noOfSon, String noOfDaughter, String sumInsured, String cost) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatePolicy/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}", new Object[]{policyId, policyNo, name, insuTypeId, insuCompId, issuedate, validity, noOfPerson, totalAdult, noOfSon, noOfDaughter, sumInsured, cost})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void deleteHi(String hid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteHi/{0}", new Object[]{hid})).request().delete();
    }

    public void addInsutype_XML(Object requestEntity, String type) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addinsutype/{0}", new Object[]{type})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void addInsutype_JSON(Object requestEntity, String type) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addinsutype/{0}", new Object[]{type})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
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

    public void hiupdateStatus_XML(Object requestEntity, String cid, String hid, String paymentno, String name, String paymentMethod, String status, String amount, String date) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("hiupdateStatus/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{cid, hid, paymentno, name, paymentMethod, status, amount, date})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void hiupdateStatus_JSON(Object requestEntity, String cid, String hid, String paymentno, String name, String paymentMethod, String status, String amount, String date) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("hiupdateStatus/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{cid, hid, paymentno, name, paymentMethod, status, amount, date})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void deleteTpi(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteTpi/{0}", new Object[]{id})).request().delete();
    }

    public void addHCD_XML(Object requestEntity, String hid, String paymentno, String name, String paymentMethod, String status, String amount, String date) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addHCD/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{hid, paymentno, name, paymentMethod, status, amount, date})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void addHCD_JSON(Object requestEntity, String hid, String paymentno, String name, String paymentMethod, String status, String amount, String date) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addHCD/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{hid, paymentno, name, paymentMethod, status, amount, date})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
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

    public void updateInsutype_XML(Object requestEntity, String insuTypeId, String type) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateinsutype/{0}/{1}", new Object[]{insuTypeId, type})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updateInsutype_JSON(Object requestEntity, String insuTypeId, String type) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateinsutype/{0}/{1}", new Object[]{insuTypeId, type})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
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

    public void updateUser_XML(Object requestEntity, String lid, String roleId, String username, String emailid, String password) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateUser/{0}/{1}/{2}/{3}/{4}", new Object[]{lid, roleId, username, emailid, password})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updateUser_JSON(Object requestEntity, String lid, String roleId, String username, String emailid, String password) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateUser/{0}/{1}/{2}/{3}/{4}", new Object[]{lid, roleId, username, emailid, password})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void updatehospital_XML(Object requestEntity, String hospitalId, String name, String address, String emailid, String website, String city, String pincode, String image, String contactno) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatehospital/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}", new Object[]{hospitalId, name, address, emailid, website, city, pincode, image, contactno})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updatehospital_JSON(Object requestEntity, String hospitalId, String name, String address, String emailid, String website, String city, String pincode, String image, String contactno) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatehospital/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}", new Object[]{hospitalId, name, address, emailid, website, city, pincode, image, contactno})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
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

    public void deleteHimember(String memberid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteHimember/{0}", new Object[]{memberid})).request().delete();
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

    public void deleteTai(String aid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteTai/{0}", new Object[]{aid})).request().delete();
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

    public <T> T getlastHiId_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getlastHiId");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getlastHiId_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getlastHiId");
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

    public <T> T getAllHipolicy_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("gethi");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllHipolicy_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("gethi");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T higetpaymentById_XML(Class<T> responseType, String cid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("higetpaymentById/{0}", new Object[]{cid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T higetpaymentById_JSON(Class<T> responseType, String cid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("higetpaymentById/{0}", new Object[]{cid}));
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

    public <T> T gethealthinsuById_XML(Class<T> responseType, String hid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("gethealthinsuById/{0}", new Object[]{hid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T gethealthinsuById_JSON(Class<T> responseType, String hid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("gethealthinsuById/{0}", new Object[]{hid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
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

    public void updateHi_XML(Object requestEntity, String hid, String policyId, String clientname, String gender, String mobileno, String emailid, String state, String city, String pincode, String plantype, String suminsured, String dobi, String height, String weight, String loginid, String isdelete, String insuCustId, String address) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateHi/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}/{15}/{16}/{17}", new Object[]{hid, policyId, clientname, gender, mobileno, emailid, state, city, pincode, plantype, suminsured, dobi, height, weight, loginid, isdelete, insuCustId, address})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updateHi_JSON(Object requestEntity, String hid, String policyId, String clientname, String gender, String mobileno, String emailid, String state, String city, String pincode, String plantype, String suminsured, String dobi, String height, String weight, String loginid, String isdelete, String insuCustId, String address) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateHi/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}/{15}/{16}/{17}", new Object[]{hid, policyId, clientname, gender, mobileno, emailid, state, city, pincode, plantype, suminsured, dobi, height, weight, loginid, isdelete, insuCustId, address})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void close() {
        client.close();
    }
    
}
