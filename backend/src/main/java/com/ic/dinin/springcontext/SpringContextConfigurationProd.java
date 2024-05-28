package com.ic.dinin.springcontext;

import com.ic.dinin.SpringProfiles;
import com.ic.dinin.infrastructure.images.service.AwsS3ImageHandlingService;
import com.ic.dinin.infrastructure.images.service.ImageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.security.KeyStore;
import java.security.KeyStoreException;

@Configuration
@Profile(SpringProfiles.PROD)
public class SpringContextConfigurationProd {

    @Bean
    public ImageService imageService() {
        return new AwsS3ImageHandlingService();
    }

}
