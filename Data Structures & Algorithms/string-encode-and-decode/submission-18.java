class Solution {

    public String encode(List<String> strs) {
        int n = strs.size();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String s = strs.get(i);

            res.append('"');
            
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '"' || s.charAt(j) == '\\') {
                    res.append('\\');
                }

                res.append(s.charAt(j));
            }

            res.append('"');

            if (i < n - 1) res.append(',');
        }

        res.insert(0, '[');
        res.append(']');

        return res.toString();
    }

    public List<String> decode(String str) {
        str = str.substring(1, str.length() - 1);

        ArrayList<String> res = new ArrayList<>();

        StringBuilder temp = new StringBuilder();
        boolean recording = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '"') {
                if (!recording) {
                    temp.setLength(0);
                    recording = true;
                } else {
                    res.add(temp.toString());
                    recording = false;
                }
            } else {
                if (c == ',' && !recording) {
                    continue;
                }

                if (c == '\\') {
                    temp.append(str.charAt(i + 1));
                    i++;
                } else {
                    temp.append(c);
                }
            }
        }

        return res;
    }
}
