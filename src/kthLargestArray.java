import java.util.Collections;
import java.util.PriorityQueue;

public class kthLargestArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0; i<nums.length; i++){
            pq.add(nums[i]);
        }

        for(int i = 1; i< k; i++){
            pq.poll();
        }

        return pq.peek();

    }
    public static void main(String[] args) {
        kthLargestArray kthLargestArray = new kthLargestArray();

        int result = kthLargestArray.findKthLargest(new int[]{1,2,3,4,5,6,7,8,9}, 3);
        System.out.println("k번째 큰수: " +result);
    }

}
