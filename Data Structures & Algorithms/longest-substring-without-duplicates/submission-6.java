class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int N = s.length();
        int[] ascii = new int[128];
        int start = 0;
        int length = 0;
        Arrays.fill(ascii,-1);
        for(int i=0;i<N;i++){
            char ch = s.charAt(i);
            if(ascii[ch] >= start){
                start = ascii[ch] + 1;
            }
            ascii[ch] = i;
            length = Math.max(length,i-start+1);
        }
        return length;
    }
}
