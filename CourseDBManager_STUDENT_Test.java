import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBManager_STUDENT_Test {
    private CourseDBManagerInterface dataMgr = new CourseDBManager();

    /**
     * Create an instance of CourseDBManager
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        dataMgr = new CourseDBManager();
    }

    /**
     * Set dataMgr reference to null
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        dataMgr = null;
    }

    /**
     * Test for the add method
     */
    @Test
    public void testAddToDB() {
        try {
            dataMgr.add("Math187",19752,2,"MC450","David Torain");
        }
        catch(Exception e) {
            fail("This should not have caused an Exception");
        }
    }

    /**
     * Test for the showAll method
     */
    @Test
    public void testShowAll() {
        dataMgr.add("Math187",19752,2,"MC450","David Torain");
        dataMgr.add("Math192",19753,4,"MC451","David Tyree");
        ArrayList<String> list = dataMgr.showAll();

        assertEquals(list.get(0),"\nCourse:Math187 CRN:19752 Credits:2 Instructor:David Torain Room:MC450");
        assertEquals(list.get(1),"\nCourse:Math192 CRN:19753 Credits:4 Instructor:David Tyree Room:MC451");
        }
    /**
     * Test for the read method
     */
    @Test
    public void testRead() {
        try {
            File inputFile = new File("Test1.txt");
            PrintWriter inFile = new PrintWriter(inputFile);
            inFile.println("Math187 19752 2 MC450 David Torain");
            inFile.print("Math192 19753 4 MC451 David Tyree");

            inFile.close();
            dataMgr.readFile(inputFile);
            //System.out.println(dataMgr.showAll());
        } catch (Exception e) {
            fail("Should not have thrown an exception");
        }
    }
}
