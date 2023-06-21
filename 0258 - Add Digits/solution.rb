# @param {Integer} num
# @return {Integer}
def add_digits(num)
    return num if num <= 9
    
    result = 0
    numAsStr = num.to_s
    (0..numAsStr.length).each { |index|
        result += numAsStr[index].to_i
    }

    if result > 9
        result = add_digits(result)
    end

    return result
end

puts add_digits 38