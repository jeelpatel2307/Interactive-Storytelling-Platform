# Interactive Storytelling Platform

This is a sample project demonstrating an Interactive Storytelling Platform implemented using Java and Spring Boot.

## Overview

The Interactive Storytelling Platform allows users to create, read, and interact with interactive stories. Each story consists of a title, content, and a set of choices. When a user selects a choice, the platform navigates them to the next story based on the choice's associated next story ID.

## Architecture

The platform is built using a Spring Boot application, which provides the following functionality:

1. **Story Management**: The `StoryController` class handles CRUD operations for stories, allowing users to create, retrieve, and manage stories.
2. **Choice Management**: The `StoryController` class also handles the creation of choices associated with a specific story.
3. **Data Storage**: The `Story` and `Choice` entities are stored in a database using Spring Data JPA repositories (`StoryRepository` and `ChoiceRepository`).

The platform uses a RESTful API to interact with the stories and choices.

## Technologies Used

- Java 11
- Spring Boot
- Spring Data JPA
- H2 Database (in-memory database for simplicity)

## Getting Started

1. Clone the repository.
2. Build and run the application using the following command:
    
    ```bash
    ./gradlew bootRun
    
    ```
    
3. The application will start running on [http://localhost:8080](http://localhost:8080/).

## Usage

You can use tools like Postman or cURL to interact with the platform's API. Here are some example requests:

**Create a Story**

```
POST /stories
{
  "title": "My Story",
  "content": "This is the beginning of my story..."
}

```

**Create a Choice for a Story**

```
POST /stories/{storyId}/choices
{
  "text": "Choose Option A",
  "nextStoryId": 2
}

```

**Get a Story with Choices**

```
GET /stories/{id}

```

## Future Enhancements

- Implement user authentication and authorization to allow users to create and manage their own stories.
- Add the ability to save user progress and allow users to resume their stories.
- Implement more advanced features, such as branching narratives, multimedia support, and social sharing.
- Improve the user interface and provide a web-based or mobile application for a better user experience.
- Implement server-side validation and error handling for a more robust and secure platform.
