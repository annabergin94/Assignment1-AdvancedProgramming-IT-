package Section1;
import java.util.Scanner;

// Question 4
//  find twin, cousin and sexy primes within a given maximum integer bound.

class PrimesWithinAMaxIntegerBound {

    // checking if n is prime
    static boolean isPrime(int n) {
        for (int x = 2; x <= (int) Math.sqrt(n); x++) {
            if (n % x == 0) {
                return false; // early termination
            }
        }
        return true; // not divisible by any number <= sqrt(n)
    }

    static void primesWithinMaxBound(int lowerBound, int upperBound){

        for (int i = lowerBound; i < upperBound; i++) {
            if (isPrime(i) && isPrime(i + 2)) {
                // twin prime: p2-p1 =2 ie., (3,5) = 5-3=2
                int secondNum = i + 2;
                if (secondNum < upperBound) {
                    System.out.println("Twin prime: (" + i + "," + secondNum + ")");
                }
            }
            if (isPrime(i) && isPrime(i + 4)) {
                int secondNum = i + 4;
                if (secondNum < upperBound) {
                    System.out.println("Cousin prime: (" + i + "," + secondNum+ ")");
                }
            }
            if (isPrime(i) && isPrime(i + 6)) {
                int secondNum = i + 6;
                if (secondNum < upperBound) {
                    System.out.println("Sexy pair: (" + i + "," + secondNum + ")");
                }
            }
        }
    }
    // CMD line arguments 2 and 20
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("usage: java PrimeFinder <max-range>");
            return;
        }
        int lowerBound = Integer.parseInt(args[0]);
        int upperBound = Integer.parseInt(args[1]);
        primesWithinMaxBound(lowerBound, upperBound);
    }
}


