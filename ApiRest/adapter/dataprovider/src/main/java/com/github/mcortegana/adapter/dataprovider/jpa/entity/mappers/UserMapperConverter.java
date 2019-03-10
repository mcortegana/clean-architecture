package com.github.mcortegana.adapter.dataprovider.jpa.entity.mappers;

import com.github.mcortegana.adapter.dataprovider.jpa.entity.UserEntity;
import com.github.mcortegana.core.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapperConverter {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName")
    })
    User toDomain(UserEntity userEntity);

    @InheritInverseConfiguration
    UserEntity toEntity(User userDomain);
}
