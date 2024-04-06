package com.ic.dinin;

import com.ic.dinin.infrastructure.JpaHelper;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(SpringProfiles.TEST_DATA_SEED)
public class TestDataSeed {

    @PersistenceUnit
    private EntityManagerFactory emf;

    public TestDataSeed() {
    }

    @PostConstruct
    public void createTestData(){

        new JpaHelper(emf).doTransaction(em -> {
            TestDataCreator.createRestaurantsData(em);
        });
    }

}
