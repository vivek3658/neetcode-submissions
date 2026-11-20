class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 1) return nums.length;
        Set<Integer> set = new HashSet<>();
        for(int num:nums) set.add(num);
        int longest = 1;
        for(int num:set){
            if(set.contains(num - 1)){
                continue;
            }else{
                int currentNum = num;
                int currentSub = 1;
                while(set.contains(currentNum+1)){
                    currentNum++;
                    currentSub++;
                }
                longest = Math.max(longest,currentSub);
            }
        }
        return longest;
    }
}
