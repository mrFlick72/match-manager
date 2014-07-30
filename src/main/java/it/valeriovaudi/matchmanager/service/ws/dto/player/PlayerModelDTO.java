package it.valeriovaudi.matchmanager.service.ws.dto.player;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: seminario
 * Date: 4/11/14
 * Time: 12:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlayerModelDTO implements Serializable {

    private String nome;
    private String cognome;

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
}
