# Day-02 – Spring AI Resume Analyzer

AI-powered Resume Analysis Service built using **Spring Boot + Spring AI + Ollama (Local LLM)**.

This project demonstrates structured AI responses, prompt engineering, and backend integration with a local Large Language Model (LLM).

---

## Tech Stack

- Java 17
- Spring Boot 3.2.5
- Spring AI (1.0.0-M6)
- Ollama (Local LLM Runtime)
- llama3 / phi Model
- Maven

---

## Features

- REST API for Resume Analysis
- System + User Message Roles
- Prompt Engineering for Strict JSON Output
- Structured Output → Java Record Mapping
- Temperature Control (Deterministic Output)
- Local LLM Integration

---

## ⚙️ Setup Instructions

### 1️⃣ Install Ollama

Mac / Linux:

```bash
curl -fsSL https://ollama.com/install.sh | sh
```

Start Ollama:

```bash
ollama serve
```

Pull a model:

```bash
ollama pull llama3
```

(If your system has low RAM, use:)

```bash
ollama pull phi
```

---

### 2️⃣ Configure `application.yml`

```yaml
server:
  port: 8081

spring:
  ai:
    ollama:
      base-url: http://localhost:11434
      chat:
        model: llama3
        options:
          temperature: 0.2
```

---

### 3️⃣ Build & Run

```bash
mvn clean install
mvn spring-boot:run
```

Application runs at:

```
http://localhost:8081
```

---

## API Usage

**POST**

```
/api/resume/analyze
```

---

## How Structured Output Works

- Strong system prompt enforces valid JSON
- Temperature set to `0.0` for deterministic output
- Spring AI maps JSON → `ResumeFeedback` record
- If invalid JSON is returned, parsing error is logged

---
## Future Enhancements

- Streaming responses (WebFlux)
- Retry mechanism for malformed JSON
- Token usage tracking
- RAG (Vector DB integration)
- Docker deployment

---

## Learning Outcome

This project demonstrates:

- Spring AI integration
- Backend AI service design
- Structured LLM outputs
- Deterministic AI responses
- Real-world debugging of LLM JSON parsing