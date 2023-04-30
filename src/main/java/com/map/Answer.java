package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {

    @Id
    @Column(name = "answer_id")
    private int answerId;
    private String answer;

    @ManyToOne
    private Question que;

    public Answer() {
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question getQue() {
        return que;
    }

    public void setQue(Question que) {
        this.que = que;
    }
}
