# random-quiz-backend
This is a backend application built using Spring Boot and MySQL, designed to streamline the process of creating and managing questions, and generating quizzes. This RESTful API provides a comprehensive set of CRUD (Create, Read, Update, Delete) operations for questions, allowing users to efficiently manage a database of questions. 

## Features

- *Question Management*: Create, read, update, and delete questions in the database using RESTful APIs.
- *Quiz Generation*: Generate dynamic quizzes by specifying the category and desired number of questions required.
- *Randomized Question Selection*: Ensure fairness and variety by randomly selecting questions from the database for each generated quiz.
- *Scalability and Performance*: Leveraging the power of Spring Boot and MySQL, the application is designed to handle large volumes of data and concurrent requests efficiently.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- PostMan

## API Endpoints

### Question Management

- GET /questions/all: Retrieve a list of all questions.
- GET /questions/category/{category}: Retrieve a specific question by category
- POST /questions/add: Create a new question.
- PUT /questions/update/{id}: Update an existing question.
- DELETE /questions/delete/{id}: Delete a question.

### Quiz Generation

- GET /quiz/get/{id}: Retrieves the list of questions in the quiz.
      -Test on PostMan with : localhost:8080/quiz/get/1
- POST /create: Generate a quiz based on the specified parameters.
    - category: The category of questions the quiz should come from.
    - numQ: The number of questions to include in the quiz.
    - title: Specifying the title of the quiz
      -Test on PostMan with : localhost:8080/quiz/create?category=Python&numQ=5&title=PyQuiz
- POST /submit/{id}: Submit the quiz answers and calculate the result
    - Test on PostMan with: localhost:8080/quiz/submit/1
    - Body: in the following format [
    {   
        "id": "5", 
        "response": "An object"
    },    
   
]
  
