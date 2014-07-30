package it.valeriovaudi.matchmanager.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "PARTITA")
@NamedQueries(value = {@NamedQuery(name = "Partita.findById",query = "from Partita where partitaId.giorno =:giorno and partitaId.ora =:ora and partitaId.campoId=:campoId"),
                       @NamedQuery(name = "Partita.findAll",query = "from Partita"),
                       @NamedQuery(name = "Partita.find",query = "from Partita partita where partita.partitaId.campoId=:campo AND partita.partitaId.ora=:ora AND partita.partitaId.giorno=:giorno and partita.squadraSfidata.giocatori.size < 5"),
                       @NamedQuery(name = "Partita.findWithoutPrincipal",query = "from Partita partita where partita.partitaId.campoId=:campo AND partita.partitaId.ora=:ora AND partita.partitaId.giorno=:giorno AND :principal not member of partita.squadraSfidante.giocatori  AND :principal not member of partita.squadraSfidata.giocatori and partita.squadraSfidata.giocatori.size < 5 "),
                       @NamedQuery(name = "Partita.findAvaibleMatch",query = " select partita.partitaId.campoId as footballField from Partita partita where partita.partitaId.giorno=:giorno and partita.partitaId.ora =:ora"),
                       @NamedQuery(name = "Partita.findAllAvaiableMatch",query = "from Partita partita where partita.partitaId.giorno >=:date AND (:principal not member of partita.squadraSfidante.giocatori  AND :principal not member of partita.squadraSfidata.giocatori)"),
                       @NamedQuery(name = "Partita.findAllMatchReserved",query = "from Partita partita where partita.partitaId.giorno >=:date AND (:principal member of partita.squadraSfidante.giocatori  OR :principal member of partita.squadraSfidata.giocatori)")})
public class Partita implements Serializable{

	private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PartitaId partitaId;

    @JoinColumn(name = "NOME_SQUADRA_SFIDATA")
    @OneToOne
    private Squadra squadraSfidata;

    @JoinColumn(name = "NOME_SQUADRA_SFIDANTE")
    @OneToOne
    private Squadra squadraSfidante;

    public PartitaId getPartitaId() {
        return partitaId;
    }

    public void setPartitaId(PartitaId partitaId) {
        this.partitaId = partitaId;
    }

    public Squadra getSquadraSfidata() {
        return squadraSfidata;
    }

    public void setSquadraSfidata(Squadra squadraSfidata) {
        this.squadraSfidata = squadraSfidata;
    }

    public Squadra getSquadraSfidante() {
        return squadraSfidante;
    }

    public void setSquadraSfidante(Squadra squadraSfidante) {
        this.squadraSfidante = squadraSfidante;
    }

    @Override
    public String toString() {
        return "Partita{" +
                "partitaId=" + partitaId +
                ", squadraSfidata=" + squadraSfidata +
                ", squadraSfidante=" + squadraSfidante +
                '}';
    }
}
