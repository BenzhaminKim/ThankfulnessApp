package com.thankfulness.thankfulness.service;

import com.thankfulness.thankfulness.Config.JwtUtil;
import com.thankfulness.thankfulness.Exceptions.UserNotMatchException;
import com.thankfulness.thankfulness.model.Thankfulness;
import com.thankfulness.thankfulness.model.Token;
import com.thankfulness.thankfulness.repository.ThankfulnessUserRepository;
import com.thankfulness.thankfulness.viewModel.ThankfulnessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thankfulness.thankfulness.repository.ThankfulnessRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ThankfulnessService {
    @Autowired
    private ThankfulnessRepository thankfulnessRepository;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private ThankfulnessUserService userService;

    public Thankfulness save(Thankfulness thankfulness){
        return thankfulnessRepository.save(thankfulness);
    }
    public Thankfulness update(ThankfulnessToken thankfulnessToken, UUID id){

        String username = jwtUtil.extractUsername(thankfulnessToken.getToken().getToken());
        UUID user_id_token = userService.findUserIdByUsername(username);
        UUID user_id_room = thankfulnessRepository.findByUUID(id).get().getUserId();
        Thankfulness newThankfulness = thankfulnessToken.getThankfulness();

        if(user_id_room == user_id_token){
            return thankfulnessRepository.findByUUID(id).map(room -> {
                room.setTitle(newThankfulness.getTitle());
                room.setContent(newThankfulness.getContent());
                return thankfulnessRepository.save(room);
            }).orElseGet(()->{
                newThankfulness.setThankfulnessId(id);
                return thankfulnessRepository.save(newThankfulness);
            });
        }

        return null;
    }
    public void delete(Thankfulness thankfulness){
        thankfulnessRepository.delete(thankfulness);
    }
    public Thankfulness find(UUID thankfulnessId){
        return thankfulnessRepository.findByUUID(thankfulnessId).get();
    }
    public List<Thankfulness> findAllForUser(Token token){
        String username =  jwtUtil.extractUsername(token.getToken());
        UUID userId = userService.findUserIdByUsername(username);
        return thankfulnessRepository.findAllByUserId(userId);
    }
}
