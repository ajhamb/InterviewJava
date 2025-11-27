# InterviewJava

This project contains a collection of small Java programs and solutions to common interview questions.

## Programs

### 1. Add Two Numbers

A simple command-line utility to add two numbers.

**File:** `src/main/java/interviewjava/AddTwoNumbers.java`

**Usage:**

You can run the program in two ways after building it:

1.  **Provide numbers as command-line arguments:**
    ```sh
    java -cp build/classes/java/main interviewjava.AddTwoNumbers 3 5
    ```

2.  **Run without arguments and enter numbers when prompted:**
    ```sh
    java -cp build/classes/java/main interviewjava.AddTwoNumbers
    Enter first number: 3
    Enter second number: 5
    ```

### 2. Remove Extra Brackets

This program contains a method to remove extra (unbalanced) parentheses from a given string.

**File:** `src/main/java/interviewjava/StackProblems.java`

The `removeExtraBracket(String input)` method uses a stack to identify and remove parentheses that do not form a valid, balanced pair.

## Building and Testing

This project uses the Gradle wrapper to build and run tests.

### Build the Project and Run Tests

To compile the code and run the tests, execute the following command from the project root directory:

```sh
./gradlew build
```

### View Test Report

The `build` command automatically runs all JUnit tests. After the build is complete, you can view a detailed HTML report of the test results by opening the following file in your web browser:

`build/reports/tests/test/index.html`