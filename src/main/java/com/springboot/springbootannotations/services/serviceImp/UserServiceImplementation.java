package com.springboot.springbootannotations.services.serviceImp;

import com.springboot.springbootannotations.Respository.UserRepository;
import com.springboot.springbootannotations.entity.User;
import com.springboot.springbootannotations.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {

    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {

      Optional<User>  optionalUser =userRepository.findById(id);
      return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User exitUser=userRepository.findById(user.getId()).get();
        exitUser.setFirstName(user.getFirstName());
        exitUser.setLastName(user.getLastName());
        exitUser.setEmail(user.getEmail());
        User updatedUser=userRepository.save(exitUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
