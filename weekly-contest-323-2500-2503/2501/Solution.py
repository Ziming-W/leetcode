from typing import *
from itertools import combinations

#Time limited exceed
# class Solution:
#     def valid(self, test):
#         test = list(test)
#         test.sort()
#         for i in range(0, len(test)-1):
#             if(test[i]*test[i] != test[i+1]):
#                 return False
#         return True

#     def longestSquareStreak(self, nums: List[int]) -> int:
#         if(len(nums) < 2):
#             return -1
#         maxLen = 0
#         for i in range(2, len(nums)+1):
#             testList = list(combinations(nums, i))
#             print(testList)
#             for test in testList:
#                 if(self.valid(test)):
#                     if(len(test) > maxLen):
#                         maxLen = len(test)
#         if(maxLen == 0):
#             return -1
#         return maxLen

# solution = Solution()
# print(solution.longestSquareStreak([2,4]))

    

