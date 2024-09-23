
-- Suppression des tables dans le bon ordre
DROP TABLE IF EXISTS Devis;
DROP TABLE IF EXISTS MainOeuvre;
DROP TABLE IF EXISTS Materiau;
DROP TABLE IF EXISTS Projet;
DROP TABLE IF EXISTS Client;

-- Création de la table Client avec estProfessionnel par défaut à FALSE
CREATE TABLE Client (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    adresse VARCHAR(255),
    telephone VARCHAR(15),
    estProfessionnel BOOLEAN NOT NULL DEFAULT FALSE
);

-- Création de la table Projet
CREATE TABLE Projet (
    id SERIAL PRIMARY KEY,
    nomProjet VARCHAR(255) NOT NULL,
    margeBeneficiaire DOUBLE PRECISION NOT NULL,
    coutTotal DOUBLE PRECISION,
    etatProjet VARCHAR(50) NOT NULL,
    clientId INT REFERENCES Client(id) ON DELETE CASCADE
);

-- Création de la table Matériau
CREATE TABLE Materiau (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    coutUnitaire DOUBLE PRECISION NOT NULL,
    quantite DOUBLE PRECISION NOT NULL,
    typeComposant VARCHAR(50) NOT NULL,
    tauxTVA DOUBLE PRECISION NOT NULL,
    coutTransport DOUBLE PRECISION,
    coefficientQualite DOUBLE PRECISION,
    projetId INT REFERENCES Projet(id) ON DELETE CASCADE
);

-- Création de la table Main-d'oeuvre
CREATE TABLE MainOeuvre (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    tauxHoraire DOUBLE PRECISION NOT NULL,
    heuresTravail DOUBLE PRECISION NOT NULL,
    productiviteOuvrier DOUBLE PRECISION NOT NULL,
    tauxTVA DOUBLE PRECISION NOT NULL,
    projetId INT REFERENCES Projet(id) ON DELETE CASCADE
);

-- Création de la table Devis
CREATE TABLE Devis (
    id SERIAL PRIMARY KEY,
    montantEstime DOUBLE PRECISION NOT NULL,
    dateEmission DATE NOT NULL,
    dateValidite DATE NOT NULL,
    accepte BOOLEAN NOT NULL,
    projetId INT REFERENCES Projet(id) ON DELETE CASCADE
);
