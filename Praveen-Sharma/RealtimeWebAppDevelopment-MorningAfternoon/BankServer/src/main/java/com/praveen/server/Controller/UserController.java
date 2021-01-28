package com.praveen.server.Controller;


import com.praveen.server.Model.User;
import com.praveen.server.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


class credentials{
    String id;
    String password;

    public credentials(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/auth")
    @CrossOrigin("*")
    public ResponseEntity<Object> authenticateAdmin(@RequestBody credentials crd)
    {
        return new ResponseEntity<>(crd.getId().equals("admin") && crd.getPassword().equals("admin123")?crd:null,HttpStatus.OK);
    }


    @GetMapping("/getByAC/{account_number}")
    @CrossOrigin("*")
    public ResponseEntity<Object> getByAccountNumber(@PathVariable("account_number") int accountNumber)
    {
        Object result=userService.getByAccountNumber(accountNumber);
        return new ResponseEntity<>(result==null?null:result, HttpStatus.OK);
    }

    @PostMapping("/addUser")
    @CrossOrigin("*")
    public ResponseEntity<Object> addUser(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.addUser(user),HttpStatus.OK);
    }
}
