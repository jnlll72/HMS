DROP DATABASE IF EXISTS HMS_TEST2;

CREATE DATABASE HMS_TEST2;

USE HMS_TEST2;

CREATE TABLE Salle(idSalle INT AUTO_INCREMENT PRIMARY KEY, nomSalle VARCHAR(25) NOT NULL);

CREATE TABLE Marque(idMarque INT AUTO_INCREMENT PRIMARY KEY, nomMarque VARCHAR(25) NOT NULL);

CREATE TABLE Composant(idComposant INT AUTO_INCREMENT PRIMARY KEY, nomComposant VARCHAR(25) NOT NULL);

CREATE TABLE TypeM(idTypeM INT AUTO_INCREMENT PRIMARY KEY, nomTypeM VARCHAR (25) NOT NULL);

CREATE TABLE Caracteristique(idCarac INT AUTO_INCREMENT PRIMARY KEY, nomCarac VARCHAR(25) NOT NULL);

CREATE TABLE Posseder(idComposant INT NOT NULL, idCarac INT NOT NULL);

CREATE TABLE Contenir(idMateriel INT NOT NULL, idComposant INT NOT NULL);

CREATE TABLE Historique(idHistorique INT AUTO_INCREMENT PRIMARY KEY, dateMaj DATE NOT NULL, description VARCHAR(100) NOT NULL);

CREATE TABLE Materiel(idMateriel INT AUTO_INCREMENT PRIMARY KEY NOT NULL, nomMateriel VARCHAR(25) NOT NULL, etatMateriel TINYINT(1) NOT NULL, qrCode VARCHAR(50));

ALTER TABLE Posseder ADD FOREIGN KEY (idComposant) REFERENCES Composant(idComposant); 
ALTER TABLE Posseder ADD FOREIGN KEY (idCarac) REFERENCES Caracteristique(idCarac); 
ALTER TABLE Posseder ADD PRIMARY KEY (idComposant,idCarac);

ALTER TABLE Contenir ADD FOREIGN KEY (idMateriel) REFERENCES Materiel(idMateriel); 
ALTER TABLE Contenir ADD FOREIGN KEY (idComposant) REFERENCES Composant(idComposant); 
ALTER TABLE Contenir ADD PRIMARY KEY (idMateriel,idComposant);

ALTER TABLE Materiel ADD idMarque INT NOT NULL;
ALTER TABLE Materiel ADD idTypeM INT NOT NULL;
ALTER TABLE Materiel ADD idSalle INT;

ALTER TABLE Materiel ADD FOREIGN KEY (idMarque) REFERENCES Marque(idMarque);
ALTER TABLE Materiel ADD FOREIGN KEY (idTypeM) REFERENCES TypeM(idTypeM);
ALTER TABLE Materiel ADD FOREIGN KEY (idSalle) REFERENCES Salle(idSalle);

ALTER TABLE Historique ADD idMateriel INT NOT NULL;
ALTER TABLE Historique ADD FOREIGN KEY (idMateriel) REFERENCES Materiel(idMateriel);

INSERT INTO Salle(nomSalle) VALUES ('SALLE01');
INSERT INTO Salle(nomSalle) VALUES ('SALLE02');
INSERT INTO Salle(nomSalle) VALUES ('SALLE03');
INSERT INTO Salle(nomSalle) VALUES ('SALLE04');
INSERT INTO Salle(nomSalle) VALUES ('SALLE05');
INSERT INTO Salle(nomSalle) VALUES ('SALLE06');
INSERT INTO Salle(nomSalle) VALUES ('SALLE07');
INSERT INTO Salle(nomSalle) VALUES ('SALLE08');
INSERT INTO Salle(nomSalle) VALUES ('SALLE09');
INSERT INTO Salle(nomSalle) VALUES ('SALLE10');
INSERT INTO Salle(nomSalle) VALUES ('SALLE11');
INSERT INTO Salle(nomSalle) VALUES ('SALLE12');
INSERT INTO Salle(nomSalle) VALUES ('SALLE13');
INSERT INTO Salle(nomSalle) VALUES ('SALLE14');
INSERT INTO Salle(nomSalle) VALUES ('SALLE15');

