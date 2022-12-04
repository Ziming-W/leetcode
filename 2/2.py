# 77% 43%
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def extract(self, node:ListNode):
        acc = 0
        mul = 1
        while node != None:
            acc += (node.val)*mul
            mul *= 10
            node = node.next
        return acc

    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        acc1 = self.extract(l1)
        acc2 = self.extract(l2)
        sum = acc1 + acc2
        s = str(sum)[::-1]
        returnNode = ListNode()
        currNode = returnNode
        for i in range(0, len(s)):
            if(i==0):
                currNode.val = s[i]
            else:
                newNode = ListNode(s[i])
                currNode.next = newNode
                currNode = newNode
        return returnNode





