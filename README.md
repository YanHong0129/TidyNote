# 🗂️ TidyNotes – Simple File Management System

TidyNotes is a full-stack web application that allows users to create, edit, and manage text-based notes. Built with **Vue.js** for the frontend and **Spring Boot** (Java) with **MySQL** for the backend.

---

## 🛠️ Tech Stack

- **Frontend**: Vue.js (Vite)
- **Backend**: Spring Boot (Java)
- **Database**: MySQL
- **Build Tools**: Maven, npm

---

## ⚙️ Setup Instructions
Make sure installed these extensions in Visual Studio Code:
- Java Extension Pack
- Spring Boot Extension Pack
- Lombok Annotations Support
---

### 📁 Clone the Repository

```bash
git clone https://github.com/YanHong0129/TidyNote.git
cd TidyNote
```

## 🖥️ Backend Setup (Spring Boot)
1. Navigate to the backend folder
```
cd backend
```

2. Configure application.properties

Make sure create a database named tidynote_db or use your own name but must match with the url

Make sure you database do not need password or enter your database password

Create or edit this file:
```
src/main/resources/application.properties
```
```
spring.datasource.url=jdbc:mysql://localhost:3306/tidynote_db
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```
Make sure MySQL is running and the database tidynote_db exists.

3. Run the Backend
```
./mvnw spring-boot:run
```

If using Windows and ./mvnw fails:
```
mvn spring-boot:run
```

Backend will run on:

📍 http://localhost:8081

## 🌐 Frontend Setup (Vue.js)
1. Navigate to the frontend folder
```
cd ../frontend
```

2. Install dependencies
```
npm install
```

3. Run the development server
```
npm run dev
```

Frontend will run on:

📍 http://localhost:5173


