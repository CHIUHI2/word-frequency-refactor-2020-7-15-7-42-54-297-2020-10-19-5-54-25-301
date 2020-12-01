# Refactoring Steps
## Step 1 - Test Protection
  1. check if has test, if not, create test case first
      - implement test for testing the try catch function as I have code refactoring on it
  2. run test and ensure all test passed
## Step 2 - Read Code
  1. understand the logic and the purposes of the coding
  2. find out all bad smell
## Step 3 - Refactor Techniques
  1. figure out which techniques have to be used
## Step 4 - Code Refactoring with Baby Step
### - refactoring one by one following : action -> test if passed all tests, if not, bug fix -> commit
  1. remove useless import inside WordFrequencyGame
  2. remove useless empty line and do formatting for WordFrequencyGame
  3. rename input variable 'input' of WordFrequencyGame getResult to 'sentence'
  4. rename class Input to WordFrequency and rename variable, method inside the class
  5. remove useless empty line and do formatting for WordFrequency
  6. make variable inside WordFrequency final
  7. remove duplicated logic inide WordFrequencyGame getResult
  8. replace error code with CalculateErrorException inide WordFrequencyGame getResult
  9. extract calculateWordFrequency and getWordFrequencyResult from WordFrequencyGame getResult
  10. add variable for magic word inside WordFrequencyGame
  11. implement cleaner code for WordFrequenctGame calculateWordFrequency
  12. implement cleaner code for WordFrequenctGame getWordFrequencyResult
  13. remove useless code in WordFrequenctGame getResult
  14. rename calculateWordFrequency to getSortedWordFrequency for including sorting
  15. extract getWordFrequencyResultLine from getWordFrequencyResult
  16. extract getWords from WordFrequencyGame getSortedWordFrequency
  17. add package for better structure
  18. rename test case
  19. refactor test case with given when then format
