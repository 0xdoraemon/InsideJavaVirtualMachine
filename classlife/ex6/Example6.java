/*
* Copyright (c) 1997-1999 Bill Venners. All rights reserved.
*
* Source code file from the book "Inside the Java 2 Virtual Machine,"
* by Bill Venners, published by McGraw-Hill, 1999, ISBN: 0-07-135093-4. 
*
* This source file may not be copied, modified, or redistributed
* EXCEPT as allowed by the following statements: You may freely use
* this file for your own work, including modifications and distribution
* in compiled (class files, native executable, etc.) form only. You may
* not copy and distribute this file. You may not remove this copyright
* notice. You may not distribute modified versions of this source file.
* You may not use this file in printed media without the express
* permission of Bill Venners. 
*
* BILL VENNERS MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE
* SUITABILITY OF THIS SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING
* BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS
* FOR PARTICULAR PURPOSE, OR NON-INFRINGEMENT. BILL VENNERS SHALL NOT
* BE LIABLE FOR ANY DAMAGES SUFFERED BY A LICENSEE AS A RESULT OF
* USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
*/

// On CD-ROM in file classlife/ex6/Example6.java
class Example6 {

    private int width = 3;

    // Constructor one:
    // This constructor begins with a this() constructor invocation,
    // which gets compiled to a same-class <init>() method
    // invocation.
    Example6() {
        this(1);
        System.out.println("Example6(), width = " + width);
    }

    // Constructor two:
    // This constructor begins with no explicit invocation of another
    // constructor, so it will get compiled to an <init>() method
    // that begins with an invocation of the superclass's no-arg
    // <init>() method.
    Example6(int width) {
        this.width = width;
        System.out.println("Example6(int), width = " + width);
    }

    // Constructor three:
    // This constructor begins with super(), an explicit invocation
    // of the superclass's no-arg constructor. Its <init>() method
    // will begin with an invocation of the superclass's no-arg
    // <init>() method.
    Example6(String msg) {
        super();
        System.out.println("Example6(String), width = " + width);
        System.out.println(msg);
    }

    public static void main(String[] args) {
        String msg
            = "The Agapanthus is also known as Lily of the Nile.";
        Example6 one = new Example6();
        Example6 two = new Example6(2);
        Example6 three = new Example6(msg);
    }
}
