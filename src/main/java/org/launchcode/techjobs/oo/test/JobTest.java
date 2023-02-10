package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    String testName;
    Employer testEmployer;
    Location testLocation;
    PositionType testPositionType;
    CoreCompetency testCoreCompetency;
    Job testJob;
    @Before
    public void setTestData(){
        testName = "Product Tester";
        testEmployer = new Employer("ACME");
        testLocation = new Location("Desert");
        testPositionType = new PositionType("Quality Control");
        testCoreCompetency = new CoreCompetency("Persistence");

    }
    @Test
    public void testSettingJobId() {
        Job testJob1 = new Job();
        Job testJob2 = new Job();
        String nameSpec = "constructor sets id";
        Assert.assertNotEquals(nameSpec, testJob1.getId(), testJob2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job(testName, testEmployer, testLocation, testPositionType, testCoreCompetency);
        Assert.assertTrue( testJob.getName() instanceof String);
        Assert.assertEquals( testName, testJob.getName());
        Assert.assertTrue( testJob.getEmployer() instanceof Employer);
        Assert.assertEquals( testEmployer, testJob.getEmployer());
        Assert.assertTrue( testJob.getLocation() instanceof Location);
        Assert.assertEquals(testEmployer, testJob.getEmployer());
        Assert.assertTrue( testJob.getPositionType() instanceof PositionType);
        Assert.assertEquals(testEmployer, testJob.getEmployer());
        Assert.assertTrue( testJob.getCoreCompetency() instanceof CoreCompetency);
        Assert.assertEquals( testEmployer, testJob.getEmployer());
    }

    @Test
    public void testJobsForEquality() {
        Job testJob1 = new Job(testName, testEmployer, testLocation, testPositionType, testCoreCompetency);
        Job testJob2 = new Job(testName, testEmployer, testLocation, testPositionType, testCoreCompetency);
        Assert.assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job(testName, testEmployer, testLocation, testPositionType, testCoreCompetency);
        String testJobStringOutput = testJob.toString();
        Assert.assertEquals(testJobStringOutput.charAt(0), '\n');
        Assert.assertEquals(testJobStringOutput.charAt(testJobStringOutput.length() -1), '\n');
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        testName = "Product Tester";
        testEmployer = new Employer("ACME");
        testLocation = new Location("Desert");
        testPositionType = new PositionType("Quality Control");
        testCoreCompetency = new CoreCompetency("Persistence");
        Job testJob = new Job(testName, testEmployer, testLocation, testPositionType, testCoreCompetency);
        String testJobStringOutput = testJob.toString();
        String expectedString = String.format("" +
                "\n" +
                "ID: %s\n" +
                "Name: %s\n" +
                "Employer: %s\n" +
                "Location: %s\n" +
                "Position Type: %s\n" +
                "Core Competency: %s\n", testJob.getId(), testName, testEmployer.toString(), testLocation.toString(), testPositionType.toString(), testCoreCompetency.toString());
        Assert.assertEquals(testJobStringOutput, expectedString);
    }
    @Test
    public void testToStringHandlesEmptyField(){
        String expectedString;
        Job testJobBlank = new Job("", null, new Location(""), null, null);
        String testJobStringOutput = testJobBlank.toString();
        if(Objects.isNull(testJobBlank.getName()) && Objects.isNull(testJobBlank.getEmployer()) && Objects.isNull(testJobBlank.getLocation()) && Objects.isNull(testJobBlank.getPositionType()) && Objects.isNull(testJobBlank.getCoreCompetency())) {
            expectedString = "\nOOPS! This job does not seem to exist.\n";
        } else {
            expectedString = String.format("" +
                            "\n" +
                            "ID: %s\n" +
                            "Name: %s\n" +
                            "Employer: %s\n" +
                            "Location: %s\n" +
                            "Position Type: %s\n" +
                            "Core Competency: %s\n",
                    testJobBlank.getId(), "Data not available", "Data not available", "Data not available", "Data not available", "Data not available");
        }
        Assert.assertEquals(expectedString, testJobStringOutput);
    }
}
