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

// On CD-ROM in file except/ex1/NitpickyMath.java
class NitpickyMath {

    static int add(int a, int b)
        throws OverflowException, UnderflowException {

        long longA = (long) a;
        long longB = (long) b;
        long result = a + b;
        if (result > Integer.MAX_VALUE) {
            throw new OverflowException();
        }
        if (result < Integer.MIN_VALUE) {
            throw new UnderflowException();
        }
        return (int) result;
    }

    static int subtract(int minuend, int subtrahend)
        throws OverflowException, UnderflowException {

        long longMinuend = (long) minuend;
        long longSubtrahend = (long) subtrahend;
        long result = longMinuend - longSubtrahend;
        if (result > Integer.MAX_VALUE) {
            throw new OverflowException();
        }
        if (result < Integer.MIN_VALUE) {
            throw new UnderflowException();
        }
        return (int) result;
    }

    static int multiply(int a, int b)
        throws OverflowException, UnderflowException {

        long longA = (long) a;
        long longB = (long) b;
        long result = a * b;
        if (result > Integer.MAX_VALUE) {
            throw new OverflowException();
        }
        if (result < Integer.MIN_VALUE) {
            throw new UnderflowException();
        }
        return (int) result;
    }

    static int divide(int dividend, int divisor)
        throws OverflowException, DivideByZeroException {

        // Overflow can occur in division when dividing the
        // negative integer of the largest possible magnitude
        // (Integer.MIN_VALUE) by -1, because this would just flip
        // the sign, but there is no way to represent that number
        // in an int.
        if ((dividend == Integer.MIN_VALUE) && (divisor == -1)) {
            throw new OverflowException();
        }
        try {
            return dividend / divisor;
        }
        catch (ArithmeticException e) {
            throw new DivideByZeroException();
        }
    }

    static int remainder(int dividend, int divisor)
        throws OverflowException, DivideByZeroException {

        // Overflow can occur in division when dividing the
        // negative integer of the largest possible magnitude
        // (Integer.MIN_VALUE) by -1, because this would just flip
        // the sign, but there is no way to represent that number
        // in an int.
        if ((dividend == Integer.MIN_VALUE) && (divisor == -1)) {
            throw new OverflowException();
        }
        try {
            return dividend % divisor;
        }
        catch (ArithmeticException e) {
            throw new DivideByZeroException();
        }
    }
}
