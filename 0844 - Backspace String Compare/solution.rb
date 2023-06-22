# @param {String} s
# @param {String} t
# @return {Boolean}
def backspace_compare(s, t)

    res1Index = 0
    res2Index = 0
    
    (0..s.length-1).each { |index|
        if s[index] == '#'
            if res1Index > 0
                res1Index -= 1
            end
        else
            s[res1Index] = s[index]
            res1Index += 1
        end
    }

    (0..t.length-1).each { |index|
        if t[index] == '#'
            if res2Index > 0
                res2Index -= 1
            end
        else
            t[res2Index] = t[index]
            res2Index += 1
        end
    }


    return true if res1Index == 0 && res2Index == 0

    s[0..res1Index-1] == t[0..res2Index-1]
end


puts backspace_compare("y#fo##f", "y#f#o##f")