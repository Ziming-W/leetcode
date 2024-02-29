from typing import *

class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [float('inf')]*n
        dp[0] = 0
        for i in range(0, n - 1):
            for j in range(1 + nums[i]):
                if(i + j < n):
                    dp[i + j] = min(dp[i+j], dp[i]+1)
        return dp[n-1]

        