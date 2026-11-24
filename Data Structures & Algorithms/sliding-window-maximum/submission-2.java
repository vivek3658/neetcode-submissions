class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        if(N<k) return new int[]{};
        int l = 0,r = 0,j = 0;
        int[] result = new int[N-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        while(r < N){
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[r]){
                deque.removeLast();
            }
            deque.addLast(r);
            if (l > deque.peekFirst()){
                deque.removeFirst();
            }
            if((r+1)>= k){
                result[j++] = nums[deque.peekFirst()];
                l++;
            }
            r++;
        }
        return result;
    }
}
