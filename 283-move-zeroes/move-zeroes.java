class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int z = 0, nz = 0;

        while (nz < n) {
            if (nums[nz] != 0) {
                if (z != nz) {
                    // XOR swap
                    nums[z] = nums[z] ^ nums[nz];
                    nums[nz] = nums[z] ^ nums[nz];
                    nums[z] = nums[z] ^ nums[nz];
                }
                z++;
            }
            nz++;
        }
    }
}
