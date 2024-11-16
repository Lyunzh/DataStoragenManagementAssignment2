package org.example.etl.qAction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/***
 * 提供SessionFactory open() close()方法，私有化构造方式
 */



public class SessionFactoryUtil {

    private static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();

    private static SessionFactory sessionFactory;

    private SessionFactoryUtil(){};

    static{
        Configuration configure = new Configuration().configure();
        sessionFactory=configure.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static Session openSession(){
        Session session=threadLocal.get();
        if(session==null){
            session=sessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
    }

    public static void closeSession(){
        Session session=threadLocal.get();
        if(session==null){
            if(session.isOpen()){
                session.close();
            }
            threadLocal.set(null);
        }
    }

}
