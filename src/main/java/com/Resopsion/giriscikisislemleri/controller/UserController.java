package com.Resopsion.giriscikisislemleri.controller;

import com.Resopsion.giriscikisislemleri.dto.CikisIslemiDTO;
import com.Resopsion.giriscikisislemleri.dto.UserCreateDTO;
import com.Resopsion.giriscikisislemleri.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @PostMapping("/create/{odaNumarasi}")
    public ResponseEntity<UserCreateDTO> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO, @PathVariable Integer odaNumarasi) {
        UserCreateDTO resultPersonel = userService.createUser(userCreateDTO,odaNumarasi);
        return ResponseEntity.ok(resultPersonel);
    }

    @PutMapping("/update/{odaNumarasi}")
    public ResponseEntity<CikisIslemiDTO> cikisIslemi(@PathVariable Integer odaNumarasi, @RequestBody CikisIslemiDTO cikisIslemiDTO ){
        CikisIslemiDTO cikisIslemi = userService.cikisIslemi(odaNumarasi,cikisIslemiDTO);
        return ResponseEntity.ok(cikisIslemi);
    }

}
