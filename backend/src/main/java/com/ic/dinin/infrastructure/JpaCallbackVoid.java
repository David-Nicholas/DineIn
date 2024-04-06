package com.ic.dinin.infrastructure;

import jakarta.persistence.EntityManager;

public interface JpaCallbackVoid {
    void execute(EntityManager em);
}
