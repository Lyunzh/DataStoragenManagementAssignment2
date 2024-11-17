package org.example.etl.qAction;


import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jakarta.validation.Configuration;
import org.hibernate.Session;
import org.example.etl.Entity.*;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class MovieQuery {

    public static List<OriginalMovie> queryByName(String name){

        Session session = SessionFactoryUtil.openSession();
        try{
            CriteriaBuilder cb = session.getCriteriaBuilder();
            //主查询
            CriteriaQuery<OriginalMovie> original_Movie_Q = cb.createQuery(OriginalMovie.class);
            Root<OriginalMovie> root = original_Movie_Q.from(OriginalMovie.class);
            //根据电影名进行子查询
            Subquery<String> subQ = original_Movie_Q.subquery(String.class);
            Root<MovieDatasource> subRoot = subQ.from(MovieDatasource.class);
            //通过名字查询
            subQ.select(subRoot.get("id").get("asin")).where(cb.equal(subRoot.get("id").get("movieName"), name));
            Predicate predicate = cb.in(root.get("asin")).value(subQ);
            //返回主查询
            original_Movie_Q.where(predicate);
            List<OriginalMovie> result = session.createQuery(original_Movie_Q).getResultList();
            System.out.println(result.toString());
            return result;
        }
        finally{
            SessionFactoryUtil.closeSession();
        }
    }


    public static List<MergeMovie> queryByActor(String actor){

        Session session = SessionFactoryUtil.openSession();
        try{
            CriteriaBuilder cb = session.getCriteriaBuilder();
            //主查询
            CriteriaQuery<MergeMovie> mergeMovie_Q = cb.createQuery(MergeMovie.class);
            Root<MergeMovie> root = mergeMovie_Q.from(MergeMovie.class);
            //子查询
            Subquery<String> subQ = mergeMovie_Q.subquery(String.class);
            Root<MergeAct> subRoot = subQ.from(MergeAct.class);
            //通过演员查询
            subQ.select(subRoot.get("id").get("movieName")).where(cb.equal(subRoot.get("id").get("actorName"), actor));
            Predicate predicate = cb.in(root.get("movieName")).value(subQ);
            //返回主查询
            mergeMovie_Q.where(predicate);
            List<MergeMovie> result = session.createQuery(mergeMovie_Q).getResultList();
            return result;
        }
        finally{
            SessionFactoryUtil.closeSession();
        }
    }

    public static List<MergeMovie> queryByDirector(String director){
        Session session = SessionFactoryUtil.openSession();
        try{
            CriteriaBuilder cb = session.getCriteriaBuilder();
            //主查询
            CriteriaQuery<MergeMovie> mergeMovie_Q = cb.createQuery(MergeMovie.class);
            Root<MergeMovie> root = mergeMovie_Q.from(MergeMovie.class);
            //子查询
            Subquery<String> subQ = mergeMovie_Q.subquery(String.class);
            Root<MergeDirect> subRoot = subQ.from(MergeDirect.class);
            //通过导演查询
            subQ.select(subRoot.get("id").get("movieName")).where(cb.equal(subRoot.get("id").get("directorName"), director));
            Predicate predicate = cb.in(root.get("movieName")).value(subQ);
            //返回主查询
            mergeMovie_Q.where(predicate);
            List<MergeMovie> result = session.createQuery(mergeMovie_Q).getResultList();
            return result;
        }
        finally{
            SessionFactoryUtil.closeSession();
        }
    }

    public static List<MergeMovie> queryBymonth(String Year, String Month){
        Session session = SessionFactoryUtil.openSession();
        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<MergeMovie> mergeMovie_Q = cb.createQuery(MergeMovie.class);
            Root<MergeMovie> root = mergeMovie_Q.from(MergeMovie.class);
            Integer iyear = Integer.parseInt(Year);
            Integer imonth = Integer.parseInt(Month);
            LocalDate startOfMonth = LocalDate.of(iyear, imonth, 1);
            LocalDate endOfMonth = startOfMonth.plusMonths(1);
            Predicate startPred = cb.greaterThanOrEqualTo(root.get("RELEASE_TIME"), startOfMonth);
            Predicate endPred = cb.lessThan(root.get("RELEASE_TIME"), endOfMonth);
            mergeMovie_Q.where(startPred, endPred);
            List<MergeMovie> result = session.createQuery(mergeMovie_Q).getResultList();
            return result;
        }
        finally{
            SessionFactoryUtil.closeSession();
        }
    }
    public static List<MergeMovie> queryByTime(String Year){
        Session session = SessionFactoryUtil.openSession();
        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<MergeMovie> mergeMovie_Q = cb.createQuery(MergeMovie.class);
            Root<MergeMovie> root = mergeMovie_Q.from(MergeMovie.class);
            Integer iyear = Integer.parseInt(Year);
            LocalDate startOfMonth = LocalDate.of(iyear, 1, 1);
            LocalDate endOfMonth = startOfMonth.plusYears(1);
            Predicate startPred = cb.greaterThanOrEqualTo(root.get("RELEASE_TIME"), startOfMonth);
            Predicate endPred = cb.lessThan(root.get("RELEASE_TIME"), endOfMonth);
            mergeMovie_Q.where(startPred, endPred);
            List<MergeMovie> result = session.createQuery(mergeMovie_Q).getResultList();
            return result;
        }
        finally{
            SessionFactoryUtil.closeSession();
        }
    }


    public static List<MovieAvgScore> queryByScoregt(String Score) {
        Session session = SessionFactoryUtil.openSession();
        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<MovieAvgScore> query = cb.createQuery(MovieAvgScore.class);
            Root<MovieAvgScore> root = query.from(MovieAvgScore.class);
            Predicate predicate = cb.greaterThanOrEqualTo(root.get("AVG_SCORE"), Score);
            query.where(predicate);
            List<MovieAvgScore> result = session.createQuery(query).getResultList();
            return result;
        } finally {
            SessionFactoryUtil.closeSession();
        }
    }

    public static List<MovieAvgScore> queryByScorelt(String Score) {
        Session session = SessionFactoryUtil.openSession();
        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<MovieAvgScore> query = cb.createQuery(MovieAvgScore.class);
            Root<MovieAvgScore> root = query.from(MovieAvgScore.class);
            Predicate predicate = cb.lessThanOrEqualTo(root.get("AVG_SCORE"), Score);
            query.where(predicate);
            List<MovieAvgScore> result = session.createQuery(query).getResultList();
            return result;
        } finally {
            SessionFactoryUtil.closeSession();
        }
    }









}
