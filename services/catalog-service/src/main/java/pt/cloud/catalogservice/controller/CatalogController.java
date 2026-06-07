package pt.cloud.catalogservice.controller;

import org.springframework.web.bind.annotation.*;
import pt.cloud.catalogservice.model.CatalogItem;
import pt.cloud.catalogservice.repository.CatalogRepository;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogRepository repository;

    public CatalogController(CatalogRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<CatalogItem> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public CatalogItem create(@RequestBody CatalogItem item) {
        return repository.save(item);
    }
}