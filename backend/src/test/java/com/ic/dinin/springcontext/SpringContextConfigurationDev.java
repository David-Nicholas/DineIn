package com.ic.dinin.springcontext;

import com.ic.dinin.SpringProfiles;
import com.ic.dinin.TestDataSeed;
import com.ic.dinin.infrastructure.images.service.ImageService;
import com.ic.dinin.infrastructure.images.service.LocalDiskImageHandlingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(SpringProfiles.DEV)
public class SpringContextConfigurationDev {

    @Bean
    public ImageService imageService() {
        return new LocalDiskImageHandlingService();
    }
}
