/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hardik
 */
@Entity
@Table(name = "himember")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Himember.findAll", query = "SELECT h FROM Himember h"),
    @NamedQuery(name = "Himember.findByMemberid", query = "SELECT h FROM Himember h WHERE h.memberid = :memberid"),
    @NamedQuery(name = "Himember.findByMembername", query = "SELECT h FROM Himember h WHERE h.membername = :membername"),
    @NamedQuery(name = "Himember.findByDobm", query = "SELECT h FROM Himember h WHERE h.dobm = :dobm"),
    @NamedQuery(name = "Himember.findByRtop", query = "SELECT h FROM Himember h WHERE h.rtop = :rtop"),
    @NamedQuery(name = "Himember.findByHeight", query = "SELECT h FROM Himember h WHERE h.height = :height"),
    @NamedQuery(name = "Himember.findByWeight", query = "SELECT h FROM Himember h WHERE h.weight = :weight"),
    @NamedQuery(name = "Himember.findByLoginid", query = "SELECT h FROM Himember h WHERE h.loginid = :loginid"),
    @NamedQuery(name = "Himember.findByIsdelete", query = "SELECT h FROM Himember h WHERE h.isdelete = :isdelete"),
    @NamedQuery(name = "Himember.findByInsuCustId", query = "SELECT h FROM Himember h WHERE h.insuCustId = :insuCustId")})
public class Himember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "memberid")
    private Integer memberid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "membername")
    private String membername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "dobm")
    private String dobm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "rtop")
    private String rtop;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "height")
    private String height;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "weight")
    private String weight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "loginid")
    private int loginid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdelete")
    private int isdelete;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "insu_cust_id")
    private String insuCustId;
    @JoinColumn(name = "hid", referencedColumnName = "hid")
    @ManyToOne(optional = false)
    private HealthInsu hid;

    public Himember() {
    }

    public Himember(Integer memberid) {
        this.memberid = memberid;
    }

    public Himember(Integer memberid, String membername, String dobm, String rtop, String height, String weight, int loginid, int isdelete, String insuCustId) {
        this.memberid = memberid;
        this.membername = membername;
        this.dobm = dobm;
        this.rtop = rtop;
        this.height = height;
        this.weight = weight;
        this.loginid = loginid;
        this.isdelete = isdelete;
        this.insuCustId = insuCustId;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public String getDobm() {
        return dobm;
    }

    public void setDobm(String dobm) {
        this.dobm = dobm;
    }

    public String getRtop() {
        return rtop;
    }

    public void setRtop(String rtop) {
        this.rtop = rtop;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getLoginid() {
        return loginid;
    }

    public void setLoginid(int loginid) {
        this.loginid = loginid;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    public String getInsuCustId() {
        return insuCustId;
    }

    public void setInsuCustId(String insuCustId) {
        this.insuCustId = insuCustId;
    }

    public HealthInsu getHid() {
        return hid;
    }

    public void setHid(HealthInsu hid) {
        this.hid = hid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberid != null ? memberid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Himember)) {
            return false;
        }
        Himember other = (Himember) object;
        if ((this.memberid == null && other.memberid != null) || (this.memberid != null && !this.memberid.equals(other.memberid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Himember[ memberid=" + memberid + " ]";
    }
    
}
