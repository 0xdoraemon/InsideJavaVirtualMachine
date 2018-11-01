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

// On CD-ROM in file classlife/ex4/Example4.java
class Example4 implements Cloneable {

    Example4() {
        System.out.println("Created by invoking newInstance()");
    }

    Example4(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args)
        throws ClassNotFoundException, InstantiationException,
        IllegalAccessException, CloneNotSupportedException {

        // Create a new Example4 object with the new operator
        Example4 obj1 = new Example4("Created with new.");

        // Get a reference to the Class instance for Example4, then
        // invoke newInstance() on it to create a new Example4 object
        Class myClass = Class.forName("Example4"); 
        Example4 obj2 = (Example4) myClass.newInstance();

        // Make an identical copy of the the second Example4 object
        Example4 obj3 = (Example4) obj2.clone();
    }
}
