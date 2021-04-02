import java.io.IOException;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * This class represents the linked list implementation of a hashTable of the CourseDBElements
 * @author John Mobarry
 */
public class CourseDBStructure implements CourseDBStructureInterface{

    int HashSize = 0;
    int elementSize = 0;
    LinkedList<CourseDBElement> [] hashTable;

    /**
     * Paramaterized constructor using size
     * sets the hashsize equal to size and creates a new linked list of that size
     * @param size
     */
    public CourseDBStructure(int size){
        HashSize = size;
        hashTable = new LinkedList[HashSize];
    }

    /**
     * Paramaterized constructor for testing purposes
     * @param test
     * @param size
     */
    public CourseDBStructure (String test, int size){
        HashSize = size;
        hashTable = new LinkedList[HashSize];
    }


    /**
     * This method will add the CourseDBE element to the hashtable based on its hashcode
     * If no the LinkedList array is empty at the hash code create a new linked list
     * If not add the element to the linked list at that spot
     * @param element the CDE to be added
     */
    @Override
    public void add(CourseDBElement element) {
        int hashcode;
        hashcode = Math.abs(element.hashCode())%HashSize;
        LinkedList<CourseDBElement> current = hashTable[hashcode];

        if (current == null){
            hashTable[hashcode] = new LinkedList<CourseDBElement>();
            hashTable[hashcode].add(element);
            elementSize++;
        }
        else{
        hashTable[hashcode].add(element);
        elementSize++;}
    }

    /**
     * This method will use the hashcode of the CourseDatabaseElement to see if it is in the hashtable.
     * If it is not it will throw an IOException
     * @param crn the CDE to be added
     * @return element at spot 0 based on hash code
     * @throws IOException
     */
    @Override
    public CourseDBElement get(int crn) throws IOException {
        String converted = Integer.toString(crn);
        int convertedCode = Math.abs(converted.hashCode()%HashSize);
        if(hashTable[convertedCode] == null){
            throw new IOException();
        }
        else{
            return (CourseDBElement) hashTable[convertedCode].get(0);
        }
    }

    /**
     * This method will return the size of the HashTable
     * @return HashSize
     */
    @Override
    public int getTableSize() {
        return HashSize;
    }

    /**
     * This method creates an array of strings representing the individual toString representation of the elements
     * @return toPrint
     */
    public ArrayList<String> assistShowAll(){
        ArrayList<String> toPrint = new ArrayList<String>();
        for(int i = 0; i <HashSize; i++){
            while(hashTable[i] != null){
                for(int j = 0; j<hashTable[i].size(); j++){
                    CourseDBElement element = (CourseDBElement) hashTable[i].get(j);
                    toPrint.add("\n"+element.toString());
                }
                break;
            }
        }
        return toPrint;
    }


}
