# Pagination in Spring Boot

## Overview
Pagination is the process of dividing a large dataset into smaller, manageable chunks, or "pages." In Spring Boot, pagination is commonly implemented using **Spring Data JPA**, which provides a built-in mechanism to retrieve and manage paginated data.

---

## Key Concepts
1. **Pageable Interface**: Defines the properties for pagination (e.g., page number, page size) and sorting.
2. **Page<T> Interface**: Represents a single page of data and provides metadata such as total pages, total elements, and the current page.
3. **Pagination Parameters**:
   - `page`: The current page number (zero-based index).
   - `size`: The number of items per page.
   - `sort`: Specifies the sorting order (e.g., `sort=name,asc`).

---

## Implementation Steps

### 1. Repository Layer
Use Spring Data JPA's `findAll(Pageable pageable)` method to fetch paginated data:
```java
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findAll(Pageable pageable);
}
```

### 2. Service Layer
Create a service method to handle pagination and sorting logic:
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<User> getUsers(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return userRepository.findAll(pageable);
    }
}
```

### 3. Controller Layer
Expose an API endpoint to retrieve paginated and sorted data:
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Page<User> getUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return userService.getUsers(page, size, sortBy);
    }
}
```

---

## Sample API Request
- **Endpoint**: `/users`
- **Parameters**: `?page=1&size=5&sort=name`

This request retrieves the second page of data (since indexing starts at 0) with 5 items per page, sorted by the `name` field.

---

## Benefits of Pagination
- **Performance**: Reduces server and client load by transferring only a subset of data.
- **Scalability**: Handles large datasets efficiently.
- **Improved UX**: Allows users to view and navigate data effectively.

---

## Additional Features
To enhance your pagination implementation, consider:
- **Custom Queries**: Use `@Query` in the repository to fetch filtered paginated data.

```java
@Query("SELECT u FROM User u WHERE u.status = :status")
Page<User> findByStatus(@Param("status") String status, Pageable pageable);
```
