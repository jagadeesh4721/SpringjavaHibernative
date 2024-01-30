package StudentApplication.SpringJPAHibernate.Controllers;

import StudentApplication.SpringJPAHibernate.Model.User;
import StudentApplication.SpringJPAHibernate.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ClientInfoStatus;
import java.util.List;
import java.util.Optional;

@RestController//
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepoObj;
    @PostMapping("/signup")
    public User createuser(@RequestBody User userObj){
        System.out.println(userObj);
        User userResponse = userRepoObj.save(userObj);
        return userResponse;
    };
    @GetMapping("/findall")
    public List<User> getallusers()
    {
        List<User> allusers=userRepoObj.findAll();
        return allusers;
    }
    @GetMapping("/findbyid/{id}")
    public User findbyuserid(@PathVariable int id)
    {
        //optional class for null pointer exception.
        Optional<User> u=userRepoObj.findById(id);
        if(u.isEmpty()) System.out.println("user id is notfind" +id);
        return u.get();
    }
    @DeleteMapping("deleteid/{id}")
    public String deletebyid(@PathVariable int id)
    {
        Optional<User>u=userRepoObj.findById(id);
        if(u.isEmpty())
        {
            System.out.println("user id is  not there"+id);
            return "alredy deleted";
        }
        userRepoObj.deleteById(id);
        return "Id is deleted";
    }
    @GetMapping("existbyid/{id}")
    public String existid(@PathVariable int id)
    {
        Optional<User>u=userRepoObj.findById(id);
        if(u.isEmpty()) return "it is not there";
        return "It exist in db";
    }

    @GetMapping("/")
    public String index() {
        return "Hello!!!";
    }

}

