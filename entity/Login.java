/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hardik
 */
@Entity
@Table(name = "login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
    @NamedQuery(name = "Login.findByLid", query = "SELECT l FROM Login l WHERE l.lid = :lid"),
    @NamedQuery(name = "Login.findByUsername", query = "SELECT l FROM Login l WHERE l.username = :username"),
    @NamedQuery(name = "Login.findByEmailid", query = "SELECT l FROM Login l WHERE l.emailid = :emailid"),
    @NamedQuery(name = "Login.findByPassword", query = "SELECT l FROM Login l WHERE l.password = :password")})
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lid")
    private Integer lid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "emailid")
    private String emailid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loginid")
    private Collection<TerminsuPi> terminsuPiCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loginid")
    private Collection<HealthInsu> healthInsuCollection;
    @JoinColumn(name = "roleid", referencedColumnName = "rid")
    @ManyToOne(optional = false)
    private Role roleid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lid")
    private Collection<Feedback> feedbackCollection;

    public Login() {
    }

    public Login(Integer lid) {
        this.lid = lid;
    }

    public Login(Integer lid, String username, String emailid, String password) {
        this.lid = lid;
        this.username = username;
        this.emailid = emailid;
        this.password = password;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<TerminsuPi> getTerminsuPiCollection() {
        return terminsuPiCollection;
    }

    public void setTerminsuPiCollection(Collection<TerminsuPi> terminsuPiCollection) {
        this.terminsuPiCollection = terminsuPiCollection;
    }

    @XmlTransient
    public Collection<HealthInsu> getHealthInsuCollection() {
        return healthInsuCollection;
    }

    public void setHealthInsuCollection(Collection<HealthInsu> healthInsuCollection) {
        this.healthInsuCollection = healthInsuCollection;
    }

    public Role getRoleid() {
        return roleid;
    }

    public void setRoleid(Role roleid) {
        this.roleid = roleid;
    }

    @XmlTransient
    public Collection<Feedback> getFeedbackCollection() {
        return feedbackCollection;
    }

    public void setFeedbackCollection(Collection<Feedback> feedbackCollection) {
        this.feedbackCollection = feedbackCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lid != null ? lid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.lid == null && other.lid != null) || (this.lid != null && !this.lid.equals(other.lid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Login[ lid=" + lid + " ]";
    }
    
}
