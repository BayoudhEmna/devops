package io.order.manager.food.order.manager.ressources;


import io.order.manager.food.order.manager.dto.ProductDTO;
import io.order.manager.food.order.manager.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/products")
public class ProductRessources {
    @Autowired
    private ProductService productService;

    @GetMapping
    // Affiche Liste des ordres
    public List<ProductDTO> getAllProducts() {
        return productService.listAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //Ajouter order:
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.save(productDTO), HttpStatus.OK);

    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateProduct(@PathVariable(value = "id") int id, @RequestBody ProductDTO productDTO) {
        productService.update(id, productDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteProduct(@PathVariable(value = "id") int id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
