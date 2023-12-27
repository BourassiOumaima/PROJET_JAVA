package phase2;

import phase1.models.Departement;
import phase1.models.Enseignant;
import phase1.services.DB;
import phase1.services.DepartementServices;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import static phase1.services.DepartementServices.getAllDept;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sys_educative";
        String user = "root";
        String pwd = "";

        try {
            Connection cx = DriverManager.getConnection(url, user, pwd);
            System.out.println("Good Connection");
            createTable(cx);
            //insertDepartement(new Departement("MATHEMATIQUE",new Enseignant("BOURASSI","OUMAIMA",
            //  "test@gmail.com","grade", DepartementServices.getDeptById(DB.getDeptId()))),cx);
            Departement deptToUpdate = new Departement(3,"MECANIQUE",new Enseignant("BOUR","OUMAIMA",
                  "test@gmail.com","grade", DepartementServices.getDeptById(3)));

            UpdateDepartement(deptToUpdate,cx);
            //deleteDepartement(1,cx);
            List<Departement> departements = getAllDepartements(cx);
            for(Departement departement: departements){
                System.out.println("id : "+departement.getId());
                System.out.println("intitule : "+departement.getIntitule());
                System.out.println("chef : "+departement.getChef().getNom());
                System.out.println();
            }

        }
        catch (SQLException e) {
            System.out.println("Bad Connection");
            e.printStackTrace();
        }
    }
           public static void createTable(Connection cx) throws SQLException
            {
                String query = "create table IF NOT EXISTS departement \n" +
                        "(\n" +
                        " id  int auto_increment primary key,\n" +
                        " intitule varchar(250) charset utf8 null,\n" +
                        " chef varchar(250) charset utf8 null,\n" +
                        "foreign key (chef) references Enseignant(nom)"+
                        ");";
               Statement st = cx.createStatement();
            st.execute(query);
                System.out.println("votre nouvelle table a été créé");
            }
    public static void insertDepartement(Departement dept, Connection cx) throws SQLException {
        String query = "INSERT INTO departement (id,intitule,chef) values (?,?,?)";

        PreparedStatement ps = cx.prepareStatement(query);

        ps.setInt(1, dept.getId());
        ps.setString(2, dept.getIntitule());
        ps.setString(3, dept.getChef().getNom());
        ps.executeUpdate();
        System.out.println("votre nouvelle table a été remplis");
    }
    public static List<Departement> getAllDepartements(Connection cx) throws SQLException{
        String query = "SELECT * from departement";
        List<Departement> departements = new ArrayList<>();
        Statement st = cx.createStatement();
        ResultSet r = st.executeQuery(query);

        while (r.next()) {
            Departement dep = new Departement();
            dep.setId(r.getInt("id"));
            dep.setIntitule(r.getString("intitule"));
            Enseignant ens = new Enseignant();
            ens.setNom(r.getString("chef"));
            dep.setChef(ens);
            departements.add(dep);
        }
        return departements;
    }
    public static void deleteDepartement(int id, Connection cx) throws SQLException {
        String query = "DELETE  from sys_educative.departement where id = ?";
        PreparedStatement ps = cx.prepareStatement(query);
        ps.setInt(1, id);
        ps.execute();
        System.out.println("la suppression de departement " +id+ " est effectuée");
    }
    public static void UpdateDepartement(Departement dept, Connection cx) throws SQLException {
        String sql= "UPDATE departement SET intitule=? , chef =? WHERE id=? ";
        PreparedStatement ps = cx.prepareStatement(sql);
        ps.setString(1,dept.getIntitule());
        ps.setString(2,dept.getChef().getNom());
        ps.setInt(3,dept.getId());

        int rowsInserted = ps.executeUpdate();
        if (rowsInserted>0) {
            System.out.println("la table departement a été mise à jour ");
        } else{
            System.out.println("Aucun mise à jour effectuée . Vérifiez l'ID de departement.");
        }
    }
}

