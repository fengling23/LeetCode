class Solution {
public:
    int binary_search(vector<int> &ind, vector<int> &nums, int l, int x) {
        int head = l, tail = ind.size() - 1, mid;
        while (head <= tail) {
            mid = (head + tail) / 2;
            if (nums[ind[mid]] == x) return ind[mid];
            if (x < nums[ind[mid]]) tail = mid - 1;
            else head = mid + 1;
        }
        return -1;
    }
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> ind(nums.size());
        for (int i = 0; i < nums.size(); i++) ind[i] = i;
        sort(ind.begin(), ind.end(), [&](int i, int j) -> bool { return nums[i] < nums[j]; });
        vector<int> ret(2);
        for (int i = 0; i < ind.size() - 1; i++) {
            int x = nums[ind[i]];
            int y = target - x;
            ret[0] = ind[i];
            ret[1] = binary_search(ind, nums, i + 1, y);
            if (ret[1] != -1) break;
        }
        if (ret[0] > ret[1]) swap(ret[0], ret[1]);
        return ret;
    }
};