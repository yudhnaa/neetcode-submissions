class TimeMap {

    private static class Entry{
        int timeStamp;
        String value;

        Entry(int timeStamp, String value){
            this.timeStamp = timeStamp;
            this.value = value;
        }
    }

    private Map<String, List<Entry>> map;


    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<Entry>())
            .add(new Entry(timestamp, value));

        // above is equals to

        // if (!map.containsKey(key))(
        //     map.put(key, new ArrayList<>());
        // )

        // List<Entry> list = map.get(key);

        // list.add(new Entry(
        //     timestamp, value
        // ));
        
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)){
            return "";
        }

        List<Entry> list = map.get(key);

        int left = 0;
        int right = list.size() - 1;
        String res = "";

        while (left <= right){
            int mid = left + (right - left) / 2;
            Entry midEntry = list.get(mid);

            if (midEntry.timeStamp <= timestamp){
                res = midEntry.value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;

    }
}
