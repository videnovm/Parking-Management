package com.videnovm.parkingmanagement.service;

import com.videnovm.parkingmanagement.model.Blacklist;

import java.util.List;

public interface BlacklistService {
    List<Blacklist> getBlacklist();
    Blacklist createBlackListItem(Blacklist blacklist);
    void deleteBlacklistItem(Long id);
}
