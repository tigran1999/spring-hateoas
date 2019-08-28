package am.itspace.hateoasexample.controller;

import am.itspace.hateoasexample.model.User;
import am.itspace.hateoasexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping()
    public List<Resource<User>> getAllUsers(){
        List<Resource<User>> users  = new LinkedList<>();
       userRepository.findAll().forEach(user -> users.add(getUserResource(user)));
        return users;
    }

    @GetMapping(value = "/{id}")
    public Resource<User> getUser(@PathVariable(value = "id") int id) {
        User user = userRepository.findById(id).get();
        return getUserResource(user);
    }

    private Resource<User> getUserResource(User user) {
        Resource<User> resource = new Resource<>(user);
        // Link to Album
        resource.add(linkTo(methodOn(UserController.class).getUser(user.getUserId())).withSelfRel());

        return resource;
    }



}
