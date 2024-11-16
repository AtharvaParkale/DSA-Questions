class Solution {
    public int[] resultsArray(int[] nums, int k) {

        if (k == 1)
            return nums;

        ArrayList<Integer> temp = new ArrayList<>();
        int n = nums.length;
        int i = 0, j = i + 1;
        int maxi = -1;

        while (j < n) {

            if ((j - i) + 1 == k) {

                if (nums[j] - nums[j - 1] == 1) {
                    maxi = Math.max(nums[j], nums[j - 1]);
                    temp.add(maxi);

                    maxi = -1;
                } else {
                    maxi = -1;
                    temp.add(maxi);

                }

                i++;
                j = i + 1;

            } else if (nums[j] - nums[j - 1] == 1) {
                maxi = Math.max(nums[j], nums[j - 1]);
                j++;
            } else {
                maxi = -1;
                temp.add(maxi);
                i++;
                j = i + 1;
            }

        }

        int[] results = new int[n - k + 1];
        for (int l = 0; l < n - k + 1; l++) {
            results[l] = temp.get(l);
        }

        return results;

    }
}