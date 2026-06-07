package pt.cloud.catalogservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.cloud.catalogservice.model.CatalogItem;

public interface CatalogRepository extends JpaRepository<CatalogItem, Long> {
}