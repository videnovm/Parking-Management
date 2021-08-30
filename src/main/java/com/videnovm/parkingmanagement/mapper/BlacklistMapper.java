package com.videnovm.parkingmanagement.mapper;

import com.videnovm.parkingmanagement.dto.BlacklistDto;
import com.videnovm.parkingmanagement.model.Blacklist;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BlacklistMapper {

    @IterableMapping(qualifiedByName = "toBlacklistDto")
    List<BlacklistDto> toBlacklistDtos(List<Blacklist> blacklists);

    @Named("toBlacklist")
    Blacklist toBlacklist(BlacklistDto blacklistDto);

    @Named("toBlacklistDto")
    BlacklistDto toBlacklistDto(Blacklist blacklist);
}
