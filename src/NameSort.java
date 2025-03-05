import java.util.Comparator;

public class NameSort implements Comparator<Student>{
    public int compare(Student student1, Student student2) {
        return student1.getName().compareToIgnoreCase(student2.getName());
    }
}
