class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;

        for (int num : nums) {
            if (num == 1) return false;
        }

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] parent = new int[n];
        int[] size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int[] primeOwner = new int[max + 1];
        java.util.Arrays.fill(primeOwner, -1);

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            for (int p = 2; p * p <= x; p++) {
                if (x % p == 0) {
                    unionPrime(i, p, primeOwner, parent, size);

                    while (x % p == 0) {
                        x /= p;
                    }
                }
            }

            if (x > 1) {
                unionPrime(i, x, primeOwner, parent, size);
            }
        }

        int root = find(0, parent);

        for (int i = 1; i < n; i++) {
            if (find(i, parent) != root) {
                return false;
            }
        }

        return true;
    }

    private void unionPrime(int i, int prime, int[] primeOwner,
                            int[] parent, int[] size) {
        if (primeOwner[prime] == -1) {
            primeOwner[prime] = i;
        } else {
            union(i, primeOwner[prime], parent, size);
        }
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    private void union(int a, int b, int[] parent, int[] size) {
        int rootA = find(a, parent);
        int rootB = find(b, parent);

        if (rootA == rootB) return;

        if (size[rootA] < size[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }

        parent[rootB] = rootA;
        size[rootA] += size[rootB];
    }
}