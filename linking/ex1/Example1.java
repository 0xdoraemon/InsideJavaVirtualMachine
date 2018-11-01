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

// On CD-ROM in file linking/ex1/Example1.java
class Example1 {

    // Assume this application is invoked with one command-line
    // argument, the string "Hi!".
    public static void main(String[] args) {

        // argZero, because it is assigned a String from the command
        // line, does not reference a string literal. This string
        // is not interned.
        String argZero = args[0];

        // literalString, however, does reference a string literal.
        // It will be assigned a reference to a String with the value
        // "Hi!" by an instruction that references a
        // CONSTANT_String_info entry in the constant pool. The
        // "Hi!" string will be interned by this process.
        String literalString = "Hi!";

        // At this point, there are two String objects on the heap
        // that have the value "Hi!". The one from arg[0], which
        // isn't interned, and the one from the literal, which
        // is interned.
        System.out.print("Before interning argZero: ");
        if (argZero == literalString) {
            System.out.println("they're the same string object!");
        }
        else {
            System.out.println("they're different string objects.");
        }

        // argZero.intern() returns the reference to the literal
        // string "Hi!" that is already interned. Now both argZero
        // and literalString have the same value. The non-interned
        // version of "Hi!" is now available for garbage collection.
        argZero = argZero.intern();
        System.out.print("After interning argZero: ");
        if (argZero == literalString) {
            System.out.println("they're the same string object!");
        }
        else {
            System.out.println("they're different string objects.");
        }
    }
}
