package Factory;

public class PersonFactory {
    public static Person createLecturer(){ return new Lecturer(); }
    public static Person createStudent(){ return new Student(); }
}
