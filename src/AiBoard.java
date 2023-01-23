public class AiBoard {
    //variables
    public int[] AiBoard;
    public int[] copyAiBoard;
    public int xMove;
    public int yMove;
    public int[] coll;


    public AiBoard(int[] ints) {
        this.AiBoard = ints;
    }

    public int[] getAiBoard(){
        return new int[]{AiBoard[0], AiBoard[1], AiBoard[2], AiBoard[3], AiBoard[4], AiBoard[5], AiBoard[6], AiBoard[7], AiBoard[8], AiBoard[9]};
    }
    public boolean equals(AiBoard board2){
        System.out.println("Comparing:");
        this.printBoard();
        System.out.println("And:");
        board2.printBoard();
        int[] BoardArray1 = AiBoard;
        int[] BoardArray2 = board2.getAiBoard();
            if (BoardArray1[0] == BoardArray2[0] && BoardArray1[1] == BoardArray2[1] && BoardArray1[2] == BoardArray2[2] && BoardArray1[3] == BoardArray2[3] && BoardArray1[4] == BoardArray2[4] && BoardArray1[5] == BoardArray2[5] && BoardArray1[6] == BoardArray2[6] && BoardArray1[7] == BoardArray2[7] && BoardArray1[8] == BoardArray2[8] && BoardArray1[9] == BoardArray2[9]){
                System.out.println("same");
                return true;
            }
            else {
                return false;
            }
    }


//    public void Boardd(int[] board){
//        this.boardd = boardd;
//    }
//
    public void changeAiBoard( int col, int row){
        AiBoard[col] = row;
    }

    public int[] copyBoard(){
        int copyAiBoard[] = new int[10];
        for(int i = 0; i<10; i++) {
            copyAiBoard[i] = AiBoard[i];
        }
        return copyAiBoard;
    }

    public boolean boardEquals(AiBoard losersBoard){
        for(int i = 0; i<10; i++){
            if (AiBoard[i] != losersBoard.getAiBoard()[i]){
                return false;
            }
        }
        return true;
    }
    public void printBoardWithMove(){
        System.out.print("The board is [");
        for (int i: AiBoard){// this says go one at a time of ai boards and put it into i pull out 1 at a time
            System.out.print(i+" ");
        }
        System.out.print("]");
        System.out.print("(");
        System.out.print(xMove + "," + yMove);
        System.out.print(")");
        System.out.println();
    }
    public void printBoard(){
        System.out.print("The board is [");
        for (int i: AiBoard){// this says go one at a time of ai boards and put it into i pull out 1 at a time
            System.out.print(i+" ");
        }
        System.out.print("]");
        System.out.println();
    }
}
