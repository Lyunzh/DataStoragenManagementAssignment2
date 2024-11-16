package org.example.etl;

import java.io.*;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.etl.Entity.AmazonTime;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.spi.MetamodelImplementor;
import org.hibernate.query.Query;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // 从SessionFactory中获取Session
        Session session = sessionFactory.openSession();

        try {
            // 开启事务
            session.beginTransaction();

            // 使用CriteriaBuilder和CriteriaQuery构建查询
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<AmazonTime> query = criteriaBuilder.createQuery(AmazonTime.class);
            Root<AmazonTime> root = query.from(AmazonTime.class);
            query.select(root).where(criteriaBuilder.equal(root.get("asin"),"6303341217"));
            Query<AmazonTime> iquery = session.createQuery(query);
            AmazonTime amazonTime = iquery.uniqueResult();

            // 输出查询结果
            if (amazonTime != null) {
                System.out.println("ASIN: " + amazonTime.getAsin());
                System.out.println("Time: " + amazonTime.getTime());
            } else {
                System.out.println("No AmazonTime found for the given ASIN.");
            }

            // 提交事务
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            // 关闭Session
            session.close();
            // 关闭SessionFactory
            sessionFactory.close();
        }
    }

    public void destroy() {
    }
}