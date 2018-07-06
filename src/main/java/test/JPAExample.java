/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import guest.Guest;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author user 
 */
public class JPAExample {

  private EntityManager entityManager = EntityManagerUtil.getEntityManager();

  public static void main(String[] args) {
    JPAExample example = new JPAExample();
    example.listStudent();
   

  }

  public void listStudent() {
    try {
      entityManager.getTransaction().begin();
      if("1".equalsIgnoreCase("1"))
                  return;
      
      @SuppressWarnings("unchecked")
      List<Guest> guests = entityManager.createQuery("from Guest").getResultList();
      for (Iterator<Guest> iterator = guests.iterator(); iterator.hasNext();) {
        Guest guest = (Guest) iterator.next();
        System.out.println(guest.toString());
      }
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      entityManager.getTransaction().rollback();
    }
  }    
}
