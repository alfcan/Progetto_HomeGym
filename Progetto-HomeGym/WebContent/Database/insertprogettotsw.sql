insert into dati_pagamento value("1234567887654321", "1234", "2023-05-05");

insert into utente value("giuseppeesposito@gmail.com", "giuseppe00", "1234567887654321", "Persona fisica");
insert into utente(email, password, tipo) value("fitcardio@gmail.com", "fitcardio00", "Azienda");
insert into utente(email, password, tipo) value("bodyfless@gmail.com", "Password1", "Azienda");
insert into utente(email, password, tipo) value("sanosprint@gmail.com", "Password1", "Azienda");

insert into azienda value("FitCardio","86334519757","Napoli","Via Nuova Dietro La Vigna","80121","3336810506","fitcardio@gmail.com");
insert into azienda value("Bodyfless","34546732564","Milano","Via G.B.Vico", "66054", " 3337856432", "bodyfless@gmail.com");
insert into azienda value("Sano Sprint", "98745110982", "Napoli", "Via Tansillo Luigi", "80125 ", "3330938457","sanosprint@gmail.com");

insert into persona_fisica(nome, cognome, genere, numero_telefono, email) value("Esposito","Giuseppe","Uomo", "3286534342", "giuseppeesposito@gmail.com");

insert into indirizzo_spedizione value("1111","Via Arbostella","Napoli","80125","giuseppeesposito@gmail.com");
insert into indirizzo_spedizione value("2222","Via Margherita","Napoli","80121","fitcardio@gmail.com");

insert into ordine value(1,"Ordinato","23-03-21","giuseppeesposito@gmail.com","1111",16700);
insert into ordine value(2,"Ordinato","06-10-21","fitcardio@gmail.com","2222",13438);

insert into categoria value (1, "Categoria 1");
insert into categoria value (2, "Categoria 2");
insert into categoria value (3, "Categoria 3");
insert into categoria value (4, "Categoria 4");
insert into categoria value (5, "Categoria 5");

insert into prodotto value("AAAA1","Technogym MyRun","Design essenziale e compatto, superficie di corsa adattiva, allenamenti personalizzati direttamente sul tuo tablet.","3200","22","0","Fitness","1",".");
insert into prodotto value("BBBB2","Synchro Forma","Synchro Forma è il cross trainer professionale perfetto per godersi un allenamento total body in tutta semplicità. La fluidità di movimento riduce lo stress articolare e muscolare, rendendolo ideale per dimagrire, tonificare e migliorare la coordinazione.","3590","22","0","Fitness","2",".");
insert into prodotto value("CCCC3","Jump Rope","Jump Rope contribuisce ad aumentare il condizionamento metabolico e la coordinazione che costituiscono la base di velocità, agilità e rapidità. Le impugnature della corda sono zigrinate nella parte inferiore per migliorare la presa e presentano dei cuscinetti a sfera per una rotazione più efficiente durante l'allenamento.","69","22","0","Accessori","3",".");
insert into prodotto value("DDDD4","Exercise Mat","Lo spessore della schiuma e la superficie antiscivolo rendono Exercise Mat un comodo strumento per eseguire esercizi di stretching e di forza in maniera comoda e sicura direttamente sul pavimento, senza che il tappetino slitti, si pieghi o si sposti durante l'esercizio.","79","22","20","Accessori","4",".");
insert into prodotto value("EEEE5","Jog Forma","Jog Forma è un tapis roulant professionale che, grazie alla nuova interfaccia utente con guida all'allenamento tramite QR code e ai nuovi Hand Sensor, consente di allenarsi in modo semplice ed efficace. La pedana Long Life Deck, il telaio resistente e la potenza del motore garantiscono prestazioni di livello superiore.","6900","22","0","Fitness","5",".");

insert into composizione value(1,"AAAA1",2,3200,22);
insert into composizione value(1,"BBBB2",1,3400,22);
insert into composizione value(1,"EEEE5",1,6900,22);
insert into composizione value(2,"AAAA1",2,3200,22);
insert into composizione value(2,"CCCC3",2,69,22);
insert into composizione value(2,"EEEE5",1,6900,22);

