create schema homegym;
use homegym;

create table dati_pagamento(
numero_carta char(16) primary key,
cvv integer not null,
data_scadenza date not null
);

create table utente(
email varchar(30) primary key,
password varchar(30) not null,
dati_pagamento char(16),
tipo varchar(30) not null,
foreign key(dati_pagamento) references dati_pagamento(numero_carta)
ON UPDATE CASCADE ON DELETE CASCADE
);

create table azienda(
ragione_sociale varchar(30) not null,
partita_iva char(11) primary key,
citta varchar(30) not null,
indirizzo_sede_legale varchar(50) not null,
cap char(5) not null,
numero_telefono varchar(30) not null,
email varchar(30) not null unique,
foreign key(email) references utente(email)
ON UPDATE CASCADE ON DELETE CASCADE
);

create table persona_fisica(
ID integer primary key AUTO_INCREMENT,
cognome varchar(30) not null,
nome varchar(30) not null,
data_nascita date not null,
genere varchar(20) not null,
numero_telefono varchar(30) not null unique,
email varchar(30) not null unique,
foreign key(email) references utente(email)
ON UPDATE CASCADE ON DELETE CASCADE
);

create table indirizzo_spedizione(
ID integer primary key,
via varchar(40) not null,
citta varchar(40) not null,
cap varchar(40) not null,
utente varchar(50) not null,
foreign key(utente) references utente(email)
ON UPDATE CASCADE ON DELETE CASCADE
);

create table ordine(
ID integer primary key,
stato varchar(30) not null,
data date not null,
utente varchar(30) not null,
foreign key(utente) references utente(email)
ON UPDATE CASCADE ON DELETE CASCADE,
indirizzo_spedizione integer not null,
foreign key(indirizzo_spedizione) references indirizzo_spedizione(ID)
ON UPDATE CASCADE ON DELETE CASCADE,
totale integer DEFAULT 0
);

create table categoria(
ID integer primary key,
nome varchar(30) not null
);

create table prodotto(
codice varchar(30) primary key,
nome varchar(30) not null,
descrizione varchar(400) not null,
prezzo float not null,
iva integer not null,
sconto integer,
sottocategoria varchar(30) not null,
categoria integer not null,
foreign key(categoria) references categoria(ID)
ON UPDATE CASCADE ON DELETE CASCADE,
url_immagine varchar(50) not null
);

create table feedback(
ID integer primary key,
valutazione varchar(500) not null,
commento varchar(100) not null,
email varchar(30) not null,
foreign key(email) references utente(email)
ON UPDATE CASCADE ON DELETE CASCADE,
prodotto varchar(50) not null,
foreign key(prodotto) references prodotto(codice)
);

create table composizione(
ordine integer not null,
foreign key(ordine) references ordine(ID)
ON UPDATE CASCADE ON DELETE CASCADE,
prodotto varchar(30) references prodotto(codice)
ON UPDATE CASCADE ON DELETE CASCADE,
quantita integer not null,
prezzo_acquisto float not null,
prezzo_iva integer not null,
primary key (ordine,prodotto)
);













