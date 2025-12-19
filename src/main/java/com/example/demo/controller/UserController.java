@RestController
@RequestMapping("/api/users")
public class UserController {
private final UserService service;
public UserController(UserService service) { this.service = service; }


@PostMapping("/register")
public User register(@RequestBody User u) { return service.registerUser(u); }


@GetMapping
public List<User> all() { return service.getAllUsers(); }
}