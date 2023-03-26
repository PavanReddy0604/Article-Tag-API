package com.capstone.capstone.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.capstone.capstone.entities.Article;

public interface ArticleRepo extends CrudRepository<Article, Long> {

   
   List<Article> findByTitleContainingIgnoreCase(String title);
    

    
}
