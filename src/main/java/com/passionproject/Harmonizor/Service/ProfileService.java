package com.passionproject.Harmonizor.Service;

import com.passionproject.Harmonizor.Model.Profile;
import com.passionproject.Harmonizor.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public Profile create(Profile profile) {
        return profileRepository.save(profile);
    }


}
