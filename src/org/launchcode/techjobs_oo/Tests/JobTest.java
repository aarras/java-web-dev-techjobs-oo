package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job test_job1;
    Job test_job2;
    Job test_job3;
    Job test_job4;
    Job test_job5;
    Job test_job6;

    @Before
    public void createJobObjects() {
        test_job1 = new Job();
        test_job2 = new Job();
        test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job5 = new Job("Product tester", new Employer(""), new Location(null), new PositionType(""), new CoreCompetency(null));
        test_job6 = new Job("", new Employer(""), new Location(null), new PositionType(""), new CoreCompetency(null));
    }

    @Test
    public void testSettingJobId() {
        //test_job1 = new Job();
        //test_job2 = new Job();

        assertEquals(1, test_job1.getId());
        assertEquals(2, test_job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        //Job test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(test_job3 instanceof Job);
        assertTrue(test_job3.getEmployer() instanceof Employer);
        assertTrue(test_job3.getLocation() instanceof Location);
        assertTrue(test_job3.getPositionType() instanceof PositionType);
        assertTrue(test_job3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(3, test_job3.getId());
        assertEquals("Product tester", test_job3.getName());
        assertEquals("ACME", test_job3.getEmployer().getValue());
        assertEquals("Desert", test_job3.getLocation().getValue());
        assertEquals("Quality control", test_job3.getPositionType().getValue());
        assertEquals("Persistence", test_job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        // Job test_job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //Job test_job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(test_job3.equals(test_job4));
    }

    @Test
    public void testToStringForBlankLinesAtBeginningAndEnd() {
        assertEquals("\n", test_job3.toString().substring(0, 1));
        assertEquals("\n", test_job3.toString().substring(test_job3.toString().length() - 1));
    }

    @Test
    public void testToStringForLabelsOnOwnLinesWithData() {
        assertEquals("\nID: 3\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n", test_job3.toString());
    }

    @Test
    public void testToStringForDataNotAvailableIfEmpty() {
        assertEquals("\nID: 5\nName: Product tester\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Data not available\n", test_job5.toString());
    }

    @Test
    public void testToStringForAllFieldEmpty() {
        assertEquals("OOPS! This job does not seem to exist.", test_job6.toString());
    }

}
