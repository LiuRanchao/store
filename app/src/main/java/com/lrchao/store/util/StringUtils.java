package com.lrchao.store.util;


import com.lrchao.store.App;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

/**
 * Description: String的工具类
 *
 * @author liuranchao
 * @date 15/12/22 上午10:41
 */
public class StringUtils {

    public static String getString(int id) {
        return App.get().getResources().getString(id);
    }

    private static int getShort(byte[] data) {
        return ((data[0] << 8) | data[1] & 0xFF);
    }

    /**
     * @param data byte[]
     * @return 经过GZIP解压的String
     * @author KevinLiu
     * 将byte[]经过GZIP转换为string
     */
    public static String convertByteToStringWithGzip(byte[] data) {
        byte[] h = new byte[2];
        h[0] = (data)[0];
        h[1] = (data)[1];
        int head = getShort(h);
        boolean t = head == 0x1f8b;
        InputStream in;
        StringBuilder sb = new StringBuilder();
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            if (t) {
                in = new GZIPInputStream(bis);
            } else {
                in = bis;
            }
            BufferedReader r = new BufferedReader(new InputStreamReader(in), 1000);
            for (String line = r.readLine(); line != null; line = r.readLine()) {
                sb.append(line);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
