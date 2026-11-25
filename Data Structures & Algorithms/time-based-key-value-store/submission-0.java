class TimeMap {
    Map<String,List<List<String>>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<>());
        }
        List<List<String>> list = map.get(key);
        list.add(List.of(value,Integer.toString(timestamp)));
    }
    
    public String get(String key, int timestamp) {
        StringBuilder sb = new StringBuilder();
        List<List<String>> values = map.getOrDefault(key,new ArrayList<>());
        int left = 0,right = values.size() - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(Integer.parseInt(values.get(mid).get(1)) <= timestamp){
                sb.setLength(0);
                sb.append(values.get(mid).get(0));
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return sb.toString();
    }
}
