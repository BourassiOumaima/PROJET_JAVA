package phase1.controllers;

import phase1.Main;
import phase1.models.Enseignant;
import phase1.models.Etudiant;
import phase1.models.Filiere;
import phase1.services.*;

public class FilieresController {
    public static void showMenu() {
        System.out.println("-------------------------[ Filieres ]---------------------------");


        System.out.println("1: Pour ajouter une filiere");
        System.out.println("2: Pour afficher les filieres");
        System.out.println("3: Pour modifier une filiere");
        System.out.println("4: Pour supprimer une filiere");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createFiliere();
                break;
            case 2:
                showFilieres();
                break;
            case 3:
                editFiliere();
                break;
            case 4:
                destroyFiliere();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showFilieres() {
        for (Filiere filiere : DB.filieres) {
            System.out.print("Id : " + filiere.getId());
            System.out.print(" | intitule: " + filiere.getIntitule());
            System.out.print(" | chef: " + filiere.getChef());
            System.out.print(" | departement: " + filiere.getDept());
            System.out.println("");
        }
    }

    public static void createFiliere() {
        String intitule = Main.getStringInput("Entrez l'intitule':");
        EnseignantsController.showEnseignants();
        int idE = Main.getIntInput("Sélecionnez un enseignant par id :");
        DepartementsController.showDepartements();
        int idD = Main.getIntInput("Sélecionnez un departement par id :");
        FiliereServices.addFiliere(intitule, EnseignantServices.getEnsById(idE),DepartementServices.getDeptById(idD));
        showFilieres();
        showMenu();
    }
    public static void editFiliere(){
        showFilieres();
        int id = Main.getIntInput("Sélecionnez une filiere par id :");
        String intitule = Main.getStringInput("Entrez l'intitule':");
        EnseignantsController.showEnseignants();
        int idE = Main.getIntInput("Sélecionnez un enseignant par id :");
        DepartementsController.showDepartements();
        int idD = Main.getIntInput("Sélecionnez un departement par id :");
        FiliereServices.updateFiliere(id,intitule,EnseignantServices.getEnsById(idE),DepartementServices.getDeptById(idD));
        showFilieres();
        showMenu();
    }
    public static void destroyFiliere(){
        showFilieres();
        int id = Main.getIntInput("Sélecionnez une filiere par id :");
        FiliereServices.deleteFiliereById(id);
        showFilieres();
    }
}
