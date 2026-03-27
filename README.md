# School Management System_1

A simple Spring Boot REST API for managing student records.

## Tech Stack
- Java 17
- Spring Boot 3.2.4
- Spring Data JPA
- H2 Database (In-memory)
- Lombok

## Project Structure
```
school-management/
├── src/main/java/com/school/management/
│   ├── controller/            # Handles API requests
│   ├── service/               # Business logic layer
│   ├── repository/            # Database access (JPA)
│   ├── entity/                # Database entity classes
│   ├── dto/                   # Data Transfer Objects
│   ├── mapper/                # Convert Entity <-> DTO
│   ├── exception/             # Custom exceptions
│   └── SchoolManagementApplication.java
├── src/main/resources/
│   └── application.yml
├── pom.xml
└── README.md
```

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | `/api/students` | Create a new student |
| GET    | `/api/students/{id}` | Get student by ID |
| GET    | `/api/students` | Get all students |
| GET    | `/api/students/search?query=name` | Search students by name |
| PUT    | `/api/students/{id}` | Update student by ID |
| DELETE | `/api/students/{id}` | Delete student by ID |

### Example Request Body (POST/PUT)
```json
{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com"
}
```

## How to Run
1. Navigate to the `school-management` directory.
2. Run the application using Maven:
   ```bash
   mvn spring-boot:run
   ```
3. The server will start on `http://localhost:8080`.
4. Access H2 Console at `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:schooldb`).
