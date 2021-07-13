package org.example.java8.base64;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        test();
    }

    public static void test() throws UnsupportedEncodingException {
        String base64encodedString = Base64.getEncoder().encodeToString("runoob?java8".getBytes(StandardCharsets.UTF_8));
        System.out.println("Base64 编码字符串 (基本) :" + base64encodedString);

        byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
        System.out.println("原始字符串: " + new String(base64decodedBytes, StandardCharsets.UTF_8));

        base64encodedString = Base64.getUrlEncoder().encodeToString("runoob?java8".getBytes(StandardCharsets.UTF_8));
        System.out.println("Base64 编码字符串 (URL) :" + base64encodedString);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(UUID.randomUUID().toString());
        }

        byte[] mimeBytes = stringBuilder.toString().getBytes(StandardCharsets.UTF_8);
        String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
        System.out.println("Base64 编码字符串 (MIME) :" + mimeEncodedString);

    }

}
