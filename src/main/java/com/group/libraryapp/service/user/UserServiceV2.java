package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {
    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void saveUser(UserCreateRequest request){
        User u = userRepository.save(new User(request.getName(), request.getAge()));
    }

    public List<UserResponse> getUsers(){
        return userRepository.findAll().stream() //findAll -> 해당 테이블의 모든 데이터를 가져옴
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    public void updateUser(UserUpdateRequest request){
        // select * from user where id = ?;
        // Optional<User>
        // orElseThrow -> 비어있으면 ()행위, 비어있지 않으면 user에 담아줌
        User user = userRepository.findById(request.getId()) //id를 기준으로 특정한 데이터 1개 가져옴
                .orElseThrow(IllegalArgumentException::new);

        user.updateName(request.getName());
        userRepository.save(user); //save : 주어진 객체 저장하거나 업데이트 시켜줌
    }
}
