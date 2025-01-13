package com.unir.poyecto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.unir.poyecto.dto.CursoDTO;
import com.unir.poyecto.model.Curso;

@Mapper
public interface CursoMapper {

	CursoMapper INSTANCE = Mappers.getMapper(CursoMapper.class);

	CursoDTO toDTO(Curso curso);

	Curso toEntity(CursoDTO cursoDTO);

//	void updateEntityFromDTO(CursoDTO cursoDTO, @MappingTarget Curso curso);

}
