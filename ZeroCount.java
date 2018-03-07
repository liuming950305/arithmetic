import java.util.Scanner;

/**
 * Created by Lenovo on 2018/2/25.
 */
public class ZeroCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(zeroCount(number));
    }

    public static int zeroCount(int n) {
        int sum = 0;
        // 小于5的相乘不会出现0
        if(n >=1 && n < 5) {
            return sum;
        }
        // 计算5^x有多少个
        while(n > 0) {
            sum = sum + (n / 5);
            n = n / 5;
        }
        return sum;
    }
}
