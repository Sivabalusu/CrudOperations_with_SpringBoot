package com.practice.crudops.controller;

import com.practice.crudops.domain.User;
import com.practice.crudops.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testSaveUser() throws Exception {
        User user = new User();
        when(userService.saveUser(any(User.class))).thenReturn(user);
        mockMvc.perform(post("/app/v1/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetAllUsers() throws Exception {
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        when(userService.getAllUsers()).thenReturn(users);
        mockMvc.perform(get("/app/v1/allUsers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[1].id").exists())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void testGetUser() throws Exception {
        User user = new User();
        when(userService.get(1)).thenReturn(user);
        mockMvc.perform(get("/app/v1/user/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = new User();
        when(userService.saveUser(any(User.class))).thenReturn(user);
        mockMvc.perform(put("/app/v1/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteUser() throws Exception {
        User user = new User();
        when(userService.deleteUser(1)).thenReturn(user);
        mockMvc.perform(delete("/app/v1/delete/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());
    }
}
