package chapterone.thirditem;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * @author https://github.com/xiaoliu66
 * @since 2022/4/18 23:10
 * @version 1.0
 * P80 Dijkstra的双栈算数表达式求值算法
 *
 * 运行时 如果是cmd 要按下ctrl + z 才能结束。idea terminal 是ctrl + D (cmd模式不是powershell)
 * ( ( 1 + sqrt ( 5.0 ) ) / 2.0 )
 * ^Z
 * 1.618033988749895
 */
public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("(")) ;
            else if (s.equals("+")) {
                ops.push(s);
            } else if (s.equals("-")) {
                ops.push(s);
            } else if (s.equals("*")) {
                ops.push(s);
            } else if (s.equals("/")) {
                ops.push(s);
            } else if (s.equals("sqrt")) {
                ops.push(s);
            } else if (s.equals(")")) {
                String o = ops.pop();
                Double v = vals.pop();
                if (o.equals("+")) {
                    vals.push(vals.pop() + v);
                } else if (o.equals("-")) {
                    vals.push(vals.pop() - v);
                } else if (o.equals("*")) {
                    vals.push(vals.pop() * v);
                } else if (o.equals("/")) {
                    vals.push(vals.pop() / v);
                } else {
                    vals.push(Math.sqrt(v));
                }
            } else {
                vals.push(Double.parseDouble(s));
            }

        }
        // System.out.println(vals.pop());
        StdOut.println(vals.pop());
    }
}
