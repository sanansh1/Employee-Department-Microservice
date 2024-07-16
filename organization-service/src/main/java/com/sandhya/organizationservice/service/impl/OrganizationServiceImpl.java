package com.sandhya.organizationservice.service.impl;

import com.sandhya.organizationservice.dto.OrganizationDto;
import com.sandhya.organizationservice.entity.Organization;
import com.sandhya.organizationservice.mapper.OrganizationMapper;
import com.sandhya.organizationservice.repository.OrganizationRepository;
import com.sandhya.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    OrganizationRepository repository;

    /**
     * @param dto
     * @return
     */
    @Override
    public OrganizationDto saveOrganization(OrganizationDto dto) {
        Organization org = repository.save(OrganizationMapper.mapToOrganization(dto));
        return OrganizationMapper.mapToOrganizationDto(org);
    }

    /**
     * @param organizationCode
     * @return
     */
    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization org = repository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(org);
    }
}
