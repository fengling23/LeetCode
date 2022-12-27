class Solution {
public:
    struct FUNCTIONS {
        FUNCTIONS(long long a, long long b, long long c) 
        : a(a), b(b), c(c),
          ab(lcm(a, b)), ac(lcm(a, c)),
          bc(lcm(b, c)), abc(lcm(a, lcm(b, c))) {}
        long long a, b, c, ab, ac, bc, abc;
        long long gcd(long long a, long long b) {
            if (!b) return a;
            return gcd(b, a % b);
        }
        long long lcm(long long a, long long b) {
            return a * b / gcd(a, b);
        }
        long long operator()(long long x) {
            return x / a + x / b + x / c - x / ab - x / bc - x / ac + x / abc;
        }
    };
    int nthUglyNumber(int n, int a, int b, int c) {
        FUNCTIONS g(a, b, c);
        long long head = 0, tail = n * min(a, min(b, c)), mid;
        while (head < tail) {
            mid = (head + tail) / 2;
            if (g(mid) < n) head = mid + 1;
            else tail = mid;
        }
        return head;
    }
};