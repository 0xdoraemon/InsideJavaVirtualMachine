/*
* Copyright (c) 1996-1999 Bill Venners. All Rights Reserved.
*
* This Java source file is part of the Interactive Illustrations Web
* Site, which is delivered in the applets directory of the CD-ROM
* that accompanies the book "Inside the Java 2 Virtual Machine" by Bill
* Venners, published by McGraw-Hill, 1999, ISBN: 0-07-135093-4. This
* source file is provided for evaluation purposes only, but you can
* redistribute it under certain conditions, described in the full
* copyright notice below.
*
* Full Copyright Notice:
*
* All the web pages and Java applets delivered in the applets
* directory of the CD-ROM, consisting of ".html," ".gif," ".class,"
* and ".java" files, are copyrighted (c) 1996-1999 by Bill
* Venners, and all rights are reserved.  This material may be copied
* and placed on any commercial or non-commercial web server on any
* network (including the internet) provided that the following
* guidelines are followed:
*
* a. All the web pages and Java Applets (".html," ".gif," ".class,"
* and ".java" files), including the source code, that are delivered
* in the applets directory of the CD-ROM that
* accompanies the book must be published together on the same web
* site.
*
* b. All the web pages and Java Applets (".html," ".gif," ".class,"
* and ".java" files) must be published "as is" and may not be altered
* in any way.
*
* c. All use and access to this web site must be free, and no fees
* can be charged to view these materials, unless express written
* permission is obtained from Bill Venners.
*
* d. The web pages and Java Applets may not be distributed on any
* media, other than a web server on a network, and may not accompany
* any book or publication.
*
* BILL VENNERS MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE
* SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING
* BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR PARTICULAR PURPOSE, OR NON-INFRINGEMENT.  BILL VENNERS
* SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY A LICENSEE AS A
* RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
* DERIVATIVES.
*/
import java.awt.*;
import COM.artima.jvmsim.*;

/**
* This class is the personality module for the Slices of Pi
* simulation applet.
*
* @author  Bill Venners
*/
public class SlicesOfPi extends JVMSimulator {

    private final static String appletTitle = "SLICES OF PI";

    private static final Color appletBackgroundColor = Color.blue;
    private static final Color registersAreaColor = Color.magenta;
    private static final Color stackAreaColor = Color.magenta;
    private static final Color methodAreaColor = Color.magenta;
    private static final Color titleColor = Color.cyan;
    private static final Color explanationLabelColor = Color.cyan;

    private static final int bytecodeViewSize = 13;
    private static final int maxStack = 8;
    private static final int maxLocals = 9;

    private static int[] theProgram = {
        OpCode.LDC2_W, 0x00, 0x0a,
        OpCode.DSTORE_0,
        OpCode.LDC2_W, 0x00, 0x06,
        OpCode.DSTORE_2,
        OpCode.ICONST_1,
        OpCode.ISTORE, 0x06,
        OpCode.DCONST_0,
        OpCode.DSTORE, 0x07,
        OpCode.GOTO, 0x00, 0x3d,
        OpCode.DCONST_1,
        OpCode.DLOAD, 0x07,
        OpCode.DLOAD, 0x07,
        OpCode.DMUL,
        OpCode.DSUB,
        OpCode.INVOKESTATIC, 0x00, 0x05,
        OpCode.DSTORE, 0x04,
        OpCode.DLOAD_0,
        OpCode.LDC2_W, 0x00, 0x0a,
        OpCode.DLOAD_2,
        OpCode.DLOAD, 0x04,
        OpCode.DMUL,
        OpCode.DMUL,
        OpCode.DSUB,
        OpCode.DSTORE_0,
        OpCode.DLOAD, 0x07,
        OpCode.DLOAD_2,
        OpCode.DADD,
        OpCode.DSTORE, 0x07,
        OpCode.DCONST_1,
        OpCode.DLOAD, 0x07,
        OpCode.DLOAD, 0x07,
        OpCode.DMUL,
        OpCode.DSUB,
        OpCode.INVOKESTATIC, 0x00, 0x05,
        OpCode.DSTORE, 0x04,
        OpCode.DLOAD_0,
        OpCode.LDC2_W, 0x00, 0x0a,
        OpCode.DLOAD_2,
        OpCode.DLOAD, 0x04,
        OpCode.DMUL,
        OpCode.DMUL,
        OpCode.DADD,
        OpCode.DSTORE_0,
        OpCode.DLOAD, 0x07,
        OpCode.DLOAD_2,
        OpCode.DADD,
        OpCode.DSTORE, 0x07,
        OpCode.DLOAD, 0x07,
        OpCode.DCONST_1,
        OpCode.DCMPG,
        OpCode.IFLT, (byte) 0xff, (byte) 0xc2,
        OpCode.IINC, 6, 1,
        OpCode.DLOAD_2,
        OpCode.LDC2_W, 0x00, 0x08,
        OpCode.DDIV,
        OpCode.DSTORE_2,
        OpCode.GOTO, (byte) 0xff, (byte) 0xb0
    };

    private static String[] bytecodeMnemonics = {
        "ldc2_w #10", "", "",
        "dstore_0",
        "ldc2_w #6", "", "",
        "dstore_2",
        "iconst_1",
        "istore 6", "",
        "dconst_0",
        "dstore 7", "",
        "goto 75", "", "",
        "dconst_1",
        "dload 7", "",
        "dload 7", "",
        "dmul",
        "dsub",
        "invokestatic #5", "", "",
        "dstore 4", "",
        "dload_0",
        "ldc2_w #10", "", "",
        "dload_2",
        "dload 4", "",
        "dmul",
        "dmul",
        "dsub",
        "dstore_0",
        "dload 7", "",
        "dload_2",
        "dadd",
        "dstore 7", "",
        "dconst_1",
        "dload 7", "",
        "dload 7", "",
        "dmul",
        "dsub",
        "invokestatic #5", "", "",
        "dstore 4", "",
        "dload_0",
        "ldc2_w #10", "", "",
        "dload_2",
        "dload 4", "",
        "dmul",
        "dmul",
        "dadd",
        "dstore_0",
        "dload 7", "",
        "dload_2",
        "dadd",
        "dstore 7", "",
        "dload 7", "",
        "dconst_1",
        "dcmpg",
        "iflt 17", "", "",
        "iinc 6 1", "", "",
        "dload_2",
        "ldc2_w #8", "", "",
        "ddiv",
        "dstore_2",
        "goto 11", "", ""
    };

    public int[] getTheProgram() {
        return theProgram;
    }
    public int getBytecodeViewSize() {
        return bytecodeViewSize;
    }
    public int getMaxStack() {
        return maxStack;
    }
    public int getMaxLocals() {
        return maxLocals;
    }
    public Color getMethodAreaColor() {
        return methodAreaColor;
    }
    public Color getStackAreaColor() {
        return stackAreaColor;
    }
    public Color getExplanationLabelColor() {
        return explanationLabelColor;
    }
    public Color getTitleColor() {
        return titleColor;
    }
    public Color getAppletBackgroundColor() {
        return appletBackgroundColor;
    }
    public String getAppletTitle() {
        return appletTitle;
    }
    public String[] getBytecodeMnemonics() {
        return bytecodeMnemonics;
    }
}
