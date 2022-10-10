package cefdemo.service;

import cefdemo.dto.UserDto;
import cefdemo.entity.UserEntity;
import cefdemo.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public UserDto createUser(UserDto userDto) {
        //convert DTO to Entity
        UserEntity userEntity = mapToEntity(userDto);
        UserEntity newUserEntity = userRepo.save(userEntity);
        //convert Entity to DTO
        UserDto userResponse = mapToDTO(newUserEntity);
        return userResponse;
    }
    // convert Entity into DTO
    private UserDto mapToDTO(UserEntity newUserEntity) {
        UserDto userDto = new UserDto();
        userDto.setLogin(newUserEntity.getLogin());
        userDto.setIIN(newUserEntity.getIIN());
        userDto.setBIN(newUserEntity.getBIN());
        userDto.setPassword(newUserEntity.getPassword());
        userDto.setDate_of_registration(newUserEntity.getDate_of_registration());
        userDto.setFull_name(newUserEntity.getFull_name());
        return userDto;
    }
    // convert DTO to entity
    private UserEntity mapToEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin(userDto.getLogin());
        userEntity.setIIN(userDto.getIIN());
        userEntity.setBIN(userEntity.getBIN());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setDate_of_registration(userDto.getDate_of_registration());
        userEntity.setFull_name(userDto.getFull_name());
        return userEntity;

    }
}
