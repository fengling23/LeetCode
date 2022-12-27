class Solution {
public:
    int binary_search(vector<int> &nums, int x) {
        int head = 0, tail = nums.size() - 1, mid;
        while (head < tail) {
            mid = (head + tail) / 2;
            if (nums[mid] >= x) tail = mid;
            else head = mid + 1;
        }
        return head;
    }
    int findRadius(vector<int>& houses, vector<int>& heaters) {
        sort(heaters.begin(), heaters.end());
        int ans = INT_MIN;
        for (auto x : houses) {
            int i = binary_search(heaters, x);
            int j = max(0, i - 1);
            ans = max(ans, min(abs(x - heaters[i]), abs(x - heaters[j])));
        }
        return ans;
    }
};