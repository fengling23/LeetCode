class Solution {
public:
    int binary_search(vector<int> &nums, int x) {
        int head = 0, tail = nums.size() - 1, mid;
        while (head <= tail) {
            mid = (head + tail) / 2;
            if (nums[mid] == x) return mid;
            if (x < nums[mid]) tail = mid - 1;
            else head = mid + 1;
        }
        return -1;
    }
    int minOperations(vector<int>& nums, int x) {
        int n = nums.size();
        vector<int> lsum(n + 1), rsum(n + 1);
        lsum[0] = 0;
        for (int i = 1; i <= n; i++) lsum[i] = lsum[i - 1] + nums[i - 1];
        rsum[0] = 0;
        for (int i = 1; i <= n; i++) rsum[i] = rsum[i - 1] + nums[n - i];
        int ans = INT_MAX;
        for (int i = 0; i < lsum.size(); i++) {
            int lval = lsum[i], rval = x - lval;
            int j = binary_search(rsum, rval);
            if (j == -1) continue;
            if (i + j > n) continue;
            ans = min(ans, i + j);
        }
        return ans == INT_MAX ? -1 : ans;
    }
};