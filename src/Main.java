import Adapter.Captain;
import Adapter.FishingBoatAdapter;
import Builder.*;
import Decorator.RedShapeDecorator;
import Facade.*;
import Factory.*;
import Iterator.*;
import Memento.*;
import Observer.*;
import Prototype.ShapeCache;
import Singleton.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // Source: https://www.tutorialspoint.com/design_pattern/index.htm
    public static void main(String[] args) {
        //1. Singleton
        //Used to save memory
        SunSingleton sun1 = SunSingleton.getInstance();
        SunSingleton sun2 = SunSingleton.getInstance();
        System.out.printf("//1.Singleton\n" +
                        "sun1 hashCode = %d\n" +
                        "sun2 hashCode = %d\n\n",
                sun1.hashCode(), sun2.hashCode()
        );

        //2. Factory
        //A neater way to create new classes
        Person lecturer = PersonFactory.createLecturer();
        Person student = PersonFactory.createStudent();
        System.out.printf("//2.Factory\n" +
                        "lecturer datatype is %s\n" +
                        "student datatype is %s\n\n",
                lecturer.getClass(), student.getClass()
        );

        //3. Iterator
        //A neater way to loop through a list
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
        //A neater way to create a new object with essentials first, then add details later
        Hero mage = new Hero.Builder("Heo", Profession.MAGE)
                .setArmor(Armor.LIGHT)
                .setHWeapon(Weapon.WAND)
                .build();

        System.out.println("//4. Builder\n" + mage + "\n");

        //5. Facade
        //Provide simplified interface for complex features
        ShapeMaker shapeMaker = new ShapeMaker();

        System.out.println("//5. Facade");
        shapeMaker.drawRectangle();
        shapeMaker.drawCircle();
        shapeMaker.drawParabola();
        System.out.println();

        //6. Decorator
        //Used for adding functionalities to existing class (patching)
        System.out.println("//6. Decorator");

        Decorator.Shape circle = new Decorator.Circle();
        Decorator.Shape redCircle = new RedShapeDecorator(new Decorator.Circle());
        Decorator.Shape redRectangle = new RedShapeDecorator(new Decorator.Rectangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
        System.out.println();

        //7. Memento
        //Restore state of an object to a previous state.
        //Used in conjunction with Command pattern for undoing
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        System.out.println("//7. Memento");
        originator.setState("State #1");

        originator.setState("State #2");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("State #4");
        System.out.println("Current State: " + originator.getState());

        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState() + "\n");

        //8. Observer
        //If one object is modified, its dependent objects (Subscriber) will be notified automatically
        Subject subject = new Subject();

        new HexObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("//8. Observer");
        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("\nSecond state change: 10");
        subject.setState(10);
        System.out.println();

        //9. Adapter
        //Convert incompatible classes into compatible
        Captain captain = new Captain(new FishingBoatAdapter());

        System.out.println("//9. Adapter");
        captain.row();

        //10. Prototype
        //Load object and cache for later reuse
        ShapeCache.loadCache();
        System.out.println("//10. Prototype");

        Prototype.Shape clonedCircle = (Prototype.Shape) ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedCircle.getType());

        Prototype.Shape clonedSquare = (Prototype.Shape) ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedSquare.getType());

        Prototype.Shape clonedRectangle = (Prototype.Shape) ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedRectangle.getType());

        System.out.println();
    }
}
