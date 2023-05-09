package com.pvlstkv.telephone_exchange;

import com.pvlstkv.telephone_exchange.model.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(
            RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(City.class);
        config.exposeIdsFor(Subscriber.class);
        config.exposeIdsFor(District.class);
        config.exposeIdsFor(TelephoneExchange.class);
        config.exposeIdsFor(PhoneNumber.class);
    }
}
