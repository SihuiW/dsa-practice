class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int res = 0;

        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > 2) {
                int x = fruits[left];
                map.put(x, map.get(x) - 1);

                if (map.get(x) == 0) {
                    map.remove(x);
                }

                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}