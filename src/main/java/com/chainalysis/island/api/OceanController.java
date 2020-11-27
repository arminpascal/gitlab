package com.chainalysis.island.api;

import com.chainalysis.island.model.request.Ocean;
import com.chainalysis.island.util.OceanHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/ocean")
@RestController
public class OceanController {

    @PostMapping
    public void postOcean(@RequestBody Ocean ocean) {

    }

}
