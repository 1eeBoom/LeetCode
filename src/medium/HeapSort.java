package medium;

/**
 * 堆是具有以下性质的完全二叉树：
 * 每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆；
 * 或者每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆。
 *
 * 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
 *
 * 小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
 *
 * 堆排序的基本思想是：
 * 将待排序序列构造成一个大顶堆.
 * 此时，整个序列的最大值就是堆顶的根节点。
 * 将其与末尾元素进行交换，此时末尾就为最大值。
 * 然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。
 * 如此反复执行，便能得到一个有序序列了
 */
public class HeapSort {
    public static void main(String[] args){
        int[] nums = {6,7,2,15,8,4};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(nums);
        for (int i :
                nums) {
            System.out.println(i);
        }
    
    }

    /**
     * 堆排序
     * 先构建
     * 在调整
     * @param nums
     */
    private void sort(int[] nums) {
        buildInitialHeap(nums);
        /*
       构建完成后，即可开始对堆顶和堆的末尾子节点进行交换，并把末尾子节点从堆中取出
       然后再对堆进行重构
        */
        int len = nums.length;
        for (int i = len-1; i > 0 ; i--) {
            swap(nums,i,0);
            //每次交换后，都需要重新调整堆，从堆顶开始。同时堆得长度减一
            len--;
            adjustRootNodeAndSonNode(nums,0,len);
        }
    }
    
    /**
     * 将待排序的序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点
     *
     * 构建的思路：
     * 从最后一个非叶子节点开始，从右向左，从下向上调整。
     * 每个非叶子节点和自己的左右子节点进行比对，将最大的数字交换
     * 交换后的子节点还需要将自身作为递归的非叶子节点，继续与自己的子节点做比对.
     * 直到节点本身没有任何子节点
     *
     */
    private void buildInitialHeap(int[] nums) {
       int len = nums.length;
        /*
         假设有3 个节点，第一个非叶子节点实际上是 下标为 0 的，即 3/2 -1
         从最后一个非叶子节点开始，从右向左，从下向上调整。构建堆
         */
       for (int i = len/2 -1; i >= 0; i--) {
           adjustRootNodeAndSonNode(nums,i,len);
       }
    }

    /**
     * 将节点与自己的左右子节点进行比对，并进行调整
     * 该方法会被递归调用，直到root 节点没有任何子节点或者比他大的子节点
     * @param nums
     * @param root
     * @param len  长度必须手动传入，因为后续在调整堆得时候，需要不断从尾部去除某节点
     */
    private void adjustRootNodeAndSonNode(int[] nums, int root,int len){
        int l = root*2+1;
        int r = root*2+2;
        int largeIndex = l;
        if(l< len && r < len && nums[r] > nums[l]){
            largeIndex = r;
        }
        if(largeIndex < len && nums[largeIndex] > nums[root]) {
            swap(nums, root, largeIndex);
            adjustRootNodeAndSonNode(nums, largeIndex, len);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
