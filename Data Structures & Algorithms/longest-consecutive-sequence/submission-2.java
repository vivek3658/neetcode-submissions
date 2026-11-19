class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 1) return nums.length;
        Set<Integer> numSet = new HashSet<>();
        for(int num:nums) numSet.add(num);
        int longest = 1;
        for(int num:numSet){
            if(numSet.contains(num-1)){
                continue;
            }else{
                int currentNum = num;
                int currentSub = 1;
                while(numSet.contains(currentNum+1)){
                    currentNum++;
                    currentSub++;
                }
                longest = Math.max(currentSub,longest);
            }

        }
        return longest;
    }
}
