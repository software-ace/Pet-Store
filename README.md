# Automated Tests for Pet Store

This repository contains automated tests for the [Pet Store](https://ecom-pet-store.myshopify.com/) website. The tests are implemented using Java Seleinum, TestNG and Page Object Model.

## Tools

- ![Java](https://img.shields.io/badge/Java-Programming%20Language-orange)
- ![TestNG](https://img.shields.io/badge/TestNG-Testing%20Framework-green)
- ![Selenium](https://img.shields.io/badge/Selenium-Web%20Automation%20Tool-blue)
- ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-Integrated%20Development%20Environment-red)

## Test Descriptions

### Test 1: Verify Search for Cat

This test verifies the search functionality of the Pet Store website. It performs a search for the keyword "cat" and checks if the displayed items contain the word "cat".

### Test 2: Verify Selecting Random Animal Category and Items Number

This test verifies the selection of a random animal category from the Pet Store website. It randomly selects a pet type from the available options and checks if the number of displayed items is as expected.

### Test 3: Verify Selecting Random Dog Item

This test verifies the selection of a random dog item from the Pet Store website. It navigates to the dogs page, selects a random product, chooses a random color and size, and adds the item to the cart.

### Test 4: Verify Checkout Process and Screenshot Payment Page

This test verifies the checkout process on the Pet Store website. It fills the checkout form with dummy information, proceeds to the payment page, takes a screenshot of the payment page, and checks if the payment header is displayed.

### Test 5: Verify Filling Contact Form and Submit

This test verifies the contact form submission on the Pet Store website. It fills the contact form with dummy information and submits it. It then checks if the success message is displayed.

## Prerequisites

To run the tests, ensure that you have the following software installed:

- IntelliJ IDEA
- Java Development Kit version 20 (JDK 20)
- TestNG testing framework
- Selenium WebDriver

## Running the Tests

1. Clone this repository: `git clone https://github.com/software-ace/Pet-Store.git`
2. Navigate to the project directory: `cd Pet-Store`
3. Open Intellij Idea `idea .`
4. Open `PetStoreTests` file
5. Run the tests: `Click on Run Tests Icon`

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
