/**
 * Created by Lenovo on 2018/2/26.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[] {7, 6, 1, 2, 4, 5, 8, 3, 0, 9};
        heapSort(arr);
        for(int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void heapSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return ;
        }
        // 构建(大/小)根堆
        for(int i = 0; i < arr.length; i ++) {
            heapInsert(arr, i);
        }
        // 排序
        int size = arr.length;
        swap(arr, 0, --size);
        while(size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        // 比较父节点之间的大小
        int left = 2 * index + 1;
        while(left < heapSize) {
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if(largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1;
        }

    }

    private static void heapInsert(int[] arr, int index) {
        // 判断当前index与父节点值的大小
        while(arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        if(arr[i] != arr[j]) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
}
