class Solution {

  public String encode(List<String> strs) {
        String wordSize = strs.stream().map(str -> str.length() + "")
                .collect(Collectors.joining(","));
        return wordSize.concat("#")
                .concat(strs.stream().collect(Collectors.joining()));
    }

    public List<String> decode(String str) {
        if(str.equals("#")){
            return new ArrayList<>();
        }
        List<Integer> wordSize = new ArrayList<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for(; i<str.length(); i++){
            char character = str.charAt(i);
            if(character == ','){
                wordSize.add(Integer.valueOf(sb.toString()));
                sb = new StringBuilder();
            }
            else if(character == '#'){
                wordSize.add(Integer.valueOf(sb.toString()));
                break;
            } else {
                sb.append(character);
            }
        }
        i++;
        List<String> decodedString = new ArrayList<>();
        for(Integer size: wordSize){
            int endIndex = i + size;
            if(size == 0){
                decodedString.add("");
            } else{
                String substring = str.substring(i, endIndex);
                decodedString.add(substring);
            }
            i = endIndex;
        }
        return decodedString;
    }
}
