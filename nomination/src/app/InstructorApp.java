package app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class InstructorApp {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) { 
        ArrayList<Nomination> nominationsInfo = loadInfo();
        int i = 0;
        for (Nomination nom : nominationsInfo) {
            System.out.println("[" + i + "]");
            System.out.println("-- NOMINATOR INFORMATION --");
            System.out.println("Name: " + nom.name);
            System.out.println("Email: " + nom.email);
            System.out.println("School District: " + nom.schoolDistrict);
            System.out.println("Position: " + nom.position);
            System.out.println("Relationship to the nominee: " + nom.relationshipToNominee);
            System.out.println("--- NOMINEE INFORMATION ---");
            System.out.println("Name: " + nom.nomineeName);
            System.out.println("Age: " + nom.nomineeAge);
            System.out.println("Contact Information: " + nom.nomineeContactInfo);
            System.out.println("Expexted Graduation Date: " + nom.nomineeGradDate);
            System.out.println("Aptitude: " + nom.nomineeAptitude);
            System.out.println("Perserverance: " + nom.nomineePerserverance);
            System.out.println("Dedication: " + nom.nomineeDedication );
            System.out.println("Work Ethic: " + nom.nomineeWorkEthic);
            System.out.println("Additional Information: " + nom.nomineeAdditionalInfo);
            System.out.println("Current Acceptance Status: " + nom.accepted);
            System.out.println("---------------------------");
            i += 1;
        }
        while (true) {
            System.out.print("Would you like to approve[Y] or disapprove[N] someone or [Q]uit: ");
            final String approve = in.nextLine().toLowerCase();
            if (approve.equals("y")) {
                System.out.print("Choose their respective number: ");
                final Integer num = Integer.parseInt(in.nextLine());
                nominationsInfo.get(num).accepted = true;
                System.out.println(nominationsInfo.get(num).nomineeName + " Approved: " + nominationsInfo.get(num).accepted);
            }
            if (approve.equals("n")) {
                System.out.print("Choose their respective number: ");
                final Integer num = Integer.parseInt(in.nextLine());
                nominationsInfo.get(num).accepted = false;
                System.out.println(nominationsInfo.get(num).nomineeName + " Approved: " + nominationsInfo.get(num).accepted);
            }
            if (approve.equals("q")) {
                break;
            }
        }
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