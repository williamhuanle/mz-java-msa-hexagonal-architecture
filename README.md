# Introduce
- Microservice Architecture project based on hexagonal architecture, domain design-driven, TDD
- This project is using java spring boot, spring security, OAuth2, JWT

## package structure
```bash
├── project
│   ├── application-core
│   │   ├── auth
│   │   │   ├── domain
│   │   │   │   ├── dto
│   │   │   │   └── services
│   │   │   └── port
│   │   │       ├── api
│   │   │       └── spi
│   │   ├── admin
│   │   │   ├── domain
│   │   │   │   ├── dto
│   │   │   │   └──  services
│   │   │   └── port
│   │   │       ├── api
│   │   │       └── spi
│   ├── user-db-adapter
│   │   ├── adapters
│   │   ├── entity
│   │   └── repository
│   └── auth-service
│       ├── config
│       ├── controller
│       └── AuthenticationApp.java
├── README.md
├── .gitignore
├── build.gradle
└── settings.gradle
```

## Require environment

```bash
java version "11.0.14" 2022-01-18 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.14+8-LTS-263)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.14+8-LTS-263, mixed mode)
```

```bash
------------------------------------------------------------
Gradle 7.4
------------------------------------------------------------

Build time:   2022-02-08 09:58:38 UTC
Revision:     f0d9291c04b90b59445041eaa75b2ee744162586

Kotlin:       1.5.31
Groovy:       3.0.9
Ant:          Apache Ant(TM) version 1.10.11 compiled on July 10 2021
JVM:          17.0.2 (Homebrew 17.0.2+0)
OS:           Mac OS X 12.2.1 aarch64
```

## How to run
1. build source code
```bash
gradle clean build
```
2. run application service
```bash
gradle bootRun
```
