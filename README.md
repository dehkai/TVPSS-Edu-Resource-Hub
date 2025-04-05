# TVPSS Educational Resource Hub

A comprehensive web-based platform for managing Technical and Vocational Program Special Stream (TVPSS) resources in the Johor State Education Department. This system facilitates program status tracking, candidate management, and resource allocation for educational institutions.

## Features

### For School Administrators
- Submit and track program status updates
- Manage candidate applications and post talent listings
- Schedule and organize activities
- Request and manage resources
- View comprehensive reports and analytics

### For TVPSS Officers
- Review and approve program status submissions
- Oversee candidate management
- Monitor resource allocation
- Generate detailed reports
- Track school performance metrics

## Technology Stack

- **Backend**: Spring Boot
- **Frontend**: Thymeleaf, TailwindCSS
- **UI Components**: Inter font family, Font Awesome icons
- **Authentication**: Spring Security

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6.x or higher
- Your preferred IDE (IntelliJ IDEA, Eclipse, etc.)

### Installation

1. Clone the repository
```bash
git clone https://github.com/yourusername/TVPSS-Edu-Resource-Hub.git
```

2. Navigate to the project directory
```bash
cd TVPSS-Edu-Resource-Hub
```

3. Build the project
```bash
./mvnw clean install
```

4. Run the application
```bash
./mvnw spring-boot:run
```

The application will be available at `http://localhost:8080`

## Project Structure

```
src/
├── main/
│   ├── java/         # Java source files
│   └── resources/    # Configuration files and templates
│       ├── templates/  # Thymeleaf templates
│       └── static/     # Static resources (CSS, JS, images)
└── test/
    └── java/         # Test files
```

## Key Features

### Program Status Management
- Submit and track TVPSS program implementation status
- Version control for program updates
- YouTube video integration for program demonstrations
- Status approval workflow

### Resource Management
- Request educational resources
- Track resource allocation status
- Generate resource utilization reports

### Candidate Management
- Manage student applications
- Post and track talent listings
- Monitor candidate progress

### Reporting Dashboard
- Comprehensive analytics
- Status tracking metrics
- Resource allocation statistics

