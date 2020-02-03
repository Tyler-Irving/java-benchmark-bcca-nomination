package app;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Nomination> nominationsInfo = loadInfo();
        Nomination newNomination = getNomination();
        nominationsInfo.add(newNomination);
        saveInfo(nominationsInfo);
    }

    public static Nomination getNomination() {
        System.out.println("-- Nominator Information --");
        System.out.println("Name:");
        String name = in.nextLine();
        System.out.println("------------------------------");
        System.out.println("Email:");
        String email = in.nextLine();
        System.out.println("------------------------------");
        System.out.println("School District:");
        String schoolDistrict = in.nextLine();
        System.out.println("------------------------------");
        System.out.println("Position:");
        String position = in.nextLine();
        System.out.println("------------------------------");
        System.out.println("Relationship to nominee:");
        String relationshipToNominee = in.nextLine();
        System.out.println("------------------------------");
        System.out.println("--- Nominee Information ---");
        System.out.println("Name:");
        String nomineeName = in.nextLine();
        System.out.println("------------------------------");
        System.out.println("Age:");
        String nomineeAge = in.nextLine();
        System.out.println("------------------------------");
        System.out.println("Number or Email:");
        String nomineeContactInfo = in.nextLine();
        System.out.println("------------------------------");
        System.out.println("Expected Graduation Date:");
        String nomineeGradDate = in.nextLine();
        System.out.println("------------------------------");
        System.out.println("Aptitude: Do you have any experiences when this student has demonstrated a strong ability to think logically and/or strategically?");
        String nomineeAptitude = in.nextLine();
        System.out.println("------------------------------");
        System.out.println("Perserverance: Is there any evidence of the applicant being engaged in something they are passionate about?");
        String nomineePerserverance = in.nextLine();
        System.out.println("------------------------------");
        System.out.println("Dedication: Do you think the applicant would be able to reliably attend the program for five days a week in Water Valley?");
        String nomineeDedication = in.nextLine();
        System.out.println("------------------------------");
        System.out.println("Work Ethic / Heart: Why does this student deserve a position at Base Camp?");
        String nomineeWorkEthic = in.nextLine();
        System.out.println("------------------------------");
        System.out.println("Anything else you'd like to share about this nominee?");
        String nomineeAdditionalInfo = in.nextLine();
        System.out.println("------------------------------");
        String accepted = "No";
        return new Nomination(name, email, schoolDistrict, position, relationshipToNominee, nomineeName, nomineeAge, nomineeContactInfo, nomineeGradDate, nomineeAptitude, nomineePerserverance, nomineeDedication, nomineeWorkEthic, nomineeAdditionalInfo, accepted);
    }

    private static void saveInfo(ArrayList<Nomination> nominationsInfo) {
        try {
            FileOutputStream fileStream = new FileOutputStream("nominationsInfo.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(nominationsInfo);
            os.close();
        } catch (IOException ex) {
            System.out.println("Failed to save nomination.");
        }
    }

    public static ArrayList<Nomination> loadInfo() {
        try {
            FileInputStream fileStream = new FileInputStream("nominationsInfo.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            ArrayList<Nomination> nominationsInfo = (ArrayList<Nomination>) os.readObject();
            os.close();
            return nominationsInfo;
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<Nomination>();
        }
    }
}