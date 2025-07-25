package org.example.z_project.__hamburger.repository;

import org.example.z_project.__hamburger.entity.Unolang;

import java.util.ArrayList;
import java.util.List;


public class UnolangRepository {
    List<Unolang> unolangs = new ArrayList<>();

    private static final UnolangRepository instance = new UnolangRepository();

    private UnolangRepository() {}

    public static UnolangRepository getInstance() {
        return instance;
    }
}
