package Section3;
import java.util.ArrayList;

// convex
public class TestingQuestion8 {

    public static void main(String[] args) {

        ArrayList<_4gon> par = new ArrayList<_4gon>();

        // polymorphism add different shapes that extend parallelogram to _4gon arraylist
        // Test: convex using parallelogram
        System.out.println(new Parallelogram(new Vec2d(0,0), new Vec2d(2,2), new Vec2d(4,2), new Vec2d(4,0)).checkingIfConvex());

        // Test: non-convex using _4gon
        System.out.println(new _4gon(new Vec2d(1,2), new Vec2d(2,6), new Vec2d(1,5), new Vec2d(2,3)).checkingIfConvex());
    }
}