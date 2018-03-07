import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2018/2/25.
 */
public class GetAllNotIncluded {

    public static void main(String[] args) {
        int[] source = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] target = new int[] {2, 10, 12, 6, 8};
        System.out.println(getAllNotIncluded(source, target));
    }

    /**
     * 找出B中所有不在A中的数值
     * @param source A
     * @param target B
     * @return
     */
    public static List<Integer> getAllNotIncluded(int[] source, int[] target) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < target.length; i ++) {
            int L = 0;
            int R = source.length - 1;
            boolean flag = false;
            // 大于中值时,往右边继续二分
            while(L <= R) {
                int mid = L + ((R - L) >> 1);
                if(target[i] == source[mid]) {
                    flag = true;
                    break;
                }
                else if(target[i] > source[mid]) {
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }
            }
            if(!flag) {
                list.add(target[i]);
            }
        }
        return list;
    }
}
