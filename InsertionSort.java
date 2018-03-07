import java.util.Arrays;

/**
 * Created by Lenovo on 2018/2/24.
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        // 插入排序, 时间复杂度为O(n^2)
        if(arr == null || arr.length < 2) {
            return ;
        }

        for(int i = 0; i < arr.length; i ++) {
            for(int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j --) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 实现一个绝对正确的方法,时间复杂度可以较高,用于验证自己算法的正确性
     * @param arr
     */
    public static void rightMethod(int[] arr) {
        // 使用JDK自带的排序方法进行排序
        Arrays.sort(arr);
    }

    /**
     * 随机生成大小与随机数值
     * @param size
     * @param value
     */
    public static int[] randomExampleGenerator(int size, int value) {
        /* 随机大小的数组
        * Math.random() 随机生成[0, 1)的double类型的数值
        */
        int[] array = new int[(int) (Math.random() * size)];
        for(int i = 0; i < array.length; i++) {
            // 随机生成值
            array[i] = (int) ((Math.random() - Math.random()) * value);
        }
        return array;
    }

    /**
     * 拷贝数组
     */
    public static int[] copyArray(int[] arr) {
        if(arr == null) {
            return null;
        }
        int[] temp = new int[arr.length];
        for(int i = 0; i < arr.length; i ++) {
            temp[i] = arr[i];
        }
        return temp;
    }

    /**
     * 比较两个数组相同,条件应该是数组长度，数组中的值都完全相同
     * @param source 源数组
     * @param target 目标数组
     * @return
     */
    public static boolean isEqual(int[] source, int[] target) {
        if((source == null && target != null) || (source != null && target ==null)) {
            return false;
        }
        if(source == null && target == null) {
            return true;
        }
        if(source.length == target.length) {
            for(int i = 0; i < source.length; i ++) {
                if(source[i] != target[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // 设置测试次数
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean flag = true;
        for(int i = 0; i < testTime; i ++) {
            int[] array = randomExampleGenerator(maxSize, maxValue);
            int[] arr2 = copyArray(array);
            int[] arr3 = copyArray(array);
            rightMethod(arr2);
            insertionSort(arr3);
            if(!isEqual(arr2, arr3)) {
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "Nice" : "Fucking Fucked" );

    }
}
