class Solution {
    public int findMin(int[] nums) {
        int left = 0,right = nums.length - 1;
        if(nums[left] <= nums[right]) return nums[left];
        int min = Integer.MAX_VALUE;
        while(left<=right){
            int mid = left + (right - left)/2;
            min = Math.min(nums[mid],min);
            if(nums[mid] >= nums[left] && nums[left] >= nums[right]){
                left= mid+1;
            }else{
                right = mid-1;
            }
        }
        return min;
    }
}
