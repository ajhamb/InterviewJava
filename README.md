# InterviewJava
Coding interview Questions with Java

## AddTwoNumbers

This repository uses a standard Gradle layout with package `interviewjava`:

- Production sources: `src/main/java/interviewjava`
- Tests: `src/test/java/interviewjava`

The `AddTwoNumbers` program adds two numbers and exposes `add(double,double)` for testing.

Build and run with Gradle:

Using your system Gradle:

```zsh
# compile
gradle build

# run the program with args (example: 3 and 5)
gradle run --args="3 5"

# run the tests
gradle test
```

Using the Gradle wrapper (recommended for CI / reproducible builds):

```zsh
# generate wrapper (if not present)
gradle wrapper

./gradlew build
./gradlew run --args="3 5"
./gradlew test
```

Files moved/added
- src/main/java/interviewjava/AddTwoNumbers.java — main program
- src/test/java/interviewjava/AddTwoNumbersTest.java — JUnit 5 tests
- build.gradle — Gradle build file (JUnit and application plugin)
- settings.gradle — Gradle project settings

Notes
- The test suite uses JUnit 5. Gradle's `test` task is configured to use JUnit Platform.
- `gradle run --args="<num1> <num2>"` will run `interviewjava.AddTwoNumbers`.

```
