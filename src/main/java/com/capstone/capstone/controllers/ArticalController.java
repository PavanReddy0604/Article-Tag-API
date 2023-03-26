package com.capstone.capstone.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.capstone.dto.ArticleDTO;
import com.capstone.capstone.services.ArticleServ;


@RestController
@RequestMapping("/articles")
public class ArticalController {

    @Autowired
    private ArticleServ articleService;

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getArticleById(@PathVariable Long id) {
        Optional<ArticleDTO> articleDto = articleService.findById(id);
        if (articleDto.isPresent()) {
            return ResponseEntity.ok(articleDto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<ArticleDTO>> getByTitle(@PathVariable String title) {
        return ResponseEntity.ok().body(articleService.findByTitle(title));
    }

    @PostMapping
    public ResponseEntity<Long> createArticle(@RequestBody ArticleDTO articleDto) {
       Long id= articleService.create(articleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateArticle(@PathVariable Long id, @RequestBody ArticleDTO articleDto) {
       try{
        articleService.update(id, articleDto);

            return ResponseEntity.ok().build();
       }
       catch(Exception e ){
        e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {

        try{
         articleService.deleteById(id);
        
            return ResponseEntity.noContent().build();
        }
        catch(Exception e ){
            return ResponseEntity.notFound().build();
        }
    }
}
