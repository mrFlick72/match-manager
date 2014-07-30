package it.valeriovaudi.matchmanager.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Valerio
 * Date: 14/03/13
 * Time: 19.49
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
public class PartitaId implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PartitaId() {}

    public PartitaId(String campoId, Date giorno, String ora) {
        this.campoId = campoId;
        this.giorno = giorno;
        this.ora = ora;
    }

    @Column(name = "CAMPO_ID")
    private String campoId;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_PARTITA")
    private Date giorno;

    @Column(name = "ORA")
    private String ora;

    public String getCampoId() {
        return campoId;
    }

    public Date getGiorno() {
        return giorno;
    }

    public String getOra() {
        return ora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PartitaId)) return false;

        PartitaId partitaId = (PartitaId) o;

        if (!campoId.equals(partitaId.campoId)) return false;
        if (!giorno.equals(partitaId.giorno)) return false;
        if (!ora.equals(partitaId.ora)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = campoId.hashCode();
        result = 31 * result + giorno.hashCode();
        result = 31 * result + ora.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PartitaId{" +
                "campoId='" + campoId + '\'' +
                ", giorno=" + giorno +
                ", ora='" + ora + '\'' +
                '}';
    }
}
