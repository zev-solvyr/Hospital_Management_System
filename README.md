# 🏥 Hospital Management System (Spring Boot)

A backend REST API for managing patients, doctors, appointment slots, and bookings.
Built using **Spring Boot, JPA, and PostgreSQL** with clean architecture and production-level practices.

---

## 🚀 Tech Stack

* **Java 17**
* **Spring Boot 3.x**
* **Spring Data JPA (Hibernate)**
* **PostgreSQL**
* **Lombok**
* **Spring Validation**

---

## 📌 Features

### 👤 Patient Module

* Create patient with auto-generated registration number (PNxxxxx)
* Fetch patient by ID

---

### 👨‍⚕️ Doctor Module

* Create doctor with auto-generated registration number (DNxxxxx)
* Fetch doctor by ID
* Get all doctors

---

### 🕒 Slot Module

* Create time slots for doctors
* Prevent overlapping slots using optimized DB query
* Fetch slots by doctor

---

### 📅 Appointment Module

* Book appointment for a patient
* Prevent double booking of slots
* Cancel appointment
* Get appointments by patient

---

### 🧱 Architecture Highlights

* DTO-based API design (no entity exposure)
* Layered architecture:

  * Controller → Service → Repository
* Custom exception handling with `@ControllerAdvice`
* Validation using `@Valid`
* Optimized queries for performance

---

## 🔗 API Endpoints

### 👤 Patient APIs

| Method | Endpoint         | Description    |
| ------ | ---------------- | -------------- |
| POST   | `/patients`      | Create patient |
| GET    | `/patients/{id}` | Get patient    |

---

### 👨‍⚕️ Doctor APIs

| Method | Endpoint        | Description     |
| ------ | --------------- | --------------- |
| POST   | `/doctors`      | Create doctor   |
| GET    | `/doctors/{id}` | Get doctor      |
| GET    | `/doctors`      | Get all doctors |

---

### 🕒 Slot APIs

| Method | Endpoint            | Description         |
| ------ | ------------------- | ------------------- |
| POST   | `/slots`            | Create slot         |
| GET    | `/slots?doctorId=1` | Get slots by doctor |

---

### 📅 Appointment APIs

| Method | Endpoint                     | Description                 |
| ------ | ---------------------------- | --------------------------- |
| POST   | `/appointments`              | Book appointment            |
| GET    | `/appointments/patient/{id}` | Get appointments by patient |
| PUT    | `/appointments/{id}/cancel`  | Cancel appointment          |

---

## 🧪 Sample Request

### Create Appointment

```json
{
  "patientId": 1,
  "slotId": 1,
  "appointmentType": "ONLINE",
  "notes": "First consultation"
}
```

---

## ⚙️ How to Run

1. Clone the repository

```bash
git clone https://github.com/your-username/hospital-management-system.git
```

2. Configure PostgreSQL in `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_db
spring.datasource.username=your_user
spring.datasource.password=your_password
```

3. Run the application

```bash
mvn spring-boot:run
```

---

## 🧠 Future Enhancements (v2)

* 🔐 Spring Security + JWT authentication
* 📊 Pagination & sorting
* 🔍 Search APIs
* 📦 Standard API response wrapper
* 🧪 Unit & integration testing
* 🐳 Docker support

---

## 👨‍💻 Author

**ZEV**👽

Built with focus on clean backend architecture and real-world practices.

---

## ⭐ If you like this project

Give it a ⭐ on GitHub!
