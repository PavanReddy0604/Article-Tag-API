package com.capstone.capstone.dto;

import java.util.List;

public class ArticleDTO {

    private String title;
    private String content;
    private List<String> tags;
    public ArticleDTO() {
    }
    public ArticleDTO(String title, String content, List<String> tags) {
        this.title = title;
        this.content = content;
        this.tags = tags;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    
    
    
}
