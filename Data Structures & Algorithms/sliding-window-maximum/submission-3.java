class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        int[] result = new int[N-k+1];
        Deque<Integer> q = new ArrayDeque<>();
        int l = 0,j = 0;
        for(int r=0;r<N;r++){
            while(!q.isEmpty() && nums[q.peekLast()] < nums[r]){
                q.removeLast();
            }
            q.addLast(r);
            if(q.peekFirst() < l){
                q.removeFirst();
            }
            if(r+1>=k){
                result[j++] = nums[q.peekFirst()];
                l++;
            }
        }
        return result;
    }
}
