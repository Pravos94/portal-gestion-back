package com.unir.poyecto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.unir.poyecto.dto.EmpleadoDTO;
import com.unir.poyecto.model.Empleado;

@Mapper
public interface EmpleadoMapper {

	EmpleadoMapper INSTANCE = Mappers.getMapper(EmpleadoMapper.class);

	EmpleadoDTO toDTO(Empleado empleado);

	Empleado toEntity(EmpleadoDTO empleadoDTO);

//	void updateEntityFromDTO(EmpleadoDTO empleadoDTO, @MappingTarget Empleado empleado);

}
