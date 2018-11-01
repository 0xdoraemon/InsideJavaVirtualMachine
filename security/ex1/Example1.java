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

import java.security.Permission;
import java.io.FilePermission;
import java.io.File;

// On CD-ROM in file security/ex1/Example1.java
class Example1 {

    public static void main(String[] args) {

        char sep = File.separatorChar;

        // Read permission for "/tmp/f"
        Permission file = new FilePermission(
            sep + "tmp" + sep + "f", "read");

        // Read permission for "/tmp/*", which
        // means all files in the /tmp directory 
        // (but not any files in subdirectories
        // of /tmp)
        Permission star = new FilePermission(
            sep + "tmp" + sep + "*", "read");

        boolean starImpliesFile = star.implies(file);
        boolean fileImpliesStar = file.implies(star);

        // Prints "Star implies file = true"
        System.out.println("Star implies file = "
            + starImpliesFile);

        // Prints "File implies star = false"
        System.out.println("File implies star = "
            + fileImpliesStar);
    }
}
