class Solution {
    public String minWindow(String s, String t) {
        int M = s.length();
        int N = t.length();
        if(M < N) return "";
        int[] arr1 = new int[128];
        int[] arr2 = new int[128];
        for(int i=0;i<N;i++){
            arr1[t.charAt(i)]++;
        }
        for(int i=0;i<N;i++){
            char ch = s.charAt(i);
            if(arr1[ch] != 0){
                arr2[ch]++;
            }
        }
        int matches = 0;
        for(int i=0;i<128;i++){
            if(arr2[i] >= arr1[i]){
                matches++;
            }
        }
        int minWindow = Integer.MAX_VALUE;
        int left = 0;
        int start = 0, end = 0;
        int right = N;
        while(true){
            if(matches == 128){
                if(right - left < minWindow){
                    minWindow = right - left;
                    start = left;
                    end = right;
                }
                char ch = s.charAt(left);
                if(arr1[ch] != 0){
                    if(arr2[ch] == arr1[ch]) matches--;
                    arr2[ch]--;
                }
                left++;
            } else {
                if(right == M) break;
                char ch = s.charAt(right);
                if(arr1[ch] != 0){
                    arr2[ch]++;
                    if(arr2[ch] == arr1[ch]) matches++;
                }
                right++;
            }
        }
        return (minWindow == Integer.MAX_VALUE) ? "" : s.substring(start, end);
    }
}
