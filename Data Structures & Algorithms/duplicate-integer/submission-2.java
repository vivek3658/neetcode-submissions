class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums.length <= 1) return false;
        Set<Integer> setOfNumbers = new HashSet<Integer>();
        for(int val:nums){
            if(setOfNumbers.contains(val)){
                return true;
            }
            setOfNumbers.add(val);
        }
        return false;
    }
}