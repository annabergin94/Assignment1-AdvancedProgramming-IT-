package Section2;

import simple.HelloWorld;

import java.util.*;

public class PrimeGaps{

    // checks if n is prime and adds it to the set
    static void erastothenesSieve(Set<Integer> primes, int n) {
        for (int x : primes) {
            if (n % x == 0) return; // early termination
        }
        // not divisible primes seen so far
        primes.add(n); // add n to our set
    }

    // finding primes that satisfy the condition
    static Set<Integer> findingPrimes(int maxRange) {
        Set<Integer> primes = new TreeSet<>(); // best because its ordered
        primes.add(2); // 2 is a boundary condition!
        // run the sieve algorithm
        for (int i = 3; i <= maxRange; i++)
            erastothenesSieve(primes, i);
        return primes;
    }

    // calculate the gap of each pair of two primes
    // copy tree set into an arraylist
    static ArrayList<Integer> calculateGap(Set<Integer> primes) {
        ArrayList<Integer> copyingTreeSet = new ArrayList<Integer>();
        for (int x : primes) {


            copyingTreeSet.add(x); // arraylist with the prime numbers from the tree set
        }

        ArrayList<Integer> returningArrayList = new ArrayList<Integer>();

        // finding the gap
        for (int i = 0; i < copyingTreeSet.size(); i++) {
            for (int j = i+1; j < copyingTreeSet.size(); j++) {
                returningArrayList.add(copyingTreeSet.get(j) - copyingTreeSet.get(i));
            }
        }
        return returningArrayList;
    }


    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("usage: java PrimesBySieve <max-range>"); return;
        }

        // call .top to print
        for (HelloWorld.SetElement x : new HelloWorld.MultiSet(calculateGap(findingPrimes(Integer.parseInt(args[0])))).top()) {
            System.out.println(x);
        }
    }
}

