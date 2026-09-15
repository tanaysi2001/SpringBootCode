package com.example.JPARelationshipDemo.service;

import com.example.JPARelationshipDemo.model.Profile;
import com.example.JPARelationshipDemo.model.User;
import com.example.JPARelationshipDemo.repository.ProfileRepository;
import com.example.JPARelationshipDemo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private ProfileRepository profileRepository;

    public UserService(UserRepository userRepository,ProfileRepository profileRepository){

        this.userRepository=userRepository;
        this.profileRepository=profileRepository;
    }

    @Transactional
    public void createUser(User user,String bio){
        Profile profile=new Profile();

        profile.setBio(bio);
        profileRepository.save(profile);
        user.setProfile(profile);
        userRepository.save(user);

    }
}
