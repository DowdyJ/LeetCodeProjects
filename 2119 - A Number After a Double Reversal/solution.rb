# @param {Integer} num
# @return {Boolean}
def is_same_after_reversals(num)
    num.to_s.reverse.to_i.to_s.reverse.to_i == num
end