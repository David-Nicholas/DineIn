package com.ic.dinin.infrastructure;

import jakarta.persistence.EntityManager;

public interface JpaCallback<T> {

    T execute(EntityManager em);
}
