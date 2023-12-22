package database;

import Entitées.Enseignants;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;



public class Connection {

    java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/systemedegestioneducative", "root", "");

    public Connection() throws SQLException {
    }}

//        try {
//        Scanner s = new Scanner(System.in);
//        ArrayList<Enseignants> listofens = new ArrayList<>();
//
//        System.out.println("entrer votre id");
//        Integer id = s.nextInt();
//
//        PreparedStatement stm = null;
//        try {
//            stm = con.prepareStatement(
//                    " SELECT prenom,nom FROM enseignant\n" +
//                            "where id=?;");
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
//
//        try {
//            stm.setInt(1, id);
//        }
//        catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
//        ResultSet rs = stm.executeQuery();
//
//        while (rs.next()) {
//            listofens.add(new Enseignants( rs.getString("prenom"), rs.getString("nom")));
//        }
//        for (Enseignants i : listofens) {
//            System.out.println(i.getPrenom());
//            System.out.println(i.getNom());}
//    }


