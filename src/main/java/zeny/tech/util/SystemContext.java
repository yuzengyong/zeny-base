package zeny.tech.util;

import zeny.tech.model.User;

public class SystemContext {
	
	public static ThreadLocal<User> threadLocal = new ThreadLocal<User>();
	
	public static void setUser(User user){
		threadLocal.set(user);
	}
	
	public static User getCurrentUser(){
		return threadLocal.get();
	}
	
	public static void removeUser(){
		if(getCurrentUser() != null){
			threadLocal.remove();
		}
	}

}
