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
import entity.Login;
import entity.Policy;
import entity.Termcarddetails;
import entity.TerminsuAi;
import entity.TerminsuPi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Hardik
 */
@Stateless
public class clientBean implements clientBeanLocal {
      @PersistenceContext(unitName = "insurancehubSecurePU")
    EntityManager em;
      @Override
      public Collection<HealthInsu> getAllHipolicy() {
      Collection<HealthInsu> hi = em.createNamedQuery("HealthInsu.findAll").getResultList();
        return hi;
       }
      @Override
        public  Collection<HealthInsu> gethiById(){
       
            Collection<HealthInsu> hi = em.createQuery("SELECT h FROM HealthInsu h WHERE h.hid=(SELECT MAX(h.hid) FROM HealthInsu h)").getResultList();
         return hi;
        }

      @Override
        public void addHi(int policyId, String clientname,String gender,long mobileno,String emailid,
                String state, String city, String pincode, String plantype, float suminsured, String dobi,
                String height, float weight, int loginid, int isdelete, String insuCustId, String address) {
       try{
          Policy p = em.find(Policy.class, policyId);
        Login l=em.find(Login.class, loginid);
        HealthInsu hi = new HealthInsu();
        hi.setPolicyId(p);
        hi.setClientname(clientname);
        hi.setGender(gender);
        hi.setMobileno(mobileno);
        hi.setEmailid(emailid);
        hi.setState(state);
        hi.setCity(city);
        hi.setPincode(pincode);
        hi.setPlantype(plantype);
        hi.setSuminsured(suminsured);
        hi.setDobi(dobi);
        hi.setHeight(height);
        hi.setWeight(weight);
        hi.setLoginid(l);
        hi.setIsdelete(isdelete);
        hi.setInsuCustId(insuCustId);
        hi.setAddress(address);
        
      
        
        Collection<HealthInsu> plist = p.getHealthInsuCollection();
         Collection<HealthInsu> llist = l.getHealthInsuCollection();
        plist.add(hi);
        llist.add(hi);
        
        p.setHealthInsuCollection(plist); 
        
       l.setHealthInsuCollection(llist); 
        
        em.merge(p);
        em.merge(l);
        em.persist(hi);
       }catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
    }
        

      @Override
        public void updateHi(int hid, int policyId, String clientname,String gender,long mobileno,String emailid,
                String state, String city, String pincode, String plantype, float suminsured, String dobi,
                String height, float weight, int loginid, int isdelete, String insuCustId, String address) {
       try{
           HealthInsu h=em.find(HealthInsu.class,hid);
          Policy p = em.find(Policy.class, policyId);
         Login l=em.find(Login.class, loginid);
        HealthInsu hi = new HealthInsu();
        hi.setHid(hid);
        hi.setPolicyId(p);
        hi.setClientname(clientname);
        hi.setGender(gender);
        hi.setMobileno(mobileno);
        hi.setEmailid(emailid);
        hi.setState(state);
        hi.setCity(city);
        hi.setPincode(pincode);
        hi.setPlantype(plantype);
        hi.setSuminsured(suminsured);
        hi.setDobi(dobi);
        hi.setHeight(height);
        hi.setWeight(weight);
        hi.setLoginid(l);
        hi.setIsdelete(isdelete);
        hi.setInsuCustId(insuCustId);
        hi.setAddress(address);
        
      
        
        Collection<HealthInsu> plist = p.getHealthInsuCollection();
         Collection<HealthInsu> llist = l.getHealthInsuCollection();
        plist.add(hi);
        llist.add(hi);
        
        p.setHealthInsuCollection(plist); 
        
       l.setHealthInsuCollection(llist); 
        
        em.merge(p);
        em.merge(l);
        em.merge(h);
       }catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
    }
         

      @Override
        public void deleteHi(Integer hid) {
        HealthInsu hi = em.find(HealthInsu.class, hid);
        em.remove(hi);
    }
      @Override
        public HealthInsu gethealthinsuById(Integer hid){
         return em.find(HealthInsu.class, hid);
    }
    
        
       //himember table
        

      @Override
         public Collection<Himember> getAllHimember() {
      Collection<Himember> hm = em.createNamedQuery("Himember.findAll").getResultList();
        return hm;
       }
        

