
class StateOfTicTacToe {
    String firstRow;
    String secondRow;
    String thirdRow;
    int countX;
    int countO;

    public GameState determineState(String[] board) {
        countXandOs(board);
        firstRow = board[0];
        secondRow = board[1];
        thirdRow = board[2];
        if (checkRows()) {
            return GameState.WIN;
        } else if (checkColumns()) {
            return GameState.WIN;
        } else if (checkDiagonals()) {
            return GameState.WIN;
        }
        if (countX > countO + 1) {
            throw new IllegalArgumentException("Wrong turn order: X went twice");
        }
        if (countO > countX) {
            throw new IllegalArgumentException("Wrong turn order: O started");
        } else if (checkOngoing()) {
            return GameState.ONGOING;
        }
        return GameState.DRAW;
    }

    public boolean checkRows() {
        if (firstRow.equals("XXX") && secondRow.equals("OOO")) {
            throw new IllegalArgumentException("Impossible board: game should have ended after the game was won");
        }

        return firstRow.equals("XXX") || firstRow.equals("OOO") ||
                secondRow.equals("XXX") || secondRow.equals("OOO") ||
                thirdRow.equals("XXX") || thirdRow.equals("OOO");
    }

    public boolean checkColumns() {
        String firstColumn = "%s%s%s".formatted(firstRow.substring(0, 1), secondRow.substring(0, 1), thirdRow.substring(0, 1));
        String secondColumn = "%s%s%s".formatted(firstRow.substring(1, 2), secondRow.substring(1, 2), thirdRow.substring(1, 2));
        String thirdColumn = "%s%s%s".formatted(firstRow.substring(2, 3), secondRow.substring(2, 3), thirdRow.substring(2, 3));

        return firstColumn.equals("XXX") || firstColumn.equals("OOO") ||
                secondColumn.equals("XXX") || secondColumn.equals("OOO") ||
                thirdColumn.equals("XXX") || thirdColumn.equals("OOO");
    }

    public boolean checkDiagonals() {
        String rightDiagonal = "%s%s%s".formatted(firstRow.substring(0, 1), secondRow.substring(1, 2), thirdRow.substring(2, 3));
        String leftDiagonal = "%s%s%s".formatted(firstRow.substring(2, 3), secondRow.substring(1, 2), thirdRow.substring(0, 1));

        return rightDiagonal.equals("XXX") || rightDiagonal.equals("OOO") || leftDiagonal.equals("XXX")
                || leftDiagonal.equals("OOO");
    }

    public boolean checkOngoing() {
        for (char c : firstRow.toCharArray()) {
            if (c == ' ') {
                return true;
            }
        }
        return false;
    }

    public void countXandOs(String[] board) {
        for (String s : board) {
            for (char c : s.toCharArray()) {
                if (c == 'X') {
                    countX += 1;
                }
                if (c == 'O') {
                    countO += 1;
                }
            }
        }
    }
}
