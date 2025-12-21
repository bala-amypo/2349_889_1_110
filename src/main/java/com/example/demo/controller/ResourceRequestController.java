import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class ResourceRequestController {

    private final ResourceRequestService service;

    public ResourceRequestController(ResourceRequestService service) {
        this.service = service;
    }

    @PostMapping("/{userId}")
    public ResourceRequest create(@PathVariable Long userId,
                                  @RequestBody ResourceRequest request) {
        return service.createRequest(userId, request);
    }

    @GetMapping("/{id}")
    public ResourceRequest get(@PathVariable Long id) {
        return service.getRequest(id);
    }
}
