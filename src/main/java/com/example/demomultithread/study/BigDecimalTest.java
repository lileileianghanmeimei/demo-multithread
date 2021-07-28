package com.example.demomultithread.study;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * BigDecimal格式化
 * 常用的格式化的符号
 * 0 表示数字，如果位数不足，则补0
 * # 表示数组，位数不足，则不显示对应的位置，小数超出部分四舍五入. 表示小数分隔符, 表示分组分隔符
 * E 表示科学计数法
 * % 表示数值乘以100并拼接百分号
 * ‰ 表示数值乘以1000并拼接千分号
 * ¤ 货币记号，输出时用货币符合代替，如果连续出现两个，则输出时用国际货币符号替换。
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal decimal = new BigDecimal("1.23");

        System.out.println(new DecimalFormat("00.000").format(decimal)); // 01.230
        System.out.println(new DecimalFormat("##.###").format(decimal)); //1.23
        System.out.println(new DecimalFormat("#.#").format(decimal));  // 1.2
        System.out.println(new DecimalFormat("#.#%").format(decimal)); // 123%
        System.out.println(new DecimalFormat("#.#‰").format(decimal)); // 1230‰
        System.out.println(new DecimalFormat("¤#.##").format(decimal)); // ￥1.23
        System.out.println(new DecimalFormat("¤¤#.##").format(decimal)); // CNY1.23
        System.out.println(new DecimalFormat(",###.##").format(new BigDecimal("12345678")));//12,345,678
        System.out.println(new DecimalFormat("#.##E0").format(new BigDecimal("12345678")));//1.23E7
        System.out.println(new DecimalFormat("我自己想输出的格式：#.##").format(decimal));//我自己想输出的格式：1.23
    }
}
