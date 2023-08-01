package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {
    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //아래 있는 함수가 시작될 떄  start transaction; 을 해준다 (트랜잭션 시작)
    // 함수가 예외 없이 잘 끝났다면 commit
    // 혹시라도 문제가 있다면 rollback
    @Transactional
    public void saveUser(UserCreateRequest request){
         userRepository.save(new User(request.getName(), request.getAge()));
    }

    @Transactional(readOnly = true) //readOnly option 적용하면 데이터 변경을 위한 기능이 빠지기 때문에 약간의 성능적 이점 존재
    public List<UserResponse> getUsers(){
        return userRepository.findAll().stream() //findAll -> 해당 테이블의 모든 데이터를 가져옴
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateUser(UserUpdateRequest request){
        // select * from user where id = ?;
        // Optional<User>
        // orElseThrow -> 비어있으면 ()행위, 비어있지 않으면 user에 담아줌
        User user = userRepository.findById(request.getId()) //id를 기준으로 특정한 데이터 1개 가져옴
                .orElseThrow(IllegalArgumentException::new);

        user.updateName(request.getName());
        //userRepository.save(user); //save : 주어진 객체 저장하거나 업데이트 시켜줌 //Transaction 으로 시작했기 때문에
        //명시적으로 save하지 않더라도, 변경을 감지해 자동으로 저장 -> 변경 감지 기능

    }

    @Transactional
    public void deleteUser(String name){
        // SELECT * FROM user WHERE name = ?
        User user = userRepository.findByName(name).orElseThrow(IllegalArgumentException::new);
    }
}
