package com.dev.gtl.model.article;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Article {

    @Id
    @SequenceGenerator(
        name = "article_sequence",
        sequenceName = "article_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "article_sequence"
    )
    private String header;
    private Paragraph paragraphs;
    private List<Question> problemSet;
    private List<String> comments;

    public Article(String header, Paragraph paragraphs) {
        this.header = header;
        this.paragraphs = paragraphs;
        this.problemSet = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Paragraph getParagraphs() {
        return this.paragraphs;
    }

    public List<Question> getProblemSet() {
        return this.problemSet;
    }

    public void addQuestion(Question question) {
        this.problemSet.add(question);
    }

    public List<String> getComments() {
        return this.comments;
    }

    public void addComments(String comment) {
        this.comments.add(comment);
    }    

    @Override
    public String toString() {
        return "{" +
            " header='" + getHeader() + "'" +
            ", paragraphs='" + getParagraphs() + "'" +
            ", discussions='" + getComments() + "'" +
            "}";
    }
}
