# @param {String} s
# @return {String}
def reverse_vowels(s)
    vowels = []
    positions = []

    s.length.times { |index|
        if s[index].downcase == 'a' || s[index].downcase == 'e' || s[index].downcase == 'i' || s[index].downcase == 'o' || s[index].downcase == 'u'
            vowels << s[index]
            positions << index
        end
    }

    vowels.reverse!
    positions.each_with_index { |pos, index| 
        s[pos] = vowels[index]
    }

    s
end
