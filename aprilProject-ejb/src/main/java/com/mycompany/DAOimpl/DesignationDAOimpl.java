/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAOimpl;

import com.mycompany.DAO.DesignationDAO;
import com.mycompany.model.entity.Designation;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.model.entity.Staff;
import java.util.ArrayList;
import javax.persistence.TypedQuery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ramen
 */
@Stateless
public class DesignationDAOimpl implements DesignationDAO{
    
    @PersistenceContext(unitName = "testDb")
    EntityManager em;
    

//    @Override
//    public Designation findOne(String position) {
//        Query query = em.createNamedQuery("Designation.findByPosition").setParameter("pos", position);
//        Designation designationList = (Designation)query.getSingleResult();
//        if(designationList.isEmpty()){
//            return null;
//        }else{
//            return designationList.get(0);
//        }
//        
//    }

    @Override
    public Designation findByPosition(String position) {
        Query query = em.createNamedQuery("Designation.findByPosition").setParameter("pos", position);
        try{
            Designation designation =  (Designation) query.getSingleResult();
            return designation;
        }catch(Exception e){
            System.out.println("No entitiy found");
            return null;
        }
    }

    @Override
    public Designation findByPositionAndSalary(String position, double salary) throws Exception{
        Query query = em.createNamedQuery("Designation.findByPositionAndSalary").setParameter("pos", position).setParameter("sal", salary);
        try{
            Designation designation = (Designation) query.getSingleResult();
            return designation;
        }catch(Exception e){
            System.out.println("No Entity Found");
            throw new Exception("No Entity Found");
        }
    }
    
    @Override
    public Designation findByPosAndSalHibernate(String position, double salary){
        System.out.println("Finding by position and salary");
        Session session = em.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Designation.class);
        criteria.add(Restrictions.like("position", position,MatchMode.EXACT))
                .add(Restrictions.eq("salary", salary));
        Designation des = (Designation) criteria.uniqueResult();
        System.out.println("Designation found: "+ des);
        return des;
    }

    @Override
    public List<Designation> getAllJobs() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
        Root<Staff> from = criteriaQuery.from(Staff.class);
        
        CriteriaQuery<Object> select = criteriaQuery.select(from);
        select.orderBy(criteriaBuilder.asc(from.get("salary")));
        TypedQuery<Object> typedQuery = em.createQuery(criteriaQuery);
        
        List<Object> resultList = typedQuery.getResultList();
        List<Designation> jobList = new ArrayList<>();
        for(Object o : resultList){
            jobList.add((Designation) o);
        }
        return jobList;
    }
    
    @Override
    public List<Designation> hibernateGetAllJobs(){
        Session session = em.unwrap(Session.class);
        Criteria cr = session.createCriteria(Designation.class);
        cr.addOrder(Order.asc("salary"));
        List result = cr.list();
        
        return result;
    }
   
}
