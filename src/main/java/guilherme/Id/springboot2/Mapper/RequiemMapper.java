package guilherme.Id.springboot2.Mapper;

import guilherme.Id.springboot2.domain.Requiem;
import guilherme.Id.springboot2.request.RequiemPostRequestBody;
import guilherme.Id.springboot2.request.RequiemPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class RequiemMapper {
    public static final RequiemMapper INSTANCE = Mappers.getMapper(RequiemMapper.class);

    public abstract Requiem toRequiem(RequiemPostRequestBody requiemPostRequestBody);

    public abstract Requiem toRequiem(RequiemPutRequestBody requiemPostRequestBody);
}
