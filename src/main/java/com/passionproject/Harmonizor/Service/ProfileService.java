package com.passionproject.Harmonizor.Service;

import com.passionproject.Harmonizor.Model.Profile;
import com.passionproject.Harmonizor.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public Profile create(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile findById(Long id){
        return profileRepository.findById(id).get();
    }

    public Iterable<Profile> findAll(){
        return profileRepository.findAll();
    }

    public Profile updateProfile(Long id, Profile profile){
        Profile origProfile = profileRepository.findById(id).get();
        origProfile.setCity(profile.getCity());
        origProfile.setState(profile.getState());
        origProfile.setCountry(profile.getCountry());
        origProfile.setZipcode(profile.getZipcode());
        origProfile.setInstruments(profile.getInstruments());
        origProfile.setGenres(profile.getGenres());
        return profileRepository.save(origProfile);
    }


}
