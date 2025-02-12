Feature: Test the-internet.herokuapp.com application

  Scenario: Verify the title of the home page
    Given I launch the URL "http://the-internet.herokuapp.com/"
    Then the title of the page should be "The Internet"

  Scenario: Verify A/B Testing page
    Given I am on the home page
    When I click on "A/B Testing" link
    Then the text on the page should be "A/B Test Variation 1"

  Scenario: Verify dropdown selection
    Given I am on the home page
    When I click on "Dropdown" link
    And I select "Option 1" from the dropdown
    Then "Option 1" should be selected

  Scenario: Verify Frames page
    Given I am on the home page
    When I click on "Frames" link
    Then the following links should be present on the Frames page
      | Nested Frames |
      | iFrame        |