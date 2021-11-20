package by.kirill.sportsman.app.mapper;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

//    private UserService userService;
//    private final ModelMapper modelMapper;
//
//    public UserMapper(
//            UserService userService,
//            ModelMapper modelMapper) {
//        this.userService = userService;
//        this.modelMapper = modelMapper;
//    }
//
//    UserUpdateReq map(Long id, UserUpdateRequest dto) {
//        UserUpdateReq model = new UserUpdateReq();
//        model.setId(id);
//        model.setFirstName(dto.getFirstName());
//        model.setLastName(dto.getLastName());
//        model.setEmail(dto.getEmail());
//        model.setBirthday(dto.getBirthday());
//        return model;
//    }
//
//    public User map(User user, UserUpdateRequest request) {
//        return User.builder()
//                .firstName(request.getFirstName())
//                .lastName(request.getLastName())
//                .email(request.getEmail())
//                .birthday(request.getBirthday())
//                .build();
//    }
//
//    public User map(UserCreationRequest dto) {
//        User user = new User();
//        user.setFirstName(dto.getFirstName());
//        user.setLastName(dto.getLastName());
//        user.setEmail(dto.getEmail());
//        user.setBirthday(dto.getBirthday());
//        return user;
//    }

//    public UserResponseDto map(User source) {
//        return UserResponseDto.builder()
//                .id(source.getId())
//                .firstName(source.getFirstName())
//                .lastName(source.getLastName())
//                .email(source.getEmail())
//                .birthday(source.getBirthday())
//                .build();
//    }
//
//    public List<UserResponseDto> map(List<User> userList) {
//        return userList.stream().map(i -> new UserResponseDto(
//                i.getId(),
//                i.getFirstName(), i.getLastName(), i.getEmail(),
//                i.getBirthday())).collect(Collectors.toList());
//    }
}
