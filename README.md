# BB Product Tracker
This is a Java-based Best Buy product tracking application that gives the user current in-stock status of any product on the Best Buy website.

## Features
- StartMenu: Provides a simple user interface for entering the product URL.
- SiteData: Retrieves data from the provided URL, including product availability, description, and image URL.
- Result: Displays product information such as description, availability, and product image. Allows users to refresh data or perform a new search.
- Tracker: Allows users to enter their email address and receive notifications when the desired product becomes available.

## Technologies Used
- Java: The core programming language used to develop the application.
- Swing: Java's GUI toolkit used for creating the graphical user interface.
- JSoup: Java HTML parser used for parsing, extracting, and manipulate data in HTML documents. 

## Dependencies
- Java Development Kit (JDK): Required to compile and run the Java code.
- Swing: Java GUI toolkit.
- Add the following JAR files to the classpath of the project:
  - jsoup-1.17.2.jar

- To add these JAR files to your classpath:
  - Download the JAR files from the web.
  - In your Java IDE, right-click on your project and select "Properties" or "Build Path" > "Configure Build Path."
  - Navigate to the "Libraries" tab.
  - click on "classpath"
  - Click "Add JARs" or "Add External JARs" and select the downloaded JAR files.
  - Click "Apply" or "OK" to save the changes.
 
## Setup
1. Prerequisites: Ensure you have Eclipse IDE installed on your system.
2. WindowBuilder Plugin: Install the WindowBuilder plugin from the Eclipse Marketplace. This plugin is required for the GUI design.
3. Clone the Repository: Clone the project repository to your local machine.
```bash
git clone <repo-url>
```
4. Open Project in Eclipse: Import the project into Eclipse IDE.
5. Ensure dependencie requirements are met.
6. Run program: Run the StartMenu class to launch the application

## Contributing
Contributions are welcome! If you'd like to contribute to this project, please follow these steps:
- Fork the repository.
- Create a new branch (git checkout -b feature)
- Make your changes
- Commit your changes (git commit -am 'Add new feature')
- Push to the branch (git push origin feature)
- Create a new Pull Request.

## Authors
Bhavnoor Saini

## Support
For help and support, please contact bhavnoorsaini@icloud.com.

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE) file for details.
