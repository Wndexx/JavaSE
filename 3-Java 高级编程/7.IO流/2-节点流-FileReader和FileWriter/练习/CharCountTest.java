package com.wndexx.exer;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author wndexx
 * @create 2022-03-07 15:27
 */
public class CharCountTest {

    /*
        获取文本上每个字符出现的次数
        提示：遍历文本的每一个字符；字符及出现的次数保存在Map中；将Map中数据
        写入文件
    */
    @Test
    public void test1() {

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            Map<Character, Integer> map = new HashMap<>();

            br = new BufferedReader(new FileReader("dbcp.txt"));
            bw = new BufferedWriter(new FileWriter("charcount.txt"));

            String data;
            while ((data = br.readLine()) != null) {
                for (int i = 0; i < data.length(); i++) {
                    char c = data.charAt(i);
                    if (!map.containsKey(c)) {
                        map.put(c, 1);
                        continue;
                    }
                    map.put(c, map.get(c) + 1);
                }
            }

            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
            for (Map.Entry<Character, Integer> entry : entrySet) {
                bw.write(entry.getKey() + ":" + entry.getValue());
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
