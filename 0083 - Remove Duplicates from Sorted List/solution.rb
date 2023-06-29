# Definition for singly-linked list.
class ListNode
    attr_accessor :val, :next
    def initialize(val = 0, _next = nil)
        @val = val
        @next = _next
    end
end

# @param {ListNode} head
# @return {ListNode}
def delete_duplicates(head)
    return nil if head.nil?

    headCache = head
    lastUniqueNode = head
    curNode = head.next
    lastUniqueNode.next = nil

    until curNode.nil?
        if lastUniqueNode.val != curNode.val
            lastUniqueNode.next = curNode
            lastUniqueNode = curNode
            curNode = curNode.next
            lastUniqueNode.next = nil
        else
            curNode = curNode.next
        end
    end
    
    head
end