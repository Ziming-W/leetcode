# Definition for a binary tree node.
from typing import Optional, List
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        store = []
        self.solve(root, 0, store)
        return store

    def solve(self, root: Optional[TreeNode], level: int, store: List[List[int]]) -> None:
        if(root is None):
            return
        # if store missing sub-store, add them
        if(len(store) < level + 1):
            for i in range(level + 1 - len(store)):
                store.append([])
        store[level].append(root.val)
        self.solve(root.left, level + 1, store)
        self.solve(root.right, level + 1, store)



        
        