/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.AdminLogin;
import entity.CompReg;
import entity.HealthInsu;
import entity.Himember;
import entity.Hospital;
import entity.Inquiry;
import entity.InsuType;
import entity.Login;
import entity.Policy;
import entity.Role;
import entity.TerminsuAi;
import entity.TerminsuPi;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Hardik
 */
@Local
public interface adminBeanLocal {
    //Company
     Collection<CompReg> getAllcomps();

 void addComp(String name, String address, String email, String website, String city, int pincode, String image, long contactno) ;
 void updateComp(Integer compId,String name, String address, String email, String website, String city, int pincode, String image, long contactno);
void removeComp(Integer compId);
CompReg getCompRegById (Integer compId);
 public Collection<CompReg> databyisdelete();

    public Collection<CompReg> databyisdelete1();

    public Collection<CompReg> findByCompin(Integer pincode);
public Collection<CompReg> getallCompRegId();

//Insutype
  public void updateInsutype(Integer insuTypeId, String type);

    public void addInsutype(String type);

void removeInsutype(Integer insuTypeId);
InsuType getInsuTypeById (Integer insuTypeId);

public Collection<InsuType> getallInsuTypeId();
    public Collection<InsuType> getAllTypes();
    
    //Policy
    public void addPolicy(int policyNo, String name,int insuTypeId,int compId, String issuedate, String validity, int noOfPerson, int totalAdult, int noOfSon, int noOfDaughter, int sumInsured, String cost);
    public void updatePolicy(Integer policyId,int policyNo, String name,int insuTypeId ,int compId,String issuedate, String validity, int noOfPerson, int totalAdult, int noOfSon, int noOfDaughter, int sumInsured, String cost);
    public void deletePolicy(Integer policyId);
    public Collection<Policy> getPolicybyNo();
    Collection<Policy> findByPolicyNo(Integer policyNo);
        public void updatedelComp(Integer compId, String name, String address, String email, String website, String city, int pincode, String image, long contactno, int isdelete);

    Policy getPolicyById (Integer policyId);

public Collection<Policy> getallPolicyId();
    public Collection<Policy> getAllPolicy();
        public void updatedelPolicy(Integer policyId, int policyNo, String name, int insuTypeId, int compId, String issuedate, String validity, int noOfPerson, int totalAdult, int noOfSon, int noOfDaughter, int sumInsured, String cost, int isdelete);

    public Collection<Policy> databyisdeletepol();

    public Collection<Policy> databyisdeletepol1();

    public Collection<Policy> findBypolno(Integer policyNo);
      public Collection<Policy> findpno();
    
     //Hospital
    Collection<Hospital> getAllhospital();

 void addhospital(String name, String address, String emailid, String website, String city, int pincode, String image, long contactno) ;
 void updatehospital(Integer hospitalId,String name, String address, String emailid, String website, String city, int pincode, String image, long contactno);
void deletehospital(Integer hospitalId);
Hospital getHospitalById (Integer hospitalId);
  public Collection<Hospital> getHospitalByhid(Integer hospitalId);
  public Hospital getHospitalByhId(Integer hospitalId);
public Collection<Hospital> getallHospitalId();

    public Policy getAllTypeById(int id);
    
    //Role

    public Collection<Role> getAllRole();

    public void addRole(String name);

    public void updateRole(Integer rid, String name);

    public Role getRoleById(Integer rid);

    public void removeRole(Integer rid);
    
    //AdminLogin

    public Collection<Login> getAllUsers();

    public Collection<Login> getAllUserByRoleID(Integer rid);

    public Collection<Policy> getLastpolId();
//Login
    public Login getLoginById(Integer lid);

    public Login getAllUserWiseEmail(String emailid);

    public Collection<Login> getAllUserByEmail(String emailid);

    public void addUser(Integer roleId, String username, String emailid, String password);

    public Collection<Login> getAllUser();

    public void updateUser(Integer lid, Integer roleId, String username, String emailid, String password);

    public Collection<Login> getAllUserBylid(String lid);

    public Collection<Inquiry> getAllinquiry();

    public void addinquiry(String name, String email, int suminsured, long mobile, int totalmember, int pincode, String insuType);

  


  

  




   

  
  

    
    


   
  
}
