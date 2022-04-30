package com.dev.gtl.model.article;

import java.util.List;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "article_question")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripton", columnDefinition="text")
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id", nullable = true)
    private List<QuestionOption> optionList;

    @Column(name = "answer")
    private String answer;

    @Column(name = "explaination", columnDefinition="text")
    private String explaination;
}
