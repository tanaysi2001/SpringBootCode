package com.example.JPARelationshipDemo.controller;


import com.example.JPARelationshipDemo.model.Profile;
import com.example.JPARelationshipDemo.model.User;
import com.example.JPARelationshipDemo.service.ProfileService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private ProfileService profileService;

    public ProfileController(ProfileService profileService){
        this.profileService=profileService;
    }

    @PostMapping()
    public ResponseEntity<String> createProfile(@RequestBody Profile profile){
        profileService.createProfile(profile);

        return ResponseEntity.status(HttpStatus.CREATED).body("Profile created...");
    }

    @PostMapping("/-user")
    public ResponseEntity<String> createProfile(@RequestBody Profile profile,@RequestParam String userName){
        profileService.createProfile(profile,userName);

        return ResponseEntity.status(HttpStatus.CREATED).body("Profile created...");
    }
}
