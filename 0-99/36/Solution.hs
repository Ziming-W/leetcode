import Data.Set(fromList)
import Data.Char
import Data.List

-- test case 1
testBoard1 :: [[Char]]
testBoard1 =
    [['5','3','.','.','7','.','.','.','.']
    ,['6','.','.','1','9','5','.','.','.']
    ,['.','9','8','.','.','.','.','6','.']
    ,['8','.','.','.','6','.','.','.','3']
    ,['4','.','.','8','.','3','.','.','1']
    ,['7','.','.','.','2','.','.','.','6']
    ,['.','6','.','.','.','.','2','8','.']
    ,['.','.','.','4','1','9','.','.','5']
    ,['.','.','.','.','8','.','.','7','9']]

-- test case 2
testBoard2 :: [[Char]]
testBoard2 = 
    [['8','3','.','.','7','.','.','.','.']
    ,['6','.','.','1','9','5','.','.','.']
    ,['.','9','8','.','.','.','.','6','.']
    ,['8','.','.','.','6','.','.','.','3']
    ,['4','.','.','8','.','3','.','.','1']
    ,['7','.','.','.','2','.','.','.','6']
    ,['.','6','.','.','.','.','2','8','.']
    ,['.','.','.','4','1','9','.','.','5']
    ,['.','.','.','.','8','.','.','7','9']]

-- a sudoku is valid, if all rows, all columns, and all grids are valid
isValidSudoku :: [[Char]] -> Bool 
isValidSudoku board
    = validRows && validColumns && validGrids
        where
            validRows = all verifyRow board
            validColumns = all verifyRow (transpose board)
            gridCoords = generateGridCoords
            gridsSymbols = map (\z->(map (\k->board!!(fst k)!!(snd k)) z)) gridCoords
            validGrids = all verifyRow gridsSymbols
    

-- generate the all point indices for each grid
generateGridCoords :: [[(Int, Int)]]
generateGridCoords
    = map (\z->[((fst z) + i, (snd z) + j)|i<-[0..2], j<-[0..2]]) topLefts
        where topLefts = [(m, n) | m<-[0, 3, 6], n<-[0, 3, 6]]

-- verfify a list, all symbols valid, and there must be no dup
verifyRow :: [Char] -> Bool
verifyRow row
    = allValidSymbol && noDup
        where
            allValidSymbol = all validSymbol row
            noDup = (length noDotList) == (length $ fromList noDotList)
            noDotList = filter (/='.') row

-- a valid symbol is either a digit, or a dot
validSymbol :: Char -> Bool
validSymbol a = (isDigit a) || (a == '.')

