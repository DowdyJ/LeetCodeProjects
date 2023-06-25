require 'set'

class ListNode
    attr_accessor :val, :next

    def initialize(val)
        @val = val
        @next = nil
    end
end

# @param {ListNode} head
# @return {Boolean}
def hasCycle(head)
    return false if head == nil

    curNode = head
    while (curNode.next != nil) 
        return true if curNode.val == 9999999
        curNode.val = 9999999
        curNode = curNode.next
    end

    false
end

# @param {ListNode} head
# @return {Boolean}
def hasCycleAlt(head)
    return false if head == nil
    
    curNode = head
    fastNode = head

    loop do
        curNode = curNode&.next
        fastNode = fastNode&.next&.next
        break if fastNode.nil?
        return true if curNode.equal? fastNode
    end

    false
end

n5 =ListNode.new(5)
n4 = ListNode.new(4)
n3 = ListNode.new(3)
n2 = ListNode.new(2)
n1 = ListNode.new(1)

n1.next = n2
n2.next = n3
n3.next = n4
n4.next = n5
n5.next = n2

puts hasCycle(n1)