package controllers;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Contact;

public class InsertContact {
	public static void main(String[] args) {
		Contact contact = new Contact();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Contact Registration\n");
		
		System.out.println("Name: ");
		String name = sc.nextLine();
		System.out.println("Telephone Number: ");
		String tel = sc.nextLine();
		System.out.println("Cellphone Number: ");
		String cel = sc.nextLine();
		
		contact.setName(name);
		contact.setTel(tel);
		contact.setCel(cel);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contacts");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(contact);
		manager.getTransaction().commit();

		System.out.println("\n" + "Contact details have been successfully registered!!!");

		sc.close();
		manager.close();
	}
}
