package com.dev.gtl.config;

import com.dev.gtl.model.article.Article;
import com.dev.gtl.model.article.Paragraph;
import com.dev.gtl.repository.ArticleRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArticleConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(ArticleRepository articleRepository) {
        return args -> {
            Article a1 = new Article("set", new Paragraph("subHeader", "content"), null);
        };
    }
}
