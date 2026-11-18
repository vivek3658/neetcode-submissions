class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] arr = new int[26];
        char[] str = s.toCharArray();
        char[] str2 = t.toCharArray();
        for(int i=0;i<s.length();i++){
            int pos = (int) (str[i] - 97);
            arr[pos] += 1;
            pos = (int) (str2[i] - 97);
            arr[pos] -= 1;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }
}
