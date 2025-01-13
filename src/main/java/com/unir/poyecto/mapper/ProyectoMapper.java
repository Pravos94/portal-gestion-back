package com.unir.poyecto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.unir.poyecto.dto.ProyectoDTO;
import com.unir.poyecto.model.Proyecto;

@Mapper
public interface ProyectoMapper {

	ProyectoMapper INSTANCE = Mappers.getMapper(ProyectoMapper.class);

	ProyectoDTO toDTO(Proyecto proyecto);

	Proyecto toEntity(ProyectoDTO proyectoDTO);

//	void updateEntityFromDTO(ProyectoDTO proyectoDTO, @MappingTarget Proyecto proyecto);

}
