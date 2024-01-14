package com.ll.global.app;

import com.ll.standard.util.TestUtil;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTest {
    public static String run(final String cmd){

        final Scanner scanner = TestUtil.genScanner(cmd.stripIndent().trim() + "\n종료");

        final ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        new App(scanner).run();

        final String out = byteArrayOutputStream.toString().trim();
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);

        return out.trim();
    }



}
