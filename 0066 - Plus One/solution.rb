#@param {Integer[]} digits
#@return {Integer[]}
def plus_one(digits)

    digits.reverse_each.with_index do |x, index|
      if x != 9 then
        digits[digits.length - 1 - index] = x + 1
        return digits
      else
        digits[digits.length - 1 - index] = 0
      end
    end    

    digits.unshift(1)
    digits
end



def plus_one_old(digits)
    digits.reverse!

    digits.each_with_index do |x, index|
      if x != 9 then
        digits[index] = x + 1
        return digits.reverse!
      else
        digits[index] = 0
      end

    end    
    digits.append(1)
    digits.reverse!
end