class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        int[] result = new int[N-k+1];
        int l = 0;
        int j = 0;
        Queue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        int top = -10001;
        for(int i=0;i<N;i++){
            queue.add(nums[i]);
            if(i-l+1>=k){
                result[j++] = queue.peek(); 
                queue.remove(nums[l]);
                l++;
            }
        }
        return result;
    }
}
