package com.company.shift.shift_api.service;

import com.company.shift.shift_api.domain.LastUpdate;

public interface LastUpdateService {

    public LastUpdate getLastUpdate();

    public LastUpdate updateLastUpdate(LastUpdate lastUpdate);
}
