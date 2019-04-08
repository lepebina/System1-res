@BaseBulk
Feature: Base bulk test cases

  Background: System & User setup
    And Edit campaign "TelekomCampaign" begin on "10/10/2015 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq"

@original-basebulk-1
  Scenario: No valid msisdns Base bulk from free short code
    And Refresh cache
    And Bulk "61" is triggered
    Then User receives the "<string>" reply from free short code

  @original-basebulk-2
  Scenario: User with no profile receives Base bulk from free short code
    And Refresh cache
    And Bulk "60" is triggered
    Then User receives the "<string>" reply from free short code

  @original-basebulk-3
  Scenario: Blacklisted User with no profile receives Base bulk from free short code
    Given Base bulk users are blacklisted
      | 355006712015 |
      #| 355006712115 |
      #| 355006711015 |
      #| 355006112015 |
      #| 355001712015 |
      #| 355016712015 |
      #| 355106712015 |
    And Refresh cache
    And Bulk "59" is triggered
    Then User receives the "<string>" reply from free short code