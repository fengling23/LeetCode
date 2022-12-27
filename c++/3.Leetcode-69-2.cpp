class Solution {
public:
    int mySqrt(int x) {
        long long head = 0, tail = ((long long)(x)) + 1, mid;
        while (head < tail) {
            mid = (head + tail) / 2;
            if (mid * mid > x) tail = mid;
            else head = mid + 1;
        }
        return head - 1;
    }
};