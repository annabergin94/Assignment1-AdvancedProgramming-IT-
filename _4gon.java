package Section3;

public class _4gon {

    Vec2d a, b, c, d;

    _4gon(Vec2d a, Vec2d b, Vec2d c, Vec2d d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    float perimeter() {
        return a.minus(b).l2norm() + b.minus(c).l2norm() + c.minus(d).l2norm() + d.minus(a).l2norm();
    }

    // Use three points to get the angle of the three points
    float angle(Vec2d v1, Vec2d v2, Vec2d v3) {
        //calculating an angle using 2 vectors
        Vec2d v1_v2 = v1.minus(v2);
        Vec2d v3_v2 = v3.minus(v2);

        // cosine equation (AxB) X is cartesian product
        return (float) Math.acos((v1_v2.getX() * v3_v2.getX() + v1_v2.getY() * v3_v2.getY()) / (v1_v2.l2norm() * v3_v2.l2norm()));
    }

    // 2*3.1415 == 360 degrees total but acos will never work over 180 degrees
    public boolean checkingIfConvex() {
        //  Math.round is used to ensure precision
        if (Math.round((angle(d, a, b) + angle(b, c, d) + angle(c, d, a) + angle(a, b, c)) * 1000) == Math.round(2 * 3.141592 * 1000)) {
            return true;
        }
        return false;
    }

    // part of q.9 area of any quadrilateral
    float area() {

        // calculating the 4 vectors by call the minus methods on 2 points
        Vec2d ad = a.minus(d);
        Vec2d ab = a.minus(b);
        Vec2d cd = c.minus(d);
        Vec2d bc = b.minus(c);

        // convex quad
        // Math.abs to calculate absolute value
        // ad.getX()*ab.getY() - ad.getY()*ab.getX() calcluates cartesian
        float s1 = Math.abs(ad.getX()*ab.getY() - ad.getY()*ab.getX())/2;
        float s2 = Math.abs(bc.getX()*cd.getY() - bc.getY()*cd.getX())/2;

        // concave quad
        float s3 = Math.abs(ab.getX()*bc.getY() - ab.getY()*bc.getX())/2;
        float s4 = Math.abs(ad.getX()*cd.getY() - ad.getY()*cd.getX())/2;
        // area = s3 + s4

        // check is it convex
        if (checkingIfConvex()) {
            return s1+s2; // this is equal to s3 + s4 for convex
        } else {
            // check which ones bigger and get the smallest
            return s1+s2 >= s3+s4 ? s3+s4 : s1+s2;
        }
    }
}

    interface ValidityChecker {
        boolean isValid();
    }

   class Parallelogram extends _4gon implements ValidityChecker {

        Parallelogram(Vec2d a, Vec2d b, Vec2d c, Vec2d d) {
            super(a, b, c, d);  // reuse the constructor function
        }

        // check object is a parallelogram because this what we need to implement
        public boolean isValid() {
            if ((a.minus(b).l2norm() == c.minus(d).l2norm())&& (a.minus(d).l2norm() == b.minus(c).l2norm())) return true;
            return false;
       }

        float area2() {
            return Math.abs(a.getX() * b.getY() - a.getY() * b.getX());
        }
    }

    // Doesn't need to implement ValidityChecker because it already extends Parallelogram
   class Rectangle extends Parallelogram {
        float l_a, l_b;

        Rectangle(Vec2d a, Vec2d b, Vec2d c, Vec2d d) {
            super(a, b, c, d);  // reuse the constructor function
            l_a = a.minus(b).l2norm(); // length of the vector
            l_b = b.minus(c).l2norm();
        }

        public boolean isValid() {
            if (!super.isValid()) return false; // rectangle must be a parallelogram
            if (a.minus(c).l2norm() == b.minus(d).l2norm()) return true;
            return false;
        }
    }

      class Square extends Rectangle {
            Square(Vec2d a, Vec2d b, Vec2d c, Vec2d d) {
                super(a, b, c, d);  // reuse the constructor function
            }
        }


