package Services;
import Entitées.*;
import database.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EnseignantService {

    private static boolean isEnseignant;

    public static List<String> showEns() throws SQLException {
        List<String> enseignant = new ArrayList<>();
        String query = "SELECT e.nom, e.prenom, e.email, e.grade, d.dep_id " +
                "FROM enseignants e " +
                "JOIN departements d ON e.dep_id = d.dep_id;";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/systemedegestioneducative", "root", "");
             PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String enseignants = "Department ID: " + rs.getInt("dep_id") +
                        ", Enseignant: " + rs.getString("nom") + " " + rs.getString("prenom") +
                        ", Email: " + rs.getString("email") + ", Grade: " + rs.getInt("grade");
                enseignant.add(enseignants);
            }
        }
        return enseignant;
    }


/// methode pour inserer les donnees au enseignant avec dep_id come un foreign key.
    public static Enseignants addEns( String nom, String prenom, String email, int grade, int departement )
            throws ClassNotFoundException, SQLException {
            ArrayList<Enseignants> listofens = new ArrayList<>();
          try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/systemedegestioneducative",
                    "root", "");
            PreparedStatement stm = con.prepareStatement("INSERT INTO enseignants ( nom, prenom, email, grade,dep_id)" +
                    " VALUES ( ?, ?, ?, ?,?)");
            stm.setString(1, nom);
        stm.setString(2, prenom);
        stm.setString(3, email);
        stm.setInt(4, grade);
              stm.setInt(5, departement);
            stm.execute();


            listofens.add(new Enseignants(nom,prenom, email, grade,departement));

            for (Enseignants i : listofens) {

//                System.out.println(i.getId());
                System.out.println(i.getNom());
                System.out.println(i.getPrenom());
                System.out.println(i.getEmail());
                System.out.println(i.getGrade());
                System.out.println(i.getDepartement());

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

          return new Enseignants();
    }

    public static Enseignants updateEns(int id, String nom, String prenom, String email, String grade, Departements dept){
        return  new Enseignants();
    }




        public static ArrayList<Enseignants>    deleteEnsById(int id) {

        return  Database.enseignants;
    }

    public static Enseignants getEnsById(int id){
        for (Enseignants enseignant : Database.enseignants) {
            if (enseignant.getId() == id) return  enseignant;
        }
        return  new Enseignants();
    }

    public static boolean isEnseignant() {
      return  isEnseignant;
    }

    public static ArrayList<Enseignants> getAllEns(){
        return  Database.enseignants;
    }
}
