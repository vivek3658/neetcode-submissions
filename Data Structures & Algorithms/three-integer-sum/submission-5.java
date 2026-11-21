class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length - 2 && nums[i]<=0;i++){
            if(i==0 || nums[i] != nums[i-1]){
                twoSum(nums,i,result);
            }
        }
        return result;
    }
    void twoSum(int[] arr,int i,List<List<Integer>> result){
        int left = i+1;
        int right = arr.length - 1;
        while(left < right){
            int sum = arr[i] + arr[left] + arr[right];
            if(sum < 0){
                ++left;
            }else if(sum > 0){
                --right;
            }else{
                result.add(List.of(arr[i],arr[left++],arr[right--]));
                while(left < right && arr[left] == arr[left - 1]){
                    ++left;
                }
            }
        }
    }
    
}
