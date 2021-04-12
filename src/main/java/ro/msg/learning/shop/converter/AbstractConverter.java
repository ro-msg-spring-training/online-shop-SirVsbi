package ro.msg.learning.shop.converter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<Model, Dto> implements Converter<Model, Dto> {

    public List<Dto> convertModelToDto(Collection<Model> models) {
        return models.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }

    public Collection<Model> convertDtoToModels(Collection<Dto> dto) {
        return dto.stream()
                .map(this::dtoToModel)
                .collect(Collectors.toList());
    }
}