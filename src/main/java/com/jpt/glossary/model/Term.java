package com.jpt.glossary.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "terms")
public class Term {
    @Id
    String id;
    String termName;
    String termDesc;

    public Term() {
    }

    public Term(String termName, String termDesc) {
        this.termName = termName;
        this.termDesc = termDesc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public String getTermDesc() {
        return termDesc;
    }

    public void setTermDesc(String termDesc) {
        this.termDesc = termDesc;
    }
}
