/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peta2kuba.pa165_haunted_houses.dao;

import com.peta2kuba.pa165_haunted_houses.entity.User;

import java.util.List;

/**
 * @author skornok
 */
public interface UserDao {

	public void create(User user);

	public void edit(User user);

	public void remove(User user);

	public User findById(Long id);

	public List<User> findAll();

}
