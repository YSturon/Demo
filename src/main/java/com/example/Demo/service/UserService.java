package com.example.Demo.service;

import com.example.Demo.repository.User;
import com.example.Demo.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	public List<User> helloWorld(){
		return userRepository.findAll();
	}
	public User create(User user){
		Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
		if(optionalUser.isPresent()){
			throw new IllegalStateException("юзер с таким мылом уже есть");
		}
		user.setAge(Period.between(user.getBirth(), LocalDate.now()).getYears());
		return userRepository.save(user);
	}
}
