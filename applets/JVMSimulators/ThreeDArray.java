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
* This class is the personality module for the Three Dimensional Array
* simulation applet.
*
* @author  Bill Venners
*/
public class ThreeDArray extends JVMSimulator {

    private final static String appletTitle = "THREE DIMENSIONAL ARRAY";

    private static final Color appletBackgroundColor = Color.blue;
    private static final Color registersAreaColor = Color.cyan;
    private static final Color stackAreaColor = Color.cyan;
    private static final Color methodAreaColor = Color.cyan;
    private static final Color titleColor = Color.green;
    private static final Color explanationLabelColor = Color.green;

    private static final int bytecodeViewSize = 13;
    private static final int maxStack = 4;
    private static final int maxLocals = 4;

    private static int[] theProgram = {
        OpCode.ICONST_5,
        OpCode.ICONST_4,
        OpCode.ICONST_3,
        OpCode.MULTIANEWARRAY, (byte) 0x00, (byte) 0x02, (byte) 0x03,
        OpCode.ASTORE_0,
        OpCode.ICONST_0,
        OpCode.ISTORE_1,
        OpCode.GOTO, (byte) 0x00, (byte) 0x2c,
        OpCode.ICONST_0,
        OpCode.ISTORE_2,
        OpCode.GOTO, (byte) 0x00, (byte) 0x1f,
        OpCode.ICONST_0,
        OpCode.ISTORE_3,
        OpCode.GOTO, (byte) 0x00, (byte) 0x12,
        OpCode.ALOAD_0,
        OpCode.ILOAD_1,
        OpCode.AALOAD,
        OpCode.ILOAD_2,
        OpCode.AALOAD,
        OpCode.ILOAD_3,
        OpCode.ILOAD_1,
        OpCode.ILOAD_2,
        OpCode.IADD,
        OpCode.ILOAD_3,
        OpCode.IADD,
        OpCode.IASTORE,
        OpCode.IINC, (byte) 0x03, (byte) 0x01,
        OpCode.ILOAD_3,
        OpCode.ICONST_3,
        OpCode.IF_ICMPLT, (byte) 0xff, (byte) 0xef,
        OpCode.IINC, (byte) 0x02, (byte) 0x01,
        OpCode.ILOAD_2,
        OpCode.ICONST_4,
        OpCode.IF_ICMPLT, (byte) 0xff, (byte) 0xe2,
        OpCode.IINC, (byte) 0x01, (byte) 0x01,
        OpCode.ILOAD_1,
        OpCode.ICONST_5,
        OpCode.IF_ICMPLT, (byte) 0xff, (byte) 0xd5,
        OpCode.BREAKPOINT
    };

    private static String[] bytecodeMnemonics = {
        "iconst_5",
        "iconst_4",
        "iconst_3",
        "multianewarray 2 3", "", "", "",
        "astore_0",
        "iconst_0",
        "istore_1",
        "goto 54", "", "",
        "iconst_0",
        "istore_2",
        "goto 46", "", "",
        "iconst_0",
        "istore_3",
        "goto 38", "", "",
        "aload_0",
        "iload_1",
        "aaload",
        "iload_2",
        "aaload",
        "iload_3",
        "iload_1",
        "iload_2",
        "iadd",
        "iload_3",
        "iadd",
        "iastore",
        "iinc 3 1", "", "",
        "iload_3",
        "iconst_3",
        "if_icmplt 23", "", "",
        "iinc 2 1", "", "",
        "iload_2",
        "iconst_4",
        "if_icmplt 18", "", "",
        "iinc 1 1", "", "",
        "iload_1",
        "iconst_5",
        "if_icmplt 13", "", "",
        "breakpoint"
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
