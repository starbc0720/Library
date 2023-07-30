package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.fruit.FruitService;
import com.group.libraryapp.service.user.UserServiceV1;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //API 진입 지점, 해당 클래스를 스프링 빈(스프링 컨테이너안의 클래스)으로 등록
public class UserController {

    private final UserServiceV1 userServiceV1;
    private final FruitService fruitService;

    public UserController(UserServiceV1 userServiceV1, @Qualifier("main")FruitService fruitService){ //생성자를 만들어 jdbcTemplate를 파라미터로 넣으면, 자동으로 들어옴
        this.userServiceV1 = userServiceV1;
        this.fruitService = fruitService;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request){
        userServiceV1.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers(){
        return userServiceV1.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request){
        userServiceV1.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){
        userServiceV1.deleteUser(name);
    }

}
