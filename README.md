# LedgerFlow

### A Modular Payment, Ledger & Reconciliation Platform

LedgerFlow is a backend-focused project aimed at simulating payment processing, maintaining financial ledgers, handling settlements, and automating transaction reconciliation.

The project is being developed using Java, Spring Boot, and PostgreSQL, following a modular backend architecture.

## Technology Stack

- **Language:** Java 21
- **Backend:** Spring Boot 3.x
- **Build Tool:** Maven
- **Database:** PostgreSQL 16
- **ORM:** Spring Data JPA / Hibernate
- **Database Migration:** Flyway

## Project Structure

```text
LedgerFlow/
│
├── apps/
│   └── core/              # Main Spring Boot application
│
├── .gitignore
└── README.md
```

Additional components such as the simulated bank service, frontend, infrastructure configuration, load tests, and documentation will be introduced in later development phases.

## Getting Started

### Prerequisites

- JDK 21
- PostgreSQL 16
- IntelliJ IDEA
- Git

### Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/Bean-Pay/LedgerFlow.git
   ```

2. Open the `apps/core` directory as a Maven project in IntelliJ IDEA.

3. Create the PostgreSQL database:

   ```sql
   CREATE ROLE ledgerflow_app
   WITH LOGIN PASSWORD 'your_password';

   CREATE DATABASE ledgerflow
   OWNER ledgerflow_app;
   ```

4. Configure the following environment variables:

   ```text
   DB_USERNAME=ledgerflow_app
   DB_PASSWORD=your_password
   ```

5. Run `CoreApplication.java` from IntelliJ IDEA.

## Current Development Status

- Repository initialized.
- Spring Boot backend project created.
- Maven configuration completed.
- PostgreSQL database configured.
- Flyway integration configured.

Further development will introduce the payment, ledger, settlement, reconciliation, and AI modules.

## Contributors

Developed by the **Bean-Pay** team.

---

*LedgerFlow — Building a foundation for reliable payment processing and financial reconciliation.*