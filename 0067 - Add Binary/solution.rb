# @param {String} a
# @param {String} b
# @return {String}
def add_binary(a, b)

    if a.length < b.length
        temp = a
        a = b
        b = temp
    end

    a.reverse!
    b.reverse!

    result = []
    carryOver = 0
    index = 0
    while index < a.length
        sum = 0
        if index < b.length
            sum += b[index].to_i 
        end

        sum += a[index].to_i + carryOver

        if sum > 1
            carryOver = 1
            sum -= 2
        else
            carryOver = 0
        end

        result << sum

        index += 1
    end

    resultString = result.join

    if carryOver > 0
        resultString = resultString + "1"
    end

    resultString.reverse!
end

puts add_binary("11", "1")