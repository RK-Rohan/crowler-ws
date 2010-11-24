package it.stasbranger.crowlerws.ws.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Ricerca entity. @author MyEclipse Persistence Tools
 */
@Entity
@NamedQueries({
	@NamedQuery(name="lastRicerca",
              query="SELECT r " +
                    "FROM Ricerca r " +
                    "WHERE r.id IN (SELECT MAX(rr.id) FROM Ricerca rr)"),
    @NamedQuery(name="findCosaDove",
              query="SELECT r " +
                    "FROM Ricerca r " +
                    "WHERE r.cosa = ?1 " +
                    "AND r.dove = ?2")                
})	
@Table(name="ricerca"
    ,catalog="spiderdb"
)
public class Ricerca  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String cosa;
     private String dove;
     private Timestamp data;


    // Constructors

    /** default constructor */
    public Ricerca() {
    }

    
    /** full constructor */
    public Ricerca(String cosa, String dove, Timestamp data) {
        this.cosa = cosa;
        this.dove = dove;
        this.data = data;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="cosa", nullable=false)

    public String getCosa() {
        return this.cosa;
    }
    
    public void setCosa(String cosa) {
        this.cosa = cosa;
    }
    
    @Column(name="dove", nullable=false)

    public String getDove() {
        return this.dove;
    }
    
    public void setDove(String dove) {
        this.dove = dove;
    }
    
    @Column(name="data", nullable=false, length=19)

    public Timestamp getData() {
        return this.data;
    }
    
    public void setData(Timestamp data) {
        this.data = data;
    }
   








}