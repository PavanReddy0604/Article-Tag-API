package com.capstone.capstone.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.capstone.dto.ArticleDTO;
import com.capstone.capstone.entities.Article;
import com.capstone.capstone.entities.Tag;
import com.capstone.capstone.repositories.ArticleRepo;

@Service

public class ArticleServ {

    @Autowired
    private ArticleRepo articleRepo;
  

  
    
    // @Value("${articles.blacklist}")
    // private String[] blacklist;

    public Optional<ArticleDTO> findById(Long id) {
        Optional<Article> article = articleRepo.findById(id);
        if (article.isPresent()) {
            return Optional.of(articleToArticleDTO(article.get()));
        } else {
            return Optional.empty();
        }
    }

    public List<ArticleDTO> findByTitle(String title) {
        List<Article> articles = articleRepo.findByTitleContainingIgnoreCase(title);
        return articles.stream()
                .map(this::articleToArticleDTO)
                .collect(Collectors.toList());
    }
    

    private ArticleDTO articleToArticleDTO(Article article) {
        List<String> tagNames = article.getTags().stream()
                .map(Tag::getTag)
                .collect(Collectors.toList());
       // return new ArticleDTO(article.getTitle(), article.getContent(), tagNames);
       ArticleDTO ad = new ArticleDTO();
       ad.setTitle(article.getTitle());
       ad.setContent(article.getContent());
       ad.setTags(tagNames);
// return new ArticleDTO(article.getTitle(), article.getContent(), tagNames);
return ad;
    }

    private Article articleDTOToArticle(ArticleDTO articleDTO) {
        List<Tag> tags = articleDTO.getTags().stream()
                .map(tagName -> new Tag(tagName, null))
                .collect(Collectors.toList());
        return new Article(null, articleDTO.getTitle(), articleDTO.getContent(), tags);
    }

   
    @Transactional
    public void deleteById(Long id) {
        articleRepo.deleteById(id);

    }
    @Transactional
    public Long create(ArticleDTO articleDTO) {
        // String content = articleDTO.getContent();
        // if (containsBlacklistWords(content)) {
        //     throw new RuntimeException("Article content contains forbidden words.");
        // }
        Article article = articleDTOToArticle(articleDTO);
        article = articleRepo.save(article);
        return article.getId();
    }
    @Transactional
    public void update(Long id, ArticleDTO articleDTO) {
         String content = articleDTO.getContent();
        // if (containsBlacklistWords(content)) {
        //     throw new RuntimeException("Article content contains forbidden words.");
        // }
        Optional<Article> optionalArticle = articleRepo.findById(id);
        if (optionalArticle.isPresent()) {
            Article article = optionalArticle.get();
            article.setTitle(articleDTO.getTitle());
            article.setContent(content);
            List<Tag> tags = article.getTags();
            tags.clear();
            for (String tag : articleDTO.getTags()) {
                tags.add(new Tag(tag, article));
            }
            articleRepo.save(article);
        } else {
            throw new RuntimeException("Article not found");
        }
    }

    //private boolean containsBlacklistWords(String content) {
        // if (content == null || content.isEmpty()) {
        //     return false;
        // }
        // for (String word : blacklist) {
        //     if (content.contains(word)) {
        //         return true;
        //     }
        // }
        // return false;
    }


