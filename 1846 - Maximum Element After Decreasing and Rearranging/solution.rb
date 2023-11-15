# @param {Integer[]} arr
# @return {Integer}
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
