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
        System.out.println("These input fields are for the nominator's information.");
        String name = nominatorsName();
        System.out.println("------------------------------");
        String email = nominatorsEmail();
        System.out.println("------------------------------");
        String schoolDistrict = nominatorsSchoolDistrict();
        System.out.println("------------------------------");
        String position = nominatorsPosition();
        System.out.println("------------------------------");
        String relationshipToNominee = nominatorsRelationshipToNominee();
        System.out.println("------------------------------");
        System.out.println("These input fields are for the nominee's information.");
        String nomineeName = nomineeName();
        System.out.println("------------------------------");
        String nomineeContactInfo = nomineeContactInfo();
        System.out.println("------------------------------");
        String nomineeGradDate = nomineeGradDate();
        System.out.println("------------------------------");
        String nomineeAptitude = nomineeAptitude();
        System.out.println("------------------------------");
        String nomineePerserverance = nomineePerserverance();
        System.out.println("------------------------------");
        String nomineeDedication = nomineeDedication();
        System.out.println("------------------------------");
        String nomineeWorkEthic = nomineeWorkEthic();
        System.out.println("------------------------------");
        String nomineeAdditionalInfo = nomineeAdditionalInfo();
        System.out.println("------------------------------");
        Integer nomineeAge = nomineeAge();
        System.out.println("------------------------------");
        Boolean accepted = false;
        Nomination newNomination = new Nomination(name, email, schoolDistrict, position, relationshipToNominee, nomineeName, nomineeAge, nomineeContactInfo, nomineeGradDate, nomineeAptitude, nomineePerserverance, nomineeDedication, nomineeWorkEthic, nomineeAdditionalInfo, accepted);
        nominationsInfo.add(newNomination);
        saveInfo(nominationsInfo);
    }

    public static String nominatorsName() {
        System.out.println("Name:");
        String name = in.nextLine();
        return name;
    }
    public static String nominatorsEmail() {
        System.out.println("Email:");
        String email = in.nextLine();
        return email;
    }
    public static String nominatorsSchoolDistrict() {
        System.out.println("School District:");
        String schoolDistrict = in.nextLine();
        return schoolDistrict;
    }
    public static String nominatorsPosition() {
        System.out.println("Position:");
        String position = in.nextLine();
        return position;
    }
    public static String nominatorsRelationshipToNominee() {
        System.out.println("Relationship to nominee:");
        String relationshipToNominee = in.nextLine();
        return relationshipToNominee;
    }

    public static String nomineeName() {
        System.out.println("Name:");
        String nomineeName = in.nextLine();
        return nomineeName;
    }

    public static Integer nomineeAge() {
        System.out.println("Age:");
        int nomineeAge = in.nextInt();
        return nomineeAge;
    }

    public static String nomineeContactInfo() {
        System.out.println("Number or Email:");
        String nomineeContactInfo = in.nextLine();
        return nomineeContactInfo;
    }

    public static String nomineeGradDate() {
        System.out.println("Expected Graduation Date:");
        String nomineeGradDate = in.nextLine();
        return nomineeGradDate;
    }

    public static String nomineeAptitude() { 
        System.out.println("Aptitude: Do you have any experiences when this student has demonstrated a strong ability to think logically and/or strategically?");
        String nomineeAptitude = in.nextLine();
        return nomineeAptitude;
    }

    public static String nomineePerserverance() {
        System.out.println("Perserverance: Is there any evidence of the applicant being engaged in something they are passionate about?");
        String nomineePerserverance = in.nextLine();
        return nomineePerserverance;
    }

    public static String nomineeDedication() {
        System.out.println("Dedication: Do you think the applicant would be able to reliably attend the program for five days a week in Water Valley?");
        String nomineeDedication = in.nextLine();
        return nomineeDedication;
    }

    public static String nomineeWorkEthic() {
        System.out.println("Work Ethic / Heart: Why does this student deserve a position at Base Camp?");
        String nomineeWorkEthic = in.nextLine();
        return nomineeWorkEthic;
    }

    public static String nomineeAdditionalInfo() {
        System.out.println("Anything else you'd like to share about this nominee?");
        String nomineeAdditionalInfo = in.nextLine();
        return nomineeAdditionalInfo;
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