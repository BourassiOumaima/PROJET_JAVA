package phase1.controllers;

import phase1.Main;
import phase1.models.Departement;
import phase1.models.Etudiant;
import phase1.services.*;
import phase1.models.Filiere;

import java.util.Scanner;

public class EtudiantsController {
    public static void showMenu() {
        System.out.println("-------------------------[ Etudiants ]---------------------------");


        System.out.println("1: Pour ajouter un etudiant");
        System.out.println("2: Pour afficher les etudiants");
        System.out.println("3: Pour modifier un etudiant");
        System.out.println("4: Pour supprimer un etudiant");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createEtudiant();
                break;
            case 2:
                showEtudiants();
                break;
            case 3:
                editEtudiant();
                break;
            case 4:
                destroyEtudiant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showEtudiants() {
        for (Etudiant etudiant : DB.etudiants) {
            System.out.print("Id : " + etudiant.getId());
            System.out.print(" | nom: " + etudiant.getNom());
            System.out.print(" | prenom: " + etudiant.getPrenom());
            System.out.print(" | email: " + etudiant.getEmail());
            System.out.print(" | apogee: " + etudiant.getApogee());
            System.out.print(" | filiere: " + etudiant.getFiliere());
            System.out.println("");
        }
    }

    public static void createEtudiant() {
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String email = Main.getStringInput("Entrez l'email' :");
        int apogee = Main.getIntInput("Entrez le code apogee :");
        FilieresController.showFilieres();
        int id = Main.getIntInput("Sélecionnez une filiere par id :");
        EtudiantServices.addEtd(nom,prenom,email,apogee, FiliereServices.getFiliereById(id));
        showEtudiants();
        showMenu();
    }
    public static void editEtudiant(){
        showEtudiants();
        int id = Main.getIntInput("Sélecionnez un etudiant par id :");
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String email = Main.getStringInput("Entrez l'email :");
        int apogee = Main.getIntInput("Entrez le code apogee :");
        FilieresController.showFilieres();
        int idF = Main.getIntInput("Sélecionnez une filiere par id :");
        EtudiantServices.updateEtd(id, nom,prenom,email,apogee, FiliereServices.getFiliereById(idF));
        showEtudiants();
        showMenu();
    }
    public static void destroyEtudiant(){
        showEtudiants();
        int id = Main.getIntInput("Sélecionnez un etudiant par id :");
        EtudiantServices.deleteEtdById(id);
        showEtudiants();
    }
}
