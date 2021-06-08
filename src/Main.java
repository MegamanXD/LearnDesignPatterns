import Builder.*;
import Factory.Person;
import Factory.PersonFactory;
import Iterator.StudentList;
import Singleton.SunSingleton;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //1. Singleton
        SunSingleton sun1 = SunSingleton.getInstance();
        SunSingleton sun2 = SunSingleton.getInstance();
        System.out.printf("//1.Singleton\n" +
                        "sun1 hashCode = %d\n" +
                        "sun2 hashCode = %d\n\n",
                sun1.hashCode(), sun2.hashCode()
        );

        //2. Factory
        Person lecturer = PersonFactory.createLecturer();
        Person student = PersonFactory.createStudent();
        System.out.printf("//2.Factory\n" +
                        "lecturer datatype is %s\n" +
                        "student datatype is %s\n\n",
                lecturer.getClass(), student.getClass()
        );

        //3. Iterator
        List<String> students = new ArrayList();
        students.add("David");
        students.add("Pastor");
        students.add("Milly");
        students.add("Cheery");
        students.add("Sam");

        StudentList studentList = new StudentList();
        studentList.setStudents(students);

        System.out.println("//3.Iterator");
        while (studentList.hasNext()) {
            System.out.println(studentList.next());
        }
        System.out.println();

        //4. Builder
        Hero mage = new Hero.Builder("Heo", Profession.MAGE)
                .setArmor(Armor.LIGHT)
                .setHairColor(HairColor.BLACK)
                .setHairType(HairType.STRAIGHT)
                .setHWeapon(Weapon.WAND)
                .build();

        System.out.println("//4. Builder\n" + mage);
    }
}
