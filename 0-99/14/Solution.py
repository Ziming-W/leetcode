class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        minLen = 201
        counter = 0
        for str in strs:
            if(len(str) < minLen):
                minLen = len(str)
        for i in range(minLen):
            flag = True
            for j in range(1, len(strs)):
                if(strs[j][i] != strs[j-1][i]):
                    flag = False
            if(not flag):
                break
            counter += 1
        return strs[0][:counter]
            