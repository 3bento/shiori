package dev.ebento.shiori.user.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import dev.ebento.shiori.user.User;
import dev.ebento.shiori.user.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

	User toUser(UserDTO source);

	@InheritInverseConfiguration
	UserDTO toUserDto(User source);

}
