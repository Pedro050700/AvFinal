package controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Contact;

public class SearchAllOfTheContacts {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contacts");
		EntityManager manager = factory.createEntityManager();
		
		String sql = "select contact from Contact as contact";
		
		Query query = manager.createQuery(sql);
		
		@SuppressWarnings("unchecked")
		List<Contact> contacts = query.getResultList();
		
		System.out.println("\n=== Contact List ===");
		for (Contact contact : contacts) {
			System.out.println("Nome: " + contact.getName() + "\nTel: " + contact.getTel() + "\nCel: " + contact.getCel() + "\n--");
		}
		
		manager.close();
	}
}
