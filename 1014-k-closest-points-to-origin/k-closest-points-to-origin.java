class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // TreeMap keeps distances sorted in ascending order
        Map<Integer, List<int[]>> map = new TreeMap<>();

        for (int[] point : points) {
            int dist = calculateDistance(point);

            map.putIfAbsent(dist, new ArrayList<>());
            map.get(dist).add(point);
        }

        int[][] result = new int[k][2];
        int index = 0;

        for (List<int[]> sameDistancePoints : map.values()) {
            for (int[] point : sameDistancePoints) {
                result[index] = point;
                index++;

                if (index == k) {
                    return result;
                }
            }
        }

        return result;
    }

    public int calculateDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}