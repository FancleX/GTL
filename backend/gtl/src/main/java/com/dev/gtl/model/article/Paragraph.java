package com.dev.gtl.model.article;

public class Paragraph {
    
    private String subHeader;
    private String content;

    public Paragraph(String subHeader, String content) {
        this.subHeader = subHeader;
        this.content = content;
    }

    public String getSubHeader() {
        return this.subHeader;
    }

    public void setSubHeader(String subHeader) {
        this.subHeader = subHeader;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "{" +
            " subHeader='" + getSubHeader() + "'" +
            ", content='" + getContent() + "'" +
            "}";
    }

}
