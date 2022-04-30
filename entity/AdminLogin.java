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
@Table(name = "admin_login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminLogin.findAll", query = "SELECT a FROM AdminLogin a"),
    @NamedQuery(name = "AdminLogin.findByLid", query = "SELECT a FROM AdminLogin a WHERE a.lid = :lid"),
    @NamedQuery(name = "AdminLogin.findByUsername", query = "SELECT a FROM AdminLogin a WHERE a.username = :username"),
    @NamedQuery(name = "AdminLogin.findByEmailid", query = "SELECT a FROM AdminLogin a WHERE a.emailid = :emailid"),
    @NamedQuery(name = "AdminLogin.findByPassword", query = "SELECT a FROM AdminLogin a WHERE a.password = :password")})
public class AdminLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lid")
    private Integer lid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "emailid")
    private String emailid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "roleid", referencedColumnName = "rid")
    @ManyToOne(optional = false)
    private Role roleid;

    public AdminLogin() {
    }

    public AdminLogin(Integer lid) {
        this.lid = lid;
    }

    public AdminLogin(Integer lid, String username, String emailid, String password) {
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

    public Role getRoleid() {
        return roleid;
    }

    public void setRoleid(Role roleid) {
        this.roleid = roleid;
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
        if (!(object instanceof AdminLogin)) {
            return false;
        }
        AdminLogin other = (AdminLogin) object;
        if ((this.lid == null && other.lid != null) || (this.lid != null && !this.lid.equals(other.lid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AdminLogin[ lid=" + lid + " ]";
    }
    
}
