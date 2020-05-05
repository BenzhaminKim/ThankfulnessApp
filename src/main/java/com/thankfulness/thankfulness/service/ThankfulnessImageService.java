package com.thankfulness.thankfulness.service;

import com.thankfulness.thankfulness.model.ThankfulnessImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thankfulness.thankfulness.repository.ThankfulnessImageRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ThankfulnessImageService {
    @Autowired
    private ThankfulnessImageRepository thankfulnessImageRepository;

    public ThankfulnessImage save(ThankfulnessImage thankfulnessImage){
        return thankfulnessImageRepository.save(thankfulnessImage);
    }
    public ThankfulnessImage update(ThankfulnessImage thankfulnessImage){
        return thankfulnessImageRepository.save(thankfulnessImage);
    }
    public void delete(ThankfulnessImage thankfulnessImage){
        thankfulnessImageRepository.delete(thankfulnessImage);
    }

    public List<String> findImagesPathByThankfulnessId(UUID id){
        return thankfulnessImageRepository.findImagesPathByThankfulnessId(id);
    }
}
