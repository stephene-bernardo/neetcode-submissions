class Solution {
  public boolean isValidSudoku(char[][] board) {
        Set<Character> integerSequence = new HashSet<>();
        for(int i=0; i<board.length; i++){
            for (int j=0;j<board[i].length; j++){
                if(integerSequence.contains(board[i][j])){
                    return false;
                } else if(board[i][j] != '.'){
                    integerSequence.add(board[i][j]);
                }
            }
            integerSequence = new HashSet<>();
        }

        for(int l=0; l<board[0].length; l++){
            for(int k=0;k<board.length;k++){
                if(integerSequence.contains(board[k][l])){
                    return false;
                } else if(board[k][l] != '.'){
                    integerSequence.add(board[k][l]);
                }
            }
            integerSequence = new HashSet<>();
        }

        Map<Integer, Set<Character>> rangeToSquare = new HashMap<>();
        for(int i=0; i<board.length; i++){
            for (int j=0;j<board[i].length; j++){
                int range = rangeToInteger(i, j);
                Set<Character> squareList = new HashSet<>();
                if(rangeToSquare.containsKey(range)){
                    squareList = rangeToSquare.get(range);
                } else {
                    rangeToSquare.put(range, squareList);

                }
                if(squareList.contains(board[i][j])){
                    return false;
                } else if(board[i][j] != '.'){
                    squareList.add(board[i][j]);
                }
            }
        }

        return true;
    }

    int rangeToInteger(int row, int column){
        if(row <= 2 && column <= 2){
            return 0;
        } else if(row <= 2 && column <= 5){
            return 1;
        } else if(row <= 2 && column <= 8){
            return 2;
        } else if(row <= 5 && column <= 2){
            return 3;
        } else if(row <= 5 && column <= 5){
            return 4;
        } else if(row <= 5 && column <= 8){
            return 5;
        } else if(row <=8 && column <= 2){
            return 6;
        } else if(row <=8 && column <= 5){
            return 7;
        }
        return 8;
    }
}
