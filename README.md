Text Analyzer - Quick Guide
How to Run the Program
1) Compile the program: TextAnalyzer.java Main.java
2) Run the program: Main
3) How to Use

Prepare a Text File

Create a simple .txt file with some text
Remember its location


Enter File Path

When prompted, enter the full path to your text file
Example: C:\Users\YourName\Desktop\test.txt
For files in the same folder, just enter the filename: test.txt
View Results

The program will display the analysis results
You can choose to analyze more or exit
Quick Tips:
Always use .txt files
Double-check your file path
Use option 9 to exit the program
Type 'exit' at the file path prompt to close the program

Design Choices
1. Architecture

Two-Class Structure

TextAnalyzer.java: Core analysis engine handling all text processing
Main.java: User interface and program flow management
This separation follows the Single Responsibility Principle



2. Data Handling

Used ArrayList for word and sentence storage for flexibility
Implemented HashMap for word frequency counting
Chose TreeMap for word length distribution to maintain natural ordering
All text is processed once during initialization to improve performance

3. User Interface

Console-based menu system for simplicity
Continuous operation loop with exit options
Clear feedback messages for all operations
Error handling with user-friendly messages

Implementation Features
Core Functions

Word counting (total and unique)
Sentence analysis
Word length calculations
Frequency analysis
Custom distribution analysis

Technical Details

Case-insensitive word processing
Punctuation handling
Stream API usage for efficient processing
Exception handling for file operations

Challenges Encountered
1. Text Processing Challenges

Problem: Initial implementation using Arrays.asList() caused UnsupportedOperationException
Solution: Switched to ArrayList for mutable list operations
Impact: Improved code reliability and maintainability

2. File Path Handling

Problem: Different path formats across operating systems
Solution: Used Java's Path API for consistent file handling
Impact: Better cross-platform compatibility

3. Performance Considerations

Problem: Potential memory issues with large files
Solution: Single-pass text processing and efficient data structures
Impact: Better resource utilization

Future Improvements

Potential Enhancements

GUI implementation
Support for multiple file analysis
Additional statistical measures
Export functionality for results


Code Optimization

Enhanced memory management
Parallel processing for large files
More sophisticated text analysis algorithms



Lessons Learned

Importance of proper data structure selection
Value of robust error handling
Benefits of modular design
Significance of user-friendly interface

This project successfully demonstrates core Java programming concepts while providing practical text analysis functionality. The modular design allows for easy maintenance and future enhancements.
