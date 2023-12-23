package com.example.parkingproviderservice.controller;

import com.example.parkingproviderservice.exception.ResourceNotFoundException;
import com.example.parkingproviderservice.model.ProviderDetails;
import com.example.parkingproviderservice.service.ProviderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/provider-details")
@CrossOrigin
public class ProviderDetailsController {
    @Autowired
    private ProviderDetailsService providerDetailsService;
    @PutMapping("/update")
    public ResponseEntity<ProviderDetails> updateProviderDetails(@RequestBody ProviderDetails providerDetails) throws ResourceNotFoundException {
        providerDetails=providerDetailsService.updateProviderDetails(providerDetails);
        return ResponseEntity.ok(providerDetails);
    }

    @PutMapping("/{userId}/profile-picture")
    public ProviderDetails updateProfilePicture(
            @PathVariable String userId,
            @RequestParam("file") MultipartFile file
    ) throws IOException, ResourceNotFoundException {

        return providerDetailsService.updateProfilePicture(userId, file);
    }
    @GetMapping("/{providerId}/get")
    public  ResponseEntity<ProviderDetails> getProviderById(@PathVariable String providerId) throws ResourceNotFoundException {
        ProviderDetails providerDetails=providerDetailsService.getProviderById(providerId);
        return ResponseEntity.ok(providerDetails);
    }
    @DeleteMapping("/{providerId}/delete")
    public ResponseEntity<String> deleteProviderDetails(@PathVariable String providerId) throws ResourceNotFoundException {
        providerDetailsService.deleteProviderDetails(providerId);
        return ResponseEntity.ok("{\"message\": \"Deleted\"}");
    }
}
