package leetcode.生命游戏_289;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author dadongge
 * @date 2020/4/2
 */
public class Solution {
    public void gameOfLife(int[][] board) {
        int[][] board1 = new int[board.length][board[0].length];
        int count = 0;
        int current = 0;
        for(int i = 0; i < board.length ; i++){
            for(int j = 0; j < board[0].length; j++){
                count = board[i][j];
                if(i - 1 >= 0){
                    if( j - 1 >= 0){
                        current = current + board[i-1][j-1];
                    }
                    current = current + board[i - 1][j];
                    if(j + 1 < board[0].length){
                        current = current + board[i - 1][j + 1];
                    }
                }
                if(j - 1 >= 0){
                    current = current + board[i][j-1];
                }
                if(j + 1 < board[0].length){
                    current = current + board[i][j+1];
                }
                if(i + 1 < board.length){
                    if( j - 1 >= 0){
                        current = current + board[i + 1][j - 1];
                    }
                    current = current + board[i + 1][j];
                    if(j + 1 < board[0].length){
                        current = current + board[i + 1][j + 1];
                    }
                }
                if(current < 2 && count == 1){
                    count = 0;
                }
                if((current == 2 || current == 3) && count == 1){
                    count = 1;
                }
                if(current > 3 && count == 1){
                    count = 0;
                }
                if(current == 3 && count == 0){
                    count = 1;
                }
                board1[i][j] = count;
                current = 0;
            }
        }
//        System.out.println(map);
//        if(!map.isEmpty()) {
//            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                board[entry.getKey()][entry.getValue()] = (board[entry.getKey()][entry.getValue()] == 1) ? 0 : 1;
//            }
//        }
        for(int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board1[i][j];
            }
        }
    }


    public static void main(String[] args){
        int[][] board = new int[4][23];
        board[0] = new int[]{0,1,0};
        board[1] = new int[]{0,0,1};
        board[2] = new int[]{1,1,1};
        board[3] = new int[]{0,0,0};
        Solution solution = new Solution();
        solution.gameOfLife(board);
        for(int[] board1 : board){
            System.out.println(Arrays.toString(board1));
        }
    }
}
