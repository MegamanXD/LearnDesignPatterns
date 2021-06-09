package Singleton;

public class SunSingleton {
    private SunSingleton(){}
    private static SunSingleton instance = new SunSingleton();

    public static SunSingleton getInstance(){
        return instance;
    }
}
