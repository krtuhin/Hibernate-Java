package com.map;

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

        //object of question
        Question question = new Question();

        question.setQuestionId(123);
        question.setQuestion("What is Java?");

        Answer answer = new Answer();

        answer.setAnswerId(003);
        answer.setAnswer("Java is a Object-Oriented-Programming Language.");
        answer.setQue(question);

        question.setAns(answer);

        //another uestion
        Question question1 = new Question();

        question1.setQuestionId(228);
        question1.setQuestion("What is Object?");

        Answer answer1 = new Answer();

        answer1.setAnswerId(546);
        answer1.setAnswer("Object is instance of a class.");
        answer1.setQue(question1);

        question1.setAns(answer1);

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        session.save(question);
        session.save(question1);
        session.save(answer);
        session.save(answer1);

        tx.commit();

        //fetching data
        Question q = (Question) session.get(Question.class, 228);

        System.out.println(q.getQuestion() + "\n" + q.getAns().getAnswer());

        session.close();
        sessionFactory.close();
    }
}
