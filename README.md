# Student Management System

This project is a simple, full-stack CRUD (Create, Read, Update, Delete) application for managing student records.

It consists of a Spring Boot backend providing a REST API and a single-page HTML/CSS/JavaScript frontend for the user interface.

## Features

* **REST API:** A backend built with Spring Boot exposes a full set of CRUD endpoints for managing students.
* **Frontend UI:** A responsive single-page interface built with HTML, Tailwind CSS, and vanilla JavaScript allows for:
    * Viewing all students in a table.
    * Adding new students via a form.
    * Editing existing students (populates the form).
    * Deleting students.
* **Database:** Uses an in-memory H2 database for simplicity and ease of setup.
* **Validation:** The backend uses `spring-boot-starter-validation` to ensure data integrity (e.g., required fields, valid email formats).

## Technology Stack

* **Backend:**
    * Java 24
    * Spring Boot 3.3.0
    * Spring Web (REST APIs)
    * Spring Data JPA (Repository pattern)
    * Lombok
* **Frontend:**
    * HTML
    * Tailwind CSS (via CDN)
    * Vanilla JavaScript (Fetch API)
* **Database:**
    * H2 In-Memory Database
* **Build:**
    * Apache Maven (via Maven Wrapper)

## Getting Started

### Prerequisites

* JDK 21 or later.
* You do **not** need to install Maven; the project includes the Maven Wrapper.

### Running the Application

1.  **Clone the repository** (or ensure all provided files are in a single project directory).

2.  **Open a terminal** in the root directory of the project.

3.  **Run the application** using the Maven Wrapper:

    * On macOS/Linux:
        ```sh
        ./mvnw spring-boot:run
        ```
    * On Windows:
        ```cmd
        .\mvnw.cmd spring-boot:run
        ```

4.  The application will start on `http://localhost:8080`.

### How to Use

Once the application is running:

1.  **Access the Frontend:**
    Open your web browser and navigate to:
    `http://localhost:8080/studentmanagement.html`

    You can now use the interface to add, edit, view, and delete students.

2.  **Access the H2 Database Console (Optional):**
    To inspect the in-memory database:
    * Navigate to: `http://localhost:8080/h2-console`
    * Use the following settings:
        * **JDBC URL:** `jdbc:h2:mem:studentdb`
        * **User Name:** `sa`
        * **Password:** (leave blank)

## API Endpoints

The backend provides the following REST API endpoints, all prefixed with `/api/students`.

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/` | Retrieves a list of all students. |
| `GET` | `/{id}` | Retrieves a single student by their ID. |
| `POST` | `/` | Creates a new student. Expects a `Student` object in the request body. |
| `PUT` | `/{id}` | Updates an existing student by their ID. Expects a `Student` object in the request body. |
| `DELETE` | `/{id}` | Deletes a student by their ID. |

### Student Model

The `Student` object used in the API has the following structure.

```json
{
  "id": 1,
  "rollNumber": "11",
  "firstName": "Arya",
  "lastName": "Dharmadhikari",
  "email": "aryadharmadhikari10@gmail.com",
  "department": "Information Technology",
  "year": 2,
  "gpa": 8.7
}
