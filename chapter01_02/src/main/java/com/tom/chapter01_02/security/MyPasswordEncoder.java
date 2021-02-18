package com.tom.chapter01_02.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * MyPasswordEncoder
 *
 * @author Tom on 2021/2/18
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
