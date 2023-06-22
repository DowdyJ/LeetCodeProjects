# @param {Integer} n
# @return {Integer}
def arrange_coins(n)
    (Math.sqrt(2*n + 0.25) - 0.5).floor
end