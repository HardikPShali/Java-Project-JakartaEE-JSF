/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.adminBeanLocal;
import ejb.clientBeanLocal;

import entity.CompReg;
import entity.Feedback;
import entity.HealthInsu;
import entity.Hicarddetails;
import entity.Himember;
import entity.Hospital;
import entity.Inquiry;
import entity.InsuType;
import entity.Login;
import entity.Policy;
import entity.Termcarddetails;
import entity.TerminsuAi;
import entity.TerminsuPi;
import java.util.Collection;
import java.util.Date;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Hardik
 */
@Path("generic")
@DeclareRoles({"Admin","User"})
@RequestScoped
public class GenericResource {
@EJB adminBeanLocal asb;
@EJB clientBeanLocal csb;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of rest.GenericResource
     * @return an instance of java.lang.String
     */
    
    //Login
         @GET
    @Path("getLoginById/{lid}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Login getLoginById(@PathParam("lid") Integer lid){
        return asb.getLoginById(lid);
    }
       @RolesAllowed("Admin,User")
    @GET
   @Path("getAllUser")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    
       //TODO return proper representation object
         public Collection<Login> getAllUser() {
        Collection<Login> l = asb.getAllUser();
      return l;
       
    
}   
    @RolesAllowed("Admin,User")
     @POST
     @Path("addUser/{roleId}/{username}/{emailid}/{password}")
      @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addUser(@PathParam("roleId") int roleId,@PathParam("username") String username,@PathParam("emailid") String emailid,@PathParam("password") String password) {     
  
asb.addUser(roleId, username, emailid, password);   
    }
        @RolesAllowed("User")
     @POST
     @Path("updateUser/{lid}/{roleId}/{username}/{emailid}/{password}")
      @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateUser(@PathParam("lid") int lid,@PathParam("roleId") int roleId,@PathParam("username") String username,@PathParam("emailid") String emailid,@PathParam("password") String password) {     
  
asb.updateUser(lid,roleId, username, emailid, password);   
    }
    @RolesAllowed("Admin,User")
            @GET
    @Path("displayWiseEmail/{emailid}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Collection<Login> getAllUserByEmail(@PathParam("emailid") String emailid){
         Collection<Login> UserWiseEmail = asb.getAllUserByEmail(emailid);
        return UserWiseEmail;
    } 
    @RolesAllowed("Admin,User")
     @GET
      @Path("displayEmail/{emailid}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Login getAllUserWiseEmail(@PathParam("emailid") String emailid){
         Login l = (Login) asb.getAllUserWiseEmail(emailid);
        return l;
    }
          
 @GET
    @Path("getuserById/{lid}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Login getuserById(@PathParam("lid") Integer lid){
        return asb.getLoginById(lid);
    }
  
  
    
    //Company
    @RolesAllowed("Admin")
    @GET
   @Path("getcomp")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    
       //TODO return proper representation object
         public Collection<CompReg> getAllcomps() {
        Collection<CompReg> comp = asb.getAllcomps();
      return comp;
       
    
}   
         @RolesAllowed("Admin")
 @GET
    @Path("getCompRegById/{compId}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public CompReg getCompRegById(@PathParam("compId") Integer compId){
        return asb.getCompRegById(compId);
    }
    @RolesAllowed("Admin")
   @POST
   
     @Path("createComp/{name}/{address}/{email}/{website}/{city}/{pincode}/{image}/{contactno}")
     @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addComp(@PathParam("name") String name, @PathParam("address")String address,@PathParam("email") String email,@PathParam("website") String website,@PathParam("city") String city,@PathParam("pincode") Integer pincode,@PathParam("image") String image,@PathParam("contactno") long contactno) {

asb.addComp(name, address, email, website, city, pincode, image, contactno);
    }
@RolesAllowed("Admin")
    @PUT
     @Path("updateComp/{compId}/{name}/{address}/{email}/{website}/{city}/{pincode}/{image}/{contactno}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateComp(@PathParam("compId") Integer compId,@PathParam("name") String name, @PathParam("address")String address,@PathParam("email") String email,@PathParam("website") String website,@PathParam("city") String city,@PathParam("pincode") Integer pincode,@PathParam("image") String image,@PathParam("contactno") long contactno) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  asb.updateComp(compId,name, address, email, website, city, pincode, image, contactno);

    }
    @RolesAllowed("Admin")
@DELETE

@Path("removeComp/{compId}")
    
