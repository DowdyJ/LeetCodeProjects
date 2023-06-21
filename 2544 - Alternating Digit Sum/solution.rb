# @param {Integer} n
# @return {Integer}
def alternate_digit_sum(n)
    sum = 0
    nString = n.to_s
    
    (0..nString.length).each { |index|
        if index % 2 == 0
            sum += nString[index].to_i
        else
            sum -= nString[index].to_i
        end
    }

    return sum
end

puts alternate_digit_sum 1999