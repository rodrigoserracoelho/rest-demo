package io.surisoft.demo;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    private CamelContext camelContext;

    @GetMapping("/test")
    public ResponseEntity<String> testGet() {
        return new ResponseEntity<>("OK-GET", HttpStatus.OK);
    }

    @PostMapping("/test")
    public ResponseEntity<String> testPost() {
        return new ResponseEntity<>("OK-POST", HttpStatus.OK);
    }

    @DeleteMapping("/test")
    public ResponseEntity<String> testDelete() {
        return new ResponseEntity<>("OK-DELETE", HttpStatus.OK);
    }
}
