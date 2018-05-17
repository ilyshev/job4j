package ru.job4j.comparator;

import java.util.Comparator;
import java.util.List;

/**
 * класс сравнения строк посимвольно.
 * @author Dmitry ILyshev (dilyshev@mac.com)
 * @version $Id$
 * @since 0.1
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rst = 0;
        int minSize = Math.min(left.length(), right.length());
        for (int i = 0; i < minSize; i++) {
            rst = Integer.compare(left.charAt(i), right.charAt(i));
            if (rst != 0) {
                break;
            }
        }
        if (rst == 0 && left.length() != right.length()) {
            rst = left.length() - right.length();
        }
        return rst;
    }
}
