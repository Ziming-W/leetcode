from typing import *
class Solution:
    def deleteGreatestValue(self, grid: List[List[int]]) -> int:
        output = 0
        for i in range(0, len(grid[0])):
            store = []
            for row in grid:
                store.append(max(row))
                row.remove(max(row))
            output += max(store)
        return output 


solution = Solution()
print(solution.deleteGreatestValue([[10]]))