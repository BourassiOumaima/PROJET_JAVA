package phase1.services;

import phase1.models.*;
import phase1.models.Module;

import java.util.ArrayList;

public class DB {
    public static int DEPT_ID = 0;
    public static int ENS_ID = 0;
    public static int ETD_ID = 0;
    public static int FIL_ID = 0;
    public static int MOD_ID = 0;
    public static ArrayList<Departement> departements = new ArrayList<Departement>();
    public static ArrayList<Enseignant> enseignants = new ArrayList<Enseignant>();
    public static ArrayList<Filiere> filieres = new ArrayList<Filiere>();
    public static ArrayList<Module> modules = new ArrayList<Module>();
    public static ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
    public static ArrayList<Note> notes = new ArrayList<Note>();

    public  static int getDeptId(){
        DEPT_ID++;
        return DEPT_ID;
    }
    public  static int getEnsId(){
        ENS_ID++;
        return ENS_ID;
    }
    public  static int getEtId(){
        ETD_ID++;
        return ETD_ID;
    }
    public  static int getFiId(){
        FIL_ID++;
        return FIL_ID;
    }
    public  static int getMoId(){
        MOD_ID++;
        return MOD_ID;
    }
}

