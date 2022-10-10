package cefdemo.service;

import cefdemo.dto.RequestDto;
import cefdemo.entity.RequestEntity;
import cefdemo.exception.ResourceNotFoundException;
import cefdemo.repo.RequestRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestServiceImpl implements RequestService{
    private RequestRepo requestRepo;

    public RequestServiceImpl(RequestRepo requestRepo) {
        this.requestRepo = requestRepo;
    }
    @Override
    public RequestDto createRequest(RequestDto requestDto){
        //convert DTO to Entity
        RequestEntity requestEntity = mapToEntity(requestDto);
        RequestEntity newRequestEntity = requestRepo.save(requestEntity);
        // convert Entity to DTO
        RequestDto requestResponse = mapToDTO(newRequestEntity);
        return requestResponse;
    }

    @Override
    public List<RequestDto> getAllRequests(){
    List<RequestEntity> requestEntities = requestRepo.findAll();
    return  requestEntities.stream().map(requestEntity -> mapToDTO(requestEntity)).collect(Collectors.toList());
    }

    public RequestDto getRequestById (Long id){
        RequestEntity requestEntity = requestRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Requst", "id", id));
    return mapToDTO(requestEntity);
    }

    @Override
    public RequestDto updateRequest(RequestDto requestDto, Long id){
        // get request by id from the database
    RequestEntity requestEntity = requestRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException ("Request", "id", id));

    requestEntity.setDate_and_time(requestDto.getDate_and_time());
    requestEntity.setSum(requestDto.getSum());
    requestEntity.setNumber(requestDto.getNumber());
    requestEntity.setDate_of_contract(requestDto.getDate_of_contract());

    RequestEntity updatedRequestEntity =requestRepo.save(requestEntity);
    return mapToDTO(updatedRequestEntity);
    }
    @Override
    public void deleteRequestById(Long id){
        //get request by id from the database
        RequestEntity requestEntity = requestRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Request", "id", id));
        requestRepo.delete(requestEntity);
    }

    // convert Entity into DTO
    private RequestDto mapToDTO(RequestEntity newRequestEntity) {
        RequestDto requestDto = new RequestDto();
        requestDto.setId(newRequestEntity.getId());
        requestDto.setDate_and_time(newRequestEntity.getDate_and_time());
        requestDto.setSum(newRequestEntity.getSum());
        requestDto.setNumber(newRequestEntity.getNumber());
        requestDto.setDate_of_contract(newRequestEntity.getDate_of_contract());
        return requestDto;
    }


    // convert DTO to entity
    private RequestEntity mapToEntity(RequestDto requestDto) {
    RequestEntity requestEntity = new RequestEntity();
    requestEntity.setDate_and_time(requestDto.getDate_and_time());
    requestEntity.setSum(requestDto.getSum());
    requestEntity.setNumber(requestDto.getNumber());
    requestEntity.setDate_of_contract(requestDto.getDate_of_contract());
    return requestEntity;
    }

    
}
