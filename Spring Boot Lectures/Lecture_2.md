# Spring Boot Annotations

## Overview of Key Annotations

### 1. `@PostMapping`
- **Purpose**: Maps HTTP POST requests to a method for creating new resources.
- **Example**:
    ```java
    @PostMapping("/add")
    @ResponseBody
    public String addUser(@RequestBody Student newStudent) {
        studentList.add(newStudent);
        return "Added successfully!";
    }
    ```
  - A POST request to `/add` with a JSON body triggers this method.

---

### 2. `@GetMapping`
- **Purpose**: Maps HTTP GET requests to a method for retrieving data.
- **Example**:
    - Retrieve all students:
        ```java
        @GetMapping
        @ResponseBody
        public List<Student> getStudents() {
            return studentList;
        }
        ```
    - Retrieve a specific student by ID:
        ```java
        @GetMapping("/{id}")
        @ResponseBody
        public List<Student> getStudentById(@PathVariable int id) {
            return studentList.stream()
                .filter(student -> student.getId() == id)
                .collect(Collectors.toList());
        }
        ```
    - A GET request to `/id` returns a specific student record.

---

### 3. `@DeleteMapping`
- **Purpose**: Maps HTTP DELETE requests to a method for deleting resources.
- **Example**:
    ```java
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentList.removeIf(student -> student.getId() == id);
        return "Student ID " + id + " deleted successfully!";
    }
    ```
    - A DELETE request to `/id` deletes the specified student.

---

### 4. `@ResponseBody`
- **Purpose**: Converts the return value into JSON and sends it as an HTTP response.
- **Example**:
    ```java
    @GetMapping("/info")
    @ResponseBody
    public Student getUserInfo() {
        return new Student(1, "John Doe", "john@example.com");
    }
    ```
    - This will return a `Student` object in JSON format.

---

### 5. `@RequestBody`
- **Purpose**: Binds HTTP request body to a Java object, commonly used in POST and PUT requests.
- **Example**:
    ```java
    @PostMapping("/register")
    @ResponseBody
    public String registerStudent(@RequestBody Student student) {
        return "Student " + student.getName() + " registered!";
    }
    ```
    - Converts JSON request body into a `Student` object.

---

### 6. `@PathVariable`
- **Purpose**: Extracts values from the URL path.
- **Example**:
    ```java
    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int userId) {
        return "Fetching user with ID: " + userId;
    }
    ```
    - A GET request to `/10` returns "Fetching user with ID: 10".

---

## Summary Table

| Annotation        | Purpose                              |
|-------------------|--------------------------------------|
| `@PostMapping`    | Handles HTTP POST requests (Create Data) |
| `@GetMapping`     | Handles HTTP GET requests (Retrieve Data) |
| `@DeleteMapping`  | Handles HTTP DELETE requests (Delete Data) |
| `@ResponseBody`   | Converts Java object to JSON response |
| `@RequestBody`    | Maps HTTP request body to Java object |
| `@PathVariable`   | Extracts values from URL             |

---

## Spring Boot Annotations vs. Database CRUD

| Operation | Database Action | HTTP Method | Spring Annotation             | Purpose                      |
|-----------|-----------------|-------------|-------------------------------|------------------------------|
| Create    | INSERT          | POST        | `@PostMapping`               | Add a new record            |
| Read      | SELECT          | GET         | `@GetMapping`                | Retrieve data               |
| Update    | UPDATE          | PUT/PATCH   | `@PutMapping / @PatchMapping`| Modify existing records     |
| Delete    | DELETE          | DELETE      | `@DeleteMapping`             | Remove a record             |

---

### **Tip**:
Think of Spring annotations as a bridge between HTTP methods and database actions:

- `@PostMapping` = "I want to INSERT new data"
- `@GetMapping` = "I want to SELECT data"
- `@PutMapping / @PatchMapping` = "I want to UPDATE data"
- `@DeleteMapping` = "I want to DELETE data"