      @Override
         public void addHimember(int hid,String membername,String dobm,String rtop,
                String height, String weight, int loginid, int isdelete, String insuCustId) {
       try{
          HealthInsu h = em.find(HealthInsu.class, hid);
        
        Himember m = new Himember();
        m.setHid(h);
        m.setMembername(membername);
        m.setDobm(dobm);
        m.setRtop(rtop);
        m.setHeight(height);
        m.setWeight(weight);
        m.setLoginid(loginid);
        m.setIsdelete(isdelete);
        m.setInsuCustId(insuCustId);
       
        
      
        
        Collection<Himember> mlist = h.getHimemberCollection();
        
        mlist.add(m);
        
        
        h.setHimemberCollection(mlist); 
        
        
        em.merge(h);
        
        em.persist(m);
       }catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
}
         
      @Override
      public Collection<Himember> getlastmembers(Integer hid){
      //  return em.find(Product.class, catId);
      HealthInsu c = em.find(HealthInsu.class, hid);
        Collection<Himember> p = c.getHimemberCollection();
        return p;
    }
      @Override
         public void updateHimember(int memberid, int hid,String membername,String dobm,String rtop,
                String height, String weight, int loginid, int isdelete, String insuCustId) {
       try{
          HealthInsu h = em.find(HealthInsu.class, hid);
          Himember hm=em.find(Himember.class,memberid);
        
        Himember m = new Himember();
        m.setMemberid(memberid);
        m.setHid(h);
        m.setMembername(membername);
        m.setDobm(dobm);
        m.setRtop(rtop);
        m.setHeight(height);
        m.setWeight(weight);
        m.setLoginid(loginid);
        m.setIsdelete(isdelete);
        m.setInsuCustId(insuCustId);
       
        
      
        
        Collection<Himember> mlist = h.getHimemberCollection();
        
        mlist.add(m);
        
        
        h.setHimemberCollection(mlist); 
        
        
        em.merge(h);
        
        em.merge(hm);
       }catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
}
         

      @Override
         public void deleteHimember(Integer memberid) {
        Himember m = em.find(Himember.class, memberid);
        em.remove(m);
    }
         
         //TerminsuPi

      @Override
        public Collection<TerminsuPi> getAllTpi() {
      Collection<TerminsuPi> tpi = em.createNamedQuery("TerminsuPi.findAll").getResultList();
        return tpi;
       }
              
      @Override
  public Collection<TerminsuPi> getalltpiId() {
        return em.createNamedQuery("TerminsuPi.findAll").getResultList();
    }
      
        
      @Override
    public TerminsuPi getTerminsuPiById(Integer id){
         return em.find(TerminsuPi.class, id);
    }
 
      
    
