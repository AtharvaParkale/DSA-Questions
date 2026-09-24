class Solution {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) {
            return false;
        }

        int perimeter = 0;

        for (int num : nums) {
            perimeter += num;
        }

        if (perimeter % 4 != 0) {
            return false;
        }

        int side = perimeter / 4;

        // Sort in ascending order
        Arrays.sort(nums);

        // Largest elements first
        reverse(nums);

        // If the largest stick is bigger than the required side
        if (nums[0] > side) {
            return false;
        }

        int[] sides = new int[4];

        return helper(nums, 0, sides, side);
    }

    private boolean helper(int[] nums, int index, int[] sides, int side) {
        if (index == nums.length) {
            return sides[0] == side &&
                   sides[1] == side &&
                   sides[2] == side &&
                   sides[3] == side;
        }

        int current = nums[index];

        for (int i = 0; i < 4; i++) {

            // Don't put the stick if it exceeds the side
            if (sides[i] + current > side) {
                continue;
            }

            // Avoid trying identical sides
            if (i > 0 && sides[i] == sides[i - 1]) {
                continue;
            }

            sides[i] += current;

            if (helper(nums, index + 1, sides, side)) {
                return true;
            }

            sides[i] -= current;

            // If this stick didn't work on an empty side,
            // trying other empty sides will be identical.
            if (sides[i] == 0) {
                break;
            }
        }

        return false;
    }

    private void reverse(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}