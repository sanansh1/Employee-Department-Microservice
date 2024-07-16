package com.sandhya.organizationservice.controller;

import com.sandhya.organizationservice.dto.OrganizationDto;
import com.sandhya.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organizations")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService service;

    @PostMapping
    public ResponseEntity<OrganizationDto> createOrganization(@RequestBody OrganizationDto dto) {
        OrganizationDto savedDto = service.saveOrganization(dto);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }

    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode) {
        OrganizationDto dto = service.getOrganizationByCode(organizationCode);
        return ResponseEntity.ok(dto);
    }
}
