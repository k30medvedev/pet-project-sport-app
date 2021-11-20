//package by.kirill.sportsman.app.service.user;
//
//import by.kirill.sportsman.app.domain.User;
//import by.kirill.sportsman.app.exception.UserNotFoundException;
//import by.kirill.sportsman.app.mapper.UserMapper;
//import by.kirill.sportsman.app.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class UserService {
//    private final UserMapper mapper;
//    private final UserRepository userRepository;
////    private final UserCreateService userCreateService;
////    private final UserUpdateService userUpdateService;
////    private final UserSearchService userSearchService;
//
//    public UserResponseDto findById(Long id) {
//        return mapper.map(findOneOrThrowException(id));
//    }
//
//    public List<UserResponseDto> findAll() {
//        return mapper.map(userRepository.findAll());
//    }
//
////    public UserResponse createUser(User user) throws EmailAlreadyInUseException {
////        return userRepository.save(user);
////    }
//
//    @Transactional
//    public void deleteById(Long id)
//    {
//        userRepository.deleteByIdCascade(id);
//    }
//
////    public UserResponse updateUser(UserUpdateRequest request) {
////        return userRepository.save(updateReq);
////    }
//
//    public User findOneOrThrowException(Long id){
//        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id + "User Not found"));
//    }
//
//
//}
//
//
