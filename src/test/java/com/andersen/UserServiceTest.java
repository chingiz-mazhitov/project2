package com.andersen;

import com.andersen.bus.TicketType;
import com.andersen.entity.User;
import com.andersen.repo.UserRepository;
import com.andersen.service.UserService;
import com.andersen.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl userService;

	private User user;

	@BeforeEach
	void setUp() {
		user = new User();
		user.setId(1);
		user.setName("Bjorn");
		user.setCreationDate(LocalDateTime.now());
	}

	@Test
	void findUserById_Found() {

		when(userRepository.findById(1)).thenReturn(Optional.of(user));
		User result = userService.findById(1);

		assertEquals(result, user);
	}

	@Disabled
	@Test
	void findUserById_NotFound() {
		assertNull(userService.findById(99));
	}

	@Disabled
	@Test
	void saveUser_Invoke() {
		userService.save(user);

		verify(userRepository).save(user);
	}

	@Test
	void deleteUser_Invoke() {
		userService.delete(user.getId());

		verify(userRepository).deleteById(user.getId());
	}

	@Test
	void deleteUser_ThrowException() {
		doThrow(new RuntimeException("Delete operation failed")).when(userRepository).deleteById(2);
		assertThrows(RuntimeException.class, () -> userService.delete(2));

	}




}
