package com.wndexx.exer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author wndexx
 * @create 2022-03-07 18:49
 */
/*
    Create a program named MyInput.java: Contain the methods for reading int,double, float, boolean, short, byte and String values from the keyboard
*/
public class MyInput {

    private BufferedReader br;

    public MyInput(InputStream is) {
        if (is == null)
            throw new RuntimeException("输入有误");
        br = new BufferedReader(new InputStreamReader(is));
    }

    public String readString() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;

    }

    public int nextInt() {
        return Integer.parseInt(readString());
    }

    public double nextDouble() {
        return Double.parseDouble(readString());

    }

    public float nextFloat() {
        return Float.parseFloat(readString());
    }

    public boolean nextBoolean() {
        return Boolean.parseBoolean(readString());
    }

    public short nextShort() {
        return Short.parseShort(readString());
    }

    public byte nextByte() {
        return Byte.parseByte(readString());
    }

    public String next() {
        return readString();
    }

    public void close() {
        try {
            if (br != null)
                br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
