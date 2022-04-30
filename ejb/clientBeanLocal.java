/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Feedback;
import entity.HealthInsu;
import entity.Hicarddetails;
import entity.Himember;
import entity.Policy;
import entity.Termcarddetails;
import entity.TerminsuAi;
import entity.TerminsuPi;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Hardik
 */
@Local
public interface clientBeanLocal {
     //healthInsu
    public Collection<HealthInsu>getAllHipolicy();
    public void addHi(int policyId, String clientname,String gender,long mobileno,String emailid,String state, String city, String pincode, String plantype, float suminsured, String dobi,String height, float weight, int loginid, int isdelete, String insuCustId, String address);
    public void updateHi(int hid, int policyId, String clientname,String gender,long mobileno,String emailid, String state, String city, String pincode, String plantype, float suminsured, String dobi,String height, float weight, int loginid, int isdelete, String insuCustId, String address);
   
    public void deleteHi(Integer hid);
    
    
    //himember
     public Collection<Himember>getAllHimember();
    public void addHimember(int hid,String membername,String dobm,String rtop,
                String height, String weight, int loginid, int isdelete, String insuCustId);
    public void updateHimember(int memberid, int hid,String membername,String dobm,String rtop,
                String height, String weight, int loginid, int isdelete, String insuCustId);
   
    public void deleteHimember(Integer memberid);
    
    
    //terminsuPi
     public Collection<TerminsuPi>getAllTpi();
    public void addTpi(int planId, String clientname, String gender, String lifestage,
                String bday, long mobile, String education, String smoke, String income, String cover,
                String coverage, int isdelete, int loginid, String insuCustId, int isexpire);
    public void updateTpi(int id,int planId, String clientname, String gender, String lifestage,
                String bday, long mobile, String education, String smoke, String income, String cover,
                String coverage, int isdelete, int loginid, String insuCustId, int isexpire);
   
    public void deleteTpi(Integer id);
     public Collection<TerminsuPi> getTpiById();
      public Collection<TerminsuPi> getalltpiId();
      public TerminsuPi getTerminsuPiById(Integer id);
    
    //terminsuAi
    public Collection<TerminsuAi>getAllTai();
    public void addTai(int tid, String occupation, int weight, int heightf, int heighti,
                 String mother, String father, String address, int isdelete, int loginid,
                 String insuCustId, int isexpire);
    public void updateTai(int aid,int tid, String occupation, int weight, int heightf, int heighti,
                 String mother, String father, String address, int isdelete, int loginid,
                 String insuCustId, int isexpire);
   
    public void deleteTai(Integer aid);

    public Collection<TerminsuPi> getLastTpiId();

    public Collection<HealthInsu> getmemberById();

    public Collection<Himember> getmember();

    //card
    public Collection<Termcarddetails> getAllTCD();

    public void addTCD(int termpiId, int paymentno, String name, String paymentMethod, String status, float amount, String date);

    public Collection<TerminsuAi> getLastTaiId();

    public Collection<Termcarddetails> getLastcard();

    public void updateStatus(int cid, int termpiId, int paymentno, String name, String paymentMethod, String status, float amount, String date);

    public Termcarddetails getPaymentById(Integer cid);

    public Collection<TerminsuPi> gethistory(Integer lid);

    public Collection<Termcarddetails> getcardbylid(Integer loginid);

    public Collection<HealthInsu> gethiById();

    public Collection<Himember> getlastmembers(Integer hid);

    public HealthInsu gethealthinsuById(Integer hid);

    public Collection<Hicarddetails> getAllHCD();

    public void addHCD(int hid, int paymentno, String name, String paymentMethod, String status, float amount, String date);

    public Collection<Hicarddetails> higetLastcard();

    public void hiupdateStatus(int cid, int hid, int paymentno, String name, String paymentMethod, String status, float amount, String date);

    public Hicarddetails higetPaymentById(Integer cid);

    public Collection<Hicarddetails> gethicardbylid(Integer loginid);

    public Collection<Feedback> getAllfeedback();

    public void addFeedback(int lid, int policyid, String msg);

  

  

   



  





   

  

  

    

   

  

   
}
