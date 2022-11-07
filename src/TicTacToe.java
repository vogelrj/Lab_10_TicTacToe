import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final String PLAYERX = "X";
        final String PLAYERO = "O";
        final String SPACE = " ";
        int moveCount = 0;
        boolean playAgain = false;
        boolean moveCheck = false;
        boolean gameWon = false;
        boolean gameTie = false;
        int colMove = 0;
        int rowMove = 0;
        do { //Main Game Loop
            clearBoard();
            moveCount = 1; //Counter
            playAgain = SafeInput.getYNConfirm(in,"\nReady to play Tic Tac Toe? [Y/N]");
            if(playAgain == false){
                System.out.println("Okay.Maybe next time!");
                System.exit(0);
            }
            printBoard();
            do { //Play Loop
                switch (moveCount){ //Switch Case for Main Game
                    case(1):
                    case(3): //Player X Moves / No tie or win Check
                        do {
                            rowMove = getRowMove(in,PLAYERX);
                            colMove = getColMove(in,PLAYERX);
                            moveCheck = isValidMove(rowMove,colMove);
                            if (moveCheck == true){ //Valid Check
                                board[rowMove][colMove] = PLAYERX;
                            }
                            else{
                                System.out.println("That move is already taken. Please try again.");
                            }
                        }
                        while (moveCheck == false);
                        moveCount++;
                        System.out.println();
                        printBoard();
                        break;
                    case(2):
                    case(4)://Player O Moves / No tie or win Check
                        do {
                            rowMove = getRowMove(in,PLAYERO);
                            colMove = getColMove(in,PLAYERO);
                            moveCheck = isValidMove(rowMove,colMove);
                            if (moveCheck == true){ //Valid Check
                                board[rowMove][colMove] = PLAYERO;
                            }
                            else{
                                System.out.println("That move is already taken. Please try again.");
                            }
                        }
                        while (moveCheck == false);
                        moveCount++;
                        System.out.println();
                        printBoard();
                        break;
                    case(5): //Player X move with Win check
                        do {
                            rowMove = getRowMove(in,PLAYERX);
                            colMove = getColMove(in,PLAYERX);
                            moveCheck = isValidMove(rowMove,colMove);
                            if (moveCheck == true){ //Valid Check
                                board[rowMove][colMove] = PLAYERX;
                            }
                            else{
                                System.out.println("That move is already taken. Please try again.");
                            }
                        }
                        while (moveCheck == false);
                        gameWon = isWin(PLAYERX);
                        gameTie = isTie(PLAYERX, PLAYERO);
                        if (gameWon == true){ //Win Check
                            System.out.println("Player X Wins!");
                            moveCount = 11;
                        }
                        else{
                            moveCount++;
                        }
                        System.out.println();
                        printBoard();
                        break;
                    case(6): //Player O move with win check
                        do {
                            rowMove = getRowMove(in,PLAYERO);
                            colMove = getColMove(in,PLAYERO);
                            moveCheck = isValidMove(rowMove,colMove);
                            if (moveCheck == true){ //valid Check
                                board[rowMove][colMove] = PLAYERO;
                            }
                            else{
                                System.out.println("That move is already taken. Please try again.");
                            }
                        }
                        while (moveCheck == false);
                        gameWon = isWin(PLAYERO);
                        gameTie = isTie(PLAYERO, PLAYERX);
                        if (gameWon == true){ //Win Check
                            System.out.println("Player O Wins!");
                            moveCount = 11;
                        }
                        else{
                            moveCount++;
                        }
                        System.out.println();
                        printBoard();
                        System.out.println();
                        break;
                    case(7): //Player X move with Win and Tie Check
                        do {
                            rowMove = getRowMove(in,PLAYERX);
                            colMove = getColMove(in,PLAYERX);
                            moveCheck = isValidMove(rowMove,colMove);
                            if (moveCheck == true){ //Valid Check
                                board[rowMove][colMove] = PLAYERX;
                            }
                            else{
                                System.out.println("That move is already taken. Please try again.");
                            }
                        }
                        while (moveCheck == false);
                        gameWon = isWin(PLAYERX);
                        gameTie = isTie(PLAYERX, PLAYERO);
                        if (gameWon == true){ //Win Check
                            System.out.println("Player X Wins!");
                            moveCount = 11;
                        }
                        else if (gameTie == true) { //Tie Check
                            System.out.println("No winning moves left! It's a Tie!");
                            moveCount = 11;
                        }
                        else{
                            moveCount++;
                        }
                        System.out.println();
                        printBoard();
                        break;
                    case(8): //Player O move with Win and Tie Check
                        do {
                            rowMove = getRowMove(in,PLAYERO);
                            colMove = getColMove(in,PLAYERO);
                            moveCheck = isValidMove(rowMove,colMove);
                            if (moveCheck == true){ //Valid Check
                                board[rowMove][colMove] = PLAYERO;
                            }
                            else{
                                System.out.println("That move is already taken. Please try again.");
                            }
                        }
                        while (!moveCheck);
                        gameWon = isWin(PLAYERO);
                        gameTie = isTie(PLAYERO, PLAYERX);
                        if (gameWon){ //Win Check
                            System.out.println("Player O Wins!");
                            printBoard();
                            moveCount = 11;
                        }
                        else if (gameTie) { //Tie check
                            System.out.println("No winning moves left! It's a Stalemate!");
                            moveCount = 11;
                        }
                        else{
                            moveCount++;
                        }
                        System.out.println();
                        printBoard();
                        System.out.println();
                        break;
                    case (9): //Player X move with Win and Board Full Statement
                        do {
                            rowMove = getRowMove(in,PLAYERX);
                            colMove = getColMove(in,PLAYERX);
                            moveCheck = isValidMove(rowMove,colMove);
                            if (moveCheck){
                                board[rowMove][colMove] = PLAYERX;
                            }
                            else{
                                System.out.println("That move is already taken. Please try again.");
                            }
                        }
                        while (!moveCheck);
                        gameWon = isWin(PLAYERX);
                        if(!gameWon){ // Full Board Message
                            System.out.println("The board is full! Its a Tie!");
                            printBoard();
                            moveCount = 11;

                        }
                        else {
                            System.out.println("Player X Wins!");
                            printBoard();
                            moveCount = 11;
                        }
                    default:
                }
            }
            while (moveCount <10);
            playAgain = SafeInput.getYNConfirm(in,"Do you want to play again? "); //Play again Msg
            if(playAgain == false){
                System.out.println("Okay.Maybe next time!");
                System.exit(0);
            }
        }
        while (playAgain);
    }

    private static void clearBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = " ";
            }
        }
    }

    private static void printBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
            }
        }
        System.out.println("    1   2   3");
        System.out.println("1 | " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |");
        System.out.println("  -------------");
        System.out.println("2 | " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |");
        System.out.println("  -------------");
        System.out.println("3 | " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |");
    }

    private static boolean isValidMove(int row, int col) {
        boolean retVal = board[row][col].equals(" ");
        return retVal;
    }

    private static boolean isRowWin(String player) {
        for (int row = 0; row < ROW; row++) {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isColWin(String player) {
        for (int col = 0; col < COL; col++) {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagWin(String player) {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)){
                    return true;}
                else if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean isWin(String player) {
        if(isColWin(player) || isRowWin(player) || isDiagWin(player))
        {
            return true;
        }
        return false;
    }
    private static int getRowMove(Scanner pipe,String player){
        Scanner in = new Scanner (System.in);
        int move = 0;
            move = SafeInput.getRangedInt(in,"Player " + player + ". What is the row (horizontal) for your move? ", 1, 3) - 1;
        return move;
    }
    private static int getColMove(Scanner pipe,String player){
        Scanner in = new Scanner(System.in);
        int move = 0;
        move = SafeInput.getRangedInt(in, "What is the column (vertical) for your " + player + ". ", 1, 3) - 1;
        return move;
    }
    private static boolean isDiagTie(String player, String opponent){
        for (int row = 0; row < ROW; row++){
            for (int col = 0; col < COL; col++){
                if (board[1][1].equals(player) && board[0][0].equals(opponent) || board[2][2].equals(player)){
                    if (board[1][1].equals(player) && board[2][0].equals(opponent) || board[0][2].equals(opponent)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private static boolean isColTie(String player, String opponent) {
        for (int col = 0; col < COL; col++) {
            if (board[0][col].equals(player) || board[1][col].equals(player) || board[2][col].equals(player)) {
                if (board[0][col].equals(opponent) || board[1][col].equals(opponent) || board[2][col].equals(opponent)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean isRowTie(String player, String opponent) {
        for (int row = 0; row < ROW; row++) {
            if (board[row][0].equals(player) || board[row][1].equals(player) || board[row][2].equals(player)) {
                if (board[row][0].equals(opponent) || board[row][1].equals(opponent) || board[row][2].equals(opponent)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean isTie(String player, String opponent){
        if(isColTie(player,opponent)) {
            if (isRowTie(player,opponent)){
                if (isDiagTie(player,opponent)){
                    return true;
                }
            }
        }
            return false;
    }
}