INSERT INTO Marque(nomMarque) VALUES ('MARQUE01');
INSERT INTO Marque(nomMarque) VALUES ('MARQUE02');
INSERT INTO Marque(nomMarque) VALUES ('MARQUE03');
INSERT INTO Marque(nomMarque) VALUES ('MARQUE04');
INSERT INTO Marque(nomMarque) VALUES ('MARQUE05');
INSERT INTO Marque(nomMarque) VALUES ('MARQUE06');
INSERT INTO Marque(nomMarque) VALUES ('MARQUE07');
INSERT INTO Marque(nomMarque) VALUES ('MARQUE08');
INSERT INTO Marque(nomMarque) VALUES ('MARQUE09');
INSERT INTO Marque(nomMarque) VALUES ('MARQUE10');

INSERT INTO Caracteristique(nomCarac) VALUES ('CARAC01');
INSERT INTO Caracteristique(nomCarac) VALUES ('CARAC02');
INSERT INTO Caracteristique(nomCarac) VALUES ('CARAC03');
INSERT INTO Caracteristique(nomCarac) VALUES ('CARAC04');
INSERT INTO Caracteristique(nomCarac) VALUES ('CARAC05');
INSERT INTO Caracteristique(nomCarac) VALUES ('CARAC06');
INSERT INTO Caracteristique(nomCarac) VALUES ('CARAC07');
INSERT INTO Caracteristique(nomCarac) VALUES ('CARAC08');
INSERT INTO Caracteristique(nomCarac) VALUES ('CARAC09');
INSERT INTO Caracteristique(nomCarac) VALUES ('CARAC10');

INSERT INTO TypeM(nomTypeM) VALUES ('TYPEM01');
INSERT INTO TypeM(nomTypeM) VALUES ('TYPEM02');
INSERT INTO TypeM(nomTypeM) VALUES ('TYPEM03');
INSERT INTO TypeM(nomTypeM) VALUES ('TYPEM04');
INSERT INTO TypeM(nomTypeM) VALUES ('TYPEM05');
INSERT INTO TypeM(nomTypeM) VALUES ('TYPEM06');
INSERT INTO TypeM(nomTypeM) VALUES ('TYPEM07');
INSERT INTO TypeM(nomTypeM) VALUES ('TYPEM08');
INSERT INTO TypeM(nomTypeM) VALUES ('TYPEM09');
INSERT INTO TypeM(nomTypeM) VALUES ('TYPEM10');

INSERT INTO Composant(nomComposant) VALUES ('COMPOSANT01');
INSERT INTO Composant(nomComposant) VALUES ('COMPOSANT02');
INSERT INTO Composant(nomComposant) VALUES ('COMPOSANT03');
INSERT INTO Composant(nomComposant) VALUES ('COMPOSANT04');
INSERT INTO Composant(nomComposant) VALUES ('COMPOSANT05');
INSERT INTO Composant(nomComposant) VALUES ('COMPOSANT06');
INSERT INTO Composant(nomComposant) VALUES ('COMPOSANT07');
INSERT INTO Composant(nomComposant) VALUES ('COMPOSANT08');
INSERT INTO Composant(nomComposant) VALUES ('COMPOSANT09');
INSERT INTO Composant(nomComposant) VALUES ('COMPOSANT10');

