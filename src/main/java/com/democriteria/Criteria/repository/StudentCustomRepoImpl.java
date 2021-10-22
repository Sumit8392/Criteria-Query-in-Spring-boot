package com.democriteria.Criteria.repository;

import com.democriteria.Criteria.entitiy.Student;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class StudentCustomRepoImpl implements StudentCustomRepo {

@Autowired
private EntityManager entityManager;

@Override
public List<Student> findName(String name){
    CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
    CriteriaQuery criteriaQuery=criteriaBuilder.createQuery(Student.class);
    Root<Student> studentRoot= criteriaQuery.from((Student.class));

    Predicate namePredicate=criteriaBuilder.equal(studentRoot.get("name"),name);
    criteriaQuery.where(namePredicate);
    TypedQuery<Student> query=entityManager.createQuery(criteriaQuery);
    return query.getResultList();
}

    @Override
    public List<Student> likeBy(String name){
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery=criteriaBuilder.createQuery(Student.class);

        Root<Student> studentRoot=criteriaQuery.from(Student.class);
        criteriaQuery.select(studentRoot);
        Predicate predicate=criteriaBuilder.like(studentRoot.get("name"),"%d%");
        criteriaQuery.where(predicate);
        TypedQuery<Student> typedQuery=entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();

    }
    @Override
    public List<Student> findNameAsc() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Student.class);

        Root<Student> studentRoot = criteriaQuery.from(Student.class);

        criteriaQuery.orderBy(criteriaBuilder.asc(studentRoot.get("name")));

        List<Student> students = entityManager.createQuery(criteriaQuery).getResultList();
        return students;
    }

    @Override
    public List<Student> getStudents(int id) {

        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery= criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot =criteriaQuery.from(Student.class);
        criteriaQuery.select((studentRoot));
        criteriaQuery.where(criteriaBuilder.equal(studentRoot.get("id"),id));

        TypedQuery<Student> typedQuery=entityManager.createQuery(criteriaQuery);
        List<Student> studentList=typedQuery.getResultList();
        return studentList;





    }



}
