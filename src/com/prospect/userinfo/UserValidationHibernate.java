package com.prospect.userinfo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;

public class UserValidationHibernate {

	
	
		public static boolean isValidHibernate(User user)
		{
			
			SessionFactory sessionFactory;
				final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
				System.out.println("2");
				try{
					sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
					//sessionFactory = new Configuration().configure().buildSessionFactory();
					Session session = sessionFactory.openSession();
					System.out.println("3");
					boolean userExists=getUser(session,user);
					System.out.println(userExists);
					
					System.out.println("3");
					if(!userExists)
					{	
						System.out.println("4");
						saveUser(session,user);
						System.out.println("5");
						return false;
						
					}
				
				}
		
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
				
				return true;
				
		}
		
		
		private static boolean getUser(Session session, User user) {
			System.out.println("7");
			User user1 = session.get(User.class, user.getUserName());
			if(user1 != null){
			
				return true;
				//System.out.println("Username : "+user.getUsername()+" | Password: "+user.getPassword()+" | Firstname : "+user.getFirstname()+" | Lastname : "+user.getLastname());
			}
			return false;
		}
	
		private static void saveUser(Session session, User user) {
			System.out.println("8");
			Transaction tx = session.beginTransaction();
			
			session.save(user);
			
			tx.commit();
		}
		
		
}
