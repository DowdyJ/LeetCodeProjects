# @param {Integer} num
# @return {Integer}
def number_of_steps(num)
    count = 0   
    until num == 0
        if num & 0x1 == 1
            num -= 1
        else
            num /=2
        end

        count += 1
    end

    count
end
