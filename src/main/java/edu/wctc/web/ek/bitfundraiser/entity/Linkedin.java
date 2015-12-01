package edu.wctc.web.ek.bitfundraiser.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author emmakordik
 */
@Entity
@Table(name = "linkedin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Linkedin.findAll", query = "SELECT l FROM Linkedin l"),
    @NamedQuery(name = "Linkedin.findByIdlinkedin", query = "SELECT l FROM Linkedin l WHERE l.idlinkedin = :idlinkedin"),
    @NamedQuery(name = "Linkedin.findByName", query = "SELECT l FROM Linkedin l WHERE l.name = :name"),
    @NamedQuery(name = "Linkedin.findByEmail", query = "SELECT l FROM Linkedin l WHERE l.email = :email")})
public class Linkedin implements Serializable {
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlinkedin")
    private Integer idlinkedin;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 60)
    @Column(name = "email")
    private String email;

    public Linkedin() {
    }

    public Linkedin(Integer idlinkedin) {
        this.idlinkedin = idlinkedin;
    }

    public Integer getIdlinkedin() {
        return idlinkedin;
    }

    public void setIdlinkedin(Integer idlinkedin) {
        this.idlinkedin = idlinkedin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlinkedin != null ? idlinkedin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Linkedin)) {
            return false;
        }
        Linkedin other = (Linkedin) object;
        if ((this.idlinkedin == null && other.idlinkedin != null) || (this.idlinkedin != null && !this.idlinkedin.equals(other.idlinkedin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "wctc.edu.web.ek.bitfundraiser.entity.Linkedin[ idlinkedin=" + idlinkedin + " ]";
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
