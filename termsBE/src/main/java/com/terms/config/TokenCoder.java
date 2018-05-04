package com.terms.config;


import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class TokenCoder {

    public static String decode(String s) {
        return StringUtils.newStringUtf8(Base64.decodeBase64(s));
    }
    public static String encode(String s) {
        return Base64.encodeBase64String(StringUtils.getBytesUtf8(s));
    }

}
