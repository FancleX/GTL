package com.dev.gtl.article;

import java.util.List;

public class Article {
    
    private String header;
    private Paragraph paragraphs;
    private List<String> discussions;



    public Article(String header, Paragraph paragraphs, List<String> discussions) {
        this.header = header;
        this.paragraphs = paragraphs;
        this.discussions = discussions;
    }



    
}
