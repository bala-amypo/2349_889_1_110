@RestController
@RequestMapping("/api/resources")
public class ResourceController {
private final ResourceService service;
public ResourceController(ResourceService service) { this.service = service; }


@PostMapping
public Resource create(@RequestBody Resource r) { return service.createResource(r); }


@GetMapping
public List<Resource> all() { return service.getAllResources(); }


@GetMapping("/{id}")
public Resource one(@PathVariable Long id) { return service.getResource(id); }
}