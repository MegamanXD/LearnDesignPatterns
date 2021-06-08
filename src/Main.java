import Builder.*;
import Facade.*;
import Factory.*;
import Iterator.*;
import Singleton.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // Source: https://www.tutorialspoint.com/design_pattern/index.htm

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
                .setHWeapon(Weapon.WAND)
                .build();

        System.out.println("//4. Builder\n" + mage + "\n");

        //5. Facade
        ShapeMaker shapeMaker = new ShapeMaker();

        System.out.println("//5. Facade");
        shapeMaker.drawRectangle();
        shapeMaker.drawCircle();
        shapeMaker.drawParabola();
    }
}
