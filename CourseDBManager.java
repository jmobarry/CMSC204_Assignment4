import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class is the manager class for the class database we will be creating
 * @author John Mobarry
 */
public class CourseDBManager implements CourseDBManagerInterface{

    CourseDBStructure CDS = new CourseDBStructure(30);

    /**
     * This method adds a paramaterized element to the structure
     * @param id
     * @param crn
     * @param credits
     * @param roomNum
     * @param instructor
     */
    @Override
    public void add(String id, int crn, int credits, String roomNum, String instructor) {
    CourseDBElement CDE = new CourseDBElement(id,crn,credits,roomNum,instructor);
    CDS.add(CDE);
    }

    /**
     * this method gets an element based on an entered CRN and throws an IO exception if caught
     * @param crn
     * @return CourseDBElement
     */
    @Override
    public CourseDBElement get(int crn) {

        try{
            return CDS.get(crn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * this method will read the entered file and create an array of strings based on the split " " / 5 int length
     * throw a FileNotFoundException if the file is not found
     * @param input
     * @throws FileNotFoundException
     */
    @Override
    public void readFile(File input) throws FileNotFoundException {
        String courses;
        String[] course;
        CourseDBElement CDE;
        Scanner keyboard = new Scanner(input);
        while(keyboard.hasNextLine()){
            courses=keyboard.nextLine();
            course = courses.split(" ",5);
            CDE = new CourseDBElement(course[0],Integer.parseInt(course[1]),Integer.parseInt(course[2]),course[3],course[4]);
            CDS.add(CDE);
        }
    }

    /**
     * This method uses the CDS method assist show all to print all of the courses in the created database
     * @return
     */
    @Override
    public ArrayList<String> showAll() {
        return CDS.assistShowAll();
    }
}
