package com.capstone.capstone.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.capstone.dto.ArticleDTO;
import com.capstone.capstone.entities.Article;
import com.capstone.capstone.entities.Tag;
import com.capstone.capstone.repositories.ArticleRepo;

// @Service
// public class ArticleService {

//     @Autowired
//      private ArticleRepo ar;
    

//     //Article to ArticleDto
//     public ArticleDTO articleToArticalDto(Article article)
//     {
//         ArticleDTO articledto = new ArticleDTO();
// 		articledto.setTitle(article.getTitle());
// 		articledto.setContent(article.getContent());


// 		List<String> list = new ArrayList<>();
// 		List<Tag> tags = article.getTags();
// 		for (Tag a : tags) {
// 			list.add(a.getTag());
// 		}

// 		articledto.setTags(list);
// 		return articledto;
//     }


//     // public Article articleDtoToArticle(ArticleDTO articleDTO)
//     // {
//     //     Article article = new Article();
//     //     article.setContent(articleDTO.getContent());
//     //     article.setTitle(articleDTO.getTitle());
//     //     List<Tag> tags = new ArrayList<>();
//     //     List<String> list = articleDTO.getTags();
//     //     for(String s : list)
//     //     {
//     //         tags.add(s.get)
//     //     }

//     // }

//     //find by id 
//     //  public Optional<ArticleDTO> findById(Long id)
//     // {
//     //     Optional<Article> findById = ar.findById(id);
//     //   // articleToArticalDto(findById);

//     //     // if(findById.isEmpty())
//     //     // {findById=null;

//     //     // throw new RuntimeException("article is not present");
//     //     // }
//     //     return findById;

//     // }

//     @Transactional
//     public void save()
//     {}
    
// }
