package Section2;
import java.util.HashSet;
import java.util.Set;

class FindingPrimesHashMaps {

    // checks if number is prime, if it is prime adds it to the set called primes
    static void erastothenesSieve(Set<Integer> primes, int n) {
        for (int x: primes) {
            if (n%x == 0) return; // early termination
        }
        primes.add(n); // n prime so we add n to our set
    }

    // 20
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("usage: java PrimesBySieve <max-range>"); return;
        }
        int maxRange = Integer.parseInt(args[0]);
        Set<Integer> primes = new HashSet<>();
        primes.add(2); // 2 is a boundary condition!
// run the sieve algorithm
        for (int i=3; i<= maxRange; i++)
            erastothenesSieve(primes, i);
// print the set
        for (int x: primes)
            System.out.println(x);
    }
}
