class Solution {
    int MOD = 1000000007;
    long[] fact, invFact;
    
    public int countGoodArrays(int n, int m, int k) {
        precomputeFactorials(n);
        
        int b = n-k;
        long c = nCr(n - 1, b - 1);
        long ans = modExp(m - 1, b - 1, MOD);
        ans = (ans * m) % MOD;
        ans = (ans * c) % MOD;
        
        return (int) ans;
    }
    
    void precomputeFactorials(int n) {
        fact = new long[n + 1];
        invFact = new long[n + 1];
        
        fact[0] = 1;
        for (int i = 1; i <= n; i++) fact[i] = (fact[i - 1] * i) % MOD;
        
        invFact[n] = modExp(fact[n], MOD - 2, MOD);
        for (int i = n - 1; i >= 0; i--) invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
    }
    
    long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return ((fact[n] * invFact[r]) % MOD * invFact[n - r]) % MOD;
    }
    
    long modExp(long x, long y, int m) {
        long res = 1;
        x %= m;
        while (y > 0) {
            if ((y & 1) == 1) res = (res * x) % m;
            x = (x * x) % m;
            y >>= 1;
        }
        return res;
    }
}