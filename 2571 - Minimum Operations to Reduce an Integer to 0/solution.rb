# @param {Integer} n
# @return {Integer}
def min_operations(n)
    op_count = 0
    while n != 0
        n += (n > 0 ? -1 : 1) * 2 ** Math.log(n.abs, 2).round
        op_count += 1
    end

    op_count
end

min_operations 1139863