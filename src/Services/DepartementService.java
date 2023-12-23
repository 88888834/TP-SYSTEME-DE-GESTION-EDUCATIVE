package Services;

import Entitées.Departements;
import Entitées.Enseignants;
import database.Database;

import java.sql.*;
import java.util.*;

import static java.lang.Class.*;

public class DepartementService {
    public static void registerJDBCDriver() {
        try {
            forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

/// utilisons cette requette pour afficher les departements avec leurs infomations .
        public static List<String>     showDep() throws SQLException {
            List<String> departments = new ArrayList<>();
            String query = "SELECT d.dep_id, d.description, e.nom ,e.prenom\n" +
                    "FROM departements d \n" +
                    "JOIN enseignants de ON d.dep_id = de.dep_id \n" +
                    "JOIN enseignants e ON de.id = e.id;";

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/systemedegestioneducative", "root", "");
                 PreparedStatement pstmt = con.prepareStatement(query);
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    String departmentInfo = "Departments ID: " + rs.getInt("dep_id") +
                            ", Description: " + rs.getString("description") +
                            ", Enseignant: " + rs.getString("nom")+rs.getString("prenom");
                    departments.add(departmentInfo);
                }
            }
            return departments;
        }

///dans cette method on utilise preparedstatement pour nserer les donnees au departement .
    public static Departements addDept( String descrip, List<String> enseignants) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/systemedegestioneducative", "root", "");
        Departements departement = new Departements();

        String insertDepartmentStatement = "INSERT INTO departements ( description) VALUES ( ?)";
        try (PreparedStatement pstmt = con.prepareStatement(insertDepartmentStatement, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, descrip);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating department failed, no rows affected.");
            }

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    departement.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating department failed, no ID obtained.");
                }
            }
        }
        System.out.println("Deparatement has created successfully!");
        String insertEnseignantStatement = "INSERT INTO enseignants (nom,dep_id) VALUES (?,?)";
        String insertLinkStatement = "INSERT INTO enseignants (dep_id) VALUES (?)";

        for (String enseignant : enseignants) {
            try (PreparedStatement pstmt = con.prepareStatement(insertEnseignantStatement, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, enseignant);
                int id = 0;
                pstmt.setInt(2, id);
                int affectedRows = pstmt.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Creating teacher failed, no rows affected.");
                }

                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int enseignantId = generatedKeys.getInt(1);


                        try (PreparedStatement linkPstmt = con.prepareStatement(insertLinkStatement)) {

                            linkPstmt.setInt(1, Integer.parseInt(descrip));
                            linkPstmt.executeUpdate();
                        }
                    } else {
                        throw new SQLException("Creating teacher failed, no ID obtained.");
                    }
                }
            }
        }

        return departement;
    }

    public static Enseignants getEnseignant(Integer id) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/systemedegestioneducative", "root", "PASSWORD");
            String query = "SELECT * FROM enseignants WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Enseignants(resultSet.getInt("id"), resultSet.getString("name"));
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return null;
    }



    private Map<String,Departements> dep;
     public DepartementService(){}




        public static void updateDep(int depId, String newDescription, String newNom, String newPrenom) throws SQLException {
            String updateDepartmentSql = "UPDATE departements SET description = ? WHERE dep_id = ?";
        String updateEnseignantSql = "UPDATE enseignants SET nom = ? , prenom=? WHERE id = (SELECT id" +
                " FROM departements WHERE dep_id = ?)";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/systemedegestioneducative",
                "root", ""))
                {
                // Update department description&id
                try (PreparedStatement pstmt = con.prepareStatement(updateDepartmentSql)) {
                    pstmt.setString(1, newDescription);
                    pstmt.setInt(2, depId);
                    pstmt.executeUpdate();
                }

                // Update enseignant nom et prenom pour ce department
                try (PreparedStatement pstmt = con.prepareStatement(updateEnseignantSql)) {
                    pstmt.setString(1, newNom);
                    pstmt.setString(2, newPrenom);
                    pstmt.setInt(3, depId);
                    pstmt.executeUpdate();
                }
            }
        }


    public static Departements getDeptById(int id){
        for (Departements dep : Database.departements) {
            if (dep.getId() == id) return  dep;
        }
        return  new Departements();
    }


    public static boolean deleteDeptById(int id) {

        String sql = "DELETE FROM departements WHERE id = ?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/systemedegestioneducative", "root", "")) {
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {

                pstmt.setInt(1, id);

                int affectedRows = pstmt.executeUpdate();
                return affectedRows > 0;

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static ArrayList<Departements> getAllDept(){

        return  Database.departements;
    }

 }

