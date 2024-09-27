package net.odk.volunteerdesk_api.services;

import lombok.AllArgsConstructor;
import net.odk.volunteerdesk_api.models.User;

import net.odk.volunteerdesk_api.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

  /*  @Autowired
    private UserRepository userRepository;


    public List<Long> findAll(){return userRepository.findAll();}

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
*/
}
