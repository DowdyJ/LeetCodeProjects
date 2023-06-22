# @param {Character[][]} board
# @return {Integer}
def num_rook_captures(board)
    rookRowIndex = -1
    rookColIndex = -1

    board.each_with_index { |row, rowIndex|
        row.each_with_index { |entry, colIndex|
            if entry == 'R'
                rookColIndex = colIndex
                rookRowIndex = rowIndex
                break
            end
        }

        if rookRowIndex != -1
            break
        end
    }


    takeablePawns = 0

    (rookColIndex-1).downto(0).each { |colIndex|
        if board[rookRowIndex][colIndex] != '.'
            if board[rookRowIndex][colIndex] != 'B'
                takeablePawns += 1
            end
            break
        end
    }

    (rookColIndex+1).upto(7).each { |colIndex|
        if board[rookRowIndex][colIndex] != '.'
            if board[rookRowIndex][colIndex] != 'B'
                takeablePawns += 1
            end
            break
        end
    }

    (rookRowIndex-1).downto(0).each { |rowIndex|
        if board[rowIndex][rookColIndex] != '.'
            if board[rowIndex][rookColIndex] != 'B'
                takeablePawns += 1
            end
            break
        end
    }


    (rookRowIndex+1).upto(7).each { |rowIndex|
        if board[rowIndex][rookColIndex] != '.'
            if board[rowIndex][rookColIndex] != 'B'
                takeablePawns += 1
            end
            break
        end
    }

    takeablePawns
end


puts num_rook_captures([[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]])
