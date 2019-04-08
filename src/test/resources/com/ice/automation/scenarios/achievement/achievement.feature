@Achievement
Feature: Achievements test cases

  Background: configuration
    Given Sms free short code is "55577"
    And Sms billed short code is "55577"
    And Edit campaign "TelekomCampaign" begin on "10/10/2015 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq"
    And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2018 00:00:00" with "7" free days and welcome message from free shorcode
    And System has offset "0"
    And Refresh cache

  Scenario: Achievement 15 billed events
    Given User has "355002033097" msisdn
    And User has no profile
    And Current time is "192"
    When User sends sms with input "YES" to free short code
    Then User has profile
    And User has subscription profile
    When Current time is "0"
    And "15" charge events for "PersonalitySubscription" subscription with charge point "1" and status "0" are triggered
    Then User has granted with achievement "EVERY_15_CONTENT"
    And User receives the "ACHIEVEMENT_OBTAINED" reply from billed short code
    And User receives the following texts/response types from billed short code ordered by event time:
      | text_key                     | response_type        |
      | achievement_every_15_content | ACHIEVEMENT_OBTAINED |
    And "15" charge events for "PersonalitySubscription" subscription with charge point "1" and status "0" are triggered
    Then User has not granted with achievement "EVERY_15_CONTENT" twice

  Scenario: 2 Achievements at the same time
 #		Given Create achievement "REPEAT_15_CONTENT" with "150MB" prize, "sq" langcode, "repeat_15_content" text key, "Congrats for your achievement" content and "return subscriptionProfile.getTotalContentDeliveries()%15==0;" condition
    And User has "355002033099" msisdn
    And User has no profile
    And Current time is "192"
    When User sends sms with input "YES" to free short code
    Then User has profile
    And User has subscription profile
    When Current time is "0"
    And "15" charge events for "PersonalitySubscription" subscription with charge point "1" and status "0" are triggered
    Then User has granted with achievement "EVERY_15_CONTENT"
    And User receives the "ACHIEVEMENT_OBTAINED" reply from billed short code
    When "15" charge events for "PersonalitySubscription" subscription with charge point "1" and status "0" are triggered
    And User has granted with achievement "EVERY_30_CONTENT"
    And User receives the "ACHIEVEMENT_OBTAINED" reply from billed short code
    And "15" charge events for "PersonalitySubscription" subscription with charge point "1" and status "0" are triggered
    Then User has not granted with achievement "EVERY_15_CONTENT" twice
    Then User has not granted with achievement "EVERY_30_CONTENT" twice
  #And Clear achievement "EVERY_30_CONTENT" from DB