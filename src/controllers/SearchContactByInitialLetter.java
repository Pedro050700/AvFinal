package controllers;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Contact;

public class SearchContactByInitialLetter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contacts");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println("Search...");
		System.out.println("Inform the initial letter you wish to find:");
		String initialName = sc.nextLine();
		
		String sql = "SELECT CONTATO FROM Contato AS CONTATO WHERE NOME LIKE'" + initialName + "%'";
		
		Query query = manager.createQuery(sql);
		
		@SuppressWarnings("unchecked")
		List<Contact> contacts = query.getResultList();
		
		System.out.println("\n=== Contact List ===");
		for (Contact contact : contacts) {
			System.out.println("Name: " + contact.getName() + "\nTel: " + contact.getTel() + "\nCel: " + contact.getCel() + "\n--");
		}
		
		sc.close();
		manager.close();
	}

}
