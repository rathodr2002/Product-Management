# Product-Management
this is Product management repository consist of Product and Category
Overview
The Product Management System is a Java Spring Boot RESTful application that provides APIs to manage Categories and Products. It supports full CRUD operations, enforces security with user roles, and persists data to a MySQL database.

This project is a practical demonstration of REST API best practices, Spring Security with role-based control, JPA entity relationships, and an example HTML/JS frontend.

Features
Category Management

Create, Read, Update, and Delete categories

Fetch category by ID

Display all products within a category

Product Management

Create, Read, Update, and Delete products

Assign products to categories

Fetch product by ID

Security

Role-based access using Spring Security

Categories: ROLE_ADMIN

Products: ROLE_SELLER

CORS Support

Frontend can interact with the API from any origin

Modern UI Example

Simple stylish HTML+JavaScript frontend, included in /frontend/index.html

Technologies Used
Java 17

Spring Boot (3.x)

Spring Data JPA

Spring Security

Lombok

MySQL

Maven

Swagger/OpenAPI (optional)

Project Structure
text
ProductManagement/
├─ src/
│  └─ main/
│     └─ java/com/rishi/product/
│         ├─ Controller/
│         │    ├─ CategoryController.java
│         │    └─ ProductController.java
│         ├─ DTO/
│         ├─ Entity/
│         │    ├─ Category.java
│         │    └─ Product.java
│         ├─ Service/
│         ├─ Repository/
│         └─ ...
├─ src/main/resources/
│    └─ application.properties
├─ frontend/
│    └─ index.html
├─ pom.xml
└─ README.md
API Endpoints
Categories
Endpoint	Method	Access	Description
/api/categories/getCategories	GET	Public	List all categories
/api/categories/addCategory	POST	ROLE_ADMIN	Add a category
/api/categories/updateCategoryNameById	PUT	ROLE_ADMIN	Update category name
/api/categories/deleteCategoryById/{id}	DELETE	ROLE_ADMIN	Delete a category
/api/categories/getCategoryById/{id}	GET	Public	Get category by ID
/api/categories/checkstatus	GET	Public	Check API status
Products
Endpoint	Method	Access	Description
/api/products/getAllProducts	GET	Public	List all products
/api/products/addProduct	POST	ROLE_SELLER	Add a product
/api/products/UpdateProductById	PUT	ROLE_SELLER	Update product
/api/products/deleteProductById/{id}	DELETE	ROLE_SELLER	Delete a product
/api/products/getProductById/{id}	GET	Public	Get product by ID
Database Schema
Category

categoryId (Primary Key, Long)

name (String)

Product

id (Primary Key, Long)

name (String)

description (String)

price (Double)

category (ManyToOne → Category)

Setup & Installation
Prerequisites
Java 17+

Maven

MySQL 8+

1. Database
Create database:

sql
CREATE DATABASE productmanagement;
Update credentials in src/main/resources/application.properties:

text
spring.datasource.url=jdbc:mysql://localhost:3306/productmanagement
spring.datasource.username=<your_mysql_user>
spring.datasource.password=<your_mysql_password>
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8081
2. Build & Run
text
# In project root
mvn clean install
mvn spring-boot:run
Spring Boot will launch on http://localhost:8081.
