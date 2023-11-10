def min_impossible_or(nums)
    bitcombo = 0
    nums.each.with_index do |x, index|
        bitcombo |= x if Math.log(x, 2).round(10) == Math.log(x, 2).round
    end

    count = 0

    while bitcombo & 1 == 1
        bitcombo >>= 1
        count += 1
    end

    2 ** count
end