package org.example.z_project.__hamburger.service;

import org.example.z_project.__hamburger.dto.Unolang.request.UnolangCreateRequestDto;
import org.example.z_project.__hamburger.dto.Unolang.request.UnolangUpdateRequestDto;
import org.example.z_project.__hamburger.dto.Unolang.response.UnolangDetailResponseDto;
import org.example.z_project.__hamburger.dto.Unolang.response.UnolangListResponseDto;

import java.util.List;

public interface UnolangService {

    //CRUD
    void OrderUser(UnolangCreateRequestDto dto);
    List<UnolangListResponseDto> listAllUsers();
    UnolangDetailResponseDto getUserById(long id);
    void updateUser(Long id, UnolangUpdateRequestDto dto);
    void deleteUser(Long id);

}
