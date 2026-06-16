class Solution {

  public String encode(List<String> strs) {
        return strs.stream()
                .map(s -> s.replace("/", "//").replace("#", "/#") + "#")
                .collect(Collectors.joining());
    }

    public List<String> decode(String str) {
        char oldChar = '\u0000';
        List<String> decodedStrings = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(oldChar == '/'){
                oldChar = '\u0000';
                stringBuilder.append(c);
                continue;
            } else if(c == '#'){
                decodedStrings.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            } else if(c != '/') {
                stringBuilder.append(c);
            }
            oldChar = c;
        }
//        decodedStrings.add(stringBuilder.toString());
        return decodedStrings;
    }
}
