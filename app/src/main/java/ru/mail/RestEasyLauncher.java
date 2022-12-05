package ru.mail;

import org.eclipse.jetty.servlet.ServletContextHandler;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import ru.mail.common.JettyServer;

public class RestEasyLauncher {
    public static void run(int port) throws Exception {
        final var server = JettyServer.build(port);

        final var context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);

        context.addServlet(HttpServletDispatcher.class, "/");
        context.addEventListener(new GuiceListener());

        server.setHandler(context);
        server.start();
    }
}
