package com.twu.thoughtconf.spring;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

public class MyPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    public static final String LOCAL_IP = "localIp";

    @Override
    protected String resolvePlaceholder(String placeholder, Properties props) {
        if (LOCAL_IP.equals(placeholder)) {
            return localIp();
        }
        return super.resolvePlaceholder(placeholder, props);
    }

    private String localIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
