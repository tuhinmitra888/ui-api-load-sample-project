@demoapp
Feature: Demo application feature

  Scenario: anonymous user sees valid results if (s)he enters valid search criteria

    Given user opens "https://demoqa.com/books" in "chrome" browser
    When user enters the text "JavaScript" as search input
    And clicks the search icon
    Then 4 books are visible to user

  Scenario: anonymous user sees no books if (s)he enters invalid search criteria

    Given user opens "https://demoqa.com/books" in "chrome" browser
    When user enters the text "abc" as search input
    And clicks the search icon
    Then "No rows found" message is visible to user

  Scenario: anonymous user is able to upload an image and successfully submit student registration form

    Given user opens "https://demoqa.com/automation-practice-form" in "chrome" browser
    When user enters first name as "Tuhin"
    And last name as "Mitra"
    And email as "tuhin.mitra@example.com"
    And select gender as "Male"
    And enters mobile number as "9038312345"
    And upload an image
    And clicks submit button
    Then the confirmation pop up is visible to user

  @addToCollection
  Scenario: a registered user is able to add books to his/her collection

    Given user opens "https://demoqa.com/login" in "chrome" browser
    When user enters username as "tuhin.mitra"
    And password as "Password123!"
    And clicks login button
    And clicks go to book store button
    And selects the book "Git Pocket Guide"
    And clicks add to your collection button
    And confirms the pop up
    And clicks "Profile" menu option
    Then the "Git Pocket Guide" book is visible to the collection of the user

  Scenario: anonymous user is able to drag and drop ui element

    Given user opens "https://demoqa.com/droppable" in "chrome" browser
    When user drags and drops the ui element
    Then "Dropped!" text is visible at the droppable area