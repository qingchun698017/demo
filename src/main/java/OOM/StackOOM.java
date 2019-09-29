/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package OOM;

/**
 * 栈 OOM
 * VMOption:-Xss108k
 * 不能低于108 The stack size specified is too small, Specify at least 108k
 *
 * @author wqc
 * @version V1.0
 * @since 2019-06-17 18:22
 */
public class StackOOM {
    public static void main(String[] args) {
        d();
    }

    //递归
    static private void d(){
        d();
    }

    //扩大局部变量
    static private void d1(){
        double a = 666L;
        double a1 = 666L;
        double a2 = 666L;
        double a3 = 666L;
        double a4 = 666L;
        double a5 = 666L;
        double a6 = 666L;
        double a7 = 666L;
        double a8 = 666L;
        double a9 = 666L;
        double a10 = 666L;
        double a11 = 666L;
        double a12 = 666L;
        double a13 = 666L;
        double a14 = 666L;
        double a15 = 666L;
        double a16 = 666L;
        double a17 = 666L;
        double a18 = 666L;
        double a19 = 666L;
        double a20 = 666L;
        d1();
    }

}
