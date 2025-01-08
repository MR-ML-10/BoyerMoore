# **Boyer-Moore String Search Algorithm**

This project implements the **Boyer-Moore string search algorithm**, a highly efficient method for substring matching. It includes a **Java implementation** of the algorithm, with options for running predefined test cases and custom inputs. The project also features a comprehensive test suite built using **JUnit** to verify the correctness and performance of the implementation.

---

## **Overview**

The Boyer-Moore algorithm is a well-known string matching algorithm that efficiently searches for a substring (pattern) within a string (text). By leveraging preprocessing techniques such as the **bad character heuristic**, the algorithm reduces the number of comparisons, making it one of the fastest methods for string searching in practice.

---

## **Features**

### **Core Functionality**
- Efficiently search for patterns within text using the **Boyer-Moore algorithm**.
- Supports both **custom inputs** and **predefined test cases**.
- Implements the **bad character heuristic** for optimized pattern matching.

### **Predefined Test Cases**
- Comprehensive test suite using **JUnit** to validate the implementation.
- Includes a variety of cases:
  - Pattern matches at the start, middle, and end of the text.
  - Patterns not present in the text.
  - Edge cases with empty strings or very small patterns.

### **Interactive Mode**
- Accepts custom input for text and pattern strings via a user-friendly console interface.
- Provides clear feedback on whether the pattern was found in the text and its position.

---

## **Technologies Used**
- **Java**: Core language for implementing the algorithm.
- **JUnit**: For automated unit testing.
- **HashMap**: Used to implement the **bad character table** for the Boyer-Moore algorithm.

---

## **How to Run**

### **Prerequisites**
1. **JDK** 8 or later installed on your system.
2. **JUnit 5** for running the test suite.

### **Running the Application**

#### **Command-Line Interface**
1. Compile the program:
   ```bash
   javac BoyerMoore.java