    public void removeComp(@PathParam("compId") Integer compId) {
   
    asb.removeComp(compId);
    }
    @RolesAllowed("Admin")
        @PUT
     @Path("updateComp/{compId}/{name}/{address}/{email}/{website}/{city}/{pincode}/{image}/{contactno}/{isdelete}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updatedelComp(@PathParam("compId") Integer compId,@PathParam("name") String name, @PathParam("address")String address,@PathParam("email") String email,@PathParam("website") String website,@PathParam("city") String city,@PathParam("pincode") Integer pincode,@PathParam("image") String image,@PathParam("contactno") long contactno,@PathParam("isdelete") Integer isdelete) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  asb.updatedelComp(compId,name, address, email, website, city, pincode, image, contactno,isdelete);

    }
    @RolesAllowed("Admin")
       @GET
    @Path("getisdelete")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
       public Collection<CompReg> databyisdelete(){
            Collection<CompReg> c = asb.databyisdelete();
      return c;  
       
       }
       @RolesAllowed("Admin")
                @GET
    @Path("getisdelete1")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
       public Collection<CompReg> databyisdelete1(){
            Collection<CompReg> c = asb.databyisdelete1();
      return c;  
       
       }
       @RolesAllowed("Admin")
         @GET
    @Path("getcompin/{pincode}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
   
       public Collection<CompReg> findBycompin(@PathParam("pincode") Integer pincode){
        return asb.findByCompin(pincode);
       }
    //Insutype
    @RolesAllowed("Admin")
        @GET
        @Path("getinsutype")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
       //TODO return proper representation object
         public Collection<InsuType> getAllTypes() {
        Collection<InsuType> type = asb.getAllTypes();
      return type;
         }
         @RolesAllowed("Admin")
             @GET
    @Path("getInsuTypeById/{insuTypeId}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public InsuType getInsuTypeById(@PathParam("insuTypeId") Integer insuTypeId){
        return asb.getInsuTypeById(insuTypeId);
    }
    @RolesAllowed("Admin")
           @POST
     @Path("addinsutype/{type}")
     @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addInsutype(@PathParam("type") String type) {

asb.addInsutype(type);
    }
    @RolesAllowed("Admin")
     @PUT
     @Path("updateinsutype/{insuTypeId}/{type}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateInsutype(@PathParam("insuTypeId") Integer insuTypeId,@PathParam("type") String type) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  asb.updateInsutype(insuTypeId,type);

    }
    @RolesAllowed("Admin")
     @DELETE

@Path("removeInsutype/{insuTypeId}")
    
    public void removeInsutype(@PathParam("insuTypeId") Integer insuTypeId) {
   
    asb.removeInsutype(insuTypeId);
    }

    
    
    //Policy
   @RolesAllowed("Admin,User")
     @GET
     @Path("getpolicy")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Collection<Policy> getPolicy() {
        Collection<Policy> pol = asb.getAllPolicy();
      return pol;    
       }
    @RolesAllowed("Admin")
     @GET
     @Path("getPolicyadmin")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Collection<Policy> getPolicyadmin() {
        Collection<Policy> pol = asb.getAllPolicy();
      return pol;    
       }
    @RolesAllowed("Admin")
       @GET
     @Path("getpolicybyNo")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Collection<Policy> getallPolicybyNo() {
        Collection<Policy> pol = asb.getPolicybyNo();
      return pol;    
       }
    @RolesAllowed("Admin")
        @GET
    @Path("getisdeletepol")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
       public Collection<Policy> databyisdeletepol(){
            Collection<Policy> c = asb.databyisdeletepol();
      return c;  
       
       }
       @RolesAllowed("Admin")
                @GET
    @Path("getisdeletepol1")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
       public Collection<Policy> databyisdeletepol1(){
            Collection<Policy> c = asb.databyisdeletepol1();
      return c;  
       
       }
       @RolesAllowed("Admin")
         @GET
    @Path("findBypolno/{policyNo}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
   
       public Collection<Policy> findBypolno(@PathParam("policyNo") Integer policyNo){
        return asb.findBypolno(policyNo);
       }
       @RolesAllowed("Admin")
             @PUT
     @Path("updatedelPolicy/{policyId}/{policyNo}/{name}/{insuTypeId}/{insuCompId}/{issuedate}/{validity}/{noOfPerson}/{totalAdult}/{noOfSon}/{noOfDaughter}/{sumInsured}/{cost}/{isdelete}")
      @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updatedelPolicy(@PathParam("policyId") int policyId,@PathParam("policyNo") int policyNo,@PathParam("name") String name,@PathParam("insuTypeId") int insuTypeId,@PathParam("insuCompId") int insuCompId,@PathParam("issuedate") String issuedate,@PathParam("validity") String validity,@PathParam("noOfPerson") int noOfPerson,@PathParam("totalAdult") int totalAdult,@PathParam("noOfSon") int noOfSon,@PathParam("noOfDaughter") int noOfDaughter,@PathParam("sumInsured") int sumInsured,@PathParam("cost") String cost,@PathParam("isdelete") int isdelete) {     
  
asb.updatedelPolicy(policyId,policyNo,name,insuTypeId,insuCompId,issuedate,validity,noOfPerson,totalAdult,noOfSon,noOfDaughter,sumInsured,cost,isdelete);
    }
   @RolesAllowed("Admin,User")
    @GET
     @Path("getAllTypeById/{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Policy getAllTypeById(@PathParam("id") int id) {
        
      return asb.getAllTypeById(id);    
       }
    @RolesAllowed("Admin")
              @GET
    @Path("getPolicyById/{policyId}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Policy getpolicyById(@PathParam("policyId") Integer policyId){
        return asb.getPolicyById(policyId);
    }
     @RolesAllowed("User")
        @GET
    @Path("getnpno")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Collection<Policy> findnpno() {
        Collection<Policy> pol = asb.findpno();
      return pol;    
       }
    @RolesAllowed("User")
    @GET
    @Path("getpolicybyNo/{policyNo}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
   
       public Collection<Policy> findByPolicyNo(@PathParam("policyNo") Integer policyNo){
        return asb.findByPolicyNo(policyNo);
       }
       @RolesAllowed("Admin")
     @POST
     @Path("addPolicy/{policyNo}/{name}/{insuTypeId}/{insuCompId}/{issuedate}/{validity}/{noOfPerson}/{totalAdult}/{noOfSon}/{noOfDaughter}/{sumInsured}/{cost}")
      @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addPolicy(@PathParam("policyNo") int policyNo,@PathParam("name") String name,@PathParam("insuTypeId") int insuTypeId,@PathParam("insuCompId") int insuCompId,@PathParam("issuedate") String issuedate,@PathParam("validity") String validity,@PathParam("noOfPerson") int noOfPerson,@PathParam("totalAdult") int totalAdult,@PathParam("noOfSon") int noOfSon,@PathParam("noOfDaughter") int noOfDaughter,@PathParam("sumInsured") int sumInsured,@PathParam("cost") String cost) {     
  
asb.addPolicy(policyNo,name,insuTypeId,insuCompId,issuedate,validity,noOfPerson,totalAdult,noOfSon,noOfDaughter,sumInsured,cost);
    }
    
  @RolesAllowed("Admin")
    @PUT
     @Path("updatePolicy/{policyId}/{policyNo}/{name}/{insuTypeId}/{insuCompId}/{issuedate}/{validity}/{noOfPerson}/{totalAdult}/{noOfSon}/{noOfDaughter}/{sumInsured}/{cost}")
      @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updatePolicy(@PathParam("policyId") int policyId,@PathParam("policyNo") int policyNo,@PathParam("name") String name,@PathParam("insuTypeId") int insuTypeId,@PathParam("insuCompId") int insuCompId,@PathParam("issuedate") String issuedate,@PathParam("validity") String validity,@PathParam("noOfPerson") int noOfPerson,@PathParam("totalAdult") int totalAdult,@PathParam("noOfSon") int noOfSon,@PathParam("noOfDaughter") int noOfDaughter,@PathParam("sumInsured") int sumInsured,@PathParam("cost") String cost) {     
  
asb.updatePolicy(policyId,policyNo,name,insuTypeId,insuCompId,issuedate,validity,noOfPerson,totalAdult,noOfSon,noOfDaughter,sumInsured,cost);
    }
    @RolesAllowed("Admin,User")
    @DELETE
    @Path("deletePolicy/{policyId}")
    public void removePolicy(@PathParam("policyId") Integer policyId) {
    
    asb.deletePolicy(policyId);
    }
    
    
   //hospital
    @RolesAllowed("Admin")
    
        @GET
         @Path("gethospital")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
       //TODO return proper representation object
         public Collection<Hospital> getAllhospital() {
        Collection<Hospital> host = asb.getAllhospital();
      return host;
}
          @RolesAllowed("User")
                 @GET
         @Path("gethospitalc")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
       //TODO return proper representation object
         public Collection<Hospital> getAllhospitalc() {
        Collection<Hospital> host = asb.getAllhospital();
      return host;
}
         @RolesAllowed("Admin")
                   @GET
    @Path("getHospitalById/{hospitalId}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Hospital getHospitalById(@PathParam("hospitalId") Integer hospitalId){
        return asb.getHospitalById(hospitalId);
    }
          @RolesAllowed("User")
                   @GET
    @Path("getHospitalByhid/{hospitalId}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Collection<Hospital> getHospitalByhid(@PathParam("hospitalId") Integer hospitalId){
        return asb.getHospitalByhid(hospitalId);
    }
    @RolesAllowed("User")
    @GET
    @Path("getHospitalByhId/{hospitalId}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Hospital getHospitalByhId(@PathParam("hospitalId") Integer hospitalId){
        Hospital p = asb.getHospitalByhId(hospitalId);
        return p;
    }
    @RolesAllowed("Admin")
         @POST
     @Path("addhospital/{name}/{address}/{emailid}/{website}/{city}/{pincode}/{image}/{contactno}")
     @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addhospital(@PathParam("name") String name, @PathParam("address")String address,
            @PathParam("emailid") String emailid,@PathParam("website") String website
            ,@PathParam("city") String city,@PathParam("pincode") int pincode
            ,@PathParam("image") String image,@PathParam("contactno") long contactno) {

asb.addhospital( name, address, emailid, website, city, pincode, image, contactno);
    }
    @RolesAllowed("Admin")
    @PUT
     @Path("updatehospital/{hospitalId}/{name}/{address}/{emailid}/{website}/{city}/{pincode}/{image}/{contactno}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updatehospital(@PathParam("hospitalId") Integer hospitalId,@PathParam("name") String name, @PathParam("address")String address,@PathParam("emailid") String emailid,@PathParam("website") String website,@PathParam("city") String city,@PathParam("pincode") Integer pincode,@PathParam("image") String image,@PathParam("contactno") long contactno) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  asb.updatehospital(hospitalId,name, address, emailid, website, city, pincode, image, contactno);

    }
    @RolesAllowed("Admin")
    @DELETE

@Path("deletehospital/{hospitalId}")
    
    public void deletehospital(@PathParam("hospitalId") Integer hospitalId) {
   
    asb.deletehospital(hospitalId);
    }
//    @RolesAllowed("User")
     //HealthInsu
     @GET
     @Path("gethi")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Collection<HealthInsu> getAllHipolicy() {
        Collection<HealthInsu> hi = csb.getAllHipolicy();
      return hi;    
       }
    @RolesAllowed("User")
    @POST
     @Path("addHi/{policyId}/{clientname}/{gender}/{mobileno}/{emailid}/{state}/{city}/{pincode}/{plantype}/{suminsured}/{dobi}/{height}/{weight}/{loginid}/{isdelete}/{insuCustId}/{address}")
      @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addHi(@PathParam("policyId") int policyId,@PathParam("clientname") String clientname,
            @PathParam("gender") String gender,@PathParam("mobileno") long mobileno,
            @PathParam("emailid") String emailid,@PathParam("state") String state,
            @PathParam("city") String city,@PathParam("pincode") String pincode,@PathParam("plantype") String plantype,
            @PathParam("suminsured") float suminsured,@PathParam("dobi") String dobi,
            @PathParam("height") String height,@PathParam("weight") float weight,
            @PathParam("loginid") int loginid,@PathParam("isdelete") int isdelete,
            @PathParam("insuCustId") String insuCustId,@PathParam("address") String address) {     
  
csb.addHi(policyId,clientname,gender,mobileno,emailid,state,city,pincode,plantype,suminsured,dobi,height,weight,loginid,isdelete,insuCustId,address);
    } 
    @RolesAllowed("User")
    @PUT
     @Path("updateHi/{hid}/{policyId}/{clientname}/{gender}/{mobileno}/{emailid}/{state}/{city}/{pincode}/{plantype}/{suminsured}/{dobi}/{height}/{weight}/{loginid}/{isdelete}/{insuCustId}/{address}")
      @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateHi(@PathParam("hid") int hid,@PathParam("policyId") int policyId,@PathParam("clientname") String clientname,
            @PathParam("gender") String gender,@PathParam("mobileno") long mobileno,
            @PathParam("emailid") String emailid,@PathParam("state") String state,
            @PathParam("city") String city,@PathParam("pincode") String pincode,@PathParam("plantype") String plantype,
            @PathParam("suminsured") float suminsured,@PathParam("dobi") String dobi,
            @PathParam("height") String height,@PathParam("weight") float weight,
            @PathParam("loginid") int loginid,@PathParam("isdelete") int isdelete,
            @PathParam("insuCustId") String insuCustId,@PathParam("address") String address) {     
  
csb.updateHi(hid,policyId,clientname,gender,mobileno,emailid,state,city,pincode,plantype,suminsured,dobi,height,weight,loginid,isdelete,insuCustId,address);
    } 
    @RolesAllowed("User")
          @GET
    @Path("getlastHiId")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
       public Collection<HealthInsu> getlastHiId(){
            Collection<HealthInsu> hi = csb.getmemberById();
      return hi;  
       
       }
       @RolesAllowed("User")
    @DELETE
    @Path("deleteHi/{hid}")
    public void deleteHi(@PathParam("hid") Integer hid) {
    
    csb.deleteHi(hid);
    }
    
    @RolesAllowed("User")
    //himember table
    
     @GET
     @Path("gethimem")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Collection<Himember> getAllHimember() {
        Collection<Himember> hm = csb.getAllHimember();
      return hm;    
       }
    @RolesAllowed("User")
     @GET
    @Path("getlastmembers/{hid}")
   @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Collection<Himember> getlastmembers(@PathParam("hid") int hid){
        Collection<Himember> getlastmembers = csb.getlastmembers(hid);
        return getlastmembers;
    }
    @RolesAllowed("User")
          @GET
    @Path("getmember")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
       public Collection<Himember> getmember(){
            Collection<Himember> m= csb.getmember();
      return m;  
       
       }
      @RolesAllowed("User")
     @POST
     @Path("addHimember/{hid}/{membername}/{dobm}/{rtop}/{height}/{weight}/{loginid}/{isdelete}/{insuCustId}")
      @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addHimember(@PathParam("hid") int hid,@PathParam("membername") String membername,
            @PathParam("dobm") String dobm,@PathParam("rtop") String rtop,
            @PathParam("height") String height,@PathParam("weight") String weight,
            @PathParam("loginid") int loginid,@PathParam("isdelete") int isdelete,
            @PathParam("insuCustId") String insuCustId) {     
  
csb.addHimember(hid,membername,dobm,rtop,height,weight,loginid,isdelete,insuCustId);
    } 
    @RolesAllowed("User")
    @PUT
     @Path("updateHimember/{memberid}/{hid}/{membername}/{dobm}/{rtop}/{height}/{weight}/{loginid}/{isdelete}/{insuCustId}")
      @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateHimember(@PathParam("memberid") int memberid,@PathParam("hid") int hid,@PathParam("membername") String membername,
            @PathParam("dobm") String dobm,@PathParam("rtop") String rtop,
            @PathParam("height") String height,@PathParam("weight") String weight,
            @PathParam("loginid") int loginid,@PathParam("isdelete") int isdelete,
            @PathParam("insuCustId") String insuCustId) {     
  
csb.updateHimember(memberid,hid,membername,dobm,rtop,height,weight,loginid,isdelete,insuCustId);
    } 
    @RolesAllowed("User")
    @DELETE
    @Path("deleteHimember/{memberid}")
    public void deleteHimember(@PathParam("memberid") Integer memberid) {
    
    csb.deleteHimember(memberid);
    }
    //terminsu pi
//    @RolesAllowed("User")
     @GET
     @Path("gettpi")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Collection<TerminsuPi> getAllTpi() {
        Collection<TerminsuPi> tpi = csb.getAllTpi();
      return tpi;    
       }
//    @RolesAllowed("User")
     @GET
    @Path("gettermpiById/{id}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public TerminsuPi getTerminsuPiById(@PathParam("id") Integer id){
        return csb.getTerminsuPiById(id);
    }
//       @RolesAllowed("User")
//     @GET
//    @Path("gettermpiBylId/{lid}")
//    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
//    public TerminsuPi getTerminsuPiBylId(@PathParam("lid") Integer lid){
//        return csb.getTerminsuPiBylId(lid);
//    }
//    @RolesAllowed("User")
       @GET
    @Path("getlastTiId")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
       public Collection<TerminsuPi> getlastTiId(){
            Collection<TerminsuPi> tpi = csb.getTpiById();
      return tpi;  
       
       }
       @RolesAllowed("User")
    @POST
     @Path("addTpi/{planId}/{clientname}/{gender}/{lifestage}/{bday}/{mobile}/{education}/{smoke}"
             + "/{income}/{cover}/{coverage}/{isdelete}/{loginid}/{insuCustId}/{isexpire}")
      @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addTpi(@PathParam("planId") int planId,@PathParam("clientname") String clientname,
            @PathParam("gender") String gender,@PathParam("lifestage") String lifestage,
            @PathParam("bday") String bday,@PathParam("mobile") long mobile,
            @PathParam("education") String education,@PathParam("smoke") String smoke,
            @PathParam("income") String income,@PathParam("cover") String cover,
            @PathParam("coverage") String coverage,@PathParam("isdelete") int isdelete,
            @PathParam("loginid") int loginid,@PathParam("insuCustId") String insuCustId,
            @PathParam("isexpire") int isexpire) {     
  
csb.addTpi(planId,clientname,gender,lifestage,bday,mobile,education,smoke,income,cover,coverage,isdelete,loginid,
        insuCustId,isexpire);
    } 
    @RolesAllowed("User")
    @PUT
     @Path("updateTpi/{id}/{planId}/{clientname}/{gender}/{lifestage}/{bday}/{mobile}/{education}/{smoke}"
             + "/{income}/{cover}/{coverage}/{isdelete}/{loginid}/{insuCustId}/{isexpire}")
      @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateTpi(@PathParam("id") int id,@PathParam("planId") int planId,@PathParam("clientname") String clientname,
            @PathParam("gender") String gender,@PathParam("lifestage") String lifestage,
            @PathParam("bday") String bday,@PathParam("mobile") long mobile,
            @PathParam("education") String education,@PathParam("smoke") String smoke,
            @PathParam("income") String income,@PathParam("cover") String cover,
            @PathParam("coverage") String coverage,@PathParam("isdelete") int isdelete,
            @PathParam("loginid") int loginid,@PathParam("insuCustId") String insuCustId,
            @PathParam("isexpire") int isexpire) {     
  
csb.updateTpi(id,planId,clientname,gender,lifestage,bday,mobile,education,smoke,income,cover,coverage,isdelete,loginid,
        insuCustId,isexpire);
    } 
    @RolesAllowed("User")
    @DELETE
    @Path("deleteTpi/{id}")
    public void deleteTpi(@PathParam("id") Integer id) {
    
    csb.deleteTpi(id);
    }
    @RolesAllowed("User")
     @GET
     @Path("gettai")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Collection<TerminsuAi> getAllTai() {
        Collection<TerminsuAi> tai = csb.getAllTai();
      return tai;    
       }
    @RolesAllowed("User")
    @POST
     @Path("addTai/{tid}/{occupation}/{weight}/{heightf}/{heighti}/{mother}/{father}/{address}"
             + "/{isdelete}/{loginid}/{insuCustId}/{isexpire}")
      @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addTai(@PathParam("tid") int tid,@PathParam("occupation") String occupation,
            @PathParam("weight") int weight,@PathParam("heightf") int heightf,
            @PathParam("heighti") int heighti,@PathParam("mother") String mother,
            @PathParam("father") String father,@PathParam("address") String address,
            @PathParam("isdelete") int isdelete,@PathParam("loginid") int loginid,
            @PathParam("insuCustId") String insuCustId,@PathParam("isexpire") int isexpire) {     
  
csb.addTai(tid,occupation,weight,heightf,heighti,mother,father,address,isdelete,loginid,insuCustId,isexpire);
    } 
    @RolesAllowed("User")
    @PUT
     @Path("updateTai/{aid}/{tid}/{occupation}/{weight}/{heightf}/{heighti}/{mother}/{father}/{address}"
             + "/{isdelete}/{loginid}/{insuCustId}/{isexpire}")
      @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateTai(@PathParam("aid") int aid,@PathParam("tid") int tid,@PathParam("occupation") String occupation,
            @PathParam("weight") int weight,@PathParam("heightf") int heightf,
            @PathParam("heighti") int heighti,@PathParam("mother") String mother,
            @PathParam("father") String father,@PathParam("address") String address,
            @PathParam("isdelete") int isdelete,@PathParam("loginid") int loginid,
            @PathParam("insuCustId") String insuCustId,@PathParam("isexpire") int isexpire) {     
  
csb.updateTai(aid,tid,occupation,weight,heightf,heighti,mother,father,address,isdelete,loginid,insuCustId,isexpire);
    } 
    @RolesAllowed("User")
    @DELETE
    @Path("deleteTai/{aid}")
    public void deleteTai(@PathParam("aid") Integer aid) {
    
    csb.deleteTai(aid);
    }
    @RolesAllowed("User")
          @GET
    @Path("getlastTpiId")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
       public Collection<TerminsuPi> getlastTpiId(){
            Collection<TerminsuPi> tpi = csb.getLastTpiId();
      return tpi;  
       
       }
       
       //card
       
       @RolesAllowed("User")
     @GET
     @Path("getcard")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Collection<Termcarddetails> getAllTCD() {
        Collection<Termcarddetails> tcd = csb.getAllTCD();
      return tcd;    
       }
         @RolesAllowed("Admin")
     @GET
     @Path("getAllTCDadmin")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Collection<Termcarddetails> getAllTCDadmin() {
        Collection<Termcarddetails> tcd = csb.getAllTCD();
      return tcd;    
       }
    @RolesAllowed("User")
    @POST
     @Path("addTCD/{termpiId}/{paymentno}/{name}/{paymentMethod}/{status}/{amount}/{date}")
      @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addTCD(@PathParam("termpiId") int termpiId,@PathParam("paymentno") int paymentno,
            @PathParam("name") String name,@PathParam("paymentMethod") String paymentMethod,
            @PathParam("status") String status,
            @PathParam("amount") float amount,@PathParam("date") String date) {     
csb.addTCD(termpiId, paymentno, name, paymentMethod, status, amount, date);
    } 
      @RolesAllowed("User")
          @GET
    @Path("getlastTaiId")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
       public Collection<TerminsuAi> getlastTaiId(){
            Collection<TerminsuAi> tai = csb.getLastTaiId();
      return tai;  
       
       }
//             @RolesAllowed("User")
          @GET
    @Path("getlastpolId")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
       public Collection<Policy> getlastpolId(){
            Collection<Policy> pol = asb.getLastpolId();
      return pol;  
       
       }
       @RolesAllowed("Admin")
                 @GET
    @Path("getlastpolIdadmin")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
       public Collection<Policy> getlastpolIdadmin(){
            Collection<Policy> pol = asb.getLastpolId();
      return pol;  
       
       }
                @RolesAllowed("User")
          @GET
    @Path("getLastcard")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
       public Collection<Termcarddetails> getLastcard(){
            Collection<Termcarddetails> c = csb.getLastcard();
      return c;  
       
       }
        @RolesAllowed("Admin")
     @PUT
     @Path("updateStatus/{cid}/{termpiId}/{paymentno}/{name}/{paymentMethod}/{status}/{amount}/{date}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateStatus(@PathParam("cid") int cid,@PathParam("termpiId") int termpiId,@PathParam("paymentno") int paymentno,
            @PathParam("name") String name,@PathParam("paymentMethod") String paymentMethod,
            @PathParam("status") String status,
            @PathParam("amount") float amount,@PathParam("date") String date) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  csb.updateStatus(cid, termpiId, paymentno, name, paymentMethod, status,amount,date);

    }
     @RolesAllowed("Admin")
              @GET
    @Path("getpaymentById/{cid}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Termcarddetails getpaymentById(@PathParam("cid") Integer cid){
        return csb.getPaymentById(cid);
    }
    @GET
    @Path("gethistory/{lid}")
   @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Collection<TerminsuPi> getHistory(@PathParam("lid") int lid){
        Collection<TerminsuPi> gethistory = csb.gethistory(lid);
        return gethistory;
    }
    
    @GET
    @Path("gethistoryLid/{lid}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
   
       public Collection<TerminsuPi> getHistorybyLid(@PathParam("lid") Integer lid){
        return csb.gethistory(lid);
       }
       //Inquiry
      
     @GET
         @Path("getinquiry")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
       //TODO return proper representation object
         public Collection<Inquiry> getAllinquiry() {
        Collection<Inquiry> iq = asb.getAllinquiry();
      return iq;
}   
         
         @POST
     @Path("addinquiry/{name}/{email}/{suminsured}/{mobile}/{totalmember}/{pincode}/{insuType}")
     @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addinquiry(@PathParam("name") String name, @PathParam("email")String email,
            @PathParam("suminsured") int suminsured,@PathParam("mobile") long mobile
            ,@PathParam("totalmember") int totalmember,@PathParam("pincode") int pincode
            ,@PathParam("insuType") String insuType) {

asb.addinquiry( name, email, suminsured, mobile, totalmember, pincode, insuType);
    }
     @RolesAllowed("User")
       @GET
    @Path("gethealthinsuById/{hid}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public HealthInsu gethealthinsuById(@PathParam("hid") Integer hid){
        return csb.gethealthinsuById(hid);
    }
//    //Hicarddetails
       @GET
     @Path("higetcard")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Collection<Hicarddetails> getAllHCD() {
        Collection<Hicarddetails> tcd = csb.getAllHCD();
      return tcd;    
       }
   
    @GET
     @Path("getAllHCDadmin")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Collection<Hicarddetails> getAllHCDadmin() {
        Collection<Hicarddetails> tcd = csb.getAllHCD();
      return tcd;    
       }
    @POST
     @Path("addHCD/{hid}/{paymentno}/{name}/{paymentMethod}/{status}/{amount}/{date}")
      @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addHCD(@PathParam("hid") int hid,@PathParam("paymentno") int paymentno,
            @PathParam("name") String name,@PathParam("paymentMethod") String paymentMethod,
            @PathParam("status") String status,
            @PathParam("amount") float amount,@PathParam("date") String date) {     
csb.addHCD(hid, paymentno, name, paymentMethod, status, amount, date);
    } 
    @GET
    @Path("higetLastcard")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
       public Collection<Hicarddetails> hhigetLastcard(){
            Collection<Hicarddetails> c = csb.higetLastcard();
      return c;  
       
       }
    @PUT
     @Path("hiupdateStatus/{cid}/{hid}/{paymentno}/{name}/{paymentMethod}/{status}/{amount}/{date}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void hiupdateStatus(@PathParam("cid") int cid,@PathParam("hid") int hid,@PathParam("paymentno") int paymentno,
            @PathParam("name") String name,@PathParam("paymentMethod") String paymentMethod,
            @PathParam("status") String status,
            @PathParam("amount") float amount,@PathParam("date") String date) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  csb.hiupdateStatus(cid, hid, paymentno, name, paymentMethod, status,amount,date);

    }

     
              @GET
    @Path("higetpaymentById/{cid}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Hicarddetails higetpaymentById(@PathParam("cid") Integer cid){
        return csb.higetPaymentById(cid);
    }
    
    //Feedback
    
      @RolesAllowed("Admin")
     @GET
         @Path("getfeedback")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
       //TODO return proper representation object
         public Collection<Feedback> getAllFeedback() {
        Collection<Feedback> f = csb.getAllfeedback();
      return f;
}   
          @RolesAllowed("Admin")
         @POST
     @Path("addfeedback/{lid}/{policyid}/{msg}")
     @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addfeedback(@PathParam("lid") int lid, @PathParam("policyid") int policyid,
            @PathParam("msg") String msg) {

csb.addFeedback(lid, policyid, msg);
    }
 
}
