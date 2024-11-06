package com.backendproject.springBackend.ubicacionregion.mapper;

import com.backendproject.springBackend.ubicacionregion.dto.UbicacionRegionNoIdDTO;
import com.backendproject.springBackend.ubicacionregion.model.UbicacionRegion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UbicacionRegionMapper {

    @Mapping(target = "id", ignore = true)
    UbicacionRegion ubicacionRegionSinId(UbicacionRegionNoIdDTO ubicacionRegionNoIdDTO);
}