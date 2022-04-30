/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.AdminLogin;
import entity.CompReg;
import entity.Hospital;
import entity.Inquiry;
import entity.InsuType;
import entity.Login;
import entity.Policy;
import entity.Role;
import entity.Termcarddetails;
import entity.TerminsuPi;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Hardik
 */
@Stateless
public class adminBean implements adminBeanLocal {
 // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     @PersistenceContext(unitName = "insurancehubSecurePU")
    EntityManager em;
     //count
     
     
     //Login
        @Override
    public Collection<Login> getAllUser(){
        Collection<Login> l = em.createNamedQuery("Login.findAll").getResultList();
        return l;
    }   
     
       @Override
    public Login getLoginById(Integer lid){
         return em.find(Login.class, lid);
    }
    
       @Override
    public Login getAllUserWiseEmail(String emailid){
       Login l = (Login) em.createNamedQuery("Login.findByEmailid").setParameter("emailid", emailid).getSingleResult();
        return l;
        
    }
     @Override
        public Collection<Login> getAllUserByEmail(String emailid){
       Collection<Login> regq = em.createNamedQuery("Login.findByEmailid").setParameter("emailid", emailid).getResultList();
        return regq;
        
    }
           @Override
        public Collection<Login> getAllUserBylid(String lid){
       Collection<Login> l = em.createNamedQuery("Login.findByEmailid").setParameter("lid", lid).getResultList();
        return l;
        
    }
          @Override
 public void addUser(Integer roleId,String username, String emailid, String password) {
        Role role = em.find(Role.class, roleId);
       
        Login l = new Login();
        l.setRoleid(role);
        l.setUsername(username);
        l.setEmailid(emailid);
        l.setPassword(password);
        
      
        
        Collection<Login> rolelist =role.getLoginCollection();
      
        rolelist.add(l);
        
        role.setLoginCollection(rolelist);
   
        
        em.merge(role);
     
        em.persist(l);
    }
     @Override
    public void updateUser(Integer lid,Integer roleId,String username, String emailid, String password){
          Role role = em.find(Role.class, roleId);
       Login lu = em.find(Login.class, lid);
        Login l = new Login();
        l.setLid(lid);
        l.setRoleid(role);
        l.setUsername(username);
        l.setEmailid(emailid);
        l.setPassword(password);
        
      
        
        Collection<Login> rolelist =role.getLoginCollection();
      
        rolelist.add(l);
        
        role.setLoginCollection(rolelist);
   
        
        em.merge(role);
     em.merge(lu);
     
    }
     //Role
   
     @Override
    public Collection<Role> getAllRole(){
        Collection<Role> role = em.createNamedQuery("Role.findAll").getResultList();
        return role;
    }   
        
    
     @Override
    public void addRole(String name){
        Role role = new Role();
        role.setName(name);
       
        
        em.persist(role);
        
    }
    
  
     @Override
    public void updateRole(Integer rid, String name){
        Role role = em.find(Role.class, rid);
        role.setName(name);
       
        
        em.merge(role);
    }
      
