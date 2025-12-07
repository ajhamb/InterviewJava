
This project contains a collection of small Java programs and solutions to common interview questions.

## Classes

### `AddTwoNumbers.java`

This class provides a simple utility to add two numbers and can be run from the command line.

**File:** `src/main/java/interviewjava/AddTwoNumbers.java`

#### Methods
- **`add(double a, double b)`**: Takes two double-precision numbers and returns their sum.

#### Usage
You can run the `main` method in two ways after building the project:

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
### `StackProblems.java`

This class contains solutions to common interview problems that can be solved using a Stack data structure.

**File:** `src/main/java/interviewjava/StackProblems.java`

#### Methods
- **`removeExtraBracket(String input)`**: This method takes a string as input and removes any parentheses that are not part of a balanced pair. It uses a stack to keep track of the indices of parentheses to identify and remove the extra ones.

### `SubarrayProblems.java`

This class is dedicated to solving various problems related to contiguous subarrays within an array.

**File:** `src/main/java/interviewjava/SubarrayProblems.java`

#### Methods
- **`maxSubarraywithTwoDistinctIntegers(int[] nums)`**: This method finds the length of the longest contiguous subarray that contains at most two distinct integers. It implements an efficient sliding window approach using a hash map to track the frequency of elements in the current window.

## Building and Testing


