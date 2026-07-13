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
            String size = "";

            while (str.charAt(i) != '#') {
                size += str.charAt(i++);
            }

            i++;
            StringBuilder s = new StringBuilder();

            for (int j = 0; j < Integer.parseInt(size); j++) {
                s.append(str.charAt(i++));
            }

            res.add(s.toString());
        }

        return res;
    }
}
