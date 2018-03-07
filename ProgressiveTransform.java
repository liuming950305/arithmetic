import java.util.Scanner;

/**
 * Created by Lenovo on 2018/2/25.
 */
public class ProgressiveTransform {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int radix = scanner.nextInt();
        System.out.println(progressiveTransform(number, radix));
    }

    /**
     * 进制转换
     * @param value 转换的值
     * @param unit 转换的进制
     */
    public static String progressiveTransform(int value, int unit) {
        if(unit < 2 || unit > 16) {
            return null;
        }
        boolean flag = value < 0 ? true : false;
        StringBuilder stringBuilder = new StringBuilder();
        value = Math.abs(value);
        while(value > 0) {
            String surplus = "";
            switch (value % unit) {
                case 10: surplus = "A"; break;
                case 11: surplus = "B"; break;
                case 12: surplus = "C"; break;
                case 13: surplus = "D"; break;
                case 14: surplus = "E"; break;
                case 15: surplus = "F"; break;
                default:
                    surplus = String.valueOf(value % unit);
            }
            stringBuilder.append(surplus);
            value = value / unit;
        }
        return flag ? stringBuilder.append("-").reverse().toString() : stringBuilder.reverse().toString();
    }
}
