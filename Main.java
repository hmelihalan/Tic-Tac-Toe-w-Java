import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] input= new char[3][3];
        boolean winstat=false;
        int row = 0, col = 0;
        int xcount = 0;
        int ocount = 0;
        int offset = 0;
        int turn=0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                input[i][j] = ' ';
            }
        }

        while(!winstat) {
            printBoard(input);
            boolean validInput = false;

            while (!validInput) {
                try {
                    row = sc.nextInt();
                    col = sc.nextInt();

                    if (row < 1 || row > 3 || col < 1 || col > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    } else if (input[row - 1][col - 1] != ' ') {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        if(turn%2==0) {
                            input[row - 1][col - 1] = 'X';
                            xcount++;
                        }
                        else {
                            input[row - 1][col - 1] = 'O';
                            ocount++;
                        }
                        validInput = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("You should enter numbers!");
                    sc.nextLine();
                }
            }
            StringBuilder strtemp = new StringBuilder();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    strtemp.append(input[i][j]);
                }
            }

            String str = strtemp.toString();


            int resultx = checkxwin(str);
            int resulto = checkowin(str);
            int difference = xcount - ocount;


            if (resulto == 1 && resultx == 0) {
                printBoard(input);
                System.out.println("O wins");
                winstat = true;
            }
            if (resulto == 0 && resultx == 1) {
                printBoard(input);
                System.out.println("X wins");
                winstat = true;
            }
            if (resulto == 1 && resultx == 1) System.out.println("Impossible");
            if (difference >= 2 || difference <= -2) System.out.println("Impossible");
            if (resulto == 0 && resultx == 0 && str.indexOf(' ') == -1 && str.indexOf('_') == -1) {
                printBoard(input);
                System.out.println("Draw");
                winstat = true;
            }


            turn++;
        }
    }

    public static int checkxwin(String input) {
        if (input.charAt(0) == 'X' && input.charAt(1) == 'X' && input.charAt(2) == 'X') return 1;
        else if (input.charAt(3) == 'X' && input.charAt(4) == 'X' && input.charAt(5) == 'X'){
            return 1;
        }
        else if (input.charAt(6) == 'X' && input.charAt(7) == 'X' && input.charAt(8) == 'X') {
            return 1;
        }
        else if (input.charAt(0) == 'X' && input.charAt(4) == 'X' && input.charAt(8) == 'X') {
            return 1;
        }
        else if (input.charAt(2) == 'X' && input.charAt(4) == 'X' && input.charAt(6) == 'X') {
            return 1;
        }
        else if (input.charAt(0) == 'X' && input.charAt(3) == 'X' && input.charAt(6) == 'X') {
            return 1;
        }
        else if (input.charAt(1) == 'X' && input.charAt(4) == 'X' && input.charAt(7) == 'X') {
            return 1;
        }
        else if (input.charAt(2) == 'X' && input.charAt(5) == 'X' && input.charAt(8) == 'X') {
            return 1;
        }
        else{
            return 0;
        }
    }
    public static int checkowin(String input){
        if (input.charAt(0) == 'O' && input.charAt(1) == 'O' && input.charAt(2) == 'O') {
            return 1;
        }
        else if (input.charAt(3) == 'O' && input.charAt(4) == 'O' && input.charAt(5) == 'O') {
            return 1;
        }
        else if (input.charAt(6) == 'O' && input.charAt(7) == 'O' && input.charAt(8) == 'O') {
            return 1;
        }
        else if (input.charAt(0) == 'O' && input.charAt(4) == 'O' && input.charAt(8) == 'O') {
            return 1;
        }
        else if (input.charAt(2) == 'O' && input.charAt(4) == 'O' && input.charAt(6) == 'O') {
            return 1;
        }
        else if (input.charAt(1) == 'O' && input.charAt(4) == 'O' && input.charAt(7) == 'O') {
            return 1;
        }
        else if (input.charAt(0) == 'O' && input.charAt(3) == 'O' && input.charAt(6) == 'O') {
            return 1;
        }
        else if (input.charAt(2) == 'O' && input.charAt(5) == 'O' && input.charAt(8) == 'O') {
            return 1;
        }
        else{
            return 0;
        }



    }
    public static void printBoard(char[][] board) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

}

