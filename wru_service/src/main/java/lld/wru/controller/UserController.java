package lld.wru.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lld.wru.dao.UserMapper;
import lld.wru.model.User;
import lld.wru.model.UserExample;
import lld.wru.model.UserExample.Criteria;

@RestController
public class UserController extends BaseController {

    public UserController() {
        userDao = (UserMapper) applicationContext.getBean("userDao");
    }

    private UserMapper userDao;

    @RequestMapping(value = "/user/{phoneNum}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers(@PathVariable("phoneNum") String phoneNum) {
        UserExample userExample = new UserExample();
        Criteria userCriteria = userExample.createCriteria();
        userCriteria.andPhoneNumLike(phoneNum);
        List<User> users = userDao.selectByExample(userExample);

        if (users == null || users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        User user = userDao.selectByPrimaryKey(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value="/user/", method=RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        int userId = userDao.insert(user);
        return getUserById(userId);
    }
}
