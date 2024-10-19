
class Solution:
    def combinationSum3(self, k: int, n: int) -> list[list[int]]:
        result = []
        self.backtrack([], result, k, n)
        return result

    
    def backtrack(self, currentCombo: list[int], result: list[list[int]], k: int, n: int) -> None:
        if(len(currentCombo)== k and sum(currentCombo) == n):
            result.append(currentCombo)
            return
        
        currentSum = sum(currentCombo)
        last = currentCombo[-1] + 1 if len(currentCombo) > 0 else 1
        for i in range(last, 10):
            if(currentSum + i) <= n:
                newCombo = [k for k in currentCombo]
                newCombo.append(i)
                self.backtrack(newCombo, result, k, n)
        


