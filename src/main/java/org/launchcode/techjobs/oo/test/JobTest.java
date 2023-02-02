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
//    @Before
//    public void setTestData(){
//
//
//        Job testJob2 = new Job("Launch Code Super Coder", testEmployer, testLocation, testPositionType, testCoreCompetency);
//    }
    @Test
    public void testJobConstructorSetsAllFields() {
        String testName = "Launch Code Super Coder";
        Employer testEmployer = new Employer("Launch Code Co.");
        Location testLocation = new Location("Somewhere in a galaxy far far away");
        PositionType testPositionType = new PositionType("Super Duper Coder");
        CoreCompetency testCoreCompetency = new CoreCompetency("Super Coder Skillz");
        Job testJob1 = new Job(testName, testEmployer, testLocation, testPositionType, testCoreCompetency);

        String nameSpec = "constructor sets name field";
        Assert.assertTrue(nameSpec, testName == testJob1.getName());
        //Assert.assertEquals(testName, testJob1.getName());
        String employerSpec = "constructor sets employer";
        Assert.assertTrue(employerSpec, testJob1.getEmployer() == testEmployer);
//        Assert.assertEquals(testJob1.getEmployer().getValue(), testEmployer.getValue());
//        Assert.assertEquals(testJob1.getEmployer().getValue(), testEmployer.getValue());
//        Assert.assertEquals(testJob1.getEmployer().getValue(), testEmployer.getValue());
//        Assert.assertEquals(testJob1.getEmployer().getValue(), testEmployer.getValue());
        String locationSpec = "constructor sets location";
        Assert.assertTrue(locationSpec, testJob1.getLocation() == testLocation);
        String positionTypeSpec = "constructor sets position type";
        Assert.assertTrue(positionTypeSpec, testJob1.getPositionType() == testPositionType);
        String coreCompetencySpec = "constructor sets core competency";
        Assert.assertTrue(coreCompetencySpec, testJob1.getCoreCompetency() == testCoreCompetency);


    }
}
