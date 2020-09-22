package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job job1;
    Job job2;
    Job job3;

    @Before
    public void initializeTwoJobObjects() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        int job1IdPlusOne = job1.getId() + 1;
        assertEquals(job1IdPlusOne, job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals(job3.getName(), "Product tester");
        assertTrue(job3.getEmployer() instanceof Employer);
        assertEquals(job3.getEmployer().getValue(), "ACME");
        assertTrue(job3.getLocation() instanceof Location);
        assertEquals(job3.getLocation().getValue(), "Desert");
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertEquals(job3.getPositionType().getValue(), "Quality control");
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job3.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job3.equals(job4));
    }

    @Test
    public void blankFirstAndLastLine() {
        assertEquals(job3.toString().indexOf('\n'), 0);
        String substring = job3.toString().substring(job3.toString().length() - 1);
        assertEquals(substring, "\n");
    }

    @Test
    public void fieldGettersWork() {
        assertTrue(job3.toString().contains(Integer.toString(job3.getId())));
        assertTrue(job3.toString().contains(job3.getName()));
        assertTrue(job3.toString().contains(job3.getEmployer().toString()));
        assertTrue(job3.toString().contains(job3.getLocation().toString()));
        assertTrue(job3.toString().contains(job3.getPositionType().toString()));
        assertTrue(job3.toString().contains(job3.getCoreCompetency().toString()));
    }

    @Test
    public void specialMessageForEmptyFields() {
        Job job5 = new Job("", new Employer(""), new Location(""),
                new PositionType(""), new CoreCompetency(""));
        job5.toString();
        assertEquals(job5.getName(), "Data not available");
        assertEquals(job5.getEmployer().getValue(), "Data not available");
        assertEquals(job5.getLocation().getValue(), "Data not available");
        assertEquals(job5.getPositionType().getValue(), "Data not available");
        assertEquals(job5.getCoreCompetency().getValue(), "Data not available");
    }

}
