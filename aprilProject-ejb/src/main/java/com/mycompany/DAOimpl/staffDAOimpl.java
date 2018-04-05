/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAOimpl;

import com.mycompany.DAO.DesignationDAO;
import com.mycompany.DAO.staffDAO;
import com.mycompany.model.entity.Staff;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.Query;
import com.mycompany.model.entity.Designation;
import java.util.ArrayList;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
/**
 *
 * @author ramen
 */
@Stateless
public class staffDAOimpl implements staffDAO {
    
    @PersistenceContext(unitName = "testDb")
    EntityManager entityManager;
    
    @Override
    public boolean insert(Staff staff) {
        System.out.println("Inserting to Database");
        try{
                entityManager.merge(staff);
  
            System.out.println("Done");
            return true;
        }catch(Exception e){
            System.out.println("failed");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Staff getStaff(long id) {
        try{
            return entityManager.find(Staff.class, id);
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public List<Staff> findByDesignationFK(Designation fk) {
        
        Query query = entityManager.createNamedQuery("Staff.findByDesignationFK").setParameter("desfk", fk);
        List<Staff> listOfStaff = (List<Staff>) query.getResultList();
        System.out.println("Found list of staffs" + listOfStaff);
        return listOfStaff;
    }

    @Override
    public List<Staff> getAllStaffs() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
        Root<Staff> from = criteriaQuery.from(Staff.class);
        
        CriteriaQuery<Object> select = criteriaQuery.select(from);
        select.orderBy(criteriaBuilder.asc(from.get("firstName")));
        
        TypedQuery<Object> typedQuery = entityManager.createQuery(select);
        List<Object> resultList = typedQuery.getResultList();
        
        List<Staff> staffList= new ArrayList<>();
        for(Object o : resultList){
            Staff staff = (Staff) o;
            staffList.add(staff);
        }
        
        return staffList;
    }

    @Override
    public List<Staff> hibernateGetAllStaffs() {
        Session session = entityManager.unwrap(Session.class);
        
        Criteria criteria = session.createCriteria(Staff.class);
        
        criteria.addOrder(Order.asc("firstName"));
        
        List staffs = criteria.list();
        
        return staffs;
    }
}
