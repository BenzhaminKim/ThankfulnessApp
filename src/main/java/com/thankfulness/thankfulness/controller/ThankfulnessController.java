package com.thankfulness.thankfulness.controller;

import com.thankfulness.thankfulness.Config.JwtUtil;
import com.thankfulness.thankfulness.Config.Logging;
import com.thankfulness.thankfulness.model.Thankfulness;
import com.thankfulness.thankfulness.model.Token;
import com.thankfulness.thankfulness.service.ThankfulnessImageService;
import com.thankfulness.thankfulness.service.ThankfulnessService;
import com.thankfulness.thankfulness.service.ThankfulnessUserService;
import com.thankfulness.thankfulness.viewModel.ThankfulnessToken;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/")
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ThankfulnessController {
    @Autowired
    private ThankfulnessService thankfulnessService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private ThankfulnessUserService userService;
    @Autowired
    private Logging logging;
    @PostMapping("thankfulness")
    public Thankfulness create(@Valid @RequestBody ThankfulnessToken thankfulnessToken){
        Token token = thankfulnessToken.getToken();
        String username = jwtUtil.extractUsername(token.getToken());
        UUID userId = userService.findUserIdByUsername(username);

        Thankfulness thankfulness = thankfulnessToken.getThankfulness();
        thankfulness.setUserId(userId);
        return thankfulnessService.save(thankfulness);
    }

    @GetMapping("thankfulness/all")
    public List<Thankfulness> getAllByUser(@Valid @RequestBody Token token) throws IOException {
        logging.get();
        return thankfulnessService.findAllForUser(token);
    }

    @GetMapping("thankfulness/{id}")
    public Thankfulness getThankfulness(@PathVariable UUID id)
    {
        return thankfulnessService.find(id);
    }
    @PutMapping("thankfulness/{id}")
    public Thankfulness updateThankfulness(@PathVariable UUID id,@Valid @RequestBody ThankfulnessToken thankfulnessToken)
    {
        return thankfulnessService.update(thankfulnessToken,id);
    }

    @DeleteMapping("thankfulness")
    public void delete(@Valid @RequestBody Thankfulness thankfulness){
        thankfulnessService.delete(thankfulness);
    }
}
