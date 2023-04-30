package com.map;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapClass {

    public static void main(String[] args) {

        //get session factory
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        //creating question
        Question question = new Question();

        question.setQuestionId(123);
        question.setQuestion("What is Java?");

        //creating answer
        Answer answer = new Answer();

        answer.setAnswerId(003);
        answer.setAnswer("Java is a Object-Oriented-Programming Language.");
        answer.setQue(question);

        //creating another answer
        Answer answer1 = new Answer();

        answer1.setAnswerId(5476);
        answer1.setAnswer("Java is a platform independent language.");
        answer1.setQue(question);

        //creating another answer
        Answer answer2 = new Answer();

        answer2.setAnswerId(545);
        answer2.setAnswer("Using java we can develop softwares.");
        answer2.setQue(question);

        //answer list
        List<Answer> list = new ArrayList<>();
        list.add(answer);
        list.add(answer1);
        list.add(answer2);

        question.setAnswers(list);

        //sesion
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        //saving data into database
        session.save(question);
        session.save(answer);
        session.save(answer1);
        session.save(answer2);

        tx.commit();

        //fetching data
        Question q = (Question) session.get(Question.class, 123);

        List<Answer> ans = q.getAnswers();

        System.out.println(q.getQuestion());

        for (Answer a : ans) {
            System.out.println(a.getAnswer());
        }

        //another way
//        for (Answer ans1 : q.getAnswers()) {
//            System.out.println(ans1.getAnswer());
//        }
        session.close();
        sessionFactory.close();
    }
}