      @Override
    public  Collection<TerminsuPi> getTpiById(){
       
            Collection<TerminsuPi> tpi = em.createQuery("SELECT t FROM TerminsuPi t WHERE t.id=(SELECT MAX(t.id) FROM TerminsuPi t)").getResultList();
         return tpi;
      
           
    }
   
      
      @Override
        public void addTpi(int planId, String clientname, String gender, String lifestage,
                String bday, long mobile, String education, String smoke, String income, String cover,
                String coverage, int isdelete, int loginid, String insuCustId, int isexpire) {
       try{
          Policy p = em.find(Policy.class, planId);
        Login l=em.find(Login.class, loginid);
        TerminsuPi tpi = new TerminsuPi();
        tpi.setPlanId(p);
        tpi.setClientname(clientname);
        tpi.setGender(gender);
        tpi.setLifestage(lifestage);
        tpi.setBday(bday);
        tpi.setMobile(mobile);
        tpi.setEducation(education);
        tpi.setSmoke(smoke);
        tpi.setIncome(income);
        tpi.setCover(cover);
        tpi.setCoverage(coverage);
        tpi.setIsdelete(isdelete);
        tpi.setLoginid(l);
        tpi.setInsuCustId(insuCustId);
        tpi.setIsexpire(isexpire);
      
        
      
        
        Collection<TerminsuPi> tpilist = p.getTerminsuPiCollection();
        Collection<TerminsuPi> loginlist=l.getTerminsuPiCollection();
        tpilist.add(tpi);
        loginlist.add(tpi);
        
        p.setTerminsuPiCollection(tpilist);
        l.setTerminsuPiCollection(loginlist);
        
        
        em.merge(p);
        em.merge(l);
        
        em.persist(tpi);
       }catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
       
    }
        

      
      @Override
       public void updateTpi(int id,int planId, String clientname, String gender, String lifestage, String bday, long mobile, String education, String smoke, String income, String cover, String coverage, int isdelete, int loginid, String insuCustId, int isexpire) {
       try{
          Policy p = em.find(Policy.class, planId);
          TerminsuPi tp=em.find(TerminsuPi.class,id);
           Login l=em.find(Login.class, loginid);
        
        TerminsuPi tpi = new TerminsuPi();
        tpi.setId(id);
        tpi.setPlanId(p);
        tpi.setClientname(clientname);
        tpi.setGender(gender);
        tpi.setLifestage(lifestage);
        tpi.setBday(bday);
        tpi.setMobile(mobile);
        tpi.setEducation(education);
        tpi.setSmoke(smoke);
        tpi.setIncome(income);
        tpi.setCover(cover);
        tpi.setCoverage(coverage);
        tpi.setIsdelete(isdelete);
        tpi.setLoginid(l);
        tpi.setInsuCustId(insuCustId);
        tpi.setIsexpire(isexpire);
      
       
        
      
        
        Collection<TerminsuPi> tpilist = p.getTerminsuPiCollection();
        Collection<TerminsuPi> loginlist=l.getTerminsuPiCollection();
        tpilist.add(tpi);
        loginlist.add(tpi);
        
        p.setTerminsuPiCollection(tpilist);
        l.setTerminsuPiCollection(loginlist);
        
        
        em.merge(p);
        em.merge(l);
        
        em.merge(tp);
       }catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
}
        


      @Override
         public void deleteTpi(Integer id) {
        TerminsuPi tpi = em.find(TerminsuPi.class, id);
        em.remove(tpi);
    }
         //terminsuai

      @Override
         public Collection<TerminsuAi> getAllTai() {
      Collection<TerminsuAi> tai = em.createNamedQuery("TerminsuAi.findAll").getResultList();
        return tai;
       }
         
         
   

      @Override
         public void addTai(int tid, String occupation, int weight, int heightf, int heighti,
                 String mother, String father, String address, int isdelete, int loginid,
                 String insuCustId, int isexpire) {
       try{
          TerminsuPi tp = em.find(TerminsuPi.class, tid);
        
        TerminsuAi tai = new TerminsuAi();
        tai.setTid(tp);
        tai.setOccupation(occupation);
        tai.setWeight(weight);
        tai.setHeightf(heightf);
        tai.setHeighti(heighti);
        tai.setMother(mother);
        tai.setFather(father);
        tai.setAddress(address);
        tai.setIsdelete(isdelete);
        tai.setLoginid(loginid);
        tai.setInsuCustId(insuCustId);
        tai.setIsexpire(isexpire);
       
      
        
      
        
        Collection<TerminsuAi> tailist = tp.getTerminsuAiCollection();
        
        tailist.add(tai);
        
        
        tp.setTerminsuAiCollection(tailist); 
        
        
        em.merge(tp);
        
        em.persist(tai);
       }catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
    }

      @Override
    public  Collection<TerminsuPi> getLastTpiId(){
       
            Collection<TerminsuPi> tpi = em.createQuery("SELECT t FROM TerminsuPi t WHERE t.id=(SELECT MAX(t.id) FROM TerminsuPi t)").getResultList();
         return tpi;
      
           
    }
      @Override
          public  Collection<HealthInsu> getmemberById(){
       
            Collection<HealthInsu> hi = em.createQuery("SELECT h FROM HealthInsu h WHERE h.hid=(SELECT MAX(h.hid) FROM HealthInsu h)").getResultList();
         return hi;
      
           
    }
            
