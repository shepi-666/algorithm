package online.labuladong.algo.utils;

/**
 * @author: DongShaowei
 * @create: 2024-10-01 20:12
 * @description: 实现堆排序
 */
public class Heap {
    public static void sort(int[] arr) {

        if (arr == null || arr.length <= 1) return;
        int n = arr.length;

        // 从最后一个非叶子节点构建大顶堆 n / 2 - 1
        for (int i = n / 2 - 1; i >= 0; i--) {
            // 递归构建大根堆
            heapify(arr, n, i);
        }

        // 逐一将最大的元素移动到数组末尾
        for (int i = n - 1; i >= 0; i--) {
            swap(0, i, arr);

            // 调整堆结构, 堆尾索引为 i， 父节点索引为 0
            heapify(arr, i, 0);
        }

    }

    /**
     * 交换数组两个元素的值
     * @param i
     * @param j
     */
    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 调整对结构，使其称为最大堆
     * @param arr
     * @param n 结尾索引
     * @param i 当前节点索引
     */
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // 默认当前索引值是最大的
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        // 如果左孩子更大
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // 如果右孩子大
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // 如果最大的不是本节点
        if (largest != i) {
            // 交换当前节点和最大的节点
            swap(largest, i, arr);

            // 调整堆结构，从某个孩子开始，调整为最大堆
            heapify(arr, n, largest);
        }

    }
}
