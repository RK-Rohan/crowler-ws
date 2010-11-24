package it.stasbranger.crowlerws.ws.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Clienti entity. @author MyEclipse Persistence Tools
 */
@Entity
@NamedQueries({
	@NamedQuery(name="clienteDuplicato",
              query="SELECT c " +
                    "FROM Clienti c " +
                    "WHERE c.email = ?1 " +
                    "AND c.provincia = ?2 " +
                    "AND c.citta = ?3")
})
@Table(name="clienti"
    ,catalog="spiderdb"
)

public class Clienti  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer idRicerca;
     private String ragioneSociale;
     private String categoriaPaginegialle;
     private String provincia;
     private String citta;
     private String telefono;
     private String fax;
     private String email;
     private String indirizzo;
     private String cap;
     private Integer numeroInviati;
     private String note;
     private Integer categoria;


    // Constructors

    /** default constructor */
    public Clienti() {
    }

	/** minimal constructor */
    public Clienti(Integer idRicerca, Integer numeroInviati) {
        this.idRicerca = idRicerca;
        this.numeroInviati = numeroInviati;
    }
    
    /** full constructor */
    public Clienti(Integer idRicerca, String ragioneSociale, String categoriaPaginegialle, String provincia, String citta, String telefono, String fax, String email, String indirizzo, String cap, Integer numeroInviati, String note, Integer categoria) {
        this.idRicerca = idRicerca;
        this.ragioneSociale = ragioneSociale;
        this.categoriaPaginegialle = categoriaPaginegialle;
        this.provincia = provincia;
        this.citta = citta;
        this.telefono = telefono;
        this.fax = fax;
        this.email = email;
        this.indirizzo = indirizzo;
        this.cap = cap;
        this.numeroInviati = numeroInviati;
        this.note = note;
        this.categoria = categoria;
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
    
    @Column(name="id_ricerca", nullable=false)

    public Integer getIdRicerca() {
        return this.idRicerca;
    }
    
    public void setIdRicerca(Integer idRicerca) {
        this.idRicerca = idRicerca;
    }
    
    @Column(name="ragione_sociale")

    public String getRagioneSociale() {
        return this.ragioneSociale;
    }
    
    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }
    
    @Column(name="categoria_paginegialle")

    public String getCategoriaPaginegialle() {
        return this.categoriaPaginegialle;
    }
    
    public void setCategoriaPaginegialle(String categoriaPaginegialle) {
        this.categoriaPaginegialle = categoriaPaginegialle;
    }
    
    @Column(name="provincia", length=2)

    public String getProvincia() {
        return this.provincia;
    }
    
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    @Column(name="citta")

    public String getCitta() {
        return this.citta;
    }
    
    public void setCitta(String citta) {
        this.citta = citta;
    }
    
    @Column(name="telefono", length=15)

    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Column(name="fax", length=15)

    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }
    
    @Column(name="email")

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="indirizzo")

    public String getIndirizzo() {
        return this.indirizzo;
    }
    
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    
    @Column(name="cap", length=15)

    public String getCap() {
        return this.cap;
    }
    
    public void setCap(String cap) {
        this.cap = cap;
    }
    
    @Column(name="numero_inviati", nullable=false)

    public Integer getNumeroInviati() {
        return this.numeroInviati;
    }
    
    public void setNumeroInviati(Integer numeroInviati) {
        this.numeroInviati = numeroInviati;
    }
    
    @Column(name="note", length=65535)

    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    
    @Column(name="categoria")

    public Integer getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }
   








}