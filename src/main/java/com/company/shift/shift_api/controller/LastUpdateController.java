package com.company.shift.shift_api.controller;

import com.company.shift.shift_api.domain.LastUpdate;
import com.company.shift.shift_api.service.LastUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cpn/last-update")
public class LastUpdateController {

    private LastUpdateService lastUpdateService;

    @Autowired
    public LastUpdateController(LastUpdateService lastUpdateService) {
        this.lastUpdateService = lastUpdateService;
    }

    @GetMapping
    public ResponseEntity<LastUpdate> getLastUpdate() {
        LastUpdate lastUpdate = lastUpdateService.getLastUpdate();
        return ResponseEntity.ok(lastUpdate);
    }

    @PutMapping
    public ResponseEntity<LastUpdate> updateLastUpdate(@RequestBody LastUpdate lastUpdate) {
        LastUpdate updatedLastUpdate = lastUpdateService.updateLastUpdate(lastUpdate);
        return ResponseEntity.ok(updatedLastUpdate);
    }
}