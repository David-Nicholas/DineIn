package com.ic.dinin.springcontext;

import com.ic.dinin.SpringProfiles;
import com.ic.dinin.TestDataSeed;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(SpringProfiles.DEV)
public class SpringContextConfigurationDev {

    @Bean
    public TestDataSeed testDataSeed() {
        return new TestDataSeed();
    }
}
