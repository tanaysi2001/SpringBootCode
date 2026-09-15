package com.example.JPARelationshipDemo.service;

import com.example.JPARelationshipDemo.model.Profile;
import com.example.JPARelationshipDemo.model.User;
import com.example.JPARelationshipDemo.repository.ProfileRepository;
import com.example.JPARelationshipDemo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private ProfileRepository profileRepository;
    private UserRepository userRepository;

    public ProfileService(ProfileRepository profileRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }

    @Transactional
    public void createProfile(Profile profile) {
        profileRepository.save(profile);
    }

    @Transactional
    public void createProfile(Profile profile, String userName) {

        User user = new User();
        user.setName(userName);

        user.setProfile(profile);
        profile.setUser(user);

        profileRepository.save(profile);
        userRepository.save(user);
    }

}
