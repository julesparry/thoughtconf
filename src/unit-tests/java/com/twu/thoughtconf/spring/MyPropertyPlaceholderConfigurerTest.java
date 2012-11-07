package com.twu.thoughtconf.spring;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MyPropertyPlaceholderConfigurerTest {

    @Test
    public void shouldResolveLocalIp() throws UnknownHostException {
        MyPropertyPlaceholderConfigurer configurer = new MyPropertyPlaceholderConfigurer();
        String value = configurer.resolvePlaceholder(MyPropertyPlaceholderConfigurer.LOCAL_IP, new Properties());
        assertThat(value, is(InetAddress.getLocalHost().getHostAddress()));
    }
}
