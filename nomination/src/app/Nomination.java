package app;

import java.io.Serializable;

public class Nomination implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    String email;
    String schoolDistrict;
    String position;
    String relationshipToNominee;
    String nomineeName;
    Integer nomineeAge;
    String nomineeContactInfo;
    String nomineeGraduationDate;
    String nomineeAptitude;
    String nomineePerserverance;
    String nomineeDedication;
    String nomineeWorkEthic;
    String nomineeAdditionalInfo;
    Boolean accepted;

    public Nomination(String name, String email, String schoolDistrict, String position, String relationshipToNominee,
            String nomineeName, Integer nomineeAge, String nomineeContactInfo, String nomineeGraduationDate,
            String nomineeAptitude, String nomineePerserverance, String nomineeDedication, String nomineeWorkEthic,
            String nomineeAdditionalInfo, Boolean accepted) {
        this.name = name;
        this.email = email;
        this.schoolDistrict = schoolDistrict;
        this.position = position;
        this.relationshipToNominee = relationshipToNominee;
        this.nomineeName = nomineeName;
        this.nomineeAge = nomineeAge;
        this.nomineeContactInfo = nomineeContactInfo;
        this.nomineeGraduationDate = nomineeGraduationDate;
        this.nomineeAptitude = nomineeAptitude;
        this.nomineePerserverance = nomineePerserverance;
        this.nomineeDedication = nomineeDedication;
        this.nomineeWorkEthic = nomineeWorkEthic;
        this.nomineeAdditionalInfo = nomineeAdditionalInfo;
        this.accepted = accepted;

    }
}