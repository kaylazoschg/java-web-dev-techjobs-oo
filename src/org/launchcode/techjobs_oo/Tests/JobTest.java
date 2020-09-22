package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job job1;
    Job job2;

    @Before
    public void initializeTwoJobObjects() {
        job1 = new Job();
        job2 = new Job();
    }

    @Test
    public void testSettingJobId() {
        int job1IdPlusOne = job1.getId() + 1;
        assertEquals(job1IdPlusOne, job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
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
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job3.equals(job4));
    }

}
