package leetcode.括号生成_22;

import java.util.*;

/**
 * @author dadongge
 * @date 2020/4/9
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        //特判
        if(n == 0){
            return res;
        }

        //执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;

    }

    /**
     * @param curStr  当前递归得到的结果
     * @param left    左括号还有几个可以使用
     * @param right   右括号还有几个可以使用
     * @param res     结果集
     */
    private void dfs(String curStr, int left, int right, List<String> res){
        //因为每一次尝试，都使用新的字符串变量，所以无需回溯
        //在递归终止的时候，直接把它添加到结果集即可
        if(left == 0 && right == 0){
            res.add(curStr);
            return ;
        }
    }


}
