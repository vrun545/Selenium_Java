# Amazon Website Testing with Selenium Java Maven Project

This project is a Selenium Java Maven project for testing the Amazon website. It follows the guidelines provided below:

## Guidelines

1. **Maven Project**: The project is structured as a Maven project for easy dependency management and build automation.

2. **Page Object Model (POM) Framework**: The implementation follows the Page Object Model framework to enhance test maintenance and readability.

3. **Test Data from Properties File**: Test data such as application URL, browser name, and global wait time are read from a properties file.

4. **Test Configurations**: Application URL, browser name, and global wait time configurations are read from the properties file.

5. **Assertions**: Proper assertions are implemented to validate the expected behavior of the application.

6. **Wait Mechanisms**: Implicit and explicit waits are used wherever necessary to handle synchronization issues.

7. **Extent Report Integration**: Extent report is implemented to generate detailed test reports with proper assertions and error descriptions.

8. **Screenshot Capture**: Screenshots are captured with the same name as the test case and appended with a brief description of the error in case of test failures.

9. **Cross-Browser Testing**: Tests are run on IE, Chrome, and Firefox browsers to ensure compatibility across different browsers.

11. **Automated Scenarios**: At least 10 automated scenarios are implemented across different flows and screens of the Amazon website.

12. **Logger Implementation**: Logger implementation is included for better logging and debugging capabilities.

## Installation and Execution

1. Clone this repository to your local machine.
2. Ensure you have Java, Maven, and your preferred web browser installed on your system.
3. Update the `config.properties` file with the required configurations such as application URL, browser name, and global wait time.
4. Open a terminal or command prompt and navigate to the project directory.
5. Run the command `mvn clean test` to execute the test cases.
6. After execution, the Extent report will be generated in the `test-output` directory.

## Contributing

Contributions are welcome! If you have any suggestions or improvements, feel free to submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE). Feel free to use, modify, and distribute it as per the terms of the license.
