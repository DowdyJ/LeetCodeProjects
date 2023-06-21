# @param {String} num1
# @param {String} num2
# @return {String}
def add_strings(num1, num2)

    if num1.length < num2.length
        temp = num1
        num1 = num2
        num2 = temp
    end

    index = 0
    num2.reverse!
    num1.reverse!

    carryOver = 0
    while index < num1.length
        val1 =  num1[index].to_i
        val2 =  index < num2.length ? num2[index].to_i : 0

        digitSum = val1 + val2 + carryOver
        num1[index] = digitSum.to_s.reverse[0]

        if digitSum >= 10
            carryOver = 1
        else
            carryOver = 0
        end

        index += 1
    end

    num1.reverse!

    if carryOver == 1
        num1 = "1"+ num1
    end

    num1
end


puts add_strings("1", "9")