package com.jpt.glossary.repository;

import com.jpt.glossary.model.Term;
import org.springframework.data.repository.CrudRepository;

public interface TermRepository extends CrudRepository<Term, String> {
    
    @Override
    void delete(Term term);

    @Override
    <S extends Term> Iterable<S> saveAll(Iterable<S> entities);
}