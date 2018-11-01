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

// On CD-ROM in file
// linking/ex8/com/artima/greeter/GreeterClassLoader.java
package com.artima.greeter;

import java.io.*;
import java.util.Hashtable;

public class GreeterClassLoader extends ClassLoader {

    // basePath gives the path to which this class
    // loader appends "/<typename>.class" to get the
    // full path name of the class file to load
    private String basePath;

    public GreeterClassLoader(String basePath) {

        this.basePath = basePath;
    }

    public synchronized Class loadClass(String className,
        boolean resolveIt) throws ClassNotFoundException {

        Class result;
        byte classData[];

        // Check the loaded class cache
        result = findLoadedClass(className);
        if (result != null) {
            // Return a cached class
            return result;
        }

        // If Spoofed, don't delegate
        if (className.compareTo("Spoofed") != 0) {

            // Check with the system class loader
            try {
                result = super.findSystemClass(className);
                // Return a system class
                return result;
            }
            catch (ClassNotFoundException e) {
            }
        }

        // Don't attempt to load a system file except through
        // the primordial class loader
        if (className.startsWith("java.")) {
            throw new ClassNotFoundException();
        }

        // Try to load it from the basePath directory.
        classData = getTypeFromBasePath(className);
        if (classData == null) {
            System.out.println("GCL - Can't load class: "
                + className);
            throw new ClassNotFoundException();
        }

        // Parse it
        result = defineClass(className, classData, 0,
            classData.length);
        if (result == null) {
            System.out.println("GCL - Class format error: "
                + className);
            throw new ClassFormatError();
        }

        if (resolveIt) {
            resolveClass(result);
        }

        // Return class from basePath directory
        return result;
    }

    private byte[] getTypeFromBasePath(String typeName) {

        FileInputStream fis;
        String fileName = basePath + File.separatorChar
            + typeName.replace('.', File.separatorChar)
            + ".class";

        try {
            fis = new FileInputStream(fileName);
        }
        catch (FileNotFoundException e) {
            return null;
        }

        BufferedInputStream bis = new BufferedInputStream(fis);

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            int c = bis.read();
            while (c != -1) {
                out.write(c);
                c = bis.read();
            }
        }
        catch (IOException e) {
            return null;
        }

        return out.toByteArray();
    }
}
