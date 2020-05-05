package com.thankfulness.thankfulness.service;

import com.thankfulness.thankfulness.Config.JwtUtil;
import com.thankfulness.thankfulness.model.CustomUserDetails;
import com.thankfulness.thankfulness.model.Thankfulness;
import com.thankfulness.thankfulness.model.ThankfulnessUser;
import com.thankfulness.thankfulness.viewModel.ThankfulnessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.thankfulness.thankfulness.repository.ThankfulnessUserRepository;

import java.util.UUID;

@Service
public class ThankfulnessUserService implements UserDetailsService {

    @Autowired
    private ThankfulnessUserRepository thankfulnessUserRepository;
    @Autowired
    private JwtUtil jwtUtil;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        ThankfulnessUser user = thankfulnessUserRepository.findByUsername(userName);

        if(user == null){
            throw  new UsernameNotFoundException(userName);
        }
        return new CustomUserDetails(user);
    }
    public UUID findUserIdByUsername(String username){
        ThankfulnessUser thankfulnessUser =  thankfulnessUserRepository.findByUsername(username);
        return thankfulnessUser.getUserId();
    }

    public ThankfulnessUser save(ThankfulnessUser user){
        return thankfulnessUserRepository.save(user);
    }

    public ThankfulnessUser findUserByToken(String token){
        String userName = jwtUtil.extractUsername(token);
        ThankfulnessUser user = thankfulnessUserRepository.findByUsername(userName);
        user.setPassword("");
        return user;
    }


}
