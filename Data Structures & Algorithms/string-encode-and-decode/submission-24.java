class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < strs.size(); i++) {
            String s = strs.get(i);

            res.append(String.valueOf(s.length()));
            res.append('#');
            res.append(s);
        }

        return res.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> res = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {
            int size = 0;

            while (str.charAt(i) != '#') {
                size = size * 10 + (str.charAt(i) - '0');
                i++;
            }
            
            i++;
            
            res.add(str.substring(i, i + size));
            i += size;
        }

        return res;
    }
}
