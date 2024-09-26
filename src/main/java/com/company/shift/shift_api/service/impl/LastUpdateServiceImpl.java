package com.company.shift.shift_api.service.impl;

import com.company.shift.shift_api.domain.LastUpdate;
import com.company.shift.shift_api.repository.LastUpdateRepository;
import com.company.shift.shift_api.service.LastUpdateService;
import org.springframework.stereotype.Service;

@Service
public class LastUpdateServiceImpl  implements LastUpdateService {

    private final LastUpdateRepository lastUpdateRepository;

    public LastUpdateServiceImpl(LastUpdateRepository lastUpdateRepository) {
        this.lastUpdateRepository = lastUpdateRepository;
    }

    @Override
    public LastUpdate getLastUpdate() {
        LastUpdate lastUpdate = lastUpdateRepository.findAll()
                .stream()
                .findFirst()
                .orElse(new LastUpdate());

        return new LastUpdate(lastUpdate.getLastDateUpdate());
    }

    @Override
    public LastUpdate updateLastUpdate(LastUpdate newDate) {
        LastUpdate lastUpdate = lastUpdateRepository.findAll()
                .stream()
                .findFirst()
                .orElse(new LastUpdate());

        lastUpdate.setLastDateUpdate(lastUpdate.getLastDateUpdate());
        lastUpdateRepository.save(newDate);
        return new LastUpdate(lastUpdate.getLastDateUpdate());
    }
}
