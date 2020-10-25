package com.wongweiye.repositoryImpl;

import com.wongweiye.repository.ExtendedRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.Converter;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExtendedRepositoryImpl<T, P extends Serializable> extends SimpleJpaRepository<T, P> implements ExtendedRepository<T, P> {


    private EntityManager entityManager;

    public ExtendedRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public ExtendedRepositoryImpl(final Class<T> entityClass, final EntityManager entityManager) {
        super(entityClass, entityManager);
        this.entityManager = entityManager;
    }

    public EntityManager getEm() {
        return entityManager;
    }

    @Override
    public TypedQuery<T> createNamedQuery(String nameQuery) {
        return getEm().createNamedQuery(nameQuery, getDomainClass());
    }

    @Override
    public TypedQuery<T> createQuery(String query) {
        return getEm().createQuery(query, getDomainClass());
    }

    @Override
    public <U> List<U> convert(List<T> list, Converter converter) {
        return null;
    }

    @Override
    public <U> U convert(T input, Converter converter) {
        return null;
    }

    @Override
    public <U> List<T> convertObject(List input, Converter converter) {
        return null;
    }

    @SuppressWarnings("rawtypes")
    public TypedQuery createQuery(String query, Class<?> type) {
        return getEm().createQuery(query, type);
    }



    protected TypedQuery<Long> countQuery(String query) {
        return getEm().createQuery(query, Long.class);
    }


    public static <T> Optional<T> findOne(final TypedQuery<T> query) {
        requireNonNull(query);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    private static <T> void requireNonNull(TypedQuery<T> query) {
    }

}
