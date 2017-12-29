package cn.et.hibernate;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.et.hibernate.dao.Food;

public class TestHibernate {
	public static void main(String[] args) {
		//saveFood();
		//queryFood();
		//deleteFood();
		updateFood();
		
	}
	/**
	 *  添加菜品
	 */
	public static void saveFood(){
		Session session = HibernateSessionFactory.getSession();
		Food food = new Food();
		food.setFoodname("土豆丝");
		food.setImagepath("/a");
		food.setPrice(10.0);
		session.getTransaction().begin();
		session.save(food);
		session.getTransaction().commit();
	}
	/**
	 * 删除菜品
	 */
	public static void deleteFood(){
		Session session = HibernateSessionFactory.getSession();
		Food food = new Food();
		food.setFoodid(12);
		session.getTransaction().begin();
		session.delete(food);
		session.getTransaction().commit();
	}
	/**
	 * 查询菜品
	 */
	public static void queryFood(){
		Session session = HibernateSessionFactory.getSession();
		Food food =(Food)session.load(Food.class, 2);
		System.out.println(food.getFoodname());
		//hsql语言
		Query query = session.createQuery("from Food where foodname like :aaaaaa");
		query.setString("aaaaaa", "%烤%");
		List<Food> foodList = query.list();
		System.out.println(foodList.size());
	}
	/**
	 * 修改菜品
	 */
	public static void updateFood(){
		Session session = HibernateSessionFactory.getSession();
		Food food = new Food();
		food.setFoodid(11);
		food.setFoodname("红烧肉");
		food.setImagepath("/d");
		food.setPrice(20.0);
		session.getTransaction().begin();
		session.update(food);
		session.getTransaction().commit();
	}
}
