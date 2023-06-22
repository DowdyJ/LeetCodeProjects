# @param {Integer[]} num
# @param {Integer} k
# @return {Integer[]}

def add_to_array_form(num, k)
    (num.join.to_i + k).to_s.split("").map { |val| val.to_i }
end


def add_to_array_form2(num, k)
    a = num.join
    b = k.to_s

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

        if sum > 9
            carryOver = 1
            sum -= 10
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

    resultString.reverse!.split("").map { |val| val.to_i }
end