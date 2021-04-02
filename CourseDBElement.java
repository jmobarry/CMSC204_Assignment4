/**
 *This class is to create the elements which contain the information for a specific course
 * @author John Mobarry
 */
public class CourseDBElement implements Comparable<CourseDBElement> {

    String CourseID;
    int CRN;
    int credits;
    String roomNum;
    String instructorName;

    /**
     *This method will return the int value of the CRN
     * @return CRN
     */
    public int getCRN() {
        return CRN;
    }

    /**
     * This is the default constructor for the CourseDBElement class
     */
    public CourseDBElement() {
        this(null, 00000, 0, null, null);
    }

    /**
     * This is the paramaterized constructor for the CourseDBElement class
     * @param courseID
     * @param CRN
     * @param credits
     * @param roomNum
     * @param instructorName
     */
    public CourseDBElement(String courseID, int CRN, int credits, String roomNum, String instructorName) {
        this.CourseID = courseID;
        this.CRN = CRN;
        this.credits = credits;
        this.roomNum = roomNum;
        this.instructorName = instructorName;
    }


    /**
     * Overridden compareTo method
     * if this CRN == compared CRN return 0
     * if this CRN < compared CRN return -1
     * if this CRN > compared CRN return 1
     * @param o
     * @return
     */
    @Override
    public int compareTo(CourseDBElement o) {
        if (this.getCRN() == o.getCRN()) {
            return 0;
        } else if (this.getCRN() < o.getCRN()) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * Convert to String to use specified hashCode formula
     * @return int representing string converted hashCode
     */
    public int hashCode(){
        String CRN_input = Integer.toString(this.CRN);
        return CRN_input.hashCode();
    }

    /**
     * To string method that displays the information for the CourseDBElement
     * @return
     */
    public String toString(){
        String info = "Course:" + this.CourseID+ " CRN:"+this.CRN+" Credits:"
                + this.credits+ " Instructor:" +this.instructorName +" Room:"+ this.roomNum;
        return info;
    }

}
