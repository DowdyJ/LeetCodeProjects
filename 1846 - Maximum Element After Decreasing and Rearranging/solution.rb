# @param {Integer[]} arr
# @return {Integer}
def maximum_element_after_decrementing_and_rearranging_short(arr)
    arr.sort!.reverse!
    (0..(arr.length - 2)).each{ |i| arr[i] = arr[i+1] + 1 if arr[i] > arr[i+1] }
    [arr.max, arr.length].min
end

def maximum_element_after_decrementing_and_rearranging_comical_oneliner(arr)
    [arr.sort!.reverse!.each_with_index{ |_, i| arr[i] = arr[i+1] + 1 if arr[i+1] != nil && arr[i] > arr[i+1] }].map{|res| [res.max, res.length].min}[0]
end

def maximum_element_after_decrementing_and_rearranging(arr)
    potential_res = [arr.max, arr.length].min
    arr.sort!.reverse!
    
    i = 0
    limit = arr.length
    while i < limit
        if arr[i] < potential_res - i
            arr[0] = arr[1] + 1
            potential_res = [arr.max, arr.length].min
            i = 0
            limit -= 1
        else
            i += 1
        end
    end

    potential_res
end