      @Override
          public  Collection<Himember> getmember(){
       
            Collection<Himember> m = em.createQuery("SELECT m FROM Himember m,HealthInsu h WHERE h.hid=(SELECT MAX(h.hid) FROM HealthInsu h)").getResultList();
         return m;
      
           
    }
      @Override
          public void updateTai(int aid,int tid, String occupation, int weight, int heightf, int heighti,
                 String mother, String father, String address, int isdelete, int loginid,
                 String insuCustId, int isexpire) {
       try{
          TerminsuPi tp = em.find(TerminsuPi.class, tid);
        TerminsuAi ta=em.find(TerminsuAi.class,aid);
        TerminsuAi tai = new TerminsuAi();
        tai.setAid(aid);
        tai.setTid(tp);
        tai.setOccupation(occupation);
        tai.setWeight(weight);
        tai.setHeightf(heightf);
        tai.setHeighti(heighti);
        tai.setMother(mother);
        tai.setFather(father);
        tai.setAddress(address);
        tai.setIsdelete(isdelete);
        tai.setLoginid(loginid);
        tai.setInsuCustId(insuCustId);
        tai.setIsexpire(isexpire);
       
      
        
      
        
        Collection<TerminsuAi> tailist = tp.getTerminsuAiCollection();
        
        tailist.add(tai);
        
        
        tp.setTerminsuAiCollection(tailist); 
        
        
        em.merge(tp);
        
        em.merge(ta);
       }catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
    }

      @Override
        public void deleteTai(Integer aid) {
        TerminsuAi tai = em.find(TerminsuAi.class, aid);
        em.remove(tai);
    }
         @Override
         public Collection<Termcarddetails> getAllTCD() {
      Collection<Termcarddetails> tcd = em.createNamedQuery("Termcarddetails.findAll").getResultList();
        return tcd;
       }
         
         
   

      @Override
         public void addTCD( int termpiId ,int paymentno, String name, String paymentMethod, String status, float amount,String date) {
       try{
          TerminsuPi tai = em.find(TerminsuPi.class, termpiId);
        
        Termcarddetails tcd = new Termcarddetails();
      
        tcd.setTermpiId(tai);
        tcd.setPaymentno(paymentno);
     tcd.setPaymentMethod(paymentMethod);
        tcd.setName(name);
        tcd.setStatus(status);
       
        tcd.setAmount(amount);
       tcd.setDate(date);
       
      
        
      
        
        Collection<Termcarddetails> tailist = tai.getTermcarddetailsCollection();
        
        tailist.add(tcd);
        
        
        tai.setTermcarddetailsCollection(tailist); 
        
        
        em.merge(tai);
        
        em.persist(tcd);
       }catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
    }
   @Override
    public  Collection<TerminsuAi> getLastTaiId(){
       
            Collection<TerminsuAi> tai = em.createQuery("SELECT t FROM TerminsuAi t WHERE t.aid=(SELECT MAX(t.aid) FROM TerminsuAi t)").getResultList();
         return tai;
      
           
    }
       @Override
    public  Collection<Termcarddetails> getLastcard(){
       
            Collection<Termcarddetails> c = em.createQuery("SELECT t FROM Termcarddetails t WHERE t.cid=(SELECT MAX(t.cid) FROM Termcarddetails t)").getResultList();
         return c;
      
           
    }
             @Override
      public void updateStatus(int cid,int termpiId ,int paymentno, String name, String paymentMethod, String status, float amount,String date) {
   try{
          TerminsuPi tai = em.find(TerminsuPi.class, termpiId);
        Termcarddetails tc = em.find(Termcarddetails.class, cid);
        Termcarddetails tcd = new Termcarddetails();
      tcd.setCid(cid);
        tcd.setTermpiId(tai);
        tcd.setPaymentno(paymentno);
     tcd.setPaymentMethod(paymentMethod);
        tcd.setName(name);
        tcd.setStatus(status);
       
        tcd.setAmount(amount);
       tcd.setDate(date);
       
      
        
      
        
        Collection<Termcarddetails> tailist = tai.getTermcarddetailsCollection();
        
        tailist.add(tcd);
        
        
        tai.setTermcarddetailsCollection(tailist); 
        
        
        em.merge(tai);
        
        em.merge(tc);
       }catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
     
    }
         @Override
    public Termcarddetails getPaymentById(Integer cid){
         return em.find(Termcarddetails.class, cid);
    }
//        @Override
//    public  Collection<Termcarddetails> getcardbylid(int loginid){
//       
//            Collection<Termcarddetails> c = em.createQuery("SELECT t FROM Termcarddetails t,TerminsuPi tp WHERE t.termpiId=tp.id AND tp.loginid="+loginid+"").getResultList();
//         return c;
//    }
        
