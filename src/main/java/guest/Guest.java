package guest;
 
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "TEST_GUEST")
public class Guest implements Serializable {
    private static final long serialVersionUID = 1L;
 
    // Persistent Fields:
    @Id @GeneratedValue
    @Column(name = "GUESTID")
    Long id;
    @Column(name = "GUESTNAME")
    private String name;
    @Column(name = "GUESTSIGNDATE")
    private Date signingDate;
 
    // Constructors:
    public Guest() {
    }
 
    public Guest(String name) {
        this.name = name;
        this.signingDate = new Date(System.currentTimeMillis());
    }
 
    // String Representation:
    @Override
    public String toString() {
        return name + " (signed on " + signingDate + ")";
    }
}