CREATE TABLE FORMAZIONE
(
    NOME_SQUADRA VARCHAR(255) NOT NULL,
    CODICE_FISCALE_GIOCATORE VARCHAR(16) NOT NULL,
    PRIMARY KEY (NOME_SQUADRA, CODICE_FISCALE_GIOCATORE)
);
CREATE TABLE GIOCATORE
(
    NOME VARCHAR(30) NOT NULL,
    COGNOME VARCHAR(30) NOT NULL,
    CODICE_FISCALE VARCHAR(16) PRIMARY KEY NOT NULL,
    USER_NAME VARCHAR(50) NOT NULL,
    MAIL VARCHAR(50) NOT NULL,
    PASSWORD VARCHAR(50) NOT NULL
);
CREATE TABLE PARTITA
(
    DATA_PARTITA DATE NOT NULL,
    ORA VARCHAR(7) NOT NULL,
    CAMPO_ID VARCHAR(30) NOT NULL,
    NOME_SQUADRA_SFIDATA VARCHAR(255),
    NOME_SQUADRA_SFIDANTE VARCHAR(255) NOT NULL,
    PRIMARY KEY (DATA_PARTITA, ORA, CAMPO_ID)
);
CREATE TABLE SQUADRA
(
    NOME VARCHAR(255) PRIMARY KEY NOT NULL,
    REFERENTE VARCHAR(16)
);
CREATE INDEX CODICE_FISCALE_GIOCATORE ON FORMAZIONE (CODICE_FISCALE_GIOCATORE);
CREATE UNIQUE INDEX unique_MAIL ON GIOCATORE (MAIL);
CREATE UNIQUE INDEX unique_USER_NAME ON GIOCATORE (USER_NAME);
CREATE INDEX NOME_SQUADRA_SFIDANTE ON PARTITA (NOME_SQUADRA_SFIDANTE);
CREATE INDEX NOME_SQUADRA_SFIDATA ON PARTITA (NOME_SQUADRA_SFIDATA);
CREATE INDEX REFERENTE ON SQUADRA (REFERENTE);
