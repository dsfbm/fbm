package Text;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;


public class text01 {
    @Test
    public void test() {
        Configuration conf = new Configuration().configure();

        SessionFactory sessionFactory = conf.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        // ③ 使用session
        //通过 ID 查找一个user对象
        TUserEntity user = session.get(TUserEntity.class, 1);
        System.out.println(user.getClass());


    }

}

