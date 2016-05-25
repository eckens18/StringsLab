package driverslicense;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;


public class DriversLicenseTest {

    DriversLicense testLicense;

    String name = "Mike Jones";
    String address = "123 Atl drive";
    String eyeColor = "Brown";
    Date expectedDOB = new Date(); // 3 times
    Date expectedIssueDate = expectedDOB;
    Date expectedExpirationDate = expectedDOB;
    String licenseNum = "007";
    String issuingState = "TX";
    String trump = "Trump";
    String male = "M";
    boolean federallyCompliantStatus = false;
    String licenseClassification = "C";

    @Before
    public void setUp() throws Exception {
        testLicense = new DriversLicense();

        testLicense.setName(name);
        testLicense.setAddress(address);
        testLicense.setEyeColor(eyeColor);
        testLicense.setDateOfBirth(expectedDOB);
        testLicense.setIssueDate(expectedIssueDate);
        testLicense.setExpirationDate(expectedExpirationDate);
        testLicense.setLicenseNumber(licenseNum);
        testLicense.setIssuingState(issuingState);
        testLicense.setEndorsements(trump);
        testLicense.setSex(male);
        testLicense.setFederallyCompliant(federallyCompliantStatus);
        testLicense.setLicenseClassification(licenseClassification);
    }

    @Test
    public void testSerializeToCSV() throws Exception {

        String actualCSVResult = testLicense.serializeToCSV();

        String expectedCSVResult = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%b,%s",
                name, address, eyeColor, expectedDOB,expectedIssueDate, expectedExpirationDate,
                licenseNum, issuingState, trump, male, federallyCompliantStatus, licenseClassification);

        assertEquals("Actual CSV result did not match expectations.",expectedCSVResult, actualCSVResult);

    }

    @Test
    public void testGetCSVHeader(){
        /*
        order: name, address, eyeColor, expectedDOB,expectedIssueDate, expectedExpirationDate,
                licenseNum, issuingState, trump, male, federallyCompliantStatus, licenseClassification
         */
        String expectedHeader = "NAME,ADDRESS,EYE COLOR,DATE OF BIRTH,ISSUE DATE,EXPIRATION DATE," +
                "LICENSE NUMBER,STATE,ENDORSEMENTS,SEX,FEDERAL COMPLIANCE,CLASSIFICATION";

        String actualHeader = DriversLicense.getCSVHeader();

        assertEquals(expectedHeader, actualHeader);
    }

    @Test
    public void deserializeFromCSVTest(){
        String testCaseString = testLicense.serializeToCSV();
        ArrayList<DriversLicense> expected = new ArrayList<>();
        expected.add(testLicense);
        ArrayList<DriversLicense> actual = null;
        try {
            actual = testLicense.deserializeFromCSV(testCaseString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(testLicense.getName(),actual.get(0).getName());
        assertEquals(testLicense.getAddress(),actual.get(0).getAddress());
    }

    @Test
    public void dateParser(){
        Date expected = null;
        try {
            expected = DriversLicense.dateParser("Mon May 23 17:18:27 EDT 2016");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertTrue(expected instanceof Date);
    }


}