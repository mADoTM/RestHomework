package ru.mail;

import com.google.inject.AbstractModule;
import ru.mail.api.CompanyRest;
import ru.mail.api.HelpRest;
import ru.mail.api.ProductRest;
import ru.mail.common.JacksonMessageBodyHandler;
import ru.mail.common.ObjectMapperProvider;
import ru.mail.dao.CompanyDAO;
import ru.mail.dao.DataService;
import ru.mail.dao.ProductDAO;

public class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(JacksonMessageBodyHandler.class).toInstance(new JacksonMessageBodyHandler());
        bind(ObjectMapperProvider.class).toInstance(new ObjectMapperProvider());
        bind(HelpRest.class);
        bind(CompanyDAO.class);
        bind(ProductDAO.class);
        bind(DataService.class);
        bind(CompanyRest.class);
        bind(ProductRest.class);
    }
}
