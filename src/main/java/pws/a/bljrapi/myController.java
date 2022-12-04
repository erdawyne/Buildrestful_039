/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.a.bljrapi;

import java.util.HashMap;
import java.util.Map;
import model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ERDA WYNE
 */
@RestController //untuk membuat layanan web yang tenang dengan 
               //bantuan dan memungkinkan kelas menangani permintaan yang dibuat oleh klien

public class myController {
    private static Map<String, Product> productRepo = new HashMap<>(); //HashMap untuk menyimpan produk
    static {
    Product honey = new Product();              //Membuat produk 
    honey.setId("1");                           //Memberikan id diproduk
    honey.setName("Honey");                     //Memberikan name di produk
    productRepo.put(honey.getId(), honey);
    
    Product almond = new Product();
    almond.setId("2");
    almond.setName("Almod");
    productRepo.put(almond.getId(), almond);
    
    Product ginger = new Product();
    ginger.setId("3");
    ginger.setName("Indian Ginger");
    productRepo.put(ginger.getId(), ginger);
    
    }
    
    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProduct(){
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
        
    }
    
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product){
        productRepo.put(product.getId(), product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
        
    }
    
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product){
    productRepo.remove(id);
    product.setId(id);
    productRepo.put(id, product);
    return new ResponseEntity<>("Product is update successsfully", HttpStatus.OK);
    }
    
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id){
        productRepo.remove(id);
        return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
    }
    
}
