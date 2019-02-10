package TemaTicTacToe;

import java.util.Map;

class TicTacToe {
    private static final String NAMEX = " X ";

    static String getNAMEX() {
        return NAMEX;
    }

    static String getNAMEO() {
        return NAMEO;
    }

    static void run() {
            Board.generateGameBoard();
            int i = 0;
            do {
            if (i % 2 == 0) {
                Board.addToList(KeyboardScanner.convertString(TicTacToe.getNAMEX()), TicTacToe.getNAMEX());
                Board.displayBoard();
                i++;
            } else {
                Board.addToList(KeyboardScanner.convertString(TicTacToe.getNAMEO()), TicTacToe.getNAMEO());
                Board.displayBoard();
                i++;
            }

        } while (TicTacToe.winCondition(Board.gameBoard).equals("continue"));
        System.out.println(TicTacToe.winCondition(Board.gameBoard));
    }


    private static final String NAMEO = " O ";

    static String winCondition(Map<String, String> a) {
        int k = 0;
        for (Map.Entry<String, String> entry : a.entrySet()) {
            if (entry.getValue().equals("   ")) {
                k++;
            }
        }
        String result = "continue";
        String line = null;
        for (int i = 0; i < 8; i++) {
            switch (i) {
                case 0:
                    line = a.get("1,1") + a.get("1,2") + a.get("1,3");
                    break;
                case 1:
                    line = a.get("2,1") + a.get("2,2") + a.get("2,3");
                    break;
                case 2:
                    line = a.get("3,1") + a.get("3,2") + a.get("3,3");
                    break;
                case 3:
                    line = a.get("1,1") + a.get("2,1") + a.get("3,1");
                    break;
                case 4:
                    line = a.get("1,2") + a.get("2,2") + a.get("3,2");
                    break;
                case 5:
                    line = a.get("1,3") + a.get("2,3") + a.get("3,3");
                    break;
                case 6:
                    line = a.get("1,1") + a.get("2,2") + a.get("3,3");
                    break;
                case 7:
                    line = a.get("1,3") + a.get("2,2") + a.get("3,1");
                    break;
            }
            if (line.equals(" X  X  X ")) {
                return "Winner Player X";
            } else {
                if (line.equals(" O  O  O ")) {
                    return "Winner Player O";
                } else {
                    if (k == 0) {
                        return "Draw";
                    }
                }
            }
        }
        return result;
    }
}
