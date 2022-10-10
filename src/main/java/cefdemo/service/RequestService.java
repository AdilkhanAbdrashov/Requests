package cefdemo.service;

import cefdemo.dto.RequestDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RequestService {
    RequestDto createRequest(RequestDto requestDto);

    List<RequestDto> getAllRequests();

    RequestDto getRequestById (Long id);

    RequestDto updateRequest(RequestDto requestDto, Long id);

    void deleteRequestById(Long id);

}
