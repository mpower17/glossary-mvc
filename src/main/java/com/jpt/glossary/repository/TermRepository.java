package com.jpt.glossary.repository;

import com.jpt.glossary.model.Term;
import org.springframework.data.repository.CrudRepository;

import javax.annotation.Nonnull;

public interface TermRepository extends CrudRepository<Term, String> {

    @Override
    void delete(@Nonnull Term term);

    @Override
    @Nonnull
    <S extends Term> Iterable<S> saveAll(@Nonnull Iterable<S> entities);
}