package strings;

/**
 * @author : dheerajkumar02
 * @date : 23-12-2021
 * @project : data-structure
 */
// A Dynamic programming solution for
// Word Wrap Problem in Java
public class Word_Wrap {

    final int MAX = Integer.MAX_VALUE;

    // A utility function to print the solution
    int printSolution(int p[], int n) {
        int k;
        if (p[n] == 1)
            k = 1;
        else
            k = printSolution(p, p[n] - 1) + 1;
        System.out.println("Line number" + " " + k + ": " +
                "From word no." + " " + p[n] + " " + "to" + " " + n);
        return k;
    }

    // l[] represents lengths of different words in input sequence.
// For example, l[] = {3, 2, 2, 5} is for a sentence like
// "aaa bb cc ddddd". n is size of l[] and M is line width
// (maximum no. of characters that can fit in a line)
    void solveWordWrap(int words[], int len, int maxSize) {
        // For simplicity, 1 extra space is used in all below arrays
        // extras[i][j] will have number of extra spaces if words from i
        // to j are put in a single line
        int extras[][] = new int[len + 1][len + 1];
        // lineCost[i][j] will have cost of a line which has words from i to j
        int lineCost[][] = new int[len + 1][len + 1];
        // totalCost[i] will have total cost of optimal arrangement of words from 1 to i
        int totalCost[] = new int[len + 1];
        // calculate extra spaces in a single line. The value extra[i][j]
        // indicates extra spaces if words from word number i to j are
        // placed in a single line
        for (int i = 1; i <= len; i++) {
            extras[i][i] = maxSize - words[i - 1];
            for (int j = i + 1; j <= len; j++)
                extras[i][j] = extras[i][j - 1] - words[j - 1] - 1;
        }
        // Calculate line cost corresponding to the above calculated extra
        // spaces. The value lc[i][j] indicates cost of putting words from
        // word number i to j in a single line
        for (int i = 1; i <= len; i++) {
            for (int j = i; j <= len; j++) {
                if (extras[i][j] < 0)
                    lineCost[i][j] = MAX;
                else if (j == len && extras[i][j] >= 0)
                    lineCost[i][j] = 0;
                else
                    lineCost[i][j] = extras[i][j] * extras[i][j];
            }
        }
        // Calculate minimum cost and find minimum cost arrangement.
        // The value c[j] indicates optimized cost to arrange words
        // from word number 1 to j.
        int result[] = new int[len + 1];
        totalCost[0] = 0;
        for (int j = 1; j <= len; j++) {
            totalCost[j] = MAX;
            for (int i = 1; i <= j; i++) {
                if (totalCost[i - 1] != MAX && lineCost[i][j] != MAX &&
                        (totalCost[i - 1] + lineCost[i][j] < totalCost[j])) {
                    totalCost[j] = totalCost[i - 1] + lineCost[i][j];
                    result[j] = i;
                }
            }
        }
        printSolution(result, len);
    }

    public static void main(String args[]) {
        Word_Wrap w = new Word_Wrap();
        int l[] = {3, 2, 2, 5};
        int n = l.length;
        int M = 6;
        w.solveWordWrap(l, n, M);
    }
}

// This code is contributed by Saket Kumar