      @Override
    public Collection<TerminsuPi> gethistory(Integer lid){
      
      Login l = em.find(Login.class, lid);
        Collection<TerminsuPi> t = l.getTerminsuPiCollection();
        return t;
    }
    @Override
    public Collection<Termcarddetails> getcardbylid(Integer loginid){
        Collection<Termcarddetails> c = em.createQuery("SELECT t FROM Termcarddetails t,TerminsuPi tp WHERE t.termpiId.id=tp.id and tp.loginid.lid = :loginid").setParameter("loginid", loginid).getResultList();
        return c;
    }
    
    //Hicard
      @Override
      public Collection<Hicarddetails> getAllHCD() {
      Collection<Hicarddetails> tcd = em.createNamedQuery("Hicarddetails.findAll").getResultList();
        return tcd;
       }
         
         
   


      @Override
          public void addHCD( int hid ,int paymentno, String name, String paymentMethod, String status, float amount,String date) {
       try{
          HealthInsu tai = em.find(HealthInsu.class, hid);
        
        Hicarddetails tcd = new Hicarddetails();
      
        tcd.setHid(tai);
        tcd.setPaymentno(paymentno);
     tcd.setPaymentMethod(paymentMethod);
        tcd.setName(name);
        tcd.setStatus(status);
       
        tcd.setAmount(amount);
       tcd.setDate(date);
       
      
        
      
        
        Collection<Hicarddetails> tailist = tai.getHicarddetailsCollection();
        
        tailist.add(tcd);
        
        
        tai.setHicarddetailsCollection(tailist); 
        
        
        em.merge(tai);
        
        em.persist(tcd);
       }catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
    }
         
      @Override
       public  Collection<Hicarddetails> higetLastcard(){
       
            Collection<Hicarddetails> c = em.createQuery("SELECT t FROM Hicarddetails t WHERE t.cid=(SELECT MAX(t.cid) FROM Hicarddetails t)").getResultList();
         return c;
      
           
    } 
      @Override
        public void hiupdateStatus(int cid,int hid ,int paymentno, String name, String paymentMethod, String status, float amount,String date) {
   try{
          HealthInsu tai = em.find(HealthInsu.class, hid);
        Hicarddetails tc = em.find(Hicarddetails.class, cid);
        Hicarddetails tcd = new Hicarddetails();
      tcd.setCid(cid);
        tcd.setHid(tai);
        tcd.setPaymentno(paymentno);
     tcd.setPaymentMethod(paymentMethod);
        tcd.setName(name);
        tcd.setStatus(status);
       
        tcd.setAmount(amount);
       tcd.setDate(date);
       
      
        
      
        
        Collection<Hicarddetails> tailist = tai.getHicarddetailsCollection();
        
        tailist.add(tcd);
        
        
        tai.setHicarddetailsCollection(tailist); 
        
        
        em.merge(tai);
        
        em.merge(tc);
       }catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
     
    }
      @Override
         public Hicarddetails higetPaymentById(Integer cid){
         return em.find(Hicarddetails.class, cid);
    }
          @Override
    public Collection<Hicarddetails> gethicardbylid(Integer loginid){
        Collection<Hicarddetails> c = em.createQuery("SELECT t FROM Hicarddetails t,HealthInsu tp WHERE t.hid.hid=tp.hid and tp.loginid.lid = :loginid").setParameter("loginid", loginid).getResultList();
        return c;
    }
  @Override
      public Collection<Feedback> getAllfeedback() {
      Collection<Feedback> f = em.createNamedQuery("Feedback.findAll").getResultList();
        return f;
       }
         
         
   


      @Override
          public void addFeedback( int lid ,int policyid, String msg) {
       try{
          Login l = em.find(Login.class, lid);
        Policy p = em.find(Policy.class, policyid);
        Feedback f = new Feedback();
      
        f.setLid(l);
        f.setPolicyid(p);
        f.setMsg(msg);
       
      
        
      
        
        Collection<Feedback> llist = l.getFeedbackCollection();
        Collection<Feedback> plist = p.getFeedbackCollection();
       
        llist.add(f);
        plist.add(f);
        
        l.setFeedbackCollection(llist);
        p.setFeedbackCollection(plist);
        
        
        
        em.merge(l);
        em.merge(p);
        
        em.persist(f);
       }catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
    }
}
