package cefdemo.controller;

import cefdemo.dto.RequestDto;
import cefdemo.service.RequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestController {
    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping
    public ResponseEntity<RequestDto> createRequest(@RequestBody RequestDto requestDto) {
        return new ResponseEntity<>(requestService.createRequest(requestDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RequestDto>> getAllRequests() {
        List<RequestDto> requestDtos = requestService.getAllRequests();
        return new ResponseEntity<>(requestDtos, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<RequestDto> getRequestById(@PathVariable("id") Long id) {
        RequestDto requestEntity = requestService.getRequestById(id);
        return new ResponseEntity<>(requestEntity, HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<RequestDto> updateRequest(@RequestBody RequestDto requestDto, @PathVariable(name = "id") Long id) {
        RequestDto requestResponse = requestService.updateRequest(requestDto, id);
        return new ResponseEntity<>(requestResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRequest(@PathVariable(name = "id") Long id) {
        requestService.deleteRequestById(id);
        return new ResponseEntity<>("Request entity deleted successfully.", HttpStatus.OK);
    }

}

