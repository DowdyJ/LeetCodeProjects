# @param {Integer[]} g
# @param {Integer[]} s
# @return {Integer}
def find_content_children(g, s)
    g.sort!
    s.sort!
    
    happyChildren = 0


    while s.length > 0 && g.length > 0
        if s[0] >= g[0]
            s.shift
            g.shift
            happyChildren += 1
        else
            s.shift
        end
    end

    return happyChildren
end

puts find_content_children([1,2,3], [1,1])