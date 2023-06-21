# @param {Integer[]} bits
# @return {Boolean}
def is_one_bit_character(bits)
    while bits.length > 1
        if bits[0] == 1
            bits.shift
        end

        bits.shift
    end

    bits.length != 0
end

puts is_one_bit_character([1,0,0])