# @param {Integer} n, a positive integer
# @return {Integer}
def reverse_bits(n)
    lastBit = n & 0x80000000
    if lastBit != 0
        n.to_s(2).reverse.to_i(2)
    else
        n |= 0x80000000
        n = n.to_s(2).reverse.to_i(2)
        n &= 0xFFFFFFFE
    end
end
