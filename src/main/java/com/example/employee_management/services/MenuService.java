package com.example.employee_management.services;

import com.example.employee_management.Entity.Menu;


import java.util.List;

public interface MenuService {
    List<Menu> getAllMenu();

    Menu saveMenu(Menu menu);

    Menu getMenuById(Long id);

    Menu updateMenu(Menu menu);

    void deleteMenuById(Long id);
}
