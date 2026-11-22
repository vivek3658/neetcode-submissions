class Solution {
    public int trap(int[] height) {
        if(height.length <= 2) return 0;
        int N = height.length;
        int water = 0;
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = N - 1;
        while(left < right){
            if(height[left]<height[right]){
                if(height[left] < leftMax){
                    water += leftMax - height[left];
                }else{
                    leftMax = height[left];
                }
                left++;
            }else{
                if(height[right] < rightMax){
                    water += rightMax - height[right];
                }else{
                    rightMax = height[right];
                }
                right--;
            }
        }
        return water;
    }
}