INSERT INTO Materiel(idMateriel,nomMateriel,etatMateriel,idMarque,idTypeM,idSalle) VALUES (100,'MATERIEL01',1,1,1,1);
INSERT INTO Materiel(idMateriel,nomMateriel,etatMateriel,idMarque,idTypeM,idSalle) VALUES (101,'MATERIEL02',1,2,2,1);
INSERT INTO Materiel(idMateriel,nomMateriel,etatMateriel,idMarque,idTypeM,idSalle) VALUES (102,'MATERIEL03',1,3,3,1);
INSERT INTO Materiel(idMateriel,nomMateriel,etatMateriel,idMarque,idTypeM,idSalle) VALUES (103,'MATERIEL04',1,4,4,1);
INSERT INTO Materiel(idMateriel,nomMateriel,etatMateriel,idMarque,idTypeM,idSalle) VALUES (104,'MATERIEL05',1,5,5,1);
INSERT INTO Materiel(idMateriel,nomMateriel,etatMateriel,idMarque,idTypeM,idSalle) VALUES (105,'MATERIEL06',1,6,6,2);
INSERT INTO Materiel(idMateriel,nomMateriel,etatMateriel,idMarque,idTypeM,idSalle) VALUES (106,'MATERIEL07',1,7,7,2);
INSERT INTO Materiel(idMateriel,nomMateriel,etatMateriel,idMarque,idTypeM,idSalle) VALUES (107,'MATERIEL08',1,8,8,2);
INSERT INTO Materiel(idMateriel,nomMateriel,etatMateriel,idMarque,idTypeM,idSalle) VALUES (108,'MATERIEL09',1,9,9,2);
INSERT INTO Materiel(idMateriel,nomMateriel,etatMateriel,idMarque,idTypeM,idSalle) VALUES (109,'MATERIEL10',1,10,10,2);
INSERT INTO Materiel(idMateriel,nomMateriel,etatMateriel,idMarque,idTypeM,idSalle) VALUES (110,'MATERIEL11',1,6,6,2);
INSERT INTO Materiel(idMateriel,nomMateriel,etatMateriel,idMarque,idTypeM,idSalle) VALUES (111,'MATERIEL12',1,7,7,2);
INSERT INTO Materiel(idMateriel,nomMateriel,etatMateriel,idMarque,idTypeM,idSalle) VALUES (112,'MATERIEL13',1,8,8,2);
INSERT INTO Materiel(idMateriel,nomMateriel,etatMateriel,idMarque,idTypeM,idSalle) VALUES (113,'MATERIEL14',1,9,9,2);
INSERT INTO Materiel(idMateriel,nomMateriel,etatMateriel,idMarque,idTypeM,idSalle) VALUES (114,'MATERIEL15',1,10,10,2);

INSERT INTO Posseder(idComposant,idCarac) VALUES (1,1);
INSERT INTO Posseder(idComposant,idCarac) VALUES (1,2);
INSERT INTO Posseder(idComposant,idCarac) VALUES (2,2);
INSERT INTO Posseder(idComposant,idCarac) VALUES (3,1);
INSERT INTO Posseder(idComposant,idCarac) VALUES (4,4);
INSERT INTO Posseder(idComposant,idCarac) VALUES (5,5);
INSERT INTO Posseder(idComposant,idCarac) VALUES (6,2);
INSERT INTO Posseder(idComposant,idCarac) VALUES (6,3);
INSERT INTO Posseder(idComposant,idCarac) VALUES (7,1);
INSERT INTO Posseder(idComposant,idCarac) VALUES (7,6);

INSERT INTO Contenir(idMateriel,idComposant) VALUES(100,1);
INSERT INTO Contenir(idMateriel,idComposant) VALUES(100,2);
INSERT INTO Contenir(idMateriel,idComposant) VALUES(100,3);
INSERT INTO Contenir(idMateriel,idComposant) VALUES(101,4);
INSERT INTO Contenir(idMateriel,idComposant) VALUES(101,5);
INSERT INTO Contenir(idMateriel,idComposant) VALUES(102,1);
INSERT INTO Contenir(idMateriel,idComposant) VALUES(103,1);

GRANT ALL PRIVILEGES ON HMS_TEST2.* TO 'julien'@'%';