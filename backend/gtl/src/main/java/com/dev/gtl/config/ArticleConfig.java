package com.dev.gtl.config;

import java.util.List;

import javax.transaction.Transactional;

import com.dev.gtl.model.article.Article;
import com.dev.gtl.model.article.Comment;
import com.dev.gtl.model.article.Paragraph;
import com.dev.gtl.model.article.Question;
import com.dev.gtl.repository.ArticleRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ArticleConfig {
    
    @Bean
    @Transactional
    CommandLineRunner commandLineRunner(ArticleRepository articleRepository) {
        return args -> {
            Article a1 = new Article();
            a1.setHeader("Set");
            Paragraph p1 = new Paragraph();
            p1.setOrder(1);
            p1.setSubHeader("set");
            p1.setContent("dasfasdgdsgadsg");
            a1.setParagraphs(List.of(p1));
            Question q1 = new Question();
            q1.setDescription("dsafdsgvcx");
            q1.setAnswer("dfasdfcvxcv");
            q1.setDescription("cxvxvzxc");
            a1.setQuestions(List.of(q1));
            Comment c1 = new Comment();
            c1.setMessage("dfzvcvxcvz");
            a1.setComments(List.of(c1));

            // Article a2 = new Article("dafdasf", List.of(p1), List.of(q1), List.of(c1));
            articleRepository.save(a1);

        };
    }
}
