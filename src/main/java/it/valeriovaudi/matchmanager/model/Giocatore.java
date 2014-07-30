package it.valeriovaudi.matchmanager.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Valerio
 * Date: 26/01/13
 * Time: 14.34
 * To change this template use File | Settings | File Templates.
 *
 *
 *
 *
 */
@Entity
@Table(name = "GIOCATORE")
@NamedQueries(value = {@NamedQuery(name = "Giocatore.fingByCodiceFiscale",query = "from Giocatore where codiceFiscale=:codiceFiscale"),
                       @NamedQuery(name = "Giocatore.findAll",query = "from Giocatore"),
                       @NamedQuery(name = "Giocatore.findSquadreReferenziate",query = "select squadra from Squadra squadra where squadra.referente.codiceFiscale =:codiceFiscale"),
                       @NamedQuery(name = "Giocatore.findByUserName",query = "from Giocatore giocatore where giocatore.userName = :userName")})
public class Giocatore implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "CODICE_FISCALE")
    private String codiceFiscale;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "COGNOME")
    private String cognome;

    @Column(name = "USER_NAME", unique = true)
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "MAIL",unique = true)
    private String mail;

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String
    toString() {
        return "Giocatore{" +
                "codiceFiscale='" + codiceFiscale + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Giocatore)) return false;

        Giocatore giocatore = (Giocatore) o;

        if (!codiceFiscale.equals(giocatore.codiceFiscale)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return codiceFiscale.hashCode();
    }
}