     @Override
    public Role getRoleById(Integer rid){
         return em.find(Role.class, rid);
    }
    
    
     @Override
    public void removeRole(Integer rid){
        Role role = em.find(Role.class, rid);
        em.remove(role);
    }
    
//AdminLogin
     @Override
      public Collection<Login> getAllUsers()
    {
        Collection<Login> al= em.createNamedQuery("Login.findAll").getResultList();
        return al;
    }
     
    
     @Override
       public Collection<Login> getAllUserByRoleID(Integer rid) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Role r = em.find(Role.class, rid);
        Collection<Login> reg = r.getLoginCollection();
        return reg;
    }

     
     //Company
     @Override
     public Collection<CompReg> getAllcomps() {
         Collection<CompReg> comp = em.createNamedQuery("CompReg.findAll").getResultList();
        return comp;
       }
     @Override
        public void addComp(String name, String address, String email, String website, String city, int pincode, String image, long contactno) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     CompReg comp = new CompReg();
    // User us=new User();
     //us.getUserAddress(ad);
     
     comp.setName(name);
     comp.setAddress(address);
     comp.setEmail(email);
     comp.setWebsite(website);
     comp.setCity(city);
     comp.setPincode(pincode);
     comp.setImage(image);
     comp.setContactno(contactno);
    
     
     em.persist(comp);
     
    }

     @Override
        public void updateComp(Integer compId,String name, String address, String email, String website, String city, int pincode, String image, long contactno) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
     
    CompReg comp  = em.find(CompReg.class, compId);
     comp.setName(name);
     comp.setAddress(address);
     comp.setEmail(email);
     comp.setWebsite(website);
     comp.setCity(city);
     comp.setPincode(pincode);
     if(!image.isEmpty())
        comp.setImage(image);
     comp.setContactno(contactno);
    em.merge(comp);
    
    }


     @Override
     public void removeComp(Integer compId) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      CompReg comp  = em.find(CompReg.class, compId);
  
    em.remove(comp);
    
    }
     @Override
     public Collection<CompReg> getallCompRegId() {
        return em.createNamedQuery("CompReg.findAll").getResultList();
    }

     @Override
    public CompReg getCompRegById(Integer compId){
         return em.find(CompReg.class, compId);
    }
         @Override
 public void updatedelComp(Integer compId,String name, String address, String email, String website, String city, int pincode, String image, long contactno,int isdelete) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
     
    CompReg comp  = em.find(CompReg.class, compId);
     comp.setName(name);
     comp.setAddress(address);
     comp.setEmail(email);
     comp.setWebsite(website);
     comp.setCity(city);
     comp.setPincode(pincode);
     if(!image.isEmpty())
        comp.setImage(image);
     comp.setContactno(contactno);
     comp.setIsdelete(isdelete);
    em.merge(comp);
    
    }
 @Override
       public Collection<CompReg> databyisdelete(){
           Query q = em.createQuery("SELECT c FROM CompReg c WHERE c.isdelete="+1);
           Collection<CompReg> c = q.getResultList();
         return c;
    }
         @Override
       public Collection<CompReg> databyisdelete1(){
           Query q = em.createQuery("SELECT c FROM CompReg c WHERE c.isdelete="+0);
           Collection<CompReg> c = q.getResultList();
         return c;
    }
         
     @Override
       public Collection<CompReg> findByCompin(Integer pincode){
           Query q = em.createQuery("SELECT c FROM CompReg c WHERE c.pincode="+pincode);
           Collection<CompReg> c = q.getResultList();
         return c;
    }
