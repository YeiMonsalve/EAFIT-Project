package com.backendproject.springBackend.roles.mapper;

import com.backendproject.springBackend.roles.dto.RolesJustIdDTO;
import com.backendproject.springBackend.roles.dto.RolesNoIdDTO;
import com.backendproject.springBackend.roles.model.Roles;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RolesMapper {

    @Mapping(target = "id", ignore = true)
    Roles rolSinId(RolesNoIdDTO rolesNoIdDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "rol", ignore = true)
    Roles toEntity(RolesJustIdDTO rolesJustIdDTO);
}