package org.launchcode.techjobs.oo.test;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs.oo.*;
import static org.junit.Assert.*;


public class JobTest {
    Job testJob1;
    Job testJob2;

    Employer testEmployer2;
    Location testLocation1;
    Location testLocation2;
    PositionType testPositionType1;
    PositionType testPositionType2;
    CoreCompetency testCoreCompetency1;
    CoreCompetency testCoreCompetency2;
    Job testJob1Clone;
    Job testJob2Clone;
    @Before
    public void testJobs(){
        Employer testEmployer1 = new Employer("testEmployer1");
        Employer testEmployer2 = new Employer("testEmployer2");
        Location testLocation1 = new Location("testLocation1");
        Location testLocation2 = new Location("testLocation2");
        PositionType testPositionType1 = new PositionType("testPositionType1");
        PositionType testPositionType2 = new PositionType("testPositionType2");
        CoreCompetency testCoreCompetency1 = new CoreCompetency("testCoreCompetency1");
        CoreCompetency testCoreCompetency2 = new CoreCompetency("testCoreCompetency2");
        testJob1 = new Job("testJob1", testEmployer1, testLocation1, testPositionType1, testCoreCompetency1 );
        testJob2 = new Job("testJob2", testEmployer2, testLocation2, testPositionType2, testCoreCompetency2);
        testJob1Clone = new Job("testJob1Clone", testEmployer1, testLocation1, testPositionType1, testCoreCompetency1);
        testJob2Clone = new Job("testJob2Clone", testEmployer2, testLocation2, testPositionType2, testCoreCompetency2);
    }

    @Test
    public void testSettingJobId(){
        assertEquals(testJob1.getId()+1, testJob2.getId(), .01);
        assertEquals(testJob1.getId()+2, testJob1Clone.getId(), .01);
    }

    @Test
    public void testJobConstructor(){
        Job thisJob = new Job("Bagel Tester", new Employer("Bagel Store"), new Location("Kitchen"), new PositionType("Tester"), new CoreCompetency("Hunger"));

        assertEquals("Bagel Tester", thisJob.getName());
        assertEquals("Bagel Store", thisJob.getEmployer().getValue());
        assertEquals("Kitchen", thisJob.getLocation().getValue());
        assertEquals("Tester", thisJob.getPositionType().getValue());
        assertEquals("Hunger", thisJob.getCoreCompetency().getValue());

    }

    @Test
    public void testJobsAreClones(){
        assertNotEquals(testJob1, testJob1Clone);
        assertNotEquals(testJob2, testJob2Clone);
    }

    @Test
    public void testToString(){

        assertTrue(testJob1.toString().startsWith("\n") && testJob1.toString().endsWith("\n"));

        String idLabel = "ID: "; String nameLabel = "Name: "; String employerLabel = "Employer: "; String locationLabel = "Location: "; String positionTypeLabel = "Position Type: "; String coreCompetencyLabel = "Core Competency: ";
        String idString = testJob1.getId().toString(); String nameString = testJob1.getName(); String employerString = testJob1.getEmployer().toString(); String locationString = testJob1.getLocation().toString(); String positionTypeString = testJob1.getPositionType().toString(); String coreCompetencyString = testJob1.getCoreCompetency().toString();


        assertEquals(testJob1.toString().indexOf(idLabel), (testJob1.toString().indexOf(idString) - idLabel.length()));
        assertEquals(testJob1.toString().indexOf(nameLabel), (testJob1.toString().indexOf(nameString) - nameLabel.length()));
        assertEquals(testJob1.toString().indexOf(employerLabel), (testJob1.toString().indexOf(employerString) - employerLabel.length()));
        assertEquals(testJob1.toString().indexOf(locationLabel), (testJob1.toString().indexOf(locationString) - locationLabel.length()));
        assertEquals(testJob1.toString().indexOf(positionTypeLabel), (testJob1.toString().indexOf(positionTypeString) - positionTypeLabel.length()));
        assertEquals(testJob1.toString().indexOf(coreCompetencyLabel), (testJob1.toString().indexOf(coreCompetencyString) - coreCompetencyLabel.length()));
    }

    @Test
    public void testJobFieldsDataForNull(){
        String idLabel = "ID: "; String nameLabel = "Name: "; String employerLabel = "Employer: "; String locationLabel = "Location: "; String positionTypeLabel = "Position Type: "; String coreCompetencyLabel = "Core Competency: ";
        Job emptyJob = new Job();
        emptyJob.setName("Job has name!");
        String noData = "Data not available";

        assertTrue(emptyJob.getEmployer() == null && emptyJob.toString().contains(employerLabel + noData));
        assertTrue(emptyJob.getLocation() == null && emptyJob.toString().contains(locationLabel + noData));
        assertTrue(emptyJob.getPositionType() == null && emptyJob.toString().contains(positionTypeLabel + noData));
        assertTrue(emptyJob.getCoreCompetency() == null && emptyJob.toString().contains(coreCompetencyLabel + noData));
    }

    @Test
    public void testJobFieldsDataForEmpty(){
        String idLabel = "ID: "; String nameLabel = "Name: "; String employerLabel = "Employer: "; String locationLabel = "Location: "; String positionTypeLabel = "Position Type: "; String coreCompetencyLabel = "Core Competency: ";
        Job emptyJob3 = new Job("",new Employer(""),new Location("location name"), new PositionType(""), new CoreCompetency(""));
        String noData = "Data not available";

        assertTrue(emptyJob3.getName().equals("") && emptyJob3.toString().contains(nameLabel + noData));
        assertTrue(emptyJob3.getEmployer().getValue().equals("") && emptyJob3.toString().contains(employerLabel + noData));
        assertTrue(emptyJob3.getPositionType().getValue().isEmpty() && emptyJob3.toString().contains(positionTypeLabel + noData));
        assertTrue(emptyJob3.getCoreCompetency().getValue().isEmpty() && emptyJob3.toString().contains(coreCompetencyLabel + noData));
    }
    //4. If a job only contains data for the id field the method returns "OOPS! This job does not seem to exist"
    @Test
    public void testForEmptyJob(){
        Job emptyJob2 = new Job();
        assertTrue(emptyJob2.toString().equals("OOPS! This job does not seem to exist"));
    }

    @Test
    public void testToStringStartsAndEndsWithNL()

    {
        Job job = new Job();
        job.setName( "name" );
        assertEquals( '\n', job.toString().charAt(0) );
        assertEquals( '\n', job.toString().charAt( job.toString().length() - 1) );
    }
}
