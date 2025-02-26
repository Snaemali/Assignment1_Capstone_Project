Feature: Test the-internet.herokuapp.com application

  Scenario: Verify the title of the home page
    Given I launch the URL "http://the-internet.herokuapp.com/"
    Then the title of the page should be "The Internet"
    When I click on "A/B Testing" link
    Then the text on the page should be "A/B Test Variation 1|A/B Test Control"
    Given I am on the home page
    When I click on "Dropdown" link
    And I select "Option 1" from the dropdown
    Then "Option 1" should be selected
    Given I am on the home page
    When I click on "Frames" link
    Then the following links should be present on the Frames page
      | Nested Frames |
      | iFrame        |