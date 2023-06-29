# @param {Integer} n
# @return {Boolean}
def is_power_of_two(n)
    n.to_s(2).count('1') == 1 && n & 0x80000000 == 0
end

# @param {Integer} n
# @return {Boolean}
def is_power_of_two_alt(n)
    return false if n <= 0
    n & (n - 1) == 0
end
