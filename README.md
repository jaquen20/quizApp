# quizApp
This document outlines the API endpoints for a quiz application built using Spring Boot. The applicationleverages the in-memory **H2 database** for data storage, ensuring fast and efficient testing during development. The API allows users to:
-  Start a new quiz session.
-  Retrive random multiple choice questions.
-  Submit answers.
-  View final results.

## Technology Used
-  **Spring Boot**: framework for building the API.
-  **H2 Database**: In-memory database for quick setup and efficient testing.
-  **Postman**: Tool for API testing.
-  **Java**: Programming language for implementing the backend logic.

## Endpoints 
### 1.  Start a New Quiz Session
-  **Endpoint**: `/quiz-app/start`
-  **Method**: `POST`
-  **Response**:
   -  **Status Code**: `200 OK`
   -  **Body**: JSON object containing the session ID.

---
### 2. Get a Random Question
-  **Endpoint**: `/quiz-app/questions`
-  **Method**: `GET`
-  **Response**:
   -  **Status Code**: `200 OK`
   -  **Body**: JSON object containing the question text and its multiple-choice options.
   -  **Status Code**: `404 Not Found`
   -  **Body**: Error message indicating  the question pool is exhausted.

### 3. Submit an Answer

- **Endpoint**: `/quiz-app/submit`
- **Method**: `POST`
- **Request Parameters**:
  - `sessionId`: The ID of the current quiz session.
  - `questionId`: The ID of the question being answered.
  - `answer`: The user's selected answer.
- **Response**:
  - **Status Code**: `200 OK`
    - **Body**: Success message.
  - **Status Code**: `400 Bad Request`
    - **Body**: Error message indicating invalid session ID, question ID, or answer.
  - **Status Code**: `404 Not Found`
    - **Body**: Error message indicating the session or question is not found.

---

### 4. Get Quiz Results

- **Endpoint**: `/quiz-app/result`
- **Method**: `GET`
- **Request Parameters**:
  - `sessionId`: The ID of the completed quiz session.
- **Response**:
  - **Status Code**: `200 OK`
    - **Body**: JSON object containing the total number of questions, correct answers, and incorrect answers.
  - **Status Code**: `404 Not Found`
    - **Body**: Error message indicating the session is not found.

---

## Error Handling

The API handles errors gracefully and returns appropriate HTTP status codes and error messages. Custom exceptions are used to indicate specific error conditions, such as:

- Invalid session IDs
- Invalid questions

---

## Testing

Use tools like **Postman** or `curl` to test the API endpoints. Ensure you provide valid session IDs and question IDs in your requests.

---

## Additional Considerations

- **Security**: Implement appropriate security measures to protect user data and prevent unauthorized access.
- **Scalability**: Design the API to handle a large number of concurrent users and scale as needed.
- **Performance**: Optimize database queries and API responses for efficient performance.
- **User Experience**: Provide clear and concise error messages to the user.
- **Logging**: Implement robust logging to track errors and debug issues.

---
