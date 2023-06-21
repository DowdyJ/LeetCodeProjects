# @param {Integer[]} flowerbed
# @param {Integer} n
# @return {Boolean}
def can_place_flowers(flowerbed, n)
    return true if n == 0

    count = 0

    flowerbed.each_with_index { |entry, index|

        previousEntry = index > 0 ? flowerbed[index - 1] : 0
        nextEntry = index + 1 < flowerbed.length ? flowerbed[index + 1] : 0

        if previousEntry == 0 and entry == 0 and nextEntry == 0
            flowerbed[index] = 1
            count += 1

            return true if count >= n
        end
    }

    return false
end


puts can_place_flowers([1,0,0,0,1], 1).to_s