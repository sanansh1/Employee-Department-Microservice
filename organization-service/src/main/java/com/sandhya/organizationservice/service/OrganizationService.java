package com.sandhya.organizationservice.service;

import com.sandhya.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
    OrganizationDto saveOrganization(OrganizationDto dto);

    OrganizationDto getOrganizationByCode(String organizationCode);
}
