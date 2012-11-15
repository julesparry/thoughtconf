package com.twu.thoughtconf.jetty;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.webapp.WebAppContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebServer {

    private static final AbstractHandler SHUTDOWN_HANDLER = new AbstractHandler() {
        @Override
        public void handle(String uri, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, int i) throws IOException, ServletException {
            if ("/shutdown".equals(uri)) {
                System.exit(0);
            }
        }
    };
    private final Server jetty;

    public WebServer(int port) {
        jetty = new Server(port);
        jetty.addHandler(new WebAppContext("src/main/webapp", "/thoughtconf"));
        jetty.addHandler(SHUTDOWN_HANDLER);
    }

    public WebServer start() throws Exception {
        jetty.start();
        return this;
    }

    public void stop() {
        try {
            jetty.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        final WebServer server = new WebServer(8080);
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                server.stop();
            }
        }));
    }
}
