package Section3;
import java.util.ArrayList;

public class TestingQuestion9 {

    public static void main(String[] args) {

        ArrayList<_4gon> par = new ArrayList<_4gon>();

        // polymorphism: adding three types of quadrilateral
        // convex test:
        par.add(new Parallelogram(new Vec2d(4,2), new Vec2d(8,2), new Vec2d(6,7), new Vec2d(10,7)));
        par.add(new Rectangle(new Vec2d(0,0), new Vec2d(4,0), new Vec2d(0,3), new Vec2d(4,3)));
        par.add(new Square(new Vec2d(0,0), new Vec2d(2,4), new Vec2d(1,5), new Vec2d(3,4)));
        par.add(new _4gon(new Vec2d(0,0), new Vec2d(10,0), new Vec2d(10,10), new Vec2d(0,10)));
        par.add(new _4gon(new Vec2d(1,2), new Vec2d(2,6), new Vec2d(1,5), new Vec2d(2,3)));


        //  concave test:
       par.add(new _4gon(new Vec2d(0,0), new Vec2d(-10,-10), new Vec2d(0,10), new Vec2d(10,-10)));

        for (_4gon x: par) {
            System.out.println(x.area());
        }
    }
}