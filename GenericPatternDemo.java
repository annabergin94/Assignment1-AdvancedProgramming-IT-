package Section1;
// Question 5

class GenericPatternDemo {

    static String repeatChar(char ch, int n) {
        StringBuilder buff = new StringBuilder(); // create empty String with 16 blanks called buff
        for (int i = 0; i < n; i++)
            buff.append(ch); // add ch to buff
        return buff.toString();
    }

    // don't need to pass nCentre because we work it out from the left and right
    static String genLine(char left, int nleft, char right, int nright, char centre, int width) {
        int nCentre = width - (nleft + nright);
        if (nCentre <0 || nCentre >= width) // to prevent the pattern being printed out of the range
            return null;

        // calling the repeat char method for the three parts of the pattern: left, centre, right
        String left_str = repeatChar(left, nleft);
        String right_str = repeatChar(right, nright);
        String centre_blank = repeatChar(centre, nCentre);

        return left_str + centre_blank + right_str;
    }

    // Inputs for CMD
    // * * " " 20
    // " " " " * 20
    // | | * 20
    public static void main(String[] args) {

        String line;

        if (args.length < 4) {
            System.err.println("usage java GenericPatternDemo <left_char> <right_char> <middle> <width>");
            return;
        }

        // Inputs added to command line as Strings and stored in a fixed array
        final int N = Integer.parseInt(args[3]); // convert to int
        final char LEFT_PIXEL = args[0].charAt(0);
        final char RIGHT_PIXEL = args[1].charAt(0);
        final char CENTRE_PIXEL = args[2].charAt(0);

        int i = 1;
        while ((line = genLine(LEFT_PIXEL, i, RIGHT_PIXEL, i, CENTRE_PIXEL, N)) != null) {
            System.out.println(line);
            i++;
        }

        i = N/2;
        while ((line = genLine(LEFT_PIXEL, i, RIGHT_PIXEL, i, CENTRE_PIXEL, N)) != null) {
            System.out.println(line);
            i--;
        }
    }
}


