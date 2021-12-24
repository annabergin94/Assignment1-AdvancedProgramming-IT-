package Section1;
// Question 3

class PrimeFinder {

    // checking if n is prime
    static boolean isPrime(int n) {
        for (int x=2; x<=(int)Math.sqrt(n); x++) {
            if (n%x == 0) {
                return false; // even, early termination
            }
        }
        return true; // not divisible by any number <= sqrt(n)
    }

    // CMD line args 100 1000
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("usage: java PrimeFinder <max-range>");
            return;
        }

        int minRange = Integer.parseInt(args[0]); // min value at position 0
        int maxRange = Integer.parseInt(args[1]); // min value at position 1
        for (int i=minRange; i<= maxRange; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }
}
		