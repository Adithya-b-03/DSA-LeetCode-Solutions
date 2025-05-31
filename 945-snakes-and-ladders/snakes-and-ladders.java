class Solution {
    static class Cell {
        int pos;
        int hopcount;
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int size = n * n;
        int[] moves = new int[size];

        // Convert the board to 1D moves[]
        int idx = 0;
        boolean isLeftToRight = true;
        for (int i = n - 1; i >= 0; i--) {
            if (isLeftToRight) {
                for (int j = 0; j < n; j++) {
                    moves[idx++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    moves[idx++] = board[i][j];
                }
            }
            isLeftToRight = !isLeftToRight;
        }

        boolean[] visited = new boolean[size];
        Queue<Cell> q = new LinkedList<>();

        Cell cell = new Cell();
        cell.pos = 0;
        cell.hopcount = 0;
        visited[0] = true;
        q.offer(cell);

        Cell newCell = null;

        while (!q.isEmpty()) {
            newCell = q.poll();
            int index = newCell.pos;

            if (index == size - 1) {
                return newCell.hopcount;
            }

            for (int i = index + 1; (i <= index + 6) && (i < size); i++) {
                int dest = (moves[i] != -1) ? (moves[i] - 1) : i;
                if (!visited[dest]) {
                    Cell c = new Cell();
                    c.hopcount = newCell.hopcount + 1;
                    c.pos = dest;
                    visited[dest] = true;
                    q.offer(c);
                }
            }
        }

        return -1; // destination was never reached
    }
}
