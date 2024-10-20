package com.forme.app.utils;


import com.forme.app.dto.PathDto;
import com.forme.app.model.Path;
import org.modelmapper.ModelMapper;

import java.util.stream.Collectors;

/**
 * The type Mapper dto.
 */
public class MapperDTO {
    private final static ModelMapper modelMapper = new ModelMapper();

    /**
     * Convert to dto d.
     *
     * @param <D>      the type parameter
     * @param <E>      the type parameter
     * @param entity   the entity
     * @param dtoClass the dto class
     * @return the d
     */
    public static <D, E> D convertToDto(E entity, Class<D> dtoClass) {
        if (entity == null) {
            throw new IllegalArgumentException("Source cannot be null");
        }
        return modelMapper.map(entity, dtoClass);
    }

    /**
     * Convert to entity e.
     *
     * @param <E>         the type parameter
     * @param <D>         the type parameter
     * @param dto         the dto
     * @param entityClass the entity class
     * @return the e
     */
    public static <E, D> E convertToEntity(D dto, Class<E> entityClass) {
        if (dto == null) {
            throw new IllegalArgumentException("Source cannot be null");
        }
        return modelMapper.map(dto, entityClass);
    }
    public static PathDto convertToDto(Path path, Class<PathDto> pathDtoClass) {
        PathDto pathDto = modelMapper.map(path, pathDtoClass);
        pathDto.setCenterId(path.getCenter().getId().toString());
        pathDto.setFormerId(path.getFormer().getId().toString());
        pathDto.setCandidateIds(path.getCandidates().stream()
                .map(candidate -> candidate.getId().toString())
                .collect(Collectors.toList()));
        return pathDto;
    }
}
