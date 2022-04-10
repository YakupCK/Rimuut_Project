Feature: Image

  @wip
  Scenario: Check broken images on homepage
    Given The user is on the homepage
    When the user checks the images
    Then There is no any broken image on the page

  @wip
  Scenario: Check broken images on business page
    Given The user is on the business page
    When the user checks the images
    Then There is no any broken image on the page