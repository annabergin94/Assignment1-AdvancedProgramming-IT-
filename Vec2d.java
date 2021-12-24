package Section3;

public class Vec2d {
        // the side of a shape, line with direction
        float x;
        float y;

        public Vec2d(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public Vec2d add(Vec2d that) {
            return new Vec2d(this.x + that.x, this.y + that.y);
        }

        // give it a float number, returns an object where x and y is scaled by alpha
        public Vec2d scale(float alpha) {
            return new Vec2d(alpha*this.x, alpha*this.y);
        }


        public Vec2d minus(Vec2d that) {
            return this.add(that.scale(-1.0f)); // scale by -1.0
        }

        // bottom of cos
        public float l2norm() {
            return (float)Math.sqrt(x*x + y*y);
        }

        public float getX() {
            return x;
        }
        public float getY() {
            return y;
        }
    }
