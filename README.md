# GScores - School Graduation Exam Score Lookup System

## Introduction

GScores is a web application that allows users to look up Vietnam High School Graduation Exam scores (2024). The system provides the following features:

- **Score Lookup**: Search for individual student scores by registration number (SBD)
- **Score Distribution Report**: Visualize score distributions across all subjects using bar charts
- **Top 10 Students**: Display the top 10 highest-scoring students in Group A (Math, Physics, Chemistry)

---

## Tech Stack

### Frontend

| Technology        | Version | Description                 |
| ----------------- | ------- | --------------------------- |
| React             | 19.x    | UI Library                  |
| TypeScript        | 5.9.x   | Type-safe JavaScript        |
| Vite              | 7.x     | Build tool and dev server   |
| MUI (Material-UI) | 7.x     | React component library     |
| MUI X-Charts      | 8.x     | Charting library            |
| TailwindCSS       | 4.x     | Utility-first CSS framework |
| Axios             | -       | HTTP client                 |

### Backend

| Technology      | Version | Description                |
| --------------- | ------- | -------------------------- |
| Java            | 17      | Programming language       |
| Spring Boot     | 3.4.3   | Backend framework          |
| Spring Data JPA | -       | Data access layer          |
| PostgreSQL      | Latest  | Database                   |
| Flyway          | -       | Database migration         |
| Lombok          | -       | Boilerplate code reduction |
| Maven           | 3.9.x   | Build tool                 |
| Docker         | Containerization              |

---

## Getting Started

### Prerequisites

- **Node.js** (v18 or higher)
- **Java** 17 or higher
- **Docker** and **Docker Compose**
- **Maven** (optional, if running backend without Docker)

---

## Running the Application

### Option 1: Run with Docker Compose (Recommended)

This will start both PostgreSQL database and the backend application.

```bash
# Navigate to backend directory
cd backend

# Start all services (PostgreSQL + Backend)
docker compose up -d

# View logs
docker compose logs -f

# Stop all services
docker compose down
```

The backend will be available at: `http://localhost:8080`

### Option 2: Run Backend Manually

#### 1. Start PostgreSQL with Docker

```bash
cd backend

# Start only PostgreSQL
docker compose up -d postgres
```

#### 2. Run Spring Boot Application

```bash
cd backend

# Using Maven wrapper
./mvnw spring-boot:run

# Or on Windows
mvnw.cmd spring-boot:run
```

---

### Running the Frontend

```bash
# Navigate to frontend directory
cd frontend

# Install dependencies
npm install

# Start development server
npm run dev
```

The frontend will be available at: `http://localhost:5173`

#### Build for Production

```bash
cd frontend

# Build the application
npm run build

# Preview production build
npm run preview
```

---

## Project Structure

```
go-test/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/backend/
│   │   │   │   ├── controller/     # REST API controllers
│   │   │   │   ├── service/        # Business logic
│   │   │   │   ├── repository/     # Data access layer
│   │   │   │   ├── entity/         # JPA entities
│   │   │   │   └── dto/            # Data transfer objects
│   │   │   └── resources/
│   │   │       ├── db/migration/   # Flyway migrations
│   │   │       └── seed/           # CSV data files
│   │   └── test/
│   ├── Dockerfile
│   ├── docker-compose.yml
│   └── pom.xml
│
└── frontend/
    ├── src/
    │   ├── api/           # API service calls
    │   ├── components/    # Reusable React components
    │   ├── pages/         # Page components
    │   ├── types/         # TypeScript type definitions
    │   ├── service/       # Axios configuration
    │   └── routes/        # Route definitions
    ├── package.json
    └── vite.config.ts
```

---
## API Endpoints

| Method | Endpoint                    | Description                       |
| ------ | --------------------------- | --------------------------------- |
| GET    | `/api/scores?sbd={sbd}`     | Get scores by registration number |
| GET    | `/api/scores/report`        | Get score distribution statistics |
| GET    | `/api/scores/top10-group-a` | Get top 10 Group A students       |

---

## Environment Variables

### Backend (via Docker Compose or application.properties)

| Variable                     | Default                                       | Description       |
| ---------------------------- | --------------------------------------------- | ----------------- |
| `SPRING_DATASOURCE_URL`      | `jdbc:postgresql://localhost:5433/gscores_db` | Database URL      |
| `SPRING_DATASOURCE_USERNAME` | `gscores`                                     | Database username |
| `SPRING_DATASOURCE_PASSWORD` | `password`                                    | Database password |

---