//InsuType
     @Override
     public Collection<InsuType> getAllTypes() {
         Collection<InsuType> type = em.createNamedQuery("InsuType.findAll").getResultList();
        return type;
       }

   
     @Override
     public void addInsutype(String type) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     InsuType itype = new InsuType();
    // User us=new User();
     //us.getUserAddress(ad);
     
     itype.setType(type);
     
     
     em.persist(itype);
     
    }

     
     @Override
 public void updateInsutype(Integer insuTypeId,String type) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
     
    InsuType itype  = em.find(InsuType.class, insuTypeId);
     itype.setType(type);
    
    em.merge(itype);
    
    }
 
     @Override
 public void removeInsutype(Integer insuTypeId) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      InsuType itype  = em.find(InsuType.class, insuTypeId);
  
    em.remove(itype);
    
    }
     @Override
    public Collection<InsuType> getallInsuTypeId() {
        return em.createNamedQuery("InsuType.findAll").getResultList();
    }

     @Override
    public InsuType getInsuTypeById(Integer insuTypeId){
         return em.find(InsuType.class, insuTypeId);
    }
 
     //Policy
     @Override
 public Collection<Policy> getAllPolicy() {
      Collection<Policy> pol = em.createNamedQuery("Policy.findAll").getResultList();
        return pol;
       }
     @Override
 public Collection<Policy> getPolicybyNo() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        Collection<Policy> pol = em.createNamedQuery("Policy.findByPolicyNo").getResultList();
        return pol;
       
    }
 
    @Override
    public Policy getAllTypeById(int id){
       
        return em.find(Policy.class, id);
    }
 
     @Override
       public Collection<Policy> findByPolicyNo(Integer policyNo){
           Query q = em.createQuery("SELECT p FROM Policy p WHERE p.policyNo="+policyNo.toString());
           Collection<Policy> pol = q.getResultList();
         return pol;
    }
     @Override
          public Collection<Policy> findpno()
       {
           Query q=em.createQuery("SELECT p FROM Policy p WHERE p.policyNo=101");
            Collection<Policy> p = q.getResultList();
           return p;
       }
     @Override
 public void addPolicy(int policyNo, String name,int insuTypeId,int compId,String issuedate, String validity, int noOfPerson, int totalAdult, int noOfSon, int noOfDaughter, int sumInsured, String cost) {
        InsuType i = em.find(InsuType.class, insuTypeId);
        CompReg c = em.find(CompReg.class, compId);
        Policy ip = new Policy();
        ip.setPolicyNo(policyNo);
        ip.setName(name);
        ip.setInsuTypeId(i);
        ip.setInsuCompId(c);
        ip.setIssuedate(issuedate);
        ip.setValidity(validity);
        ip.setNoOfPerson(noOfPerson);
        ip.setTotalAdult(totalAdult);
        ip.setNoOfSon(noOfSon);
        ip.setNoOfDaughter(noOfDaughter);
        ip.setSumInsured(sumInsured);
        ip.setCost(cost);
      
        
        Collection<Policy> insutypelist = i.getPolicyCollection();
        Collection<Policy> complist = c.getPolicyCollection();
        insutypelist.add(ip);
        complist.add(ip);
        
        i.setPolicyCollection(insutypelist); 
        c.setPolicyCollection(complist); 
        
        em.merge(i);
         em.merge(c);
        em.persist(ip);
    }
 @Override
       public Collection<Policy> databyisdeletepol(){
           Query q = em.createQuery("SELECT p FROM Policy p WHERE p.isdelete="+1);
           Collection<Policy> p = q.getResultList();
         return p;
    }
         @Override
       public Collection<Policy> databyisdeletepol1(){
           Query q = em.createQuery("SELECT p FROM Policy p WHERE p.isdelete="+0);
           Collection<Policy> p = q.getResultList();
         return p;
    }
           @Override
       public Collection<Policy> findBypolno(Integer policyNo){
           Query q = em.createQuery("SELECT p FROM Policy p WHERE p.policyNo="+policyNo.toString());
           Collection<Policy> p = q.getResultList();
         return p;
    }
  @Override
         public void updatedelPolicy(Integer policyId, int policyNo, String name,int insuTypeId ,int compId,String issuedate, String validity, int noOfPerson, int totalAdult, int noOfSon, int noOfDaughter, int sumInsured, String cost,int isdelete) {
       Policy p = em.find(Policy.class, policyId);
      InsuType i = em.find(InsuType.class, insuTypeId);
       CompReg c = em.find(CompReg.class, compId);
       
        Policy ip = new Policy();
        ip.setPolicyId(policyId);
        ip.setPolicyNo(policyNo);
        ip.setName(name);
        ip.setInsuTypeId(i);
        ip.setInsuCompId(c);
        ip.setIssuedate(issuedate);
        ip.setValidity(validity);
        ip.setNoOfPerson(noOfPerson);
        ip.setTotalAdult(totalAdult);
        ip.setNoOfSon(noOfSon);
        ip.setNoOfDaughter(noOfDaughter);
        ip.setSumInsured(sumInsured);
        ip.setCost(cost);
        ip.setIsdelete(isdelete);
        
       Collection<Policy> insutypelist = i.getPolicyCollection();
        Collection<Policy> complist = c.getPolicyCollection();
        insutypelist.add(ip);
        complist.add(ip);
        
        i.setPolicyCollection(insutypelist); 
        c.setPolicyCollection(complist); 
        
        em.merge(p);
        em.merge(i);
        em.merge(c);
    }
     @Override
  public void updatePolicy(Integer policyId, int policyNo, String name,int insuTypeId ,int compId,String issuedate, String validity, int noOfPerson, int totalAdult, int noOfSon, int noOfDaughter, int sumInsured, String cost) {
       Policy p = em.find(Policy.class, policyId);
      InsuType i = em.find(InsuType.class, insuTypeId);
       CompReg c = em.find(CompReg.class, compId);
       
        Policy ip = new Policy();
        ip.setPolicyId(policyId);
        ip.setPolicyNo(policyNo);
        ip.setName(name);
        ip.setInsuTypeId(i);
        ip.setInsuCompId(c);
        ip.setIssuedate(issuedate);
        ip.setValidity(validity);
        ip.setNoOfPerson(noOfPerson);
        ip.setTotalAdult(totalAdult);
        ip.setNoOfSon(noOfSon);
        ip.setNoOfDaughter(noOfDaughter);
        ip.setSumInsured(sumInsured);
        ip.setCost(cost);
        
       Collection<Policy> insutypelist = i.getPolicyCollection();
        Collection<Policy> complist = c.getPolicyCollection();
        insutypelist.add(ip);
        complist.add(ip);
        
        i.setPolicyCollection(insutypelist); 
        c.setPolicyCollection(complist); 
        
        em.merge(p);
        em.merge(i);
        em.merge(c);
    }
     @Override
   public void deletePolicy(Integer policyId) {
        Policy ip = em.find(Policy.class, policyId);
        em.remove(ip);
    }
     @Override
  public Collection<Policy> getallPolicyId() {
        return em.createNamedQuery("Policy.findAll").getResultList();
    }

     @Override
    public Policy getPolicyById(Integer policyId){
         return em.find(Policy.class, policyId);
    }
    
    
    //hospital table
     @Override
      public Collection<Hospital> getAllhospital() {
         Collection<Hospital> host = em.createNamedQuery("Hospital.findAll").getResultList();
        return host;
       }
     @Override
      public void addhospital(String name, String address, String emailid, String website, String city, int pincode, String image, long contactno) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     Hospital host = new Hospital();
    // User us=new User();
     //us.getUserAddress(ad);
     
     host.setName(name);
     host.setAddress(address);
     host.setEmailid(emailid);
     host.setWebsite(website);
     host.setCity(city);
     host.setPincode(pincode);
     host.setImage(image);
     host.setContactno(contactno);
    
     
     em.persist(host);
     
    }
     @Override
      public void updatehospital(Integer hospitalId,String name, String address, String emailid, String website, String city, int pincode, String image, long contactno) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//     Hospital host = new Hospital();
    // User us=new User();
     //us.getUserAddress(ad);
     Hospital host  = em.find(Hospital.class, hospitalId);
     host.setName(name);
     host.setAddress(address);
     host.setEmailid(emailid);
     host.setWebsite(website);
     host.setCity(city);
     host.setPincode(pincode);
     host.setImage(image);
     host.setContactno(contactno);
    
     
     em.merge(host);
     
    }
     @Override
     public void deletehospital(Integer hospitalId) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      Hospital host  = em.find(Hospital.class, hospitalId);
  
    em.remove(host);
    
    } 
     @Override
 public Collection<Hospital> getallHospitalId() {
        return em.createNamedQuery("Hospital.findAll").getResultList();
    }

     @Override
    public Hospital getHospitalById(Integer hospitalId){
         return em.find(Hospital.class, hospitalId);
    }
      @Override
    public Collection<Hospital> getHospitalByhid(Integer hospitalId){
        Query q = em.createQuery("SELECT h FROM Hospital h WHERE h.hospitalId ="+hospitalId.toString());
           Collection<Hospital> h = q.getResultList();
           return h;
    }
    
    @Override
    public Hospital getHospitalByhId(Integer hospitalId){
         return em.find(Hospital.class, hospitalId);
    }
     
 @Override
    public  Collection<Policy> getLastpolId(){
       
     Collection<Policy> pol = em.createQuery("SELECT p FROM Policy p WHERE p.policyId=(SELECT MAX(p.policyId) FROM Policy p)").getResultList();
         return pol;
      
           
    }
    //Inquiry table
     @Override
      public Collection<Inquiry> getAllinquiry() {
         Collection<Inquiry> iq = em.createNamedQuery("Inquiry.findAll").getResultList();
        return iq;
       }
     @Override
      public void addinquiry(String name, String email, int suminsured, long mobile,
              int totalmember, int pincode, String insuType) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     Inquiry iq = new Inquiry();
    // User us=new User();
     //us.getUserAddress(ad);
     
     iq.setName(name);
     iq.setEmail(email);
     iq.setSuminsured(suminsured);
     iq.setMobile(mobile);
     iq.setTotalmember(totalmember);
     iq.setPincode(pincode);
     iq.setInsuType(insuType);
   
     
     em.persist(iq);
     
    }

}
