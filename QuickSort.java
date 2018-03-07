/**
 * Created by Lenovo on 2018/2/26.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[] {7, 6, 1, 2, 4, 5, 8, 3, 0, 9};
        quickSort(arr, 0 , arr.length - 1);
        for(int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort(int[] arr, int L, int R) {
        if(arr == null || arr.length < 2) {
            return;
        }
        if(L < R) {
            int[] p = partition(arr, L , R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }

    public static int[] partition(int[] arr, int L, int R) {
        // 定义两个变量标记大于与小于区域
        int less = L - 1;
        int more = R;
        // 表示还没有撞上
        while(L < more) {
            if(arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else {
                // 相等情况下直接直接右移
                less++;
            }
        }
        swap(arr, more, R);
        return new int[] {less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        if(arr[i] != arr[j]) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
}
