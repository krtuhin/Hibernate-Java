package com.cascade;

import com.map.Answer;
import com.map.Question;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CascadeExample {

    public static void main(String[] args) {
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();

        Question question = new Question();
        question.setQuestionId(5534);
        question.setQuestion("What is Hibernate?");

        Answer answer = new Answer();
        answer.setAnswerId(83967);
        answer.setAnswer("Java Database framework.");

        Answer answer1 = new Answer();
        answer1.setAnswerId(376);
        answer1.setAnswer("We can use this with any java application.");

        List<Answer> answers = new ArrayList<>();
        answers.add(answer);
        answers.add(answer1);

        question.setAnswers(answers);

        Transaction tx = s.beginTransaction();
        s.save(question);

        //when we use cascade we don't need to save answers manually
//        s.save(answer);
//        s.save(answer1);
        tx.commit();

        s.close();
        f.close();
    }
}
