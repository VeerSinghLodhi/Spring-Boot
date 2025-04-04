
/*
 
    Spring Boot Annotations:
     @PostMapping,
     @GetMapping,
     @DeleteMapping,
     @ResponseBody,
     @RequestBody,
     @PathVariable

    1. @PostMapping
        -Maps HTTP POST requests to a method.
        -Used for creating new resources.
        -Example:

        @PostMapping("/add")
        @ResponseBody
        public String addUser(@RequestBody Student newStudent) {
        studentList.add(newStudent);
        return "Added successfully!";
        }
        -Here, a POST request to /add with a JSON body will trigger the method.
___________________________________________________________________________________________________________________________________________________

    2. @GetMapping
        -Maps HTTP GET requests to a method.
        -Used for retrieving data.
        -Example:

        @GetMapping
        @ResponseBody
        public List<Student> getStudents(){
            return studentList;
        }
        - will show all Students.

        @GetMapping("/{id}")
        @ResponseBody
        public List<Student getStudentById(@PathVariable int id) {
        return studentLIst.stream().filter(student->student.getId()==id).collect(Collectors.toList());
        }
        -A GET request to /id returns "One Student Record1".

___________________________________________________________________________________________________________________________________________________


    3. @DeleteMapping
        -Maps HTTP DELETE requests to a method.
        -Used for deleting resources.
        -Example:

        @DeleteMapping("/{id}")
        public String deleteStudent(@PathVariable int id) {
        studentLIst.removeIf(studentLIst->studentLIst.getId()==id);
            return "Student ID " + id + " deleted successfully!";
        }
        -A DELETE request to /id deletes the Student.

___________________________________________________________________________________________________________________________________________________


    4. @ResponseBody
        -Converts the return value into JSON and sends it as an HTTP response.
        -Example:

        @GetMapping("/info")
        @ResponseBody
        public Student getUserInfo() {
            return new Student(1, "John Doe", "john@example.com");
        }
        -Returns a Student object in JSON format.
___________________________________________________________________________________________________________________________________________________

    5. @RequestBody
        -Binds HTTP request body to a Java object.
        -Used in POST and PUT requests.
        -Example:

        @PostMapping("/register")
        @ResponseBody
        public String registerStudent(@RequestBody Student student) {
            return "Student " + student.getName() + " registered!";
        }
        -Converts JSON request body into a Student object.

___________________________________________________________________________________________________________________________________________________

    6. @PathVariable
        -Extracts values from the URL path.
        -Example:

        @GetMapping("/{id}")
        public String getUserById(@PathVariable("id") int userId) {
            return "Fetching user with ID: " + userId;
        }
        -A GET request to /10 returns "Fetching user with ID: 10".

___________________________________________________________________________________________________________________________________________________

        Summary Table:

        Annotation	                        Purpose
-------------------------------------------------------------------------------------------------------------
    @PostMapping	            Handles HTTP POST requests (Create Data)
    @GetMapping	                Handles HTTP GET requests (Retrieve Data)
    0@DeleteMapping     	    Handles HTTP DELETE requests (Delete Data)
    @ResponseBody	            Converts Java object to JSON response
    @RequestBody	            Maps HTTP request body to Java object
    @PathVariable	            Extracts values from URL


___________________________________________________________________________________________________________________________________________________


            Spring Boot Annotations vs Database CRUD


           Operation |	Database Action | 	HTTP Method |	Spring Annotation             |  Purpose
-----------------------------------------------------------------------------------------------------------------------------------------
            Create	 |      INSERT	    |   POST	    |    @PostMapping	              |  Add a new record to the database
            Read	 |      SELECT	    |   GET	        |    @GetMapping	              |  Retrieve data from the database
            Update	 |      UPDATE	    |   PUT/PATCH	|    @PutMapping / @PatchMapping  |  Modify existing records
            Delete	 |      DELETE	    |   DELETE	    |    @DeleteMapping	              |  Remove a record from the database
------------------------------------------------------------------------------------------------------------------------------------------


     Summary Tip:
     
        Think of Spring annotations as a bridge between HTTP methods and database actions:

            -@PostMapping = "I want to INSERT new data"

            -@GetMapping = "I want to SELECT data"

            -@PutMapping / @PatchMapping = "I want to UPDATE data"

            -@DeleteMapping = "I want to DELETE data"


___________________________________________________________________________________________________________________________________________________


 */
