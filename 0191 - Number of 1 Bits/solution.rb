# @param {Integer} n, a positive integer
# @return {Integer}
def hamming_weight(n)
    total = 0
    32.times { |x|
        total += (n >> x & 1)
    }

    total
end



puts hamming_weight("11111111111111111111111111111101")