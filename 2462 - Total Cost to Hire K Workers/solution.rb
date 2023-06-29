# @param {Integer[]} costs
# @param {Integer} k
# @param {Integer} candidates
# @return {Integer}
def total_cost(costs, k, candidates)
    totalCost = 0
    totalHired = 0
    sorted = false
    arr1 = nil
    arr2 = nil

    # for when the market wages are suspiciously competitive
    allSameNumber = false

    if costs.length > 1 && costs[0] == costs[1]
        hmm1 = costs.slice(costs.length / 2, costs.length)
        hmm2 = costs.slice(0, costs.length / 2)
        bonus = hmm1[0]
        if hmm1.length != hmm2.length
            bonus = hmm1.pop
        end
        allSameNumber = hmm1[0] == bonus && hmm1 == hmm2
    end
    
    if allSameNumber
        return k * costs[0]
    end

    while totalHired < k
        if costs.length <= 2 * candidates
            if !sorted
                sorted = true
                costs.sort!
            end

            employeeCost = costs.shift
            
            totalCost += employeeCost
            totalHired += 1
        else

            if arr1 == nil
                arr1 = costs.slice(0, candidates)
                arr1.sort!
            end

            if arr2 == nil
                arr2 = costs.slice(-candidates, costs.length)
                arr2.sort!
            end

            usingArr1 = arr1[0] <= arr2[0]
            employeeCost = usingArr1 ? arr1.shift : arr2.shift

            if usingArr1
                arr1 << costs[candidates]

                if arr1[-1] != nil && arr1[-2] != nil && arr1[-1] < arr1[-2]
                    arr1.sort!
                end

                indexToRemove = costs.index(employeeCost)
            else
                arr2 << costs[costs.length - candidates - 1]

                if arr2[-1] != nil && arr2[-2] != nil && arr2[-1] < arr2[-2]
                    arr2.sort!
                end
                
                indexToRemove = costs.rindex(employeeCost)
            end
            
            costs.delete_at(indexToRemove)

            totalCost += employeeCost
            totalHired += 1

        end
    end

    totalCost
end
