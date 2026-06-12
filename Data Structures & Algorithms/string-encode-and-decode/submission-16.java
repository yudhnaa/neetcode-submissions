class Solution {
    public String encode(List<String> strs) {
        
        if (strs.size() == 0){
            return "";
        }

        String encodeString = "";
        String delimeter = "#";

        for (String str : strs){
            encodeString += str.length() + delimeter + str;
        }

        return encodeString;
    }

    public List<String> decode(String str) {

        System.out.println(str);

        char delimeter = '#';
        List<String> decodeStrings = new ArrayList<String>();

        for (int index = 0; index < str.length();){
            
            int countIndexEnd = index;
            while (str.charAt(countIndexEnd) != delimeter){
                countIndexEnd++;
            }
            
            int count = Integer.parseInt(str.substring(index, countIndexEnd));
            String decodeString = str.substring(countIndexEnd+1, countIndexEnd+count+1);

            decodeStrings.add(decodeString);

            index = countIndexEnd + count + 1;
        }

        return decodeStrings;
    }
}
