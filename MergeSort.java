/**
 * Created by Lenovo on 2018/2/25.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[] {7, 6, 1, 2, 4, 5, 8, 3, 0, 9};
        mergeSort(arr, 0 , arr.length - 1);
        for(int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 归并排序
     * @param arr 所需要排序的数组
     * @param L 左边界
     * @param R 右边界
     */
    public static void mergeSort(int[] arr, int L, int R) {
        // 终止条件
        if(L == R) {
            return ;
        }
        int mid = L + ((R - L) >> 1);
        // 排序
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        // 合并
        merge(arr, L, mid, R);
    }


    public static void merge(int[] arr, int L, int mid, int R){
        // 生成一个辅助数组
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int i = 0;
        // 类似外排进行记录
        while(p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 将剩余的拷贝进辅助数组
        while(p1 <= mid) {
            help[i++] = arr[p1++];
        }
        // 将剩余的拷贝进辅助数组
        while(p2 <= R) {
            help[i++] = arr[p2++];
        }
        // 拷贝进原数组
        for(i = 0; i < help.length; i ++) {
            arr[L + i] = help[i];
        }
    }
}
