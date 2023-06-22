# @param {Integer[]} salary
# @return {Float}
def average(salary)
    salary.sort!
    salary.shift
    salary.pop
    salary.sum.to_f / salary.length
end

puts average([4000,3000,1000,2000])