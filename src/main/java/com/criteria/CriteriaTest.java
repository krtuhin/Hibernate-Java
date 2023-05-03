
package com.criteria;

import com.mavenp.Student;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class CriteriaTest {
    public static void main(String[] args) {
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s  = f.openSession();
        
        //create criteria
        Criteria c = s.createCriteria(Student.class);
        
        //restriction
        //all SQL condition given as function of restriction class just call them and use
        c.add(Restrictions.eq("department", "Electrical"));
        c.add(Restrictions.like("name", "So%"));
        
        //get all the value
        List<Student> list = c.list();
        
        for(Student st:list){
            System.out.println(st.getName());
        }
        
        s.close();
        f.close();
    }
}
