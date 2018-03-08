package org.babyfind.dao;

import org.babyfind.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
	public User selectByPrimaryKey(int userId);
}
