class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int N = s.length();
        int maxLength = 0;
        int[] ascii = new int[128];
        Arrays.fill(ascii,-1);
        int start = 0;
        for(int i=0;i<N;i++){
            char ch = s.charAt(i);
            if(ascii[ch] >= start){
                start = ascii[ch] + 1;
            }
            ascii[ch] = i;
            maxLength = Math.max(maxLength,i-start+1);
        }
        return maxLength;
    }
}
