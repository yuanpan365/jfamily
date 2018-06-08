package com.yuanpan.jfamily.security.auth.token.extractor;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.security.auth.token.extractor
 * @Description: 表示Token
 * @date 2018/6/7 13:28
 */
public interface TokenExtractor {
    String extract(String payload);
}
