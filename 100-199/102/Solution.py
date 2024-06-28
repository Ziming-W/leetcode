# Definition for a binary tree node.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

from typing import Optional, List

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        queue = [root]
        output = []
        level_max = 1
        level_output = []
        level_counter = 0
        if(not root):
            return []
        while len(queue) > 0:
            pop = queue.pop(0)
            if level_counter < level_max:
                level_counter += 1
                if pop:
                    if len(level_output) == 1:
                        level_output.append(pop.val)
                        output.append([x for x in level_output])
                        level_output = []
                    else:
                        level_output.append(pop.val)
            else:
                level_max *= 2
                level_counter = 1
                if level_output:
                    output.append([x for x in level_output])
                if pop:
                    level_output = [pop.val]
                else:
                    level_output = []
            if(pop):
                queue.append(pop.left)
                queue.append(pop.right)
        # final clean up
        if level_output:
            output.append(level_output)
        return output


        