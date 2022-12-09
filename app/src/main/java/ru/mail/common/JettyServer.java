package ru.mail.common;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

public class JettyServer {
    public static Server build(int port) {
        final var server = new Server();
        final var serverConnector = new ServerConnector(server, new HttpConnectionFactory());
        serverConnector.setHost("localhost");
        serverConnector.setPort(port);
        server.setConnectors(new Connector[]{serverConnector});
        return server;
    }

    public static Server build() {
        return build(3466);
    }
}
