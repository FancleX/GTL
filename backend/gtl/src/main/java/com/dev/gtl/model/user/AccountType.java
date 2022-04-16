package com.dev.gtl.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public enum AccountType {
    
    ADMIN {
        @Override
        public String toString() {
            return "ADMIN";
        }
    },
    NORMAL {
        @Override
        public String toString() {
            return "NORMAL";
        }
    };

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
