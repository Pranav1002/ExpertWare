# ExpertWare

The ExpertWare is a microservices-based application designed to streamline warehouse operations, including inventory management, order processing, and optimization of storage and retrieval processes. The system ensures efficient management of warehouse resources, secure access control using OAuth 2.0, and scalable deployment with Docker. The Inventory Service leverages MongoDB for flexible schema management, while MySQL is used for other transactional services.

## Features

- **Inventory Management**: Track and manage warehouse inventory, including real-time updates on stock levels.
- **Order Management**: Process and manage customer orders, including order creation, updating, and tracking.
- **Optimization Service**: Enhance warehouse efficiency by optimizing storage locations and retrieval paths.
- **Security**: Secure the application using OAuth 2.0 for authentication and authorization.
- **Containerization**: Dockerized microservices for seamless deployment and scalability.
- **Multi-Database Integration**: Used MongoDB for the Inventory Service and MySQL for Order Management and Optimization Services.

## Tech Stack

The ExpertWare project is built using the following technologies:

- **Backend**: Spring Boot, Java
- **Databases**:
--MySQL (Order Management, Optimization)
--MongoDB (Inventory Service)
- **Security**: OAuth 2.0
- **Containerization**: Docker, Docker Compose
- **Build Tool**: Maven
- **Version Control**: Git
  
## Installation

Prerequisites
- Java 17+
- Maven 3.6+
- Docker and Docker Compose
- MySQL and MongoDB

1. Clone the repository: `git clone https://github.com/ExpertWare.git`
2. Build the Project:: `mvn clean install`
3. Set Up Databases:
   - MySQL: Create the necessary databases and update the connection details in the respective application.properties files.
   - MongoDB: Ensure MongoDB is running and update the connection details in the Inventory Service’s application.properties.
4. Dockerize the Application:
 - Build Docker images for each microservice: Build Docker images for each microservice:
 - Start all services: docker-compose up
5. Access the Application:
 - The microservices will be available at different ports as configured in the docker-compose.yml file.
 - Use Postman or a similar tool to interact with the API endpoints.


## Contributor

- Pranav1002 ([@Pranav1002](https://github.com/Pranav1002))

## Future Improvements

There are several future improvements planned for ExpertWare, including:

- **Enhance Optimization Algorithms**: Implement advanced machine learning algorithms to further optimize storage and retrieval processes.
- **Implement a Frontend**: Develop a React.js or Angular frontend for a better user interface and experience.
- **Add Notification Service**: Integrate a notification system to alert warehouse staff of critical inventory levels or order updates.
- **Improve Monitoring and Logging**: Integrate tools like Prometheus and Grafana for better monitoring, and ELK stack for advanced logging.
- **Scalability Enhancements**: Implement Kubernetes for orchestrating the microservices in a production environment.


  Thank you for your interest in ExpertWare!
