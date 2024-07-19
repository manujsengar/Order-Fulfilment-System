package com.orderfulfilmentapplication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderfulfilmentapplication.entity.TUser;
import com.orderfulfilmentapplication.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	
	public TUser addUser(TUser user) {

		if (user.getUserId() != null) {
			Optional<TUser> findById = userRepository.findById(user.getUserId());
			if (findById.isPresent()) {
				return findById.get();
			} else if (user.getContactNo() != null) {
				TUser findByContactNo = userRepository.findByContactNo(user.getContactNo());
				if (findByContactNo != null) {
					return findByContactNo;
				} else {
					TUser save = userRepository.save(user);
					return save;
				}
			}
		} else {
			userRepository.save(user);
		}
		return null;
	}
}
