from typing import List

mapping = {
            "2": "abc", 
            "3": "def",
            "4": "ghi",
            "5": "jkl", 
            "6": "mno", 
            "7": "pqrs", 
            "8": "tuv", 
            "9": "wxyz"
        }

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if digits == "":
            return []
        resultStore = []
        self.backtrack(digits, "", resultStore)
        return resultStore
        
        
    def backtrack(self, digits: str, currentCombo: str, resultStore: list[str]) -> None:
        if(len(currentCombo) == len(digits)):
            resultStore.append(currentCombo)
            return
        
        # else, keep backtracking
        candidate = digits[len(currentCombo)]
        for element in mapping.get(candidate):
            self.backtrack(digits, currentCombo + element, resultStore)