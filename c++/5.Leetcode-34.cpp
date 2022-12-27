class Solution {
public:
    int binary_search_find_first_one(vector<int>& nums, int target) {
        int head = 0, tail = nums.size(), mid;
        while (head < tail) {
            mid = (head + tail) / 2;
            if (nums[mid] < target) head = mid + 1;
            else tail = mid;
        }
        return head;
    }
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> ret(2);
        ret[0] = binary_search_find_first_one(nums, target);
        if (ret[0] == nums.size() || nums[ret[0]] != target) {
            ret[0] = ret[1] = -1;
            return ret;
        }
        ret[1] = binary_search_find_first_one(nums, target + 1) - 1;
        return ret;
    }
};