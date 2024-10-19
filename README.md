# Quiz App

## Overview
The **Quiz App** is a monolithic Spring Boot application designed to create, manage, and take quizzes. The app consists of two main services:

1. **Question Service**: Responsible for managing and fetching questions. It is connected to a PostgreSQL database for CRUD operations.
2. **Quiz Service**: Fetches random questions from the Question Service, presents them to the user, and calculates the score based on the user's answers.

## Architecture
This application follows a monolithic architecture with the following services:

- **Question Service**: Handles operations such as:
  - Fetching all questions.
  - Modifying existing questions.
  - Adding new questions.
  - Connected to PostgreSQL for persistent storage of questions.

- **Quiz Service**: Handles the quiz-taking process, including:
  - Fetching random questions from the Question Service.
  - Conducting quizzes.
  - Calculating and displaying the score after quiz completion.

## Technologies Used
- **Java**: The programming language used for the backend logic.
- **Spring Boot**: Framework for building the microservices.
- **PostgreSQL**: Database for storing questions.
- **Maven**: For dependency management and building the project.
- **RestTemplate / Feign**: For inter-service communication between Question Service and Quiz Service.

## Prerequisites
To run this project, you need to have the following installed:

- Java 11 or higher
- Maven 3.6+
- PostgreSQL 12 or higher

## Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/your-repo/quiz-app.git
cd quiz-app


