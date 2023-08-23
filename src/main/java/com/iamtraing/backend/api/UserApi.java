package com.iamtraing.backend.api;

import com.iamtraing.backend.business.UserBusiness;
import com.iamtraing.backend.entity.User;
import com.iamtraing.backend.exception.BaseException;
import com.iamtraing.backend.model.MRegisterRequest;
import com.iamtraing.backend.model.TestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserApi {

    //METHOD: 1 =>Field Injection
//    @Autowired
//    private TestBusiness business;

    //METHOD: 2 =>Constructor Injection
    private final UserBusiness business;

    public UserApi(UserBusiness business) {
        this.business = business;
    }

    @GetMapping
    public TestResponse test() {
        TestResponse response = new TestResponse();
        response.setName("Kong");
        response.setFood("KFC");
        return response;
    }

    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<User> register(@RequestBody MRegisterRequest request) throws BaseException {
        User response = business.register(request);
        return ResponseEntity.ok(response);

    }

    @PostMapping
    public ResponseEntity<String> uploadProfilePicture(@RequestPart MultipartFile file) throws BaseException {
        String response = business.uploadProfilePicture(file);
        return ResponseEntity.ok(response);

    }

}
