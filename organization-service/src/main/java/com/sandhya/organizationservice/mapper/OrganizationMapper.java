package com.sandhya.organizationservice.mapper;

import com.sandhya.organizationservice.dto.OrganizationDto;
import com.sandhya.organizationservice.entity.Organization;

public class OrganizationMapper {

    public static OrganizationDto mapToOrganizationDto(Organization entity) {
        return new OrganizationDto(entity.getId(), entity.getOrganizationName(), entity.getOrganizationDescription(), entity.getOrganizationCode(), entity.getCreatedDate());
    }

    public static Organization mapToOrganization(OrganizationDto dto) {
        return new Organization(dto.getId(), dto.getOrganizationName(), dto.getOrganizationDescription(), dto.getOrganizationCode(), dto.getCreatedDate());
    }
}
