package com.thankfulness.thankfulness.controller;

import com.thankfulness.thankfulness.model.ThankfulnessImage;
import com.thankfulness.thankfulness.service.ThankfulnessImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/")
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ThankfulnessImageController {
    @Autowired
    private ThankfulnessImageService imageService;

    @GetMapping("image/{id}")
    public List<String> getImages(@PathVariable UUID id){
        return imageService.findImagesPathByThankfulnessId(id);
    }
}
