package ro.msg.learning.shop.converter;

public interface Converter<Model, Dto> {
    Model dtoToModel(Dto dto);

    Dto modelToDto(Model model);
}