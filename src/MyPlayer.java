import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    ArrayList<AiBoard> losersBoard = new ArrayList<AiBoard>();
    ArrayList<AiBoard> winnersBoard = new ArrayList<AiBoard>();
    ArrayList<AiBoard> allBoards = new ArrayList<AiBoard>();
    public  AiBoard newBoard;
    public int[] pBoardT;
    public int xMove;
    public int yMove;
    public int[] converterBoard;
    public AiBoard convertedPboard = new AiBoard(new int[10]);



    public MyPlayer() {
//        //first row is the last number
        losersBoard.add(new AiBoard(new int[]{1,0,0,0,0,0,0,0,0,0}));
        columns = new int[10];
        //Creating all possible Boards
        for (int a = 1; a <= 10; a++) {
            for (int b = 0; b <= a; b++) {
                for (int c = 0; c <= b; c++) {
                    for (int d = 0; d <= c; d++) {
                        for (int e = 0; e <= d; e++) {
                            for (int f = 0; f <= e; f++) {
                                for (int g = 0; g <= f; g++) {
                                    for (int h = 0; h <= g; h++) {
                                        for (int i = 0; i <= h; i++) {
                                            for (int j = 0; j <= i; j++) {
                                                newBoard = new AiBoard(new int[]{a, b, c, d, e, f, g, h, i, j});
//                                                System.out.println("------------------Original board is directly below---------------");
//                                                newBoard.printBoard();
                                                allBoards.add(newBoard);
                                                getLoserBoards(newBoard);// makes the board in terms of newBoard passes the value to getLosersBoards



                                                //for every column we need to loop through and cut it
                                                //all possible one move boards
//                                                for (int column=0; column<9; column++){
//                                                    AiBoard baseBoardToCut = new AiBoard(new int[]{a, b, c, d, e, f, g, h, i, j});
//                                                    //System.out.println("Staring Cut On Column:" + column);
//                                                    for (int r = baseBoardToCut.AiBoard[column]; r > 0; r--){//row
//                                                        //System.out.println("cutting on row at height:" + r);
//                                                        for (int col = column; col < 9; col++){
//                                                            if(baseBoardToCut.AiBoard[col] >= r){
//                                                                baseBoardToCut.AiBoard[col] = r-1;
//                                                            }
//                                                        }
//                                                        //System.out.println("fresh cut board:");
//                                                        //baseBoardToCut.printBoard();
//
//                                                        for(int loserlength = 0; loserlength< losersBoard.size(); loserlength++){
//                                                            //System.out.println("cohones-------------------------------------------------------------------");
//
//                                                            if (baseBoardToCut.AiBoard[0] == losersBoard.get(loserlength).AiBoard[0] && baseBoardToCut.AiBoard[1] == losersBoard.get(loserlength).AiBoard[1] && baseBoardToCut.AiBoard[2] == losersBoard.get(loserlength).AiBoard[2] && baseBoardToCut.AiBoard[3] == losersBoard.get(loserlength).AiBoard[3] && baseBoardToCut.AiBoard[4] == losersBoard.get(loserlength).AiBoard[4] && baseBoardToCut.AiBoard[5] == losersBoard.get(loserlength).AiBoard[5] && baseBoardToCut.AiBoard[6] == losersBoard.get(loserlength).AiBoard[6] && baseBoardToCut.AiBoard[7] == losersBoard.get(loserlength).AiBoard[7] && baseBoardToCut.AiBoard[8] == losersBoard.get(loserlength).AiBoard[8] && baseBoardToCut.AiBoard[9] == losersBoard.get(loserlength).AiBoard[9]){
//                                                                losersBoard.add(new AiBoard(newBoard.getAiBoard()));
//                                                                break;
//                                                            }
//
//                                                        }
//
//                                                    }
//                                                    //System.out.println();
//                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
//        System.out.println("++++++++++++++++++++++"+ losersBoard.size());

//        for (int x = 0; x<losersBoard.size();x++){
//            losersBoard.get(x).printBoard();
//        }
////        System.out.println("-------------------------Winners -------");
//        for (int x = 0; x<winnersBoard.size();x++){
//            winnersBoard.get(x).printBoardWithMove();
//        }
////        to check first thirteen boards
////        for(int a = 0; a <= 13; a++) {
////            allBoards.get(a).printBoard();
////        }
//        // to check all losing boards
//        for (AiBoard board : losersBoard) {
//            board.printBoard();
//        }
//
//
//
//
//        /***
//         * This code will run just once, when the game opens.
//         * Add your code here.
//         */
    }


//    public int[] convertDA2SA(Chip[][] pBoard ){
//        int[] converterBoard;
//        for(int c = 0; c<10; c++) {
//            for (int r = 0; r < 10; r++) {
//                if (pBoard[c][r]) {
//
//                }
//            }
//        }
//    }
    public void getLoserBoards(AiBoard board){

        for (int column=0; column<10; column++){
//            System.out.println("*******************");
            AiBoard baseBoardToCut = new AiBoard(board.getAiBoard());// if you are trying to modify a getter it wont do anything coppy than it gets refreshed to next board
            //System.out.println("Staring Cut On Column:" + column);
            for (int r = baseBoardToCut.AiBoard[column]; r > 0; r--) {//row makes r = to number of chips in that column goes back and reduces everything again
                //System.out.println("cutting on row at height:" + r);
                for (int col = column; col < 10; col++) {// I must understand this better col ++ continues until everything is = to or less than to r
                    if (baseBoardToCut.AiBoard[col] >= r) {// r is value of whats in columb
                            baseBoardToCut.AiBoard[col] = r - 1;// than going to cut
                            if(column ==0 && r-1 == 0) {
                                baseBoardToCut.AiBoard[col] = 1;
                            }
                    }
                }
//                System.out.println("fresh cut board:");
//                baseBoardToCut.printBoard();

                for(int loserlength = 0; loserlength< losersBoard.size(); loserlength++){
//                    System.out.println("cohones-------------------------------------------------------------------");
// checks current reduced boards to all loser boards
                    if (baseBoardToCut.AiBoard[0] == losersBoard.get(loserlength).AiBoard[0] && baseBoardToCut.AiBoard[1] == losersBoard.get(loserlength).AiBoard[1] && baseBoardToCut.AiBoard[2] == losersBoard.get(loserlength).AiBoard[2] && baseBoardToCut.AiBoard[3] == losersBoard.get(loserlength).AiBoard[3] && baseBoardToCut.AiBoard[4] == losersBoard.get(loserlength).AiBoard[4] && baseBoardToCut.AiBoard[5] == losersBoard.get(loserlength).AiBoard[5] && baseBoardToCut.AiBoard[6] == losersBoard.get(loserlength).AiBoard[6] && baseBoardToCut.AiBoard[7] == losersBoard.get(loserlength).AiBoard[7] && baseBoardToCut.AiBoard[8] == losersBoard.get(loserlength).AiBoard[8] && baseBoardToCut.AiBoard[9] == losersBoard.get(loserlength).AiBoard[9]){
//                        System.out.print("BOOOOOOOOOOOOOOOOOOOOOOOOO");
//                        newBoard.printBoard();
                        AiBoard hold = new AiBoard(newBoard.getAiBoard());
                        hold.xMove = column;
                        hold.yMove = r-1;
                        winnersBoard.add(hold);// must specify the x move and y move of new AiBoard

                        return;
                    }

                    //if(baseBoardToCut.equals(losersBoard)){
                    //losersBoard.add(new AiBoard(baseBoardToCut.getAiBoard()));

                    //}

                }


            }

            //System.out.println();
        }
        losersBoard.add(new AiBoard(newBoard.getAiBoard()));// must specify the x move and y move of new AiBoard
//        System.out.print("Fooooooouuuuuuunnnnnddddd LOOOSEEEEERRRR");


    }


    // Convert pBoard into AiBoard notation aka convert pBoard double array into an AiBoard single board
    // check all losers boards for pBoard in AiNotation
    // find
    // use to for loops with an array called my row go thorugh the p board and see what is alive and add to myarray
    // for loop goes from 0 to p board for row
    // than you would have and if that has if pboard . col .row is alive add to my array [row]. myArray[row]= ++
    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        System.out.println(pBoard);
        int[] convertedboard = new int[10];

        for (int col = 0; col < 10; col++){
            for(int row = 0; row < 10; row++){
                if(pBoard[col][row].isAlive){
                    convertedboard[col] = convertedboard[col] + 1;
                }
            }
        }
        int row = 1;
        int column = 1;
        convertedPboard.AiBoard = convertedboard;
        convertedPboard.printBoard();
        for(int loserlength = 0; loserlength< winnersBoard.size(); loserlength++){
            if (convertedPboard.AiBoard[0] == winnersBoard.get(loserlength).AiBoard[0] && convertedPboard.AiBoard[1] == winnersBoard.get(loserlength).AiBoard[1] && convertedPboard.AiBoard[2] == winnersBoard.get(loserlength).AiBoard[2] && convertedPboard.AiBoard[3] == winnersBoard.get(loserlength).AiBoard[3] && convertedPboard.AiBoard[4] == winnersBoard.get(loserlength).AiBoard[4] && convertedPboard.AiBoard[5] == winnersBoard.get(loserlength).AiBoard[5] && convertedPboard.AiBoard[6] == winnersBoard.get(loserlength).AiBoard[6] && convertedPboard.AiBoard[7] == winnersBoard.get(loserlength).AiBoard[7] && convertedPboard.AiBoard[8] == winnersBoard.get(loserlength).AiBoard[8] && convertedPboard.AiBoard[9] == winnersBoard.get(loserlength).AiBoard[9]) {
                column = winnersBoard.get(loserlength).xMove;
                row = winnersBoard.get(loserlength).yMove;
                break;
            }

        }





//        int row = xMove;
//        int column = yMove;

        System.out.println(column+ ", "+ row);
        //System.out.println(pBoard[1][1]);



        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        Point myMove = new Point(column, row);


        //other code
//        public int[] chiptoBoard (Chip[][] chippy){
//            int[] chips = {column1(chippy),column2(chippy),column3(chippy)};
//            return chips;
//        }
//
//        public Point findMove(int[] board){
//            for(Board i: myList){
//                if(i.col1 == board[0] && i.col3 == board[2] && i.col2 == board[1]){
//                    return new Point(i.xcordy,i.ycordy);
//                }
//            }
//            return new Point();
//        }


        return myMove;

    }

}










// losersBoard.get(losersBoard.size()).xMove = 2; //row    these are both for converted boards
//          losersBoard.get(losersBoard.size()).yMove = 2;

//                        losersBoard.get(losersBoard.size()).xMove = 2; //row
//                        losersBoard.get(losersBoard.size()).yMove = 2; //column