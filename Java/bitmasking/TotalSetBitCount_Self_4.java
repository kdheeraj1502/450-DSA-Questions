package bitmasking;

/**
 * @author : dheerajkumar02
 * @date : 22-12-2021
 * @project : data-structure
 */
public class TotalSetBitCount_Self_4 {

    static int count = 0;
    public static int countSetBits(int n){
        for(int i = 1; i <= n; i++){
            count += findSetBitCount(i);
        }
        return count;
    }

    private static int findSetBitCount(int n){
        int a = n;
        int count = 0;
        while(n > 0){
            n = n & (n - 1);
            count++;
        }
        System.out.println("For " + a + " set bits are " + count);
        return count;
    }

    public static void main(String[] args) {
        int a = countSetBits(40);
        System.out.println("total is ");
        System.out.println(a);
    }
}
