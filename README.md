Sure — here’s a cleaned up and more polished version that you can paste directly into your repo’s `README.md`:

---

# Product Management System

A Java Spring Boot REST API for managing **Categories** and **Products**, featuring full CRUD capabilities, MySQL persistence, and role-based security. A simple HTML+JavaScript frontend is also included.

---

## 🚀 Features

### 📁 Category Management

* Create, read, update, and delete categories
* Fetch category by ID
* List all products under a category

### 📦 Product Management

* Create, read, update, and delete products
* Assign products to categories
* Fetch product by ID

### 🔐 Security

* Role-based access control using Spring Security:

  * `ROLE_ADMIN` → Category APIs
  * `ROLE_SELLER` → Product APIs
* Public endpoints for read-only access
* CORS enabled (frontend can access from any origin)

### 🌐 Frontend

* Simple modern UI example under `/frontend/index.html`
* Uses HTML + JavaScript + fetch API

---

## 🛠️ Tech Stack

| Technology      | Version    |
| --------------- | ---------- |
| Java            | 17         |
| Spring Boot     | 3.x        |
| Spring Data JPA | –          |
| Spring Security | –          |
| MySQL           | 8+         |
| Lombok          | –          |
| Maven           | –          |
| Swagger/OpenAPI | (optional) |

---

## 📂 Project Structure

```
ProductManagement/
├─ src/main/java/com/rishi/product/
│  ├─ Controller/
│  │    ├─ CategoryController.java
│  │    └─ ProductController.java
│  ├─ DTO/
│  ├─ Entity/
│  │    ├─ Category.java
│  │    └─ Product.java
│  ├─ Service/
│  ├─ Repository/
│  └─ ...
├─ src/main/resources/
│  └─ application.properties
├─ frontend/
│  └─ index.html
├─ pom.xml
└─ README.md
```

---

## 📡 API Endpoints

### **Categories**

| Endpoint                                  | Method | Access      | Description          |
| ----------------------------------------- | ------ | ----------- | -------------------- |
| `/api/categories/getCategories`           | GET    | Public      | List all categories  |
| `/api/categories/addCategory`             | POST   | ROLE\_ADMIN | Add a category       |
| `/api/categories/updateCategoryNameById`  | PUT    | ROLE\_ADMIN | Update category name |
| `/api/categories/deleteCategoryById/{id}` | DELETE | ROLE\_ADMIN | Delete a category    |
| `/api/categories/getCategoryById/{id}`    | GET    | Public      | Get category by ID   |
| `/api/categories/checkstatus`             | GET    | Public      | Check API status     |

### **Products**

| Endpoint                               | Method | Access       | Description       |
| -------------------------------------- | ------ | ------------ | ----------------- |
| `/api/products/getAllProducts`         | GET    | Public       | List all products |
| `/api/products/addProduct`             | POST   | ROLE\_SELLER | Add a product     |
| `/api/products/UpdateProductById`      | PUT    | ROLE\_SELLER | Update product    |
| `/api/products/deleteProductById/{id}` | DELETE | ROLE\_SELLER | Delete a product  |
| `/api/products/getProductById/{id}`    | GET    | Public       | Get product by ID |

---

## 🧬 Database Schema

### **Category**

| Field      | Type      |
| ---------- | --------- |
| categoryId | Long (PK) |
| name       | String    |

### **Product**

| Field       | Type                 |
| ----------- | -------------------- |
| id          | Long (PK)            |
| name        | String               |
| description | String               |
| price       | Double               |
| category    | ManyToOne → Category |

---

## ⚙️ Setup & Installation

### ✅ Prerequisites

* Java 17+
* Maven
* MySQL 8+

### 1. Create MySQL Database

```sql
CREATE DATABASE productmanagement;
```

Update credentials in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/productmanagement
spring.datasource.username=<your_mysql_user>
spring.datasource.password=<your_mysql_password>
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8081
```

### 2. Build & Run

```bash
# In project root
mvn clean install
mvn spring-boot:run
```

Application will start at:
👉 [http://localhost:8081](http://localhost:8081)

---

Would you like me to also include sample `curl` requests or the Swagger usage section?
