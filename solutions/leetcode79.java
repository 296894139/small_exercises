/**
 * @创建人 徐介晖
 * @创建时间 2018/9/27
 * @描述  Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */
class leetcode79{
    public boolean exist(char[][] board, String word) {

        char[] w = word.toCharArray();
        boolean[][] helper = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[i].length; j ++){
                if(exist(board, w, i, j, 0, helper)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, char[] word, int i, int j, int k, boolean[][] helper){
        if(k == word.length){
            return true;
        }

        if(i < 0 || j < 0 || i == board.length || j == board[i].length || helper[i][j]){
            return false;
        }

        if(board[i][j] != word[k]){
            return false;
        }

        helper[i][j] = true;

        boolean exist = exist(board, word, i + 1, j, k + 1, helper)
                || exist(board, word, i - 1, j, k + 1, helper)
                || exist(board, word, i, j + 1, k + 1, helper)
                || exist(board, word, i, j - 1 , k + 1, helper);

        helper[i][j] = false;

        return exist;
    }
}
