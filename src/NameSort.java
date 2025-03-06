/* Defines a custom comparator used for the sort functionality
   of student data as it is exported in the Main class.
 */
import java.util.Comparator;

public class NameSort implements Comparator<Student>{
    public int compare(Student student1, Student student2) {
        return student1.getName().compareToIgnoreCase(student2.getName());
    }
}
