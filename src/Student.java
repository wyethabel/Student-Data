public class Student {
    private String name;
    private String address;
    private double GPA;

    public Student() {
        this.name = "";
        this.address = "";
        this.GPA = 0.0;
    }

    public Student(String name, String address, double GPA) {
        this.name = name;
        this.address = address;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getGPA() {
        return GPA;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
}
