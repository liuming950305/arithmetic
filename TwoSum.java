import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2018/2/26.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 11, 7, 15};
        int target = 9;
        new TwoSum().twoSum(nums, target);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i ++) {
            if(map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
