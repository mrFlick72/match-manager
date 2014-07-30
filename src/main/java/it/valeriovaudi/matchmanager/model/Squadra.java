package it.valeriovaudi.matchmanager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "SQUADRA")
@NamedQueries(value = {@NamedQuery(name = "Squadra.findByName",query = "from Squadra where nome=:nome"),
                       @NamedQuery(name = "Squadra.findAll",query = "from Squadra squadra where squadra not in (select partita.squadraSfidata from Partita partita)"),
                       @NamedQuery(name = "Squadra.findByReferente",query = "from Squadra squadra where squadra.referente =:referente")})

public class Squadra implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "NOME")
    private String nome;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "FORMAZIONE",
               joinColumns = @JoinColumn(name = "NOME_SQUADRA"),
               inverseJoinColumns = @JoinColumn(name = "CODICE_FISCALE_GIOCATORE"))
    private List<Giocatore> giocatori;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "REFERENTE")
    private Giocatore referente;

    public List<Giocatore> getGiocatori() {
        return giocatori;
    }

    public void setGiocatori(List<Giocatore> giocatori) {
        this.giocatori = giocatori;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Giocatore getReferente() {
        return referente;
    }

    public void setReferente(Giocatore referente) {
        this.referente = referente;
    }

    @Override
    public String toString() {
        return "Squadra{" +
                "nome='" + nome + '\'' +
                ", giocatori=" + giocatori +
                ", referente=" + referente +
                '}';
    }
}
