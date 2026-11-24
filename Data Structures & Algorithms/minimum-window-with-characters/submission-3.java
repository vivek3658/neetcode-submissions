class Solution {
    public String minWindow(String s, String t) {
        int M = s.length();
        int N = t.length();
        if(N == 0) return "";
        Map<Character,Integer> countT = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for(int i=0;i<N;i++){
            char ch = t.charAt(i);
            countT.put(ch,countT.getOrDefault(ch,0)+1);
        }
        int have = 0,need = countT.size();
        int l = 0;
        int minWindow = Integer.MAX_VALUE,start = 0,end = 0;
        for(int r=0;r<M;r++){
            char ch = s.charAt(r);
            window.put(ch,window.getOrDefault(ch,0)+1);
            if(countT.containsKey(ch) && window.get(ch).equals(countT.get(ch))){
                have += 1;
            }
            while (have == need){
                if((r-l+1) < minWindow){
                    minWindow = r-l+1;
                    start = l;
                    end = r;
                }
                ch = s.charAt(l);
                window.put(ch,window.get(ch) - 1);
                if(countT.containsKey(ch) && window.get(ch) < countT.get(ch)){
                    have -= 1;
                }
                l++;
            }
        }
        return (minWindow != Integer.MAX_VALUE)?s.substring(start,end+1):"";
    }
}
