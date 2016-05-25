package driverslicense;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DriversLicense {

    private String name, address, licenseNumber, endorsements, issuingState, eyeColor, sex;
    private int height;
    private double weight;
    private String licenseClassification;
    private boolean organDonor, federallyCompliant;
    private Date dateOfBirth, issueDate, expirationDate;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getLicenseClassification() {
        return licenseClassification;
    }

    public void setLicenseClassification(String licenseClassification) {
        this.licenseClassification = licenseClassification;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isOrganDonor() {
        return organDonor;
    }

    public void setOrganDonor(boolean organDonor) {
        this.organDonor = organDonor;
    }

    public boolean isFederallyCompliant() {
        return federallyCompliant;
    }

    public void setFederallyCompliant(boolean federallyCompliant) {
        this.federallyCompliant = federallyCompliant;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getEndorsements() {
        return endorsements;
    }

    public void setEndorsements(String endorsements) {
        this.endorsements = endorsements;
    }

    public String getIssuingState() {
        return issuingState;
    }

    public void setIssuingState(String issuingState) {
        this.issuingState = issuingState;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * (include description of field order here)
     * @return
     */
    public String serializeToCSV(){

        StringBuilder csvBuilder = new StringBuilder();

        csvBuilder.append(name).append(',')
                .append(address).append(',')
                .append(eyeColor).append(',')
                .append(dateOfBirth).append(',')
                .append(issueDate).append(',')
                .append(expirationDate).append(',')
                .append(licenseNumber).append(',')
                .append(issuingState).append(',')
                .append(endorsements).append(',')
                .append(sex).append(',')
                .append(federallyCompliant).append(',')
                .append(licenseClassification);

        return csvBuilder.toString();
    }

    public static String getCSVHeader(){
        return "NAME,ADDRESS,EYE COLOR,DATE OF BIRTH,ISSUE DATE,EXPIRATION DATE," +
                "LICENSE NUMBER,STATE,ENDORSEMENTS,SEX,FEDERAL COMPLIANCE,CLASSIFICATION";
    }

    public static ArrayList<DriversLicense> deserializeFromCSV(String licenseProperties) throws ParseException {
        ArrayList<DriversLicense> licenseList = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss zzz yyyy");
        String[] licenceprop = licenseProperties.split(",");
        for(String entry : licenceprop){
            DriversLicense driversLicense = new DriversLicense();

            driversLicense.setName(licenceprop[0]);
            driversLicense.setAddress(licenceprop[1]);
            driversLicense.setEyeColor(licenceprop[2]);
            driversLicense.setDateOfBirth(dateParser(licenceprop[3]));
            driversLicense.setIssueDate(dateParser(licenceprop[4]));
            driversLicense.setExpirationDate(dateParser(licenceprop[5]));
            driversLicense.setLicenseNumber(licenceprop[6]);
            driversLicense.setIssuingState(licenceprop[7]);
            driversLicense.setEndorsements(licenceprop[8]);
            driversLicense.setSex(licenceprop[9]);
            driversLicense.setFederallyCompliant(Boolean.parseBoolean(licenceprop[10]));
            driversLicense.setLicenseClassification(licenceprop[11]);

            licenseList.add(driversLicense);

        }
return licenseList;
    }

    public static Date dateParser(String startDateString) throws ParseException{
        DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss zzz yyyy");
        Date startDate = null;
        try {
            startDate = df.parse(startDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return startDate;
    }
}
