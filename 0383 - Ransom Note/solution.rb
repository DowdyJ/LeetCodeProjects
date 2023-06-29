# @param {String} ransom_note
# @param {String} magazine
# @return {Boolean}
def can_construct(ransom_note, magazine)
    note = ransom_note.split("").sort.reverse
    maga = magazine.split("").sort.reverse

    while note.length != 0 && maga.length != 0
        if note[0] == maga[0]
            note.pop
        end

        maga.pop
    end

    return note.length == 0
end

puts can_construct("egg", "hehehehegg")


def can_construct_alt(ransom_note, magazine)

    ransom_note.chars.uniq.each do |char|
        return false if ransom_note.count(char) > magazine.count(char)
    end

    true
end
