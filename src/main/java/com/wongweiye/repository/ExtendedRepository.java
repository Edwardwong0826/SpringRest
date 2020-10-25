package com.wongweiye.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.Converter;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;
@NoRepositoryBean
public interface ExtendedRepository<T, P extends Serializable> extends JpaRepository<T, P> {
    TypedQuery<T> createNamedQuery(String nameQuery);

    TypedQuery<T> createQuery(String query);

    <U> List<U> convert(List<T> list, Converter converter);

    <U> U convert(T input, Converter converter);

    <U> List<T> convertObject(List input, Converter converter);

}
