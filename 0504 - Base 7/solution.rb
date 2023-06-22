# @param {Integer} num
# @return {String}
def convert_to_base7(num)
    sign = num > 0 ? 1 : -1
    num *= sign
    result = []
    while num >= 7
        result << num % 7
        num /= 7
    end

    result << num

    (result.reverse!.join.to_i * sign).to_s
end

puts convert_to_base7(351)