package Facade;

public class ShapeMaker {
    private Shape circle;
    private Shape rectangle;
    private Shape parabola;

    public ShapeMaker() {
        this.circle = new Circle();
        this.rectangle = new Rectangle();
        this.parabola = new Parabola();
    }

    public void drawCircle(){
        circle.draw();
    }

    public void drawRectangle(){
        rectangle.draw();
    }

    public void drawParabola(){
        parabola.draw();
    }
}
