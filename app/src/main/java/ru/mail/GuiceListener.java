package ru.mail;

import com.google.inject.Module;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;
import org.jetbrains.annotations.NotNull;

import javax.servlet.ServletContext;
import java.util.Collections;
import java.util.List;

public class GuiceListener extends GuiceResteasyBootstrapServletContextListener {
    @Override
    protected @NotNull List<? extends Module> getModules(ServletContext context) {
        return Collections.singletonList(new GuiceModule());
    }
}
