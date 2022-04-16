package com.dev.gtl.config;

import java.util.List;

import javax.transaction.Transactional;

import com.dev.gtl.model.article.Article;
import com.dev.gtl.model.user.Account;
import com.dev.gtl.model.user.AccountType;
import com.dev.gtl.model.user.User;
import com.dev.gtl.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    
    @Bean
    @Transactional
    CommandLineRunner commandLineRunner1(UserRepository userRepository) {
        return args -> {
            // Account account = new Account();
            // account.setAccountType(AccountType.ADMIN.toString());
            // account.setEmail("dsfdf2323f@gamil.com");
            // account.setUserName("dsafads");
            // account.setPassWord("fcvxcvvc");
            
            // User user = new User(account, List.of(new Article()));

            // userRepository.save(user);
        };
    }
}
