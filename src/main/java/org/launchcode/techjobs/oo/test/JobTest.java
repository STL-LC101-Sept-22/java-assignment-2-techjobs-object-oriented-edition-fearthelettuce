package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

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
        Job testJob = new Job(testName, testEmployer, testLocation, testPositionType, testCoreCompetency);
        String testJobStringOutput = testJob.toString();
        Assert.assertEquals(testJobStringOutput,
                "\n" +
                "ID: 1\n" +
                "Name: Product Tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality Control\n" +
                "Core Competency: Persistence\n"
        );
    }
    @Test
    public void testToStringHandlesEmptyField(){
        Employer testBlankEmployer = new Employer();
        Job testJob = new Job(testName, null, new Location(""), testPositionType, testCoreCompetency);
        String testJobStringOutput = testJob.toString();
        Assert.assertEquals(
                "\n" +
                        "ID: 1\n" +
                        "Name: Product Tester\n" +
                        "Employer: Data not available\n" +
                        "Location: Data not available\n" +
                        "Position Type: Quality Control\n" +
                        "Core Competency: Persistence\n",
                testJobStringOutput);
    }
}
