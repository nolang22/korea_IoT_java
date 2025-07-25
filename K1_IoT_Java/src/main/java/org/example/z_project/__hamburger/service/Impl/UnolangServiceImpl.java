package org.example.z_project.__hamburger.service.Impl;

import org.example.z_project.__hamburger.repository.UnolangRepository;
import org.example.z_project.user_reservation.dto.UserLoginRequestDto;
import org.example.z_project.user_reservation.dto.UserRegisterRequestDto;
import org.example.z_project.user_reservation.entity.User;
import org.example.z_project.user_reservation.service.UserService;

import java.util.Optional;

public class UnolangServiceImpl implements UserService {
    private final UnolangRepository userRepository;

    public UnolangServiceImpl() {
        this.userRepository = UnolangRepository.getInstance();
    }

    @Override
    public void registerUser(UserRegisterRequestDto dto) {

    }

    @Override
    public void login(UserLoginRequestDto dto) {

    }

    @Override
    public void logout() {

    }

    @Override
    public boolean isLoggedIn() {
        return false;
    }

    @Override
    public Optional<User> findUserById(String userId) {
        return Optional.empty();
    }
}
