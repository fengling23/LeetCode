class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int head = 0, tail = nums.size() - 1, mid;
        if (nums[head] == target) return true;
        while (head < tail && nums[head] == nums[0]) head += 1;
        while (head < tail && nums[tail] == nums[0]) tail -= 1;
        while (head <= tail) {
            mid = (head + tail) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] <= nums[tail]) {
                if (target <= nums[tail] && nums[mid] < target) head = mid + 1;
                else tail = mid - 1;
            } else {
                if (nums[head] <= target && target < nums[mid]) tail = mid - 1;
                else head = mid + 1;
            }
        }
        return false;
    }
};