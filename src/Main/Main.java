package Main;

import Controleurs.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {



        public static void main (String[] args) throws SQLException, ClassNotFoundException {
//
//            Enseignants enseignant = new Enseignants();
//            enseignant.setNom("Chaymae");
//            enseignant.setPrenom("Moudnib");
//            enseignant.setEmail("chaym3@gmail.com");
//            enseignant.setGrade(Integer.parseInt("3"));
//            enseignant.setId(Database.getEnsId());
//            Database.enseignants.add(enseignant);
            showPrincipalMenu();

    }

    public static void showPrincipalMenu() throws SQLException, ClassNotFoundException {
        System.out.println("-------------------------[ Bienvenu ]---------------------------");


        System.out.println("1: Pour gérer les départements");
        System.out.println("2: Pour gérer les filières");
        System.out.println("3: Pour gérer les enseignants");
        System.out.println("4: Pour gérer les modules");
        System.out.println("5: Pour gérer les étudiants");
        System.out.println("0: Pour sortir");

        int option = getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                DepartementControleurs.showMenu();
                break;
            case 2:FillieresControleurs.showMenu();
                break;
            case 3:EnseignantControleurs.showMenu();
                break;
            case 4:ModulesControleurs.showMenu();
                break;
            case 5:EtudiantControleurs.showMenu();
                break;
            default:
                System.out.println("This departement does not exists");
        }

    }

//    public static int getIntInput(String s) {     Scanner scan = new Scanner(System.in);
//        String message = "Entrez un nombre entier : ";
//        if (s.length() > 0 ){
//            message = s;
//        System.out.print(message);}
//
//
//        // This method reads the number provided using keyboard
//        int num = scan.nextInt();
//
//        // Closing Scanner after the use
//        //  scan.close();
//        return num;
//    }
public static int getIntInput(String message) {
    Scanner scanner = new Scanner(System.in);
    int value = 0;
    boolean validInput = false;

    while (!validInput) {
        System.out.println(message);
        if (scanner.hasNextInt()) {
            value = scanner.nextInt();
            validInput = true;
        } else {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next(); // discard invalid input
        }
    }
    return value;
}
    public static String getStringInput(String... msg) {
        Scanner scan = new Scanner(System.in);
        String message = "Entrez un texte : ";
        if (msg.length > 0 )
            message = msg[0] ;
        System.out.print(message);

        // This method reads the number provided using keyboard
        String str = scan.nextLine();

        // Closing Scanner after the use
        //  scan.close();
        return str;
    }

    public static boolean isNull(List<String> obj) {
        return obj == null;
    }
}