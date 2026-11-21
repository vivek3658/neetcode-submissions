class Solution {
    public int trap(int[] height) {
        if(height.length <= 2) return 0;
        int N = height.length;
        int[] left = new int[N];
        int[] right = new int[N];
        left[0] = height[0];
        right[N-1] = height[N-1];
        for(int i=1;i<N;i++){
            left[i] = Math.max(left[i-1],height[i]);
        }
        for(int i=N-2;i>=0;i--){
            right[i] = Math.max(right[i+1],height[i]);
        }
        int trap = 0;
        for(int i=0;i<N;i++){
            trap += Math.min(left[i],right[i]) - height[i];
        }
        return trap;
    }
}
