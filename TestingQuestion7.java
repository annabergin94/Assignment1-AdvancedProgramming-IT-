package Section3;
import java.util.ArrayList;

// run with green  button

public class TestingQuestion7 {

    public static void main(String[] args) {

        // container is ArrayList par
        ArrayList<_4gon> par = new ArrayList<_4gon>();

        // polymorphism: adding three types of quadrilateral
        par.add(new Parallelogram(new Vec2d(0,0), new Vec2d(2,2), new Vec2d(1,3), new Vec2d(2,4)));
        par.add(new Rectangle(new Vec2d(0,0), new Vec2d(1,3), new Vec2d(4,3), new Vec2d(2,4)));
        par.add(new Square(new Vec2d(0,0), new Vec2d(2,4), new Vec2d(1,5), new Vec2d(3,4)));

        // printing perimeter for each element in the ArrayList
        // if it prints we can confirm that the quadrilateral can use the perimeter method
        for (_4gon x: par) {
            System.out.println(x.perimeter());
        }
    }
}


